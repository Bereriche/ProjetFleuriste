/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Model.Membre;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akram
 */
public class Util {

    public static Set<Membre> creationListeEmploye(ResultSet resultSet) throws SQLException {
        Set<Membre> registre = new HashSet<Membre>();

        int id_membre;
        String nom, prenom, adresse, status;

        //Parcourir et créer la liste
        while (resultSet.next()) {
            id_membre = resultSet.getInt("id_membre");
            nom = resultSet.getString("nom_membre");
            prenom = resultSet.getString("prenom_membre");
            adresse = resultSet.getString("adresse_membre");
            status = resultSet.getString("status_membre");

            //créer un objet
            Membre emp = new Membre(id_membre, nom, prenom, adresse, status);
            registre.add(emp);
        }

        return registre;
    }


public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
}