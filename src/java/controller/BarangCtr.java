/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.BarangDao;
import database.KoneksiMySql;
import java.util.ArrayList;
import model.Barang;
import servlet.barang.Insert;
import servlet.barang.Update;

/**
 *
 * @author vikar
 */
public class BarangCtr {
    BarangDao dao = new BarangDao(KoneksiMySql.getKoneksi());
    private String error;
    
    public BarangCtr() {
        
    }
    
    public String getError() {
        return error;
    }

    public boolean insertBrg() {
        Barang brg = new Barang();
        brg.setKodebarang(Insert.getKodebrg());
        brg.setNamabarang(Insert.getNamabrg());
        brg.setHargabarang(Insert.getHargabrg());
        boolean sts = dao.insertBrg(brg);
        if(!sts) {
            error = dao.getError();
        }
        return sts;
    }
    
    public ArrayList<Barang> getAll() {
        return dao.getAll();
    }
    
    public Barang cari(String kode) {
        return dao.search(kode);
    }
    
    public boolean updateBrg() {
        Barang brg = new Barang();
        brg.setKodebarang(Update.getKodeBrg());
        brg.setNamabarang(Update.getNamaBrg());
        brg.setHargabarang(Update.getHargaBrg());
        boolean sts = dao.updateBrg(brg);
        if(!sts) {
            error = dao.getError();
        }
        return sts;
    }
    
}
