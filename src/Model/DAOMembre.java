/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Set;
import javax.swing.table.DefaultTableModel;
import utilitaire.ConnectionSingleton;

/**
 *
 * @author akram
 */
public class DAOMembre extends DAO<Membre> {

    @Override
    public void insererMembre(Membre obj) throws SQLException {
        Connection DbConnection = null;
        PreparedStatement ps = null;
        String InsertQuery = "insert into membre (id_membre,nom_membre,prenom_membre,adresse_membre,status_membre)"
                + "values"
                + "(?,?,?,?,?)";

        try {
            DbConnection = ConnectionSingleton.instance();
            ps = DbConnection.prepareStatement(InsertQuery);

            ps.setInt(1, obj.getId_membre());
            ps.setString(2, obj.getNom());
            ps.setString(3, obj.getPrenom());
            ps.setString(4, obj.getAdresse());
            ps.setString(5, obj.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (DbConnection != null) {
                DbConnection.close();
            }
        }
    }

    @Override
    public void MettreAjourMembre(Membre obj) throws SQLException {
        
        Connection connect = null;
        CallableStatement cs = null;
       String  UpdateQuery = "{call procedure1(?,?)}";
       try{
       cs = ConnectionSingleton.instance().prepareCall(UpdateQuery);
       cs.setInt(1,obj.getId_membre());
       cs.setString(2, obj.getStatus());
       cs.executeUpdate();
       }finally{}
       
            }

    @Override
    public DefaultTableModel rechercherMembres() throws SQLException {

        Connection DbConnection = null;
        Statement s = null;
        try {
            String selectQuery = "select * from membre ";
            DbConnection = ConnectionSingleton.instance();
            s = DbConnection.createStatement();
            ResultSet rs = s.executeQuery(selectQuery);
//            Set<Membre> membres = utilitaire.Util.creationListeEmploye(rs);
            DefaultTableModel dtm = utilitaire.Util.buildTableModel(rs);
            return dtm;
        } finally {
            if (s != null) {
                s.close();
            }
            if (DbConnection != null) {
                DbConnection.close();
            }

        }
    }

    @Override
    public Set<Membre> rechercherMembreStatus(String status) throws SQLException {
        Connection DbConnection = null;
        PreparedStatement ps = null;
        try {
            String rechercheQuery = "select * from membre where status_membre = ? ";
            DbConnection = ConnectionSingleton.instance();
            ps = DbConnection.prepareStatement(rechercheQuery);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            Set<Membre> membres = utilitaire.Util.creationListeEmploye(rs);
            return membres;
            } finally {
            if (ps != null) {
                ps.close();
            }
            if (DbConnection != null) {
                DbConnection.close();
            }

        }
    }


@Override
        public void supprimerMembre(int id) throws SQLException {
            
            Connection connect = null;
            PreparedStatement ps = null;
            String DeleteQuery = "delete membre where id_membre = ?";
            try{
            ps = ConnectionSingleton.instance().prepareStatement(DeleteQuery);
            ps.setInt(1,id);
            ps.executeUpdate();
            }finally{
                if(ps != null){ps.close();}
            if(connect != null){
            connect.close();
            }
            }
        }
}
