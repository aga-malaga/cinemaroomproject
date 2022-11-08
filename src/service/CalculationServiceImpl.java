package service;

import model.InputData;

import java.math.BigDecimal;

public class CalculationServiceImpl implements CalculationService {
    @Override
    public BigDecimal calculateTicketPrice(InputData inputData) {
        BigDecimal ticketPrice = BigDecimal.TEN;
        BigDecimal result = BigDecimal.ZERO;
        Integer rows = inputData.getRowNumber();
        Integer seats = inputData.getSeatsNumber();
        int totalSeatsNumber = seats * rows;
        int firstHalf = rows / 2;

        for (int row = 1; row <= rows; row++) {
            if (totalSeatsNumber < 60 || inputData.getBookingRow() <= firstHalf) {
                result = ticketPrice;
            } else {
                result = BigDecimal.valueOf(8);
            }
        }

        inputData.setCurrentIncome(inputData.getCurrentIncome().add(result));
        inputData.setBoughtTickets(inputData.getBoughtTickets() + 1);
        return result;
    }

    @Override
    public void calculateTotalIncome(InputData inputData) {
        BigDecimal ticketPrice = BigDecimal.TEN;
        BigDecimal result = BigDecimal.ZERO;
        Integer rows = inputData.getRowNumber();
        Integer seats = inputData.getSeatsNumber();
        int totalSeatsNumber = seats * rows;
        int firstHalf = rows / 2;

        for (int row = 1; row <= rows; row++) {
            if (totalSeatsNumber < 60 || row <= firstHalf) {
                result = result.add(ticketPrice.multiply(BigDecimal.valueOf(seats)));
            } else {
                result = result.add(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(seats)));
            }
        }
        inputData.setTotalIncome(result);
    }
}

