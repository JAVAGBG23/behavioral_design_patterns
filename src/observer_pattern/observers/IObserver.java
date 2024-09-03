package observer_pattern.observers;

import observer_pattern.domain.Employee;

public interface IObserver {
    void callMe(Employee emp, String msg);
}
