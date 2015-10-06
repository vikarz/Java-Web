/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DaoImplements.BarangInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Barang;

/**
 *
 * @author vikar
 */
public class BarangDao implements BarangInt {
    private Connection koneksi;
    private String sql;
    private String error;
    
    public BarangDao(Connection c) {
        koneksi = c;
    }
    
    public String getError() {
        return error;
    }

    @Override
    public boolean insertBrg(Barang b) {   
        boolean sts = true;
        try {
            sql = "insert into barang set kodebrg=?, namabrg=?, hargabrg=?";            
            PreparedStatement p = koneksi.prepareStatement(sql);
            p.setString(1, b.getKodebarang());
            p.setString(2, b.getNamabarang());
            p.setDouble(3, b.getHargabarang());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            sts = false;
            error = ex.getMessage();
        }   
        return sts;
    }

    @Override
    public boolean updateBrg(Barang b) {
        boolean sts = true;
        sql = "update barang set namabrg=?, hargabrg=? where kodebrg=?";
        try {
            PreparedStatement p = koneksi.prepareStatement(sql);
            p.setString(1, b.getNamabarang());
            p.setDouble(2, b.getHargabarang());
            p.setString(3, b.getKodebarang());
            p.executeUpdate();
            p.close();
        }catch(SQLException e) {
            sts = false;
            error = e.getMessage();
        }
        return sts;
    }

    @Override
    public void deleteBrg(String s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Barang> getAll() {
        ArrayList<Barang> lb = new ArrayList<Barang>();
        sql = "select * from barang";
        try {
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            while(r.next()) {
                Barang b = new Barang();
                b.setKodebarang(r.getString("kodebrg"));
                b.setNamabarang(r.getString("namabrg"));
                b.setHargabarang(r.getDouble("hargabrg"));
                lb.add(b);
            }
            r.close();
            s.close();
        }catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public Barang search(String kode) {
        Barang brg = new Barang();
        sql = "select * from barang where kodebrg ='"+ kode +"'";
        
        try{
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            r.first();
            brg.setKodebarang(kode);
            brg.setNamabarang(r.getString("namabrg"));
            brg.setHargabarang(r.getDouble("hargabrg"));
            r.close();
            s.close();
        }catch(SQLException e) {
            
        }
        return brg;
    }
    
}
