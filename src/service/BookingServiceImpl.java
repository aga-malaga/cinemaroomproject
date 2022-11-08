package service;

import model.InputData;

public class BookingServiceImpl implements BookingService {

    @Override
    public void bookSeating(InputData inputData) {
        int rowNumber = inputData.getBookingRow();
        int seatNumber = inputData.getBookingSeat();
        final String[][] room = inputData.getRoom();

        room[rowNumber - 1][seatNumber - 1] = " B";
    }
}
