package observer_pattern.client;

import observer_pattern.domain.Employee;
import observer_pattern.observers.HRDepartment;
import observer_pattern.observers.IObserver;
import observer_pattern.observers.PayrollDepartment;
import observer_pattern.subjects.EmployeeManagementSystem;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        IObserver payroll = new PayrollDepartment();
        IObserver hrSystem = new HRDepartment();

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.registerObserver(payroll);
        ems.registerObserver(hrSystem);

        Employee bob = new Employee("Bob", new Date(), 35000, true);
        ems.hireEmployee(bob);
        System.out.println("---------------------------------");

        ems.modifyEmployeeName(5, "Bengt");

    }
}










