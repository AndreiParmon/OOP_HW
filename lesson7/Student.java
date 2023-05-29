package lesson7.observer;

public class Student implements Observer {
    private String name;
    private double salary;
    private JobType jobType;

    public Student(String name) {
        this.name = name;
        salary = 5000;
        jobType = JobType.STUDENT;
    }

    @Override
    public void newReceiveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Студент %s >>> Я найду работу получше! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getJobType() {
        return jobType.getJobType();
    }
}
