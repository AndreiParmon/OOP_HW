package lesson7.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Агенство по поиску сотрудников
 */
public class JobAgency implements Publisher{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Реализация рассылки сообщений
     * @param vacancy
     */
    @Override
    public void newSendOffer(Vacancy vacancy) {
        for (Observer observer : observers){
            if (observer.getJobType().equals(vacancy.getType().getJobType())){
                observer.newReceiveOffer(vacancy);
            }
        }
    }
}
