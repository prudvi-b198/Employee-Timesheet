package com.employee.timesheet.domain;

import java.text.DecimalFormat;

import com.employee.timesheet.enums.EmployeeType;

public abstract class Employee {
	public static final int MAX_WORK_DAYS = 260;
	public static final int MIN_WORK_DAYS = 1;

	private int employeeId;
	private String employeeName;
	private float vacationDays;
	private int workDays;
	private EmployeeType employeeType;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(float vacationDays) {
		this.vacationDays = vacationDays;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public abstract void logWork(int days) throws Exception;

	public void takeVacation(float days) throws RuntimeException {
		if (days > vacationDays) {
			throw new RuntimeException("Vacations balance is not enough to take vacations.");
		}
		float vacations = this.vacationDays - days;
		this.setVacationDays(vacations);
		DecimalFormat df = new DecimalFormat(".00");
		this.setVacationDays(Float.valueOf(df.format(this.getVacationDays())));
	}

	protected void validateWorkDays(int numberOfDaysWorked) throws RuntimeException {
		this.workDays += numberOfDaysWorked;
		if (this.workDays < MIN_WORK_DAYS || this.workDays > MAX_WORK_DAYS) {
			this.workDays -= numberOfDaysWorked;
			throw new RuntimeException("Work days can not be less than 1 or greater than 260 days.");
		}
	}
}