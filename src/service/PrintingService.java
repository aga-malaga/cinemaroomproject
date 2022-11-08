package service;

import model.InputData;

import java.math.BigDecimal;

public interface PrintingService {
    String[][] createArray();

    void printBookedRoom(InputData inputData);

    int bookSeat(InputData inputData);

    void close();

    void statistics(InputData inputData);

    void menu();

    void printTicketPrice(BigDecimal bigDecimal);
}
