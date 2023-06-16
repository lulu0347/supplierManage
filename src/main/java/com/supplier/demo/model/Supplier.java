package com.supplier.demo.model;

import java.sql.Timestamp;

public class Supplier {

	private Integer supplierId;
	private String account;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String last_create_staff;
	private Timestamp last_create_time;
	private String last_modify_staff;
	private Timestamp last_modify_time;
	
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLast_create_staff() {
		return last_create_staff;
	}
	public void setLast_create_staff(String last_create_staff) {
		this.last_create_staff = last_create_staff;
	}
	public Timestamp getLast_create_time() {
		return last_create_time;
	}
	public void setLast_create_time(Timestamp last_create_time) {
		this.last_create_time = last_create_time;
	}
	public String getLast_modify_staff() {
		return last_modify_staff;
	}
	public void setLast_modify_staff(String last_modify_staff) {
		this.last_modify_staff = last_modify_staff;
	}
	public Timestamp getLast_modify_time() {
		return last_modify_time;
	}
	public void setLast_modify_time(Timestamp last_modify_time) {
		this.last_modify_time = last_modify_time;
	}
}
