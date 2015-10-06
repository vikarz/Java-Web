<%-- 
    Document   : EditBarang
    Created on : Aug 16, 2015, 3:25:59 PM
    Author     : vikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.BarangCtr" %>
<%
    String kode = request.getParameter("kodeBrg");
    BarangCtr ctr = new BarangCtr();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Barang</title>
    </head>
    <body>
        <h1>Edit Barang</h1>
        <form action="/appinventori/UpdateBrg" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Kode Barang</th>
                        <th>: <input type="text" name="kodeBrg" value="${ param.kodeBrg }" readonly="readonly" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nama Barang</td>
                        <td>: <input type="text" name="namaBrg" value="<%= ctr.cari(kode).getNamabarang() %>" /></td>
                    </tr>
                    <tr>
                        <td>Harga Barang</td>
                        <td>: <input type="number" name="hargaBrg" value="<%= ctr.cari(kode).getHargabarang() %>" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Simpan" name="simpan" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>            
        </form>
    </body>
</html>
