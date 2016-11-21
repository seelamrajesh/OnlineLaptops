package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Product implements Serializable {
	@Id
	@GeneratedValue
	@Column
	private String pid;
	@Column
	private String pname;
	@Column
	private String pdes;
	@Column
	private int pprice;
	@Column
	private int pstock;
	@Column
	private String supId;
	@Column
	private String catId;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}

}
