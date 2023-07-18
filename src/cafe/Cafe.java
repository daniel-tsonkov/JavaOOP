package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;

    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        if (this.employees.contains(name)) {
            this.employees.remove(name);
            return true;
        } else {
            return false;
        }
        /*for (Employee employee : this.employees) {
            if(employee.getName().equals(name)) {
                this.employees.remove(name);
                return true;
            }
        }
        return false;*/
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();

        /*Employee oldestEmploee = new Employee("", 0, "");
        for (Employee employee : this.employees) {
            if(employee.getAge() > oldestEmploee.getAge()) {
                oldestEmploee = employee;
            }
        }
        return oldestEmploee;*/
    }

    public Employee getEmployee(String name) {

    }
}
