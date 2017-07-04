package org.rf.template.core.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class HistoricalCoreDomain.
 * 
 * @author dbejar
 */
@MappedSuperclass
public abstract class HistoricalCoreDomain extends CoreDomain {

	/** The Constant serialVersionUID. @author dbejar */
	static final long serialVersionUID = 5166611768473775880L;

	/** The Constant REMOVAL_DATE. */
	public static final String REMOVAL_DATE = "removalDate";

	/** The removal date. */
	private Date removalDate;

	/**
	 * Gets the removal date.
	 * 
	 * @return the removalDate
	 * @author dbejar
	 */
	@Column(name = "REMOVAL_DATE", length = SEVEN)
	@Temporal(TemporalType.DATE)
	public Date getRemovalDate() {
		return this.removalDate;
	}

	/**
	 * Sets the removal date.
	 * 
	 * @param removalDate
	 *            the removalDate to set
	 * @author dbejar
	 */
	public void setRemovalDate(Date removalDate) {
		this.removalDate = removalDate;
	}

}
