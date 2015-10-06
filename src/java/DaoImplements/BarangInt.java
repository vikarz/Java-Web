/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplements;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Barang;

/**
 *
 * @author vikar
 */
public interface BarangInt {
    
    public boolean insertBrg(Barang b) throws SQLException;
    
    public boolean updateBrg(Barang b) throws SQLException;
    
    public void deleteBrg(String s) throws SQLException;
    
    public Barang search(String s) throws SQLException;
    
    public ArrayList<Barang> getAll() throws SQLException;
    
}
