package org.rf.template.entities;

// Generated Dec 11, 2016 11:49:31 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.rf.template.constants.Constanta;
import org.rf.template.core.persistence.domain.UuidBasedCoreDomain;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group_", catalog = Constanta.SCHEMA)
public class Group extends UuidBasedCoreDomain implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4599040006910652608L;
	private String nama;

	public static final String GROUP_BBM = "1";
	public static final String GROUP_GAS = "2";

	public Group() {
	}

	public Group(String nama) {
		this.nama = nama;
	}

	@Column(name = "NAMA", length = 250)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}
