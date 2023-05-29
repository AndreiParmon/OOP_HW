package lesson7.observer;

public class Vacancy {

    private JobType type;
    private double salary;
    private String nameCompany;

    public JobType getType() {
        return type;
    }
    public double getSalary() {
        return salary;
    }
    public String getNameCompany() {
        return nameCompany;
    }
    public Vacancy(JobType type, double salary, String nameCompany) {
        this.type = type;
        this.salary = salary;
        this.nameCompany = nameCompany;
    }
}
