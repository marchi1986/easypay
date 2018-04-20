package com.pay.common.hibernate;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;

public interface IBaseDao<M extends java.io.Serializable, PK extends java.io.Serializable> {
    

    public void save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(PK id);

    public void deleteObject(M model);

    public M get(PK id);
    
    public int countAll();

    public List<M> listAll();
    
    public List<M> listAll(int pn, int pageSize);
    
    public List<M> listSql(String sql,Class classes);
    
    public List<M> listSql(String sql,Map<String,Object> parameter,Class classes);
    
    public List<M> listSql(String sql,Object[] parameter,Class classes);
    
    public List<M> listSql(String sql,Object[] paramArray,Map<String,Object> paramMap, Class classes) ;
    
    public List<M> listSql(String sql);
    
    public int execHql(String hql,Map<String,Object> parameter);
    
    public int execSql(String sql,Map<String,Object> parameter);
        
    public void saveAll(Collection<M> collection);

	public void saveOrUpdateAll(Collection<M> collection);

	public void updateAll(Collection<M> collection);
	
	public void mergeAll(Collection<M> collection);
	
	public void deleteAll(Collection<M> collection);
    
    boolean exists(PK id);
    
    public void flush();
    
    public void clear();
    
    public List<M> list(String hql);
	
	public List<M> list(String hql,Object[] param);
	
	/**
	 * 获取分页语句的查询总条数语句
	 * @param sql
	 * @return
	 */
	public String getCountSql(String sql);
	
	/**
	 * 基于Hibernate的Sql分页查询
	 * @param page 包含pageNo与pageSize值的dorado7 page对象
	 * @param queryString 查询目标结果用的HQL
	 * @param parameters 查询中可能包含的查询条件值,按位置顺序拼装参数方式
	 * @param parametersMap 查询中可能包含的查询条件值,按参数名拼装参数方式，与参数parameters只能二选一
	 * @param dataSourceName要采用的目标数据源名称
	 * @throws Exception 可能抛出的异常
	 */
	public void pagingSqlQuery(final Page<?> page,final String queryString,final String countQueryString,final Object[] parameters,final Map<String,Object> parametersMap,String dataSourceName,final Class<M> c) throws Exception;
	
	public void pagingHQLQuery(final String hql,final Page<?> page,final Map<String, Object> parameter);
	
	public void pagingHQLQuery(final String hql,final String countHql, final Page<?> page,final Map<String, Object> parameter) ;
	
	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,final Class<M> c) throws Exception;
	
	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,Map<String,Object> parametersMap,final Class<M> c) throws Exception;

	public void pagingSqlQuery(Page<?> page,String queryString,String countQueryString,Map<String,Object> parametersMap,String dataSourceName,final Class<M> c) throws Exception;

}
