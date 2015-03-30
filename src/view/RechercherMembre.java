/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.DAOMembre;
import Model.Membre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akram
 */
public class RechercherMembre extends javax.swing.JFrame {

    /**
     * Creates new form RechercherMembre
     */
    public RechercherMembre() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        btnRechercheSimple = new javax.swing.JButton();
        btnRechercheStatus = new javax.swing.JButton();
        btnRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rechercher Membres");

        jLabel1.setText("Recherche simple:");
        jLabel1.setToolTipText("");

        jLabel2.setText("Recherche par status:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REGULIER", "ARGENT", "OR" }));

        btnRechercheSimple.setText("Rechercher:");
        btnRechercheSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercheSimpleActionPerformed(evt);
            }
        });

        btnRechercheStatus.setText("Rechercher:");
        btnRechercheStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercheStatusActionPerformed(evt);
            }
        });

        btnRetour.setText("Retour");
        btnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnRechercheStatus))
                            .addComponent(btnRechercheSimple))
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRechercheSimple))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRechercheStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnRetour)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetourActionPerformed
        new Menu().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRetourActionPerformed

    private void btnRechercheSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercheSimpleActionPerformed
      
         DAOMembre DAOm = new DAOMembre();
        try {
        DefaultTableModel dtm =DAOm.rechercherMembres();
        JTable table =new JTable(dtm);
        JOptionPane.showMessageDialog(this, new JScrollPane(table));
             
            
//            System.out.println(membres);
//               new Menu().setVisible(true);
//                 this.dispose();
           
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "erreur veillez contacter admin");
            ex.getMessage();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRechercheSimpleActionPerformed

    private void btnRechercheStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercheStatusActionPerformed
         DAOMembre DAOm = new DAOMembre();
        try {
            Set<Membre> membres =DAOm.rechercherMembreStatus(jComboBox1.getSelectedItem().toString());
            System.out.println(membres);
               new Menu().setVisible(true);
        this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "erreur veillez contacter admin");
            ex.getMessage();
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnRechercheStatusActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRechercheSimple;
    private javax.swing.JButton btnRechercheStatus;
    private javax.swing.JButton btnRetour;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
