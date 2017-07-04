package org.rf.template.model.table;

import java.io.Serializable;

public class DataTableBean implements Serializable{
	private static final long serialVersionUID = -1727317970501062345L;

	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	// private List<Object> data;
	private Object data;

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/*
	 * public List<Object> getData() { return data; } public void
	 * setData(List<Object> data) { this.data = data; }
	 */
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
