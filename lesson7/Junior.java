package lesson7.observer;

public class Junior implements Observer{

    private String name;
    private double salary;
    private JobType jobType;

    public Junior(String name) {
        this.name = name;
        salary = 30000;
        jobType = JobType.JUNIOR;
    }

    @Override
    public void newReceiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Младший специалист  %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Младший специалист %s >>> Я найду работу получше! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getJobType() {
        return jobType.getJobType();
    }
}
