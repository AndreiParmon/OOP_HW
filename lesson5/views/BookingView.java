package lesson5.views;

import lesson5.models.Reservation;
import lesson5.models.Table;
import lesson5.presenters.View;
import lesson5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer; // наблюдатель

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    public void setObserver(ViewObserver observer){
        this.observer = observer;
    }

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    public void showTables(Collection<Table> tables){
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservation, Date newDateReservation, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, newDateReservation, tableNo, name);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     */
    public void showReservationTableStatus(int reservationId){
        if (reservationId > 0){
            System.out.printf("Столик успешно забронирован.\nНомер брони: #%d\n", reservationId);
        }
        else {
            System.out.println("Ошибка бронирования столика.\nПовторите попытку позже.\n");
        }
    }

    @Override
    public void showTablesWithReservations(Collection<Table> tables) {
        for (Table table : tables){
            System.out.println(table);
            for (Reservation reservation : table.getReservations()){
                System.out.println(reservation);
            }
        }
    }
}
