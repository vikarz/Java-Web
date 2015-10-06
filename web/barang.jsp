<%-- 
    Document   : barang
    Created on : Aug 16, 2015, 1:15:23 AM
    Author     : vikar
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--Penempatan import di bawah div preloader tidak pengaruh 
pada loading --%>
<%@page import="controller.BarangCtr" %>
<%
    BarangCtr ctr = new BarangCtr();
    pageContext.setAttribute("listBarang", ctr.getAll());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery-1.11.3.js"></script>
        <title>Master Barang</title>
    </head>
    <body>
        <div id="preloader">
            <div id="status"></div>
        </div>        
        <h1>Daftar Barang</h1>
        <c:choose>
            <c:when test="${!empty listBarang}">
                <table>
                    <tr>
                        <td>
                            <a href="index.html">Tambah Master</a>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Kode Barang
                        </th>
                        <th>
                            Nama Barang
                        </th>
                        <th>
                            Harga Barang
                        </th>
                        <th>
                            Edit
                        </th>
                        <th>
                            Hapus
                        </th>
                    </tr>
                    <c:forEach items="${listBarang}" var="brg">                                            
                        <tr>
                            <td>
                                <c:out value="${brg.getKodebarang()}"></c:out>
                                </td>                        
                                <td>
                                <c:out value="${brg.getNamabarang()}"></c:out>
                                </td>
                                <td>
                                <c:out value="${brg.getHargabarang()}"></c:out>
                                </td>
                                <td>
                                    <a href="/appinventori/EditBarang.jsp?kodeBrg=<c:out value="${brg.getKodebarang()}"/>">
                                    Edit
                                </a>
                            </td>
                        </tr>   
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h4>Tidak Ada Data</h4>
            </c:otherwise>
        </c:choose>
        <script type="text/javascript">
            $(window).load(function() { // makes sure the whole site is loaded
            $("#status").fadeOut(); // will first fade out the loading animation
            $("#preloader").delay(350).fadeOut("slow"); // will fade out the white DIV that covers the website.
            })
        </script>
    </body>
</html>
