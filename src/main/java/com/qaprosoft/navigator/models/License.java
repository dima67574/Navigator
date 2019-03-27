package com.qaprosoft.navigator.models;

import java.util.Date;

public class License {
	private String dl;
	private String clas;
	private Date exp;
	private Date end;
	public License() {}
	public String getDl() {
		return dl;
	}
	public void setDl(String dl) {
		this.dl = dl;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
