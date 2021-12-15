package view.Payments;

import control.PaymentDA;
import control.ProductLineDA;
import model.Payment;
import model.ProductLine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

@WebServlet({"/payments","/payments/edit","/payments/delete","/payments/add"})
public class PaymentManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        switch (url) {
            case "/payments/edit"  :
                editProduct(request,response);
                System.out.println("call edit payments method success!");
                break;
            case "/payments/add"  :
                addPayment(request,response);
                System.out.println("call add payments method success!");
                break;
            case "/payments/delete"  :
                deleteProduct(request,response);
                System.out.println("call delete payments method success!");
                break;
            default:
                showAllPayments(request,response);
                System.out.println("call show all payments method success!");
                break;
        }
    }
    protected void showAllPayments(HttpServletRequest request, HttpServletResponse response) {
        try {
            PaymentDA paymentDA = new PaymentDA();
            ArrayList<Payment> listPayment = paymentDA.showAllPayments();
            request.setAttribute("listPayment",listPayment);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("payments/view.jsp");
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Date date = new Date();
            int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
            String checkNumber = request.getParameter("checkNumber");
            java.sql.Date paymentDate =  java.sql.Date.valueOf(request.getParameter("paymentDate"));
            Double amount = Double.parseDouble(request.getParameter("amount"));
            PaymentDA paymentDA = new PaymentDA();
            ArrayList<Payment> listPayment =   paymentDA.showAllPayments();
            for (Payment p : listPayment) {
                if(p.getCustomerNumber() == customerNumber && p.getCheckNumber().equals(checkNumber)) {
                    p.setCustomerNumber(customerNumber);
                    p.setCheckNumber(checkNumber);
                    p.setPaymentDate(paymentDate);
                    p.setAmount(amount);
                    if(paymentDA.editPayment(p)) {
                        System.out.println("Update success!");
                        pw.println("<script>alert('Update success');window.location='/demo_war_exploded/payments'</script>");
                    } else {
                        System.out.println("Update Failed");
                        pw.println("<script>alert('Update failed');window.location='/demo_war_exploded/payments'</script>");
                    }
                } else ;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
        } catch (InputMismatchException | IllegalArgumentException ex) {
            pw.println("<script>alert('Invalid');window.location='/demo_war_exploded/payments'</script>");
        }
    }
    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try{
            int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
            String checkNumber = request.getParameter("checkNumber");
            PaymentDA paymentDA = new PaymentDA();
            if(paymentDA.deletePayment(customerNumber,checkNumber)) {
                pw.println("<script>alert('Delete success');window.location='/demo_war_exploded/payments'</script>");
            } else System.out.println("Delete Failed");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            pw.println("<script>alert('Delete Failed');window.location='/demo_war_exploded/payments'</script>");
        }
    }
    protected void addPayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try{
            int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
            String checkNumber = request.getParameter("checkNumber");
            java.sql.Date paymentDate =  java.sql.Date.valueOf(request.getParameter("paymentDate"));
            Double amount = Double.parseDouble(request.getParameter("amount"));
            Payment payment = new Payment(customerNumber,checkNumber,paymentDate,amount);
            PaymentDA paymentDA = new PaymentDA();
            if(paymentDA.addPayment(payment)) {
                pw.println("<script>alert('Add success');window.location='/demo_war_exploded/payments'</script>");
            } else System.out.println("Add Failed");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            pw.println("<script>alert('Add Failed');window.location='/demo_war_exploded/payments'</script>");
        } catch (InputMismatchException | IllegalArgumentException ex) {
            pw.println("<script>alert('Invalid');window.location='/demo_war_exploded/payments'</script>");
        }
    }
}
