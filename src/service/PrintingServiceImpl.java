package service;

import model.InputData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class PrintingServiceImpl implements PrintingService {
    Scanner scanner;

    public PrintingServiceImpl(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String[][] createArray() {
        System.out.println("Enter the number of rows:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();
        String[][] room = new String[rowNumber][seatsNumber];
        for (String[] strings : room) {
            Arrays.fill(strings, " S");
        }
        return room;
    }

    @Override
    public void close() {
        scanner.close();
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    @Override
    public void printTicketPrice(BigDecimal ticketPrice) {
        System.out.println("Ticket price: $" + ticketPrice);

    }

    @Override
    public void printBookedRoom(InputData inputData) {
        final String[][] room = inputData.getRoom();
        System.out.println();
        System.out.println("Cinema:");
        int counter = 1;
        System.out.print(" ");
        while (counter <= room[0].length) {
            System.out.print(" " + counter);
            counter++;
        }
        for (int row = 0; row < room.length; row++) {
            System.out.println();
            System.out.print(row + 1);
            for (int column = 0; column < room[row].length; column++) {
                System.out.print(room[row][column]);
            }
        }
        System.out.println();
    }

    @Override
    public int bookSeat(InputData inputData) {
        System.out.println();
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        final String[][] room = inputData.getRoom();

        if (room[rowNumber - 1][seatNumber - 1].equals(" B")) {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            return 1;
        }

        inputData.setBookingRow(rowNumber);
        inputData.setBookingSeat(seatNumber);
        return 0;
    }

    @Override
    public void statistics(InputData inputData) {
        System.out.println();
        System.out.println("Number of purchased tickets: " + inputData.getBoughtTickets());
        System.out.printf("Percentage: %.2f%%\n", (float) (inputData.getBoughtTickets() * 100) / (inputData.getRowNumber() * inputData.getSeatsNumber()));
        System.out.println("Current income: $" + inputData.getCurrentIncome());
        System.out.println("Total income: $" + inputData.getTotalIncome());

    }
}
