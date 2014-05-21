/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.bbb.service.base;

import com.liferay.bbb.model.BBBParticipant;
import com.liferay.bbb.service.BBBParticipantService;
import com.liferay.bbb.service.persistence.BBBMeetingPersistence;
import com.liferay.bbb.service.persistence.BBBParticipantPersistence;
import com.liferay.bbb.service.persistence.BBBServerPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the b b b participant remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.bbb.service.impl.BBBParticipantServiceImpl}.
 * </p>
 *
 * @author Shinn Lok
 * @see com.liferay.bbb.service.impl.BBBParticipantServiceImpl
 * @see com.liferay.bbb.service.BBBParticipantServiceUtil
 * @generated
 */
public abstract class BBBParticipantServiceBaseImpl extends BaseServiceImpl
	implements BBBParticipantService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.bbb.service.BBBParticipantServiceUtil} to access the b b b participant remote service.
	 */

	/**
	 * Returns the b b b meeting local service.
	 *
	 * @return the b b b meeting local service
	 */
	public com.liferay.bbb.service.BBBMeetingLocalService getBBBMeetingLocalService() {
		return bbbMeetingLocalService;
	}

	/**
	 * Sets the b b b meeting local service.
	 *
	 * @param bbbMeetingLocalService the b b b meeting local service
	 */
	public void setBBBMeetingLocalService(
		com.liferay.bbb.service.BBBMeetingLocalService bbbMeetingLocalService) {
		this.bbbMeetingLocalService = bbbMeetingLocalService;
	}

	/**
	 * Returns the b b b meeting remote service.
	 *
	 * @return the b b b meeting remote service
	 */
	public com.liferay.bbb.service.BBBMeetingService getBBBMeetingService() {
		return bbbMeetingService;
	}

	/**
	 * Sets the b b b meeting remote service.
	 *
	 * @param bbbMeetingService the b b b meeting remote service
	 */
	public void setBBBMeetingService(
		com.liferay.bbb.service.BBBMeetingService bbbMeetingService) {
		this.bbbMeetingService = bbbMeetingService;
	}

	/**
	 * Returns the b b b meeting persistence.
	 *
	 * @return the b b b meeting persistence
	 */
	public BBBMeetingPersistence getBBBMeetingPersistence() {
		return bbbMeetingPersistence;
	}

	/**
	 * Sets the b b b meeting persistence.
	 *
	 * @param bbbMeetingPersistence the b b b meeting persistence
	 */
	public void setBBBMeetingPersistence(
		BBBMeetingPersistence bbbMeetingPersistence) {
		this.bbbMeetingPersistence = bbbMeetingPersistence;
	}

	/**
	 * Returns the b b b participant local service.
	 *
	 * @return the b b b participant local service
	 */
	public com.liferay.bbb.service.BBBParticipantLocalService getBBBParticipantLocalService() {
		return bbbParticipantLocalService;
	}

	/**
	 * Sets the b b b participant local service.
	 *
	 * @param bbbParticipantLocalService the b b b participant local service
	 */
	public void setBBBParticipantLocalService(
		com.liferay.bbb.service.BBBParticipantLocalService bbbParticipantLocalService) {
		this.bbbParticipantLocalService = bbbParticipantLocalService;
	}

	/**
	 * Returns the b b b participant remote service.
	 *
	 * @return the b b b participant remote service
	 */
	public com.liferay.bbb.service.BBBParticipantService getBBBParticipantService() {
		return bbbParticipantService;
	}

	/**
	 * Sets the b b b participant remote service.
	 *
	 * @param bbbParticipantService the b b b participant remote service
	 */
	public void setBBBParticipantService(
		com.liferay.bbb.service.BBBParticipantService bbbParticipantService) {
		this.bbbParticipantService = bbbParticipantService;
	}

	/**
	 * Returns the b b b participant persistence.
	 *
	 * @return the b b b participant persistence
	 */
	public BBBParticipantPersistence getBBBParticipantPersistence() {
		return bbbParticipantPersistence;
	}

	/**
	 * Sets the b b b participant persistence.
	 *
	 * @param bbbParticipantPersistence the b b b participant persistence
	 */
	public void setBBBParticipantPersistence(
		BBBParticipantPersistence bbbParticipantPersistence) {
		this.bbbParticipantPersistence = bbbParticipantPersistence;
	}

	/**
	 * Returns the b b b server local service.
	 *
	 * @return the b b b server local service
	 */
	public com.liferay.bbb.service.BBBServerLocalService getBBBServerLocalService() {
		return bbbServerLocalService;
	}

	/**
	 * Sets the b b b server local service.
	 *
	 * @param bbbServerLocalService the b b b server local service
	 */
	public void setBBBServerLocalService(
		com.liferay.bbb.service.BBBServerLocalService bbbServerLocalService) {
		this.bbbServerLocalService = bbbServerLocalService;
	}

	/**
	 * Returns the b b b server persistence.
	 *
	 * @return the b b b server persistence
	 */
	public BBBServerPersistence getBBBServerPersistence() {
		return bbbServerPersistence;
	}

	/**
	 * Sets the b b b server persistence.
	 *
	 * @param bbbServerPersistence the b b b server persistence
	 */
	public void setBBBServerPersistence(
		BBBServerPersistence bbbServerPersistence) {
		this.bbbServerPersistence = bbbServerPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return BBBParticipant.class;
	}

	protected String getModelClassName() {
		return BBBParticipant.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = bbbParticipantPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.bbb.service.BBBMeetingLocalService.class)
	protected com.liferay.bbb.service.BBBMeetingLocalService bbbMeetingLocalService;
	@BeanReference(type = com.liferay.bbb.service.BBBMeetingService.class)
	protected com.liferay.bbb.service.BBBMeetingService bbbMeetingService;
	@BeanReference(type = BBBMeetingPersistence.class)
	protected BBBMeetingPersistence bbbMeetingPersistence;
	@BeanReference(type = com.liferay.bbb.service.BBBParticipantLocalService.class)
	protected com.liferay.bbb.service.BBBParticipantLocalService bbbParticipantLocalService;
	@BeanReference(type = com.liferay.bbb.service.BBBParticipantService.class)
	protected com.liferay.bbb.service.BBBParticipantService bbbParticipantService;
	@BeanReference(type = BBBParticipantPersistence.class)
	protected BBBParticipantPersistence bbbParticipantPersistence;
	@BeanReference(type = com.liferay.bbb.service.BBBServerLocalService.class)
	protected com.liferay.bbb.service.BBBServerLocalService bbbServerLocalService;
	@BeanReference(type = BBBServerPersistence.class)
	protected BBBServerPersistence bbbServerPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private BBBParticipantServiceClpInvoker _clpInvoker = new BBBParticipantServiceClpInvoker();
}