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
       /* if (this.employees.contains(name)) {
            this.employees.remove(employee);
            return true;
        } else {
            return false;
        }*/
        for (Employee employee : this.employees) {
            if(employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
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
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe " + this.name + ": ").append(System.lineSeparator());
        /*for (Employee employee : this.employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }*/
        this.employees.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
