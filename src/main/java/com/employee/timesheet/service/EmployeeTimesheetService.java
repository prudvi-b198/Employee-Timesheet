package com.employee.timesheet.service;

import java.util.List;

import com.employee.timesheet.domain.Employee;

public interface EmployeeTimesheetService {
	
	List<Employee> getEmployees();

	List<Employee> logWork(int id, int workDays) throws Exception;

	List<Employee> takeVacation(int id, float vacations) throws Exception;
}
