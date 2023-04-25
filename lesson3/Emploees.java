//Доработать приложение, которое мы разрабатывали на уроке. Мы доллжны поработать с сортировкой объектов,
// освоить работу с интерфейсами Comparator, Comparable.
//1. Доработать класс Freelancer, при желании можно разработать и свой собтственный тип сотрудника.
//2. Переработать метод generateEmployee, метод должен создавать случайного сотрудника (Worker, Freelancer или любого другого). Метод должен быть один!
//3. Придумать свой собственный компаратор (Возможно отсортировать сотрудников по возрасту? Тогда добавьте соответствующее состояние на уровне ваших классов).
//4. Продемонстрировать сортировку объектов различного типа с использованием собственного компаратора.

package lesson3.homeWork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Employees {
    private static Random random = new Random();
    public static Employee generateEmployee(){
        String[] names = new String[] {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[] {"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

        int salary = random.nextInt(1000, 1500);
        int salaryIndex = random.nextInt(28, 31);
        int age = random.nextInt(25, 50);
        boolean flag = random.nextBoolean();
        if (flag){
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], salary * salaryIndex, age);
        }
        else {
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], salary * 18 * 5, age);
        }
    }

    public static void main(String[] args) {
       Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }


        Arrays.sort(employees);
        System.out.println("\n*** Отсортированный массив сотрудников по уровню дохода ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }


        Arrays.sort(employees, new AgeComparator());
        System.out.println("\n*** Отсортированный массив сотрудников по возрасту ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }


        Arrays.sort(employees, new SurNameComparator());
        System.out.println("\n*** Отсортированный массив сотрудников по фамилии ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class AgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.surName.compareTo(o2.surName);
    }
}

abstract class Employee implements Comparable<Employee>{
    protected String firstName;
    protected String surName;
    protected double salary;
    protected int age;

    public Employee(String firstName, String surName, double salary, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee {
    public Worker(String firstName, String surName, double salary, int age){
        super(firstName, surName,salary, age);
    }

    @Override
    public double calculateSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата: %.2f; Возраст: %s",
                surName, firstName, calculateSalary(), age);
    }
}

class Freelancer extends Employee{
    public Freelancer(String firstName, String surName, double salary, int age){
        super(firstName, surName,salary, age);
    }

    @Override
    public double calculateSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f; Возраст: %s",
                surName, firstName, calculateSalary(), age);
    }
}

