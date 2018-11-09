package kr.or.ddit.prod.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class ProdVo implements HttpSessionBindingListener {
	//prod_id , prod_name, lprod_nm, prod_insdate 
	private String prod_id;
	private String prod_name;
	private String lprod_nm;
	private Date prod_insdate;
	private String buyer_name;
	private String buyer_mail;
	private int Rnum;
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public Date getProd_insdate() {
		return prod_insdate;
	}
	public void setProd_insdate(Date prod_insdate) {
		this.prod_insdate = prod_insdate;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_mail() {
		return buyer_mail;
	}
	public void setBuyer_mail(String buyer_mail) {
		this.buyer_mail = buyer_mail;
	}
	public int getRnum() {
		return Rnum;
	}
	public void setRnum(int rnum) {
		Rnum = rnum;
	}
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name
				+ ", lprod_nm=" + lprod_nm + ", prod_insdate=" + prod_insdate
				+ ", buyer_name=" + buyer_name + ", buyer_mail=" + buyer_mail
				+ ", Rnum=" + Rnum + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}
	

	
	
}
