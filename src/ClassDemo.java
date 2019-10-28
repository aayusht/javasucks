import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassDemo {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("Matt", "prez", 6));
        employees.add(new SalariedEmployee("Ben", "senior prez", 6));
        employees.add(new SalariedEmployee("Brad", "super senior prez", 6));
        employees.add(new SalariedEmployee("Ryan", "associate prez", 6));
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.title + " " + employee.name);
        }

        employees.add(new Contractor("Mohit", "contractor", "berk"));
        employees.add(new Manager("Jane", "grandmaster", employees));
        for (Employee employee : employees) {
            if (employee instanceof SalariedEmployee) {
                System.out.println(((SalariedEmployee) employee).salary);
            } else if (employee instanceof Contractor) {
                System.out.println(((Contractor) employee).location);
            } else if (employee instanceof Manager) {
                System.out.println(((Manager) employee).employees.size());
            }
        }
    }

    static abstract class Employee {
        String name;
        String title;

        Employee(String name, String title) {
            this.name = name;
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) &&
                    Objects.equals(title, employee.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, title);
        }
    }

    static class Manager extends Employee {
        List<Employee> employees;

        Manager(String name, String title, List<Employee> employees) {
            super(name, title);
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    static class Contractor extends Employee {
        String location;

        public Contractor(String name, String title, String location) {
            super(name, title);
            this.location = location;
        }

        public String getLocation() {
            return location;
        }
    }

    static class SalariedEmployee extends Employee {
        int salary;

        public SalariedEmployee(String name, String title, int salary) {
            super(name, title);
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }
    }
}
