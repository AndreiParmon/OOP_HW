package lesson7.observer;

public class Senior implements Observer {
    private String name;
    private double salary;
    private JobType jobType;

    public Senior(String name) {
        this.name = name;
        salary = 80000;
        jobType = JobType.SENIOR;
    }


    @Override
    public void newReceiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Старший пециалист %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Старший пециалист %s >>> Я найду работу получше! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getJobType() {
        return jobType.getJobType();
    }
}
