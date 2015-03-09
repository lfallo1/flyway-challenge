package com.flywaychallenge.models;

import java.sql.Date;

import org.joda.time.LocalDate;

import com.flywaychallenge.annotations.Column;
import com.flywaychallenge.annotations.PropertyName;
import com.flywaychallenge.annotations.TableName;
import com.flywaychallenge.annotations.TemplateConstructor;

@TableName(value = "employee")
public class Employee {
	@Column("id")
	private Integer id;
	@Column("name")
	private String name;
	@Column("job_title")
	private String jobTitle;
	@Column("department")
	private String department;
	@Column("start_date")
	private LocalDate startDate;
	@Column("active")
	private Boolean active;

	public Employee() {
	}

	@TemplateConstructor
	public Employee(@PropertyName("id") Integer id,
			@PropertyName("name") String name,
			@PropertyName("jobTitle") String jobTitle,
			@PropertyName("department") String department,
			@PropertyName("startDate") Date startDate,
			@PropertyName("active") Boolean active) {
		this.id = id;
		this.name = name;
		this.jobTitle = jobTitle;
		this.department = department;
		this.startDate = new LocalDate(startDate);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + "\\t" + name + "\\t" + jobTitle + "\\t" + department
				+ "\\t" + startDate + "\\t" + active;
	}
}
