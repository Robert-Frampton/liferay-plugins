/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.bbb.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BBBServer service. Represents a row in the &quot;BBBServer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.bbb.model.impl.BBBServerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.bbb.model.impl.BBBServerImpl}.
 * </p>
 *
 * @author Shinn Lok
 * @see BBBServer
 * @see com.liferay.bbb.model.impl.BBBServerImpl
 * @see com.liferay.bbb.model.impl.BBBServerModelImpl
 * @generated
 */
public interface BBBServerModel extends AuditedModel, BaseModel<BBBServer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a b b b server model instance should use the {@link BBBServer} interface instead.
	 */

	/**
	 * Returns the primary key of this b b b server.
	 *
	 * @return the primary key of this b b b server
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this b b b server.
	 *
	 * @param primaryKey the primary key of this b b b server
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the bbb server ID of this b b b server.
	 *
	 * @return the bbb server ID of this b b b server
	 */
	public long getBbbServerId();

	/**
	 * Sets the bbb server ID of this b b b server.
	 *
	 * @param bbbServerId the bbb server ID of this b b b server
	 */
	public void setBbbServerId(long bbbServerId);

	/**
	 * Returns the company ID of this b b b server.
	 *
	 * @return the company ID of this b b b server
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this b b b server.
	 *
	 * @param companyId the company ID of this b b b server
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this b b b server.
	 *
	 * @return the user ID of this b b b server
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this b b b server.
	 *
	 * @param userId the user ID of this b b b server
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this b b b server.
	 *
	 * @return the user uuid of this b b b server
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this b b b server.
	 *
	 * @param userUuid the user uuid of this b b b server
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this b b b server.
	 *
	 * @return the user name of this b b b server
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this b b b server.
	 *
	 * @param userName the user name of this b b b server
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this b b b server.
	 *
	 * @return the create date of this b b b server
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this b b b server.
	 *
	 * @param createDate the create date of this b b b server
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this b b b server.
	 *
	 * @return the modified date of this b b b server
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this b b b server.
	 *
	 * @param modifiedDate the modified date of this b b b server
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this b b b server.
	 *
	 * @return the name of this b b b server
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this b b b server.
	 *
	 * @param name the name of this b b b server
	 */
	public void setName(String name);

	/**
	 * Returns the url of this b b b server.
	 *
	 * @return the url of this b b b server
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this b b b server.
	 *
	 * @param url the url of this b b b server
	 */
	public void setUrl(String url);

	/**
	 * Returns the secret of this b b b server.
	 *
	 * @return the secret of this b b b server
	 */
	@AutoEscape
	public String getSecret();

	/**
	 * Sets the secret of this b b b server.
	 *
	 * @param secret the secret of this b b b server
	 */
	public void setSecret(String secret);

	/**
	 * Returns the active of this b b b server.
	 *
	 * @return the active of this b b b server
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this b b b server is active.
	 *
	 * @return <code>true</code> if this b b b server is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this b b b server is active.
	 *
	 * @param active the active of this b b b server
	 */
	public void setActive(boolean active);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(BBBServer bbbServer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BBBServer> toCacheModel();

	@Override
	public BBBServer toEscapedModel();

	@Override
	public BBBServer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}