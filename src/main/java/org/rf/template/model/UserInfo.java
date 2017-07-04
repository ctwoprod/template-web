package org.rf.template.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = -1490497193800570907L;

	private String id;
	private String nama;
	private String email;
	private String userName;
	private String aktif;
	private String lastLogin;
	private String groupId;
	private String groupName;
	private String roleId;
	private String roleName;
	private String pembangkitId;
	private String pembangkitName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAktif() {
		return aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPembangkitId() {
		return pembangkitId;
	}

	public void setPembangkitId(String pembangkitId) {
		this.pembangkitId = pembangkitId;
	}

	public String getPembangkitName() {
		return pembangkitName;
	}

	public void setPembangkitName(String pembangkitName) {
		this.pembangkitName = pembangkitName;
	}

}
