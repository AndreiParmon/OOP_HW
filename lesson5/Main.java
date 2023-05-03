package lesson5;

import lesson5.models.TableModel;
import lesson5.presenters.BookingPresenter;
import lesson5.views.BookingView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);


        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        view.reservationTable(new Date(), 2, "Станислав");
        view.reservationTable(new Date(), 4, "Игорь");
        view.reservationTable(new Date(), 6, "Светлана");
        bookingPresenter.newUpdateView();
        view.changeReservationTable(1002, new Date(), 1, "Станислав");
        bookingPresenter.newUpdateView();
    }
}
