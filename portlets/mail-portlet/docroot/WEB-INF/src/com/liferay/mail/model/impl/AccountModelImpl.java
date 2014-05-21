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

package com.liferay.mail.model.impl;

import com.liferay.mail.model.Account;
import com.liferay.mail.model.AccountModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Account service. Represents a row in the &quot;Mail_Account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.mail.model.AccountModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccountImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountImpl
 * @see com.liferay.mail.model.Account
 * @see com.liferay.mail.model.AccountModel
 * @generated
 */
public class AccountModelImpl extends BaseModelImpl<Account>
	implements AccountModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a account model instance should use the {@link com.liferay.mail.model.Account} interface instead.
	 */
	public static final String TABLE_NAME = "Mail_Account";
	public static final Object[][] TABLE_COLUMNS = {
			{ "accountId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "address", Types.VARCHAR },
			{ "personalName", Types.VARCHAR },
			{ "protocol", Types.VARCHAR },
			{ "incomingHostName", Types.VARCHAR },
			{ "incomingPort", Types.INTEGER },
			{ "incomingSecure", Types.BOOLEAN },
			{ "outgoingHostName", Types.VARCHAR },
			{ "outgoingPort", Types.INTEGER },
			{ "outgoingSecure", Types.BOOLEAN },
			{ "login", Types.VARCHAR },
			{ "password_", Types.VARCHAR },
			{ "savePassword", Types.BOOLEAN },
			{ "signature", Types.VARCHAR },
			{ "useSignature", Types.BOOLEAN },
			{ "folderPrefix", Types.VARCHAR },
			{ "inboxFolderId", Types.BIGINT },
			{ "draftFolderId", Types.BIGINT },
			{ "sentFolderId", Types.BIGINT },
			{ "trashFolderId", Types.BIGINT },
			{ "defaultSender", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Mail_Account (accountId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,address VARCHAR(75) null,personalName VARCHAR(75) null,protocol VARCHAR(75) null,incomingHostName VARCHAR(75) null,incomingPort INTEGER,incomingSecure BOOLEAN,outgoingHostName VARCHAR(75) null,outgoingPort INTEGER,outgoingSecure BOOLEAN,login VARCHAR(75) null,password_ VARCHAR(75) null,savePassword BOOLEAN,signature VARCHAR(75) null,useSignature BOOLEAN,folderPrefix VARCHAR(75) null,inboxFolderId LONG,draftFolderId LONG,sentFolderId LONG,trashFolderId LONG,defaultSender BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Mail_Account";
	public static final String ORDER_BY_JPQL = " ORDER BY account.address ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Mail_Account.address ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.mail.model.Account"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.mail.model.Account"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.mail.model.Account"),
			true);
	public static long ADDRESS_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.mail.model.Account"));

	public AccountModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _accountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Account.class;
	}

	@Override
	public String getModelClassName() {
		return Account.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("accountId", getAccountId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("address", getAddress());
		attributes.put("personalName", getPersonalName());
		attributes.put("protocol", getProtocol());
		attributes.put("incomingHostName", getIncomingHostName());
		attributes.put("incomingPort", getIncomingPort());
		attributes.put("incomingSecure", getIncomingSecure());
		attributes.put("outgoingHostName", getOutgoingHostName());
		attributes.put("outgoingPort", getOutgoingPort());
		attributes.put("outgoingSecure", getOutgoingSecure());
		attributes.put("login", getLogin());
		attributes.put("password", getPassword());
		attributes.put("savePassword", getSavePassword());
		attributes.put("signature", getSignature());
		attributes.put("useSignature", getUseSignature());
		attributes.put("folderPrefix", getFolderPrefix());
		attributes.put("inboxFolderId", getInboxFolderId());
		attributes.put("draftFolderId", getDraftFolderId());
		attributes.put("sentFolderId", getSentFolderId());
		attributes.put("trashFolderId", getTrashFolderId());
		attributes.put("defaultSender", getDefaultSender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String personalName = (String)attributes.get("personalName");

		if (personalName != null) {
			setPersonalName(personalName);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String incomingHostName = (String)attributes.get("incomingHostName");

		if (incomingHostName != null) {
			setIncomingHostName(incomingHostName);
		}

		Integer incomingPort = (Integer)attributes.get("incomingPort");

		if (incomingPort != null) {
			setIncomingPort(incomingPort);
		}

		Boolean incomingSecure = (Boolean)attributes.get("incomingSecure");

		if (incomingSecure != null) {
			setIncomingSecure(incomingSecure);
		}

		String outgoingHostName = (String)attributes.get("outgoingHostName");

		if (outgoingHostName != null) {
			setOutgoingHostName(outgoingHostName);
		}

		Integer outgoingPort = (Integer)attributes.get("outgoingPort");

		if (outgoingPort != null) {
			setOutgoingPort(outgoingPort);
		}

		Boolean outgoingSecure = (Boolean)attributes.get("outgoingSecure");

		if (outgoingSecure != null) {
			setOutgoingSecure(outgoingSecure);
		}

		String login = (String)attributes.get("login");

		if (login != null) {
			setLogin(login);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Boolean savePassword = (Boolean)attributes.get("savePassword");

		if (savePassword != null) {
			setSavePassword(savePassword);
		}

		String signature = (String)attributes.get("signature");

		if (signature != null) {
			setSignature(signature);
		}

		Boolean useSignature = (Boolean)attributes.get("useSignature");

		if (useSignature != null) {
			setUseSignature(useSignature);
		}

		String folderPrefix = (String)attributes.get("folderPrefix");

		if (folderPrefix != null) {
			setFolderPrefix(folderPrefix);
		}

		Long inboxFolderId = (Long)attributes.get("inboxFolderId");

		if (inboxFolderId != null) {
			setInboxFolderId(inboxFolderId);
		}

		Long draftFolderId = (Long)attributes.get("draftFolderId");

		if (draftFolderId != null) {
			setDraftFolderId(draftFolderId);
		}

		Long sentFolderId = (Long)attributes.get("sentFolderId");

		if (sentFolderId != null) {
			setSentFolderId(sentFolderId);
		}

		Long trashFolderId = (Long)attributes.get("trashFolderId");

		if (trashFolderId != null) {
			setTrashFolderId(trashFolderId);
		}

		Boolean defaultSender = (Boolean)attributes.get("defaultSender");

		if (defaultSender != null) {
			setDefaultSender(defaultSender);
		}
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_columnBitmask = -1L;

		if (_originalAddress == null) {
			_originalAddress = _address;
		}

		_address = address;
	}

	public String getOriginalAddress() {
		return GetterUtil.getString(_originalAddress);
	}

	@Override
	public String getPersonalName() {
		if (_personalName == null) {
			return StringPool.BLANK;
		}
		else {
			return _personalName;
		}
	}

	@Override
	public void setPersonalName(String personalName) {
		_personalName = personalName;
	}

	@Override
	public String getProtocol() {
		if (_protocol == null) {
			return StringPool.BLANK;
		}
		else {
			return _protocol;
		}
	}

	@Override
	public void setProtocol(String protocol) {
		_protocol = protocol;
	}

	@Override
	public String getIncomingHostName() {
		if (_incomingHostName == null) {
			return StringPool.BLANK;
		}
		else {
			return _incomingHostName;
		}
	}

	@Override
	public void setIncomingHostName(String incomingHostName) {
		_incomingHostName = incomingHostName;
	}

	@Override
	public int getIncomingPort() {
		return _incomingPort;
	}

	@Override
	public void setIncomingPort(int incomingPort) {
		_incomingPort = incomingPort;
	}

	@Override
	public boolean getIncomingSecure() {
		return _incomingSecure;
	}

	@Override
	public boolean isIncomingSecure() {
		return _incomingSecure;
	}

	@Override
	public void setIncomingSecure(boolean incomingSecure) {
		_incomingSecure = incomingSecure;
	}

	@Override
	public String getOutgoingHostName() {
		if (_outgoingHostName == null) {
			return StringPool.BLANK;
		}
		else {
			return _outgoingHostName;
		}
	}

	@Override
	public void setOutgoingHostName(String outgoingHostName) {
		_outgoingHostName = outgoingHostName;
	}

	@Override
	public int getOutgoingPort() {
		return _outgoingPort;
	}

	@Override
	public void setOutgoingPort(int outgoingPort) {
		_outgoingPort = outgoingPort;
	}

	@Override
	public boolean getOutgoingSecure() {
		return _outgoingSecure;
	}

	@Override
	public boolean isOutgoingSecure() {
		return _outgoingSecure;
	}

	@Override
	public void setOutgoingSecure(boolean outgoingSecure) {
		_outgoingSecure = outgoingSecure;
	}

	@Override
	public String getLogin() {
		if (_login == null) {
			return StringPool.BLANK;
		}
		else {
			return _login;
		}
	}

	@Override
	public void setLogin(String login) {
		_login = login;
	}

	@Override
	public String getPassword() {
		if (_password == null) {
			return StringPool.BLANK;
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		_password = password;
	}

	@Override
	public boolean getSavePassword() {
		return _savePassword;
	}

	@Override
	public boolean isSavePassword() {
		return _savePassword;
	}

	@Override
	public void setSavePassword(boolean savePassword) {
		_savePassword = savePassword;
	}

	@Override
	public String getSignature() {
		if (_signature == null) {
			return StringPool.BLANK;
		}
		else {
			return _signature;
		}
	}

	@Override
	public void setSignature(String signature) {
		_signature = signature;
	}

	@Override
	public boolean getUseSignature() {
		return _useSignature;
	}

	@Override
	public boolean isUseSignature() {
		return _useSignature;
	}

	@Override
	public void setUseSignature(boolean useSignature) {
		_useSignature = useSignature;
	}

	@Override
	public String getFolderPrefix() {
		if (_folderPrefix == null) {
			return StringPool.BLANK;
		}
		else {
			return _folderPrefix;
		}
	}

	@Override
	public void setFolderPrefix(String folderPrefix) {
		_folderPrefix = folderPrefix;
	}

	@Override
	public long getInboxFolderId() {
		return _inboxFolderId;
	}

	@Override
	public void setInboxFolderId(long inboxFolderId) {
		_inboxFolderId = inboxFolderId;
	}

	@Override
	public long getDraftFolderId() {
		return _draftFolderId;
	}

	@Override
	public void setDraftFolderId(long draftFolderId) {
		_draftFolderId = draftFolderId;
	}

	@Override
	public long getSentFolderId() {
		return _sentFolderId;
	}

	@Override
	public void setSentFolderId(long sentFolderId) {
		_sentFolderId = sentFolderId;
	}

	@Override
	public long getTrashFolderId() {
		return _trashFolderId;
	}

	@Override
	public void setTrashFolderId(long trashFolderId) {
		_trashFolderId = trashFolderId;
	}

	@Override
	public boolean getDefaultSender() {
		return _defaultSender;
	}

	@Override
	public boolean isDefaultSender() {
		return _defaultSender;
	}

	@Override
	public void setDefaultSender(boolean defaultSender) {
		_defaultSender = defaultSender;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Account.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Account toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Account)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setAccountId(getAccountId());
		accountImpl.setCompanyId(getCompanyId());
		accountImpl.setUserId(getUserId());
		accountImpl.setUserName(getUserName());
		accountImpl.setCreateDate(getCreateDate());
		accountImpl.setModifiedDate(getModifiedDate());
		accountImpl.setAddress(getAddress());
		accountImpl.setPersonalName(getPersonalName());
		accountImpl.setProtocol(getProtocol());
		accountImpl.setIncomingHostName(getIncomingHostName());
		accountImpl.setIncomingPort(getIncomingPort());
		accountImpl.setIncomingSecure(getIncomingSecure());
		accountImpl.setOutgoingHostName(getOutgoingHostName());
		accountImpl.setOutgoingPort(getOutgoingPort());
		accountImpl.setOutgoingSecure(getOutgoingSecure());
		accountImpl.setLogin(getLogin());
		accountImpl.setPassword(getPassword());
		accountImpl.setSavePassword(getSavePassword());
		accountImpl.setSignature(getSignature());
		accountImpl.setUseSignature(getUseSignature());
		accountImpl.setFolderPrefix(getFolderPrefix());
		accountImpl.setInboxFolderId(getInboxFolderId());
		accountImpl.setDraftFolderId(getDraftFolderId());
		accountImpl.setSentFolderId(getSentFolderId());
		accountImpl.setTrashFolderId(getTrashFolderId());
		accountImpl.setDefaultSender(getDefaultSender());

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public int compareTo(Account account) {
		int value = 0;

		value = getAddress().compareTo(account.getAddress());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Account)) {
			return false;
		}

		Account account = (Account)obj;

		long primaryKey = account.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AccountModelImpl accountModelImpl = this;

		accountModelImpl._originalUserId = accountModelImpl._userId;

		accountModelImpl._setOriginalUserId = false;

		accountModelImpl._originalAddress = accountModelImpl._address;

		accountModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Account> toCacheModel() {
		AccountCacheModel accountCacheModel = new AccountCacheModel();

		accountCacheModel.accountId = getAccountId();

		accountCacheModel.companyId = getCompanyId();

		accountCacheModel.userId = getUserId();

		accountCacheModel.userName = getUserName();

		String userName = accountCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			accountCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			accountCacheModel.createDate = createDate.getTime();
		}
		else {
			accountCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			accountCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			accountCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		accountCacheModel.address = getAddress();

		String address = accountCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			accountCacheModel.address = null;
		}

		accountCacheModel.personalName = getPersonalName();

		String personalName = accountCacheModel.personalName;

		if ((personalName != null) && (personalName.length() == 0)) {
			accountCacheModel.personalName = null;
		}

		accountCacheModel.protocol = getProtocol();

		String protocol = accountCacheModel.protocol;

		if ((protocol != null) && (protocol.length() == 0)) {
			accountCacheModel.protocol = null;
		}

		accountCacheModel.incomingHostName = getIncomingHostName();

		String incomingHostName = accountCacheModel.incomingHostName;

		if ((incomingHostName != null) && (incomingHostName.length() == 0)) {
			accountCacheModel.incomingHostName = null;
		}

		accountCacheModel.incomingPort = getIncomingPort();

		accountCacheModel.incomingSecure = getIncomingSecure();

		accountCacheModel.outgoingHostName = getOutgoingHostName();

		String outgoingHostName = accountCacheModel.outgoingHostName;

		if ((outgoingHostName != null) && (outgoingHostName.length() == 0)) {
			accountCacheModel.outgoingHostName = null;
		}

		accountCacheModel.outgoingPort = getOutgoingPort();

		accountCacheModel.outgoingSecure = getOutgoingSecure();

		accountCacheModel.login = getLogin();

		String login = accountCacheModel.login;

		if ((login != null) && (login.length() == 0)) {
			accountCacheModel.login = null;
		}

		accountCacheModel.password = getPassword();

		String password = accountCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			accountCacheModel.password = null;
		}

		accountCacheModel.savePassword = getSavePassword();

		accountCacheModel.signature = getSignature();

		String signature = accountCacheModel.signature;

		if ((signature != null) && (signature.length() == 0)) {
			accountCacheModel.signature = null;
		}

		accountCacheModel.useSignature = getUseSignature();

		accountCacheModel.folderPrefix = getFolderPrefix();

		String folderPrefix = accountCacheModel.folderPrefix;

		if ((folderPrefix != null) && (folderPrefix.length() == 0)) {
			accountCacheModel.folderPrefix = null;
		}

		accountCacheModel.inboxFolderId = getInboxFolderId();

		accountCacheModel.draftFolderId = getDraftFolderId();

		accountCacheModel.sentFolderId = getSentFolderId();

		accountCacheModel.trashFolderId = getTrashFolderId();

		accountCacheModel.defaultSender = getDefaultSender();

		return accountCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{accountId=");
		sb.append(getAccountId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", personalName=");
		sb.append(getPersonalName());
		sb.append(", protocol=");
		sb.append(getProtocol());
		sb.append(", incomingHostName=");
		sb.append(getIncomingHostName());
		sb.append(", incomingPort=");
		sb.append(getIncomingPort());
		sb.append(", incomingSecure=");
		sb.append(getIncomingSecure());
		sb.append(", outgoingHostName=");
		sb.append(getOutgoingHostName());
		sb.append(", outgoingPort=");
		sb.append(getOutgoingPort());
		sb.append(", outgoingSecure=");
		sb.append(getOutgoingSecure());
		sb.append(", login=");
		sb.append(getLogin());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", savePassword=");
		sb.append(getSavePassword());
		sb.append(", signature=");
		sb.append(getSignature());
		sb.append(", useSignature=");
		sb.append(getUseSignature());
		sb.append(", folderPrefix=");
		sb.append(getFolderPrefix());
		sb.append(", inboxFolderId=");
		sb.append(getInboxFolderId());
		sb.append(", draftFolderId=");
		sb.append(getDraftFolderId());
		sb.append(", sentFolderId=");
		sb.append(getSentFolderId());
		sb.append(", trashFolderId=");
		sb.append(getTrashFolderId());
		sb.append(", defaultSender=");
		sb.append(getDefaultSender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.liferay.mail.model.Account");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalName</column-name><column-value><![CDATA[");
		sb.append(getPersonalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protocol</column-name><column-value><![CDATA[");
		sb.append(getProtocol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incomingHostName</column-name><column-value><![CDATA[");
		sb.append(getIncomingHostName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incomingPort</column-name><column-value><![CDATA[");
		sb.append(getIncomingPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incomingSecure</column-name><column-value><![CDATA[");
		sb.append(getIncomingSecure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outgoingHostName</column-name><column-value><![CDATA[");
		sb.append(getOutgoingHostName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outgoingPort</column-name><column-value><![CDATA[");
		sb.append(getOutgoingPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outgoingSecure</column-name><column-value><![CDATA[");
		sb.append(getOutgoingSecure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>login</column-name><column-value><![CDATA[");
		sb.append(getLogin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>savePassword</column-name><column-value><![CDATA[");
		sb.append(getSavePassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signature</column-name><column-value><![CDATA[");
		sb.append(getSignature());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useSignature</column-name><column-value><![CDATA[");
		sb.append(getUseSignature());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderPrefix</column-name><column-value><![CDATA[");
		sb.append(getFolderPrefix());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inboxFolderId</column-name><column-value><![CDATA[");
		sb.append(getInboxFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>draftFolderId</column-name><column-value><![CDATA[");
		sb.append(getDraftFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentFolderId</column-name><column-value><![CDATA[");
		sb.append(getSentFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trashFolderId</column-name><column-value><![CDATA[");
		sb.append(getTrashFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultSender</column-name><column-value><![CDATA[");
		sb.append(getDefaultSender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Account.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Account.class
		};
	private long _accountId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _address;
	private String _originalAddress;
	private String _personalName;
	private String _protocol;
	private String _incomingHostName;
	private int _incomingPort;
	private boolean _incomingSecure;
	private String _outgoingHostName;
	private int _outgoingPort;
	private boolean _outgoingSecure;
	private String _login;
	private String _password;
	private boolean _savePassword;
	private String _signature;
	private boolean _useSignature;
	private String _folderPrefix;
	private long _inboxFolderId;
	private long _draftFolderId;
	private long _sentFolderId;
	private long _trashFolderId;
	private boolean _defaultSender;
	private long _columnBitmask;
	private Account _escapedModel;
}