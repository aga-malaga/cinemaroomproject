package service;

import model.InputData;

import java.math.BigDecimal;

public interface CalculationService {

    BigDecimal calculateTicketPrice(InputData inputData);

    void calculateTotalIncome(InputData inputData);
}
