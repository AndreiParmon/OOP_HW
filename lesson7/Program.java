package lesson7.observer;

public class Program {
    /**
     * TODO: 1.Доработать приложение, поработать с шаблоном проектирования Observer
     *   добавить новый тип соискателя.
     *   **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *   **.3 Предусмотреть тип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Senior ivanov = new Senior("Ivanov");
        Senior petrov = new Senior("Petrov");
        Student sidorov = new Student("Sidorov");
        Junior parmon = new Junior("Parmon");
        Junior gudkov = new Junior("Gudkov");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(parmon);
        jobAgency.registerObserver(gudkov);

        for (int i = 0; i < 3; i++) {
            geekBrains.newNeedEmployee();
            google.newNeedEmployee();
            yandex.newNeedEmployee();
        }

    }
}
