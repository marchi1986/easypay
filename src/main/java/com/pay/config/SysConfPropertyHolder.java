package com.pay.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;

import com.pay.common.DESUtils;


/**
 * 加载自定义properties
 * @author marchi.ma
 *
 */
public class SysConfPropertyHolder extends PropertyPlaceholderConfigurer implements ApplicationContextAware{

	protected static final Logger LOGGER = LoggerFactory.getLogger(SysConfPropertyHolder.class);
	
	private Properties properties = null;
	private ResourcePatternResolver resourcePatternResolver = null;
	
	
	private String resourceStr = null;

	public void setResourceStr(String resourceStr) {
		this.resourceStr = resourceStr;
	}

	/**
	 * 取得Spring管理的properties.
	 * 
	 * @return Spring管理的properties
	 */
	public Properties getProperties() {
		return this.properties;
	}
	
	protected void loadProperties(Properties properties) throws IOException {
		//ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = this.resourcePatternResolver.getResources("classpath*:*config.properties");
		List<Resource> resourceList = new ArrayList<Resource>();
		CollectionUtils.mergeArrayIntoCollection(resources, resourceList);
		if(StringUtils.isNotEmpty(this.resourceStr)){
			Resource[] resourceStrs = this.resourcePatternResolver.getResources(this.resourceStr);
			if(resourceStrs != null){
				CollectionUtils.mergeArrayIntoCollection(resourceStrs, resourceList);
			}
		}
		for(Resource res : resourceList){
			Properties props = new Properties();
			InputStream inputStream = res.getInputStream();
			props.load(inputStream);
			
			CollectionUtils.mergePropertiesIntoMap(props, properties);
			inputStream.close();
		}
		
		Resource resource = this.resourcePatternResolver.getResource("classpath:jdbc.properties");
		InputStream inputStream = resource.getInputStream();
		Properties props = new Properties();
		props.load(inputStream);
		String password=props.getProperty("jdbc.password");
		props.setProperty("jdbc.password", DESUtils.decode(password));
		CollectionUtils.mergePropertiesIntoMap(props, properties);
		
		this.properties = properties;
		//TODO
		// may be from webService
	}
	
	
	
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		try{
			if(applicationContext instanceof WebApplicationContext){
				WebApplicationContext context = ((WebApplicationContext)applicationContext);
				this.resourcePatternResolver = new ServletContextResourcePatternResolver(context.getServletContext());
			}
		}catch (BeansException e) {
			System.out.println(e.getMessage());
		}finally{
			if(this.resourcePatternResolver == null){
				this.resourcePatternResolver = new PathMatchingResourcePatternResolver();
			}
		}
		//custemFileName = context.getServletContext().getRealPath(custemFileName);
	}
	

}
