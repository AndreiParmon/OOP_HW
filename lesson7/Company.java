package lesson7.observer;

import java.util.Random;

/**
 * Компания
 */
public class Company {
    private Random random;
    private String nameCompany;
    private double maxSalary;
    private Publisher jobAgency;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
        random = new Random();
    }

    public void newNeedEmployee(){
        double salary = random.nextDouble(3000, maxSalary);
        JobType randomJobType = JobType.randomJobType();
        System.out.printf("Компания: %s >>> Ищет: %s\n", nameCompany, randomJobType.getJobType());
        jobAgency.newSendOffer(new Vacancy(randomJobType, salary, nameCompany));
    }
}
