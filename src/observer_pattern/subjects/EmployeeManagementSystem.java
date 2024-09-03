package observer_pattern.subjects;

import observer_pattern.domain.Employee;
import observer_pattern.domain.EmployeeDAO;
import observer_pattern.observers.IObserver;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem implements ISubject{
    private Employee emp;
    private String msg = null;
    private List<IObserver> observers;
    private List<Employee> employees;
    private EmployeeDAO employeeDAO;

    public EmployeeManagementSystem() {
        observers = new ArrayList<IObserver>();
        employeeDAO = new EmployeeDAO();
        employees = employeeDAO.generateEmployees();
    }

    public void modifyEmployeeName(int id, String newName) {
        boolean notify = false;
        for (Employee emp : employees) {
            if (id == emp.employeeID) {
                emp.setName(newName);
                this.emp = emp;
                this.msg = "Employee name changed.";
                notify = true;
            }
        }
        if(notify) {
            notifyObservers();
        }
    }

    public void hireEmployee(Employee emp) {
        this.emp = emp;
        this.msg = "New hire!";
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver addMe) {
        observers.add(addMe);
    }

    @Override
    public void removeObserver(IObserver removeMe) {
        int removeIndex = observers.indexOf(removeMe);
        observers.remove(removeIndex);
    }

    @Override
    public void notifyObservers() {
        for(IObserver department : observers) {
            department.callMe(emp, msg);
        }
    }
}
