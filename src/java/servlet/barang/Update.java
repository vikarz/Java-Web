/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.barang;

import controller.BarangCtr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vikar
 */
public class Update extends HttpServlet {
    BarangCtr ctr = new BarangCtr();
    private static String kodebrg;
    private static String namabrg;
    private static double hargabrg;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        kodebrg = request.getParameter("kodeBrg");
        namabrg = request.getParameter("namaBrg");
        hargabrg = Double.valueOf(request.getParameter("hargaBrg"));
        
        if (kodebrg.equals("") && namabrg.equals("") && hargabrg == 0) {
            if (ctr.updateBrg()) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Master Barang Berhasil</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Update Master Barang Berhasil</h1>");
                    out.println("<a href='/appinventori'>Kembali</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }else {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Master Barang Gagal</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Update Master Barang Gagal</h1>");
                    out.println("<h4>" + ctr.getError() + "</h4>");
                    out.println("<a href='/appinventori'>Kembali</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }else {
            response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Master Barang Gagal</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Update Master Barang Gagal</h1>");
                    out.println("<h4>Data tidak Valid!</h4>");
                    out.println("<a href='/appinventori'>Kembali</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
        }
    }
    
    public static String getKodeBrg() {
        return kodebrg;
    }
    
    public static String getNamaBrg() {
        return namabrg;
    }
    
    public static double getHargaBrg() {
        return hargabrg;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
