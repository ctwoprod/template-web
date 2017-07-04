package org.rf.template.core.persistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * An Entity Class with UUID Based ID. Any Entity that have ID with System UUID
 * primary key, should/may extend from this class.
 * 
 * @author Roberto
 */
@MappedSuperclass
public abstract class UuidBasedCoreDomain extends CoreDomain {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 2941889719273066897L;

	/**
	 * Id. Generated from system UUID.
	 */
	protected String id;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 * @author Roberto
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = THIRTY_TWO)
	@Override
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
	 * @author Roberto
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}
}
