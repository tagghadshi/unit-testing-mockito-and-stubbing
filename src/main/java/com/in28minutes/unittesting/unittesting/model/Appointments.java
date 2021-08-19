package com.in28minutes.unittesting.unittesting.model;

public class Appointments {
	private long appointmentid;
	private String userName;
	private byte userAge;
	private String userEmail;
	private long userPhoneNo;

	public Appointments(long appointmentid, String userName, byte userAge, String userEmail, long userPhoneNo) {
		this.appointmentid = appointmentid;
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPhoneNo = userPhoneNo;
	}

	public long getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(long appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte getUserAge() {
		return userAge;
	}

	public void setUserAge(byte userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

}
