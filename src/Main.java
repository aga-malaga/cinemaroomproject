import model.InputData;
import service.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookingService bookingService = new BookingServiceImpl();

        PrintingService printingService = new PrintingServiceImpl(scanner);
        CalculationService calculationService = new CalculationServiceImpl();
        String[][] room = printingService.createArray();
        InputData inputData = new InputData(
                room.length,
                room[0].length,
                0,
                0,
                room,
                0,
                BigDecimal.ZERO,
                BigDecimal.ZERO
        );

        int item = 1;

        while (item != 0) {
            printingService.menu();
            item = scanner.nextInt();
            switch (item) {
                case 1:
                    printingService.printBookedRoom(inputData);
                    break;
                case 2:
                    try {
                        final int i = printingService.bookSeat(inputData);
                        if (i == 1) {
                            break;
                        }
                        bookingService.bookSeating(inputData);
                        BigDecimal ticketPrice = calculationService.calculateTicketPrice(inputData);
                        printingService.printTicketPrice(ticketPrice);

                    } catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Wrong input!");
                    }
                    break;
                case 3:
                    calculationService.calculateTotalIncome(inputData);
                    printingService.statistics(inputData);
                    break;
                case 0:
                    printingService.close();
                    break;
            }
        }
    }
}