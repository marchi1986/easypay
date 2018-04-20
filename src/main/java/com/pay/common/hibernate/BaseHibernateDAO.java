package com.pay.common.hibernate;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.Id;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.bdf2.core.orm.hibernate.ISessionCallback;
import com.bstek.dorado.data.provider.Page;


public class BaseHibernateDAO<M extends java.io.Serializable, PK extends java.io.Serializable> extends HibernateDao implements IBaseDao<M, PK>{

	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseHibernateDAO.class);
	
	private final Class<M> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;
	private final String HQL_OPTIMIZE_PRE_LIST_ALL;
	private final String HQL_OPTIMIZE_NEXT_LIST_ALL;
	private String pkName = null;
	
	public BaseHibernateDAO() {
		this.entityClass = (Class<M>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Method[] method = this.entityClass.getDeclaredMethods();
		for (Method m : method) {
			if (m.isAnnotationPresent(Id.class)) {
				String methodName = m.getName();

				this.pkName = StringUtils.uncapitalize(methodName.substring(3,
						methodName.length()));
			}
		}

		// TODO @Entity name not null
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " order by " + pkName + " desc";
		HQL_OPTIMIZE_PRE_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " > ? order by " + pkName + " asc";
		HQL_OPTIMIZE_NEXT_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " < ? order by " + pkName + " desc";
		HQL_COUNT_ALL = " select count(*) from "
				+ this.entityClass.getSimpleName();
	}
	
	@Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        //获取当前Seesion,必须事务控制
        return sessionFactory.getCurrentSession();
    }
	
	public void save(M model) {

		getSession().save(model);
	}

	public void saveOrUpdate(M model) {
		getSession().saveOrUpdate(model);

	}
	
	public void saveAll(Collection<M> collection) {
		for(M m:collection){
			save(m);
		}
	}

	public void saveOrUpdateAll(Collection<M> collection) {
		for(M m:collection){
			saveOrUpdate(m);
		}
	}

	public void updateAll(Collection<M> collection) {
		for(M m:collection){
			update(m);
		}
	}
	
	public void mergeAll(Collection<M> collection) {
		for(M m:collection){
			merge(m);
		}
	}
	
	public void deleteAll(Collection<M> collection){
		for(M m:collection){
			deleteObject(m);
		}
	}

	public void update(M model) {
		getSession().update(model);

	}

	public void merge(M model) {
		getSession().merge(model);
	}

	public void delete(PK id) {
		getSession().delete(this.get(id));

	}

	public void deleteObject(M model) {
		getSession().delete(model);

	}

	public boolean exists(PK id) {
		return get(id) != null;
	}
	
	public M get(PK id){
		return (M)this.getSession().get(entityClass,id);
	}

	public int countAll() {
		Long total = aggregate(HQL_COUNT_ALL);
        return total.intValue();
	}

	public List<M> listAll() {
		// TODO Auto-generated method stub
		return list(HQL_LIST_ALL);
	}

	public List<M> listAll(int pn, int pageSize) {
		// TODO Auto-generated method stub
		int total= countAll();
		Page<M> page=new Page<M>(pageSize, pn);
		page.setEntityCount(total);
		Query query=this.getSession().createQuery(HQL_LIST_ALL).setMaxResults(pageSize).setFirstResult(page.getFirstEntityIndex());
		List<M> list=query.list();
		
		return list;
	}
	
	public List<M> listSql(String sql,Class classes){
		
		return listSql(sql,null,null,classes);
	}
	
	public List<M> listSql(String sql,Object[] paramArray,Map<String,Object> paramMap, Class classes){
		
		Query query=getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(classes));
		if(paramArray!=null){
			setParameters(query, paramArray);
		}else if(MapUtils.isNotEmpty(paramMap)){
			setQueryParameters(query, paramMap);
		}
		return query.list();
	}
	
	public List<M> listSql(String sql,Map<String,Object> parameter,Class classes){
		
		
		return listSql(sql,null,parameter,classes);
	}
	
	public List<M> listSql(String sql,Object[] parameter,Class classes){
		
		return listSql(sql,parameter,null,classes);
	}
	
	public List<M> listSql(String sql){
		Query query=getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(entityClass));
		return query.list();
	}
	

	public int execSql(String sql,Map<String,Object> parameter){
		Query query=getSession().createSQLQuery(sql) ;
		setQueryParameters(query, parameter);
		return query.executeUpdate();
	}
	
	public int execHql(String hql,Map<String,Object> parameter){
		Query query=getSession().createQuery(hql) ;
		setQueryParameters(query, parameter);
		return query.executeUpdate();
	}
	
	public List<M> list(String hql,Object[] paramArray,Map<String,Object> paramMap){
		
		Query query=getSession().createQuery(hql);
		if(paramArray!=null){
			setParameters(query, paramArray);
		}else if(MapUtils.isNotEmpty(paramMap)){
			setQueryParameters(query, paramMap);
		}
		return query.list();
	}
	
	public List<M> list(String hql){
		return list(hql,null,null);
	}
	
	public List<M> list(String hql,Map<String,Object> parameter){

		return list(hql,null,parameter);
	}
	
	public List<M> list(String hql,Object[] parameter){

		return list(hql,parameter,null);
	}

	public void flush() {
		// TODO Auto-generated method stub
		 getSession().flush();
	}

	public void clear() {
		// TODO Auto-generated method stub
		getSession().clear();
	}
	
	protected <T> T aggregate(final String hql) {
		return aggregate(hql,null,null);
    }
	
	protected <T> T aggregate(final String hql, final Object[] paramlist ) {
		return aggregate(hql,paramlist,null);
    }
	
	protected <T> T aggregate(final String hql,  final Map<String,Object> paramMap) {
		return aggregate(hql,null,paramMap);
    }
	
	protected <T> T aggregate(final String hql, final Object[] paramlist,final Map<String,Object> paramMap) {
        Query query = getSession().createQuery(hql);
        if (paramlist != null) {
            setParameters(query, paramlist);
        }else if(paramMap!=null){
        	setQueryParameters(query,paramMap);
        }
        return (T) query.uniqueResult();
    }
	
	protected void setParameters(Query query, Object[] paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.length; i++) {
                if(paramlist[i] instanceof Date) {
                    query.setTimestamp(i, (Date)paramlist[i]);
                } else {
                    query.setParameter(i, paramlist[i]);
                }
            }
        }
    }
	
	/**
	 * 基于Hibernate的Sql分页查询
	 * @param page 包含pageNo与pageSize值的dorado7 page对象
	 * @param queryString 查询目标结果用的HQL
	 * @param parameters 查询中可能包含的查询条件值,按位置顺序拼装参数方式
	 * @param parametersMap 查询中可能包含的查询条件值,按参数名拼装参数方式，与参数parameters只能二选一
	 * @param dataSourceName要采用的目标数据源名称
	 * @throws Exception 可能抛出的异常
	 */
	public void pagingSqlQuery(final Page<?> page,final String queryString,final String countQueryString,final Object[] parameters,final Map<String,Object> parametersMap,String dataSourceName,final Class<M> c) {
		this.doInHibernateSession(dataSourceName,new ISessionCallback<Object>(){
			@SuppressWarnings("unchecked")
			public Object doInSession(Session session){
				String querySql=queryString.trim();
				Query query=session.createSQLQuery(querySql).addEntity(c);
				int safePageSize=page.getPageSize() < 1 ? 65535 : page.getPageSize();
				int start=(page.getPageNo()-1)*safePageSize;
				if(parameters!=null){
					setQueryParameters(query,parameters);					
				}else if(parametersMap!=null){
					setQueryParameters(query,parametersMap);										
				}
				query.setMaxResults(safePageSize).setFirstResult(start);
				page.setEntities(query.list());
				Query countQuery=session.createSQLQuery(countQueryString);
				if(parameters!=null){
					setQueryParameters(countQuery,parameters);					
				}else if(parametersMap!=null){
					setQueryParameters(countQuery,parametersMap);										
				}
				int count=0;
				Object countObj=countQuery.uniqueResult();
				if(countObj instanceof Long){
					count=((Long)countObj).intValue();
				}else if(countObj instanceof Integer){
					count=((Integer)countObj).intValue();
				}
				page.setEntityCount(count);
				return null;
			}
		});
	}
	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,Map<String,Object> parametersMap,String dataSourceName,final Class<M> c) {
		this.pagingSqlQuery(page, queryString,countQueryString,null,parametersMap,dataSourceName,c);
	}
	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,Map<String,Object> parametersMap,final Class<M> c){
		this.pagingSqlQuery(page, queryString,countQueryString,null,parametersMap,null,c);
	}
	
	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,final Class<M> c) {
		this.pagingSqlQuery(page, queryString,countQueryString,null,null,null,c);
	}
	
	public void pagingHQLQuery(final String hql, final Page<?> page,
			final Map<String, Object> parameter) {
		pagingHQLQuery(hql,null,page,parameter);
	}
	
	public void pagingHQLQuery(final String hql,final String countHql, final Page<?> page,
			final Map<String, Object> parameter) {

		this.doInHibernateSession(new ISessionCallback<Object>() {
			@SuppressWarnings("unchecked")
			public Object doInSession(Session session) {
				String queryHql = hql.toString();
				Query query = session.createQuery(queryHql);
				if (parameter != null && parameter.size() > 0) {
					query.setProperties(parameter);
				}
				int safePageSize = page.getPageSize() < 1 ? 65535 : page
						.getPageSize();
				int start = (page.getPageNo() - 1) * safePageSize;

				query.setMaxResults(safePageSize).setFirstResult(start);
				page.setEntities(query.list());
				String sqlCount="Select count(*) "+ hql.toString();
				if(StringUtils.isNotEmpty(countHql)){
					sqlCount=countHql;
				}
				Query countQuery = session.createQuery(sqlCount);
				if (parameter != null && parameter.size() > 0) {
					countQuery.setProperties(parameter);
				}
				int count = 0;
				Object countObj = countQuery.uniqueResult();
				if (countObj instanceof Long) {
					count = ((Long) countObj).intValue();
				} else if (countObj instanceof Integer) {
					count = ((Integer) countObj).intValue();
				}
				page.setEntityCount(count);
				return null;
			}
		});

	}
	
	/**
	 * 获取分页语句的查询总条数语句
	 * @param sql
	 * @return
	 */
	public String getCountSql(String sql){
		
		StringBuffer sqlCount=new StringBuffer();
		sqlCount.append("select count(*) from (").append(sql).append(") as tab ");
		return sqlCount.toString();
	}
	



}
