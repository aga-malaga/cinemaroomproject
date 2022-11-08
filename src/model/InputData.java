package model;

import java.math.BigDecimal;

public class InputData {
    private final Integer rowNumber;
    private final Integer seatsNumber;
    private Integer bookingRow;
    private Integer bookingSeat;

    private final String[][] room;

    private Integer boughtTickets;
    private BigDecimal currentIncome;

    private BigDecimal totalIncome;

    public InputData(
            final Integer rowNumber,
            final Integer seatsNumber,
            final Integer bookingRow,
            final Integer bookingSeat,
            final String[][] room,
            final Integer boughtTickets,
            final BigDecimal currentIncome,
            final BigDecimal totalIncome) {
        this.rowNumber = rowNumber;
        this.seatsNumber = seatsNumber;
        this.bookingRow = bookingRow;
        this.bookingSeat = bookingSeat;
        this.room = room;
        this.boughtTickets = boughtTickets;
        this.currentIncome = currentIncome;
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(final BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(final Integer boughtTickets) {
        this.boughtTickets = boughtTickets;
    }

    public BigDecimal getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(final BigDecimal currentIncome) {
        this.currentIncome = currentIncome;
    }

    public String[][] getRoom() {
        return room;
    }


    public Integer getRowNumber() {
        return rowNumber;
    }


    public Integer getSeatsNumber() {
        return seatsNumber;
    }


    public Integer getBookingRow() {
        return bookingRow;
    }

    public void setBookingRow(final Integer bookingRow) {
        this.bookingRow = bookingRow;
    }

    public Integer getBookingSeat() {
        return bookingSeat;
    }

    public void setBookingSeat(final Integer bookingSeat) {
        this.bookingSeat = bookingSeat;
    }
}
