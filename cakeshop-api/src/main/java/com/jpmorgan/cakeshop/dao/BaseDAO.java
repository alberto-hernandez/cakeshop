package com.jpmorgan.cakeshop.dao;

import static com.jpmorgan.cakeshop.config.rdbms.AbstractDataSourceConfig.JDBC_BATCH_SIZE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.jpmorgan.cakeshop.util.StringUtils;

public abstract class BaseDAO
{

	@Value(value = "${" + JDBC_BATCH_SIZE + "}:20")
	private String batchSize;

	@Autowired
	private SessionFactory sessionFactory;

	protected final Integer BATCH_SIZE = StringUtils.isNotBlank(System.getProperty(JDBC_BATCH_SIZE))
			? Integer.valueOf(System.getProperty(JDBC_BATCH_SIZE))
			: StringUtils.isNotBlank(batchSize) ? Integer.valueOf(batchSize)
					: 20;

	/**
	 * 
	 * @return
	 */
	protected Session getCurrentSession()
	{
		return (sessionFactory == null ? null : sessionFactory.getCurrentSession());
	}

	/**
	 * 
	 */
	public abstract void reset();

}
