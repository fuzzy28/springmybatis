package org.jrue.poc.springmybatis.domain;


/**
 * Base for all Entities that have basic audit information
 * @author jruelos
 *
 */

public abstract class BaseEntity {

	private Integer delflag = 0;
	private Integer credate;
	private Integer cretime;
	private String creperson;
	private String creproid;
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Integer getCredate() {
		return credate;
	}
	public void setCredate(Integer credate) {
		this.credate = credate;
	}
	public Integer getCretime() {
		return cretime;
	}
	public void setCretime(Integer cretime) {
		this.cretime = cretime;
	}
	public String getCreperson() {
		return creperson;
	}
	public void setCreperson(String creperson) {
		this.creperson = creperson;
	}
	public String getCreproid() {
		return creproid;
	}
	public void setCreproid(String creproid) {
		this.creproid = creproid;
	}		
}
