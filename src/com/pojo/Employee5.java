package com.pojo;

public class Employee5 {

	private String lastmoddatetime;

	private String id;

	private String description;

	private String name;

	private String lastmoduserid;

	public String getLastmoddatetime() {
		return lastmoddatetime;
	}

	public void setLastmoddatetime(String lastmoddatetime) {
		this.lastmoddatetime = lastmoddatetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastmoduserid() {
		return lastmoduserid;
	}

	public void setLastmoduserid(String lastmoduserid) {
		this.lastmoduserid = lastmoduserid;
	}

	@Override
	public String toString() {
		return "ClassPojo [lastmoddatetime = " + lastmoddatetime + ", id = " + id + ", description = " + description
				+ ", name = " + name + ", lastmoduserid = " + lastmoduserid + "]";
	}

}
