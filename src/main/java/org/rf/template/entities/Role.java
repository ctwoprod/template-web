package org.rf.template.entities;

// Generated Dec 11, 2016 11:49:31 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.rf.template.constants.Constanta;
import org.rf.template.core.persistence.domain.UuidBasedCoreDomain;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role_", catalog = Constanta.SCHEMA)
public class Role extends UuidBasedCoreDomain implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8168693900200590599L;
	private String nama;
	private String keterangan;

	public static final String ROLE_ADMINISTRATOR = "1";
	public static final String ROLE_MANAGER = "2";
	public static final String ROLE_APPROVER = "3";
	public static final String ROLE_UPLOADER = "4";
	public static final String ROLE_USER = "5";

	public Role() {
	}

	public Role(String nama, String keterangan) {
		this.nama = nama;
		this.keterangan = keterangan;
	}

	@Column(name = "NAMA", length = 100)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "KETERANGAN", length = 250)
	public String getKeterangan() {
		return this.keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}
