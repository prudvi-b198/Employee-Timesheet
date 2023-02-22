import { EmployeeType } from './employee.enum';
export class Employee {
  employeeId: number;
  employeeName: string;
  employeeType: EmployeeType;
  vacationDays: number;
  workDays: number;
}
