/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JTextField;

/**
 *
 * @author German le yo
 */
public class CreateDialog extends javax.swing.JDialog {

    
    private JTextField[] textFields;
    
    /**
     * Creates new form CreateDialog
     */
    public CreateDialog() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        att_panel = new javax.swing.JPanel();
        create_button = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(data_access.Database.tables));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        att_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout att_panelLayout = new javax.swing.GroupLayout(att_panel);
        att_panel.setLayout(att_panelLayout);
        att_panelLayout.setHorizontalGroup(
            att_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        att_panelLayout.setVerticalGroup(
            att_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        create_button.setText("Crear");
        create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttonActionPerformed(evt);
            }
        });

        infoLabel.setText("Escriba los datos del elemento a crear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(att_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(create_button)
                                .addGap(41, 41, 41)
                                .addComponent(infoLabel)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(att_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_button)
                    .addComponent(infoLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        String[] newLabels = data_access.Database.tablesCNames[jComboBox1.getSelectedIndex()];
        
        att_panel.removeAll();
        att_panel.setLayout(new GridLayout(newLabels.length, 1));
        
        LinkedList<JTextField> list = new LinkedList();
        PanelAttribute tmp;
        
        for (String newLabel : newLabels) {
            tmp = new PanelAttribute(newLabel);
            att_panel.add(tmp);
            list.add(tmp.textField);
        }
        textFields = list.toArray(new JTextField[list.size()]);
        
        setSize(500, 180 + 40 * newLabels.length);
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttonActionPerformed
        
        String[] values = new String[textFields.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = textFields[i].getText();
        }
        
        databaseinterface.DatabaseInterface.insert(jComboBox1.getSelectedIndex(), values, this);
    }//GEN-LAST:event_create_buttonActionPerformed

    public void setInfoText(String text){
        infoLabel.setText(text);
    }
    
    public class PanelAttribute extends javax.swing.JPanel {

        public PanelAttribute(String labelText) {
            initComponents(labelText);
        }
        
        private void initComponents(String labelText) {

            label = new javax.swing.JLabel(labelText);
            textField = new javax.swing.JTextField();

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField)
                        .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
        }                   


        // Variables declaration - do not modify                     
        private javax.swing.JLabel label;
        private javax.swing.JTextField textField;
        // End of variables declaration                   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel att_panel;
    private javax.swing.JButton create_button;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
