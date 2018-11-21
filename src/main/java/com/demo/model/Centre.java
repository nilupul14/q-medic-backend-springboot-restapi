package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "centres")
public class Centre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer centreId;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String phone;
	@NotNull
	private String address;
	@NotNull
	private String centreInfo;
	@Lob
	@Column(length=100000)
	private byte[] image;
	private boolean isDeleted = false;

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}
}
