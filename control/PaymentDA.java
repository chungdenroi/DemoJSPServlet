package control;

import model.Payment;
import model.ProductLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PaymentDA extends DataAccess{
    private String table = "payments";
    private String idCol = "customerNumber";

    public ArrayList<Payment> showAllPayments() throws SQLException {
        ResultSet rs = selectAll(table);
        ArrayList<Payment> list = new ArrayList<>();
        while (rs.next()){
            int customerNumber = rs.getInt("customerNumber");
            String checkNumber = rs.getString("checkNumber");
            Date paymentDate = rs.getDate("paymentDate");
            Double amount = rs.getDouble("amount");
            Payment payment = new Payment(customerNumber,checkNumber,paymentDate,amount);
            list.add(payment);
        }
        conn.close();
        return  list;
    }
    public Payment searchPayment(int customerNumber, String checkNumber) throws SQLException, NullPointerException{
        String idCol1 = "customerNumber";
        String idCol2 = "checkNumber";
        String cusNumber = Integer.toString(customerNumber);
        ResultSet rs = selectByID(table,idCol1,idCol2,cusNumber,checkNumber);
        Payment payment = new Payment();
        while (rs.next()) {
            Date paymentDate = rs.getDate("paymentDate");
            Double amount = rs.getDouble("amount");
            payment = new Payment(customerNumber,checkNumber,paymentDate,amount);
        }
        conn.close();
        return payment;
    }
    public boolean editPayment(Payment payment) throws SQLException {
        conn = connectDB();
        String idCol1 = "customerNumber";
        String idCol2 = "checkNumber";
        int nRow = 0;
        String sql = "UPDATE " + table + " SET checkNumber = ?, paymentDate = ?, amount = ? WHERE " + idCol1 + " = ? and " + idCol2 + " = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,payment.getCheckNumber());
        stm.setDate(2, (java.sql.Date) payment.getPaymentDate());
        stm.setDouble(3,payment.getAmount());
        stm.setInt(4,payment.getCustomerNumber());
        stm.setString(5,payment.getCheckNumber());
        nRow = stm.executeUpdate();
        conn.close();
        return nRow != 0;
    }
    public boolean deletePayment(int customerNumber,String checkNumber) throws SQLException {
        String idCol1 = "customerNumber";
        String idCol2 = "checkNumber";
        conn = connectDB();
        String cusNumber =Integer.toString(customerNumber);
        conn.close();
        return deleteByID(table,idCol1,idCol2,cusNumber,checkNumber);

    }
    public boolean addPayment(Payment payment) throws SQLException {
        conn = connectDB();
        String sql = "INSERT INTO " + table +" (customerNumber, checkNumber, paymentDate, amount)" +
                " values (?, ?, ?, ?);";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,payment.getCustomerNumber() );
        stm.setString(2,payment.getCheckNumber() );
        stm.setDate(3, (java.sql.Date) payment.getPaymentDate());
        stm.setDouble(4,payment.getAmount());
        int nRows = stm.executeUpdate();
        conn.close();
        return nRows != 0;
    }
}
