package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer doctorId;
	@NotNull
	private String name;
	@NotNull
	private String doctorType;
	@NotNull
	private String email;
	@NotNull
	private String phone;
	@NotNull
	private String doctorInfo;
	@NotNull
	@Lob
	@Column(length=100000)
	private byte[] image;
	
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoctorType() {
		return doctorType;
	}
	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
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
	public String getDoctorInfo() {
		return doctorInfo;
	}
	public void setDoctorInfo(String doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

	public String getImage() {
		if(image != null){
			return new String(image);
		}
		return null;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
