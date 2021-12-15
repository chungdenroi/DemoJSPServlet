package view.ProductLines;

import control.ProductLineDA;
import model.ProductLine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet({"/productlines","/productlines/edit","/productlines/delete","/productlines/add"})
public class ProductManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url1 = ((HttpServletRequest)request).getServletPath();
        System.out.println("Path: "+ url1);
        switch (url1) {
            case "/productlines/edit":
                editProduct(request,response);
                System.out.println("Call edit product method - dopost");break;
            case "/productlines/delete" :
                deleteProduct(request,response);
                System.out.println("Call delete product method success - dopost"); break;
            case "/productlines/add" :
                addProduct(request,response);
                System.out.println("Call add product method success - dopost"); break;
            default:
                showAllProducts(request,response);
                System.out.println("Call show all product success - dopost"); break;
        }
    }
    protected void showAllProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ProductLineDA productLineDA = new ProductLineDA();
            ArrayList<ProductLine> listProduct = productLineDA.selectAllProductLines();
            request.setAttribute("listProduct",listProduct);
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/productlines/view.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException ex) {
            System.out.println("SQLException: "+ex.getMessage());
        } catch (ServletException e) {
            System.out.println("ServletException: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("I0Exception: "+e.getMessage());
        }
    }
    protected void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String pline = request.getParameter("productline");
            String textDes = request.getParameter("textdescription");
            String htmlDes = request.getParameter("htmldescription");
            ProductLineDA productLineDA = new ProductLineDA();
            ArrayList<ProductLine> listProduct =  productLineDA.selectAllProductLines();
            for (ProductLine p : listProduct) {
                if(p.getProductLine().equals(pline)) {
                    p.setTextDescription(textDes);
                    p.setHtmlDescription(htmlDes);
                    if(productLineDA.editProductLine(p)) {
                        System.out.println("Update success!");
                        pw.println("<script>alert('Update success');window.location='/demo_war_exploded/productlines'</script>");
                    } else {
                        System.out.println("Update Failed");
                        pw.println("<script>alert('Update failed');window.location='/demo_war_exploded/productlines'</script>");
                    }
                } else System.out.println("Not found");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
        }
    }
    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try{
            String productLine = request.getParameter("productLineDelete");
            ProductLineDA productLineDA = new ProductLineDA();
            if(productLineDA.deleteProductLine(productLine)) {
                pw.println("<script>alert('Delete success');window.location='/demo_war_exploded/productlines'</script>");
            } else System.out.println("Delete Failed");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            pw.println("<script>alert('Delete Failed');window.location='/demo_war_exploded/productlines'</script>");
        }
    }
    protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try{
            String productLine = request.getParameter("productline");
            String textDes = request.getParameter("textdescription");
            String htmlDes = request.getParameter("htmldescription");
            ProductLine p = new ProductLine(productLine,textDes,htmlDes);
            ProductLineDA productLineDA = new ProductLineDA();
            if(productLineDA.addProductLine(p)) {
                pw.println("<script>alert('Add success');window.location='/demo_war_exploded/productlines'</script>");
            } else System.out.println("Add Failed");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            pw.println("<script>alert('Add Failed');window.location='/demo_war_exploded/productlines'</script>");
        }
    }
}
