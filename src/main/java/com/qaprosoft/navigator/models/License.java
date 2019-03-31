package com.qaprosoft.navigator.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class License extends AbstractModel {
	private String dl;
	private String clas;
	private Date exp;
	private Date end;
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");	
	private SimpleDateFormat form = new SimpleDateFormat ("yyyy-MM-dd");
	
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
	public String getExp() {
		return format.format(exp);
	}
	public void setExp(String exp) throws ParseException {
		this.exp = format.parse(exp);
	}
	public String getEnd() {
		return form.format(end);
	}
	public void setEnd(String end) throws ParseException {
		this.end = form.parse(end);
	}
	@Override
	public String toString() {
		return "License [dl=" + dl + ", clas=" + clas + ", exp=" + exp + ", end=" + end + "]";
	}
	
	
	
}
