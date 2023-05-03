package lesson5.presenters;

import lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    void showTables(Collection<Table> tables);

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     */
    void showReservationTableStatus(int reservationId);

    void changeReservationTable(int oldReservation, Date newDateReservation, int tableNo, String name);

    /**
     * Отобразить список всех столиков с резервами
     * @param tables столики
     */
    void showTablesWithReservations(Collection<Table> tables);
}
