package com.employee.timesheet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.employee.timesheet.domain.Employee;
import com.employee.timesheet.domain.Hourly;
import com.employee.timesheet.domain.Manager;
import com.employee.timesheet.domain.Salaried;
import com.employee.timesheet.enums.EmployeeType;

@Service
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService {

	private static List<Employee> employees;

	@PostConstruct
	private void createEmployees() {
		employees = new ArrayList<>();
		employees.add(getEmployee(1, "Robert", EmployeeType.MANAGER));
		employees.add(getEmployee(2, "Alwis", EmployeeType.HOURLY));
		employees.add(getEmployee(3, "Rehan", EmployeeType.HOURLY));
		employees.add(getEmployee(4, "Abdul", EmployeeType.SALARIED));
		employees.add(getEmployee(5, "Waris", EmployeeType.MANAGER));
		employees.add(getEmployee(6, "Wuhan", EmployeeType.SALARIED));
		employees.add(getEmployee(7, "Tokyo", EmployeeType.MANAGER));
		employees.add(getEmployee(8, "Rangel", EmployeeType.HOURLY));
		employees.add(getEmployee(9, "Adwards", EmployeeType.MANAGER));
		employees.add(getEmployee(10, "Romeo", EmployeeType.HOURLY));
	}
	
	@Override
	public List<Employee> logWork(int id, int workDays) throws Exception {
		Optional<Employee> emp = employees.stream().filter(employee -> employee.getEmployeeId() == id).findFirst();
		if (emp.isPresent()) {
			emp.get().logWork(workDays);
		} else {
			throw new RuntimeException("Employee not found");
		}
		return employees;
	}
	
	@Override
	public List<Employee> takeVacation(int id, float vacations) throws Exception {
		Optional<Employee> emp = employees.stream().filter(employee -> employee.getEmployeeId() == id).findFirst();
		if (emp.isPresent()) {
			emp.get().takeVacation(vacations);
		} else {
			throw new RuntimeException("Employee not found");
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	private Employee getEmployee(int id, String name, EmployeeType type) {
		Employee employee = null;
		switch (type) {
		case HOURLY:
			employee = new Hourly();
			employee.setEmployeeType(EmployeeType.HOURLY);
			break;
		case SALARIED:
			employee = new Salaried();
			employee.setEmployeeType(EmployeeType.SALARIED);
			break;
		case MANAGER:
			employee = new Manager();
			employee.setEmployeeType(EmployeeType.MANAGER);
			break;
		}
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		return employee;
	}

}