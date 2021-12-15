package model;

import java.util.Date;

public class Payment {
    private int customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private Double amount;

    public Payment() {
    }

    public Payment(int customerNumber, String checkNumber, Date paymentDate, Double amount) {
        setCustomerNumber(customerNumber);
        setCheckNumber(checkNumber);
        setPaymentDate(paymentDate);
        setAmount(amount);
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
