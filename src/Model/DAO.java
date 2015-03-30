/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



import java.sql.SQLException;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akram
 */
public abstract  class DAO<T> {
    
    public abstract  void insererMembre(T obj)throws SQLException;
    public abstract   void MettreAjourMembre(T obj)throws SQLException;
    public abstract DefaultTableModel rechercherMembres()throws SQLException;
    public abstract Set<T> rechercherMembreStatus(String status)throws SQLException;
    public abstract void supprimerMembre(int id)throws SQLException;

  
    
}
