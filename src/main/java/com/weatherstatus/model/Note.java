package com.weatherstatus.model;


public class Note {
	
	@Override
	public String toString() {
		return "Note [status=" + status + ", note=" + note + ", createDate=" + createDate + ", temperature="
				+ temperature + "]";
	}
	private String status;
	private String note;
	private String createDate	;
	private String temperature;
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
