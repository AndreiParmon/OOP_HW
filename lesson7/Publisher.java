package lesson7.observer;

public interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void newSendOffer(Vacancy vacancy);
}
