package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "centres2")
public class Centre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer centreId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String centreInfo;

	public Integer getCentreId() {
		return centreId;
	}
	public void setCentreId(Integer centreId) {
		this.centreId = centreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCentreInfo() {
		return centreInfo;
	}
	public void setCentreInfo(String centreInfo) {
		this.centreInfo = centreInfo;
	}


}
