package com.employee.timesheet.domain;

import java.text.DecimalFormat;

public class Hourly extends Employee {

	@Override
	public void logWork(int numberOfDaysWorked) throws Exception {
		super.validateWorkDays(numberOfDaysWorked);
		float vacations = (Float.valueOf(numberOfDaysWorked) / MAX_WORK_DAYS) * 10;
		this.setVacationDays(this.getVacationDays() + vacations);
		DecimalFormat df = new DecimalFormat(".00");
		this.setVacationDays(Float.valueOf(df.format(this.getVacationDays())));
	}

}