/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data_access.Database;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author German le yo
 */
public class MainPanel extends javax.swing.JFrame {

    private Component[] adminComponents;
    private JTextField[] procTextFields;
    private JTextField[] funTextFields;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        tablesTables.getTableHeader().setReorderingAllowed(false);
        tablesViews.getTableHeader().setReorderingAllowed(false);

        adminComponents = new Component[]{create_button, borrar_table, actualizar_table};
        if(!databaseinterface.DatabaseInterface.user.isAdmin){
            for (Component adminComponent : adminComponents) {
                adminComponent.setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        combobox_table = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesTables = new javax.swing.JTable();
        create_button = new javax.swing.JButton();
        borrar_table = new javax.swing.JButton();
        tableInfoLabel = new javax.swing.JLabel();
        actualizar_table = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        combobox_view = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesViews = new javax.swing.JTable();
        infoLabelView = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        combobox_view1 = new javax.swing.JComboBox<>();
        create_button2 = new javax.swing.JButton();
        proceduresInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        combobox_view2 = new javax.swing.JComboBox<>();
        create_button3 = new javax.swing.JButton();
        funInput = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        infoLabelFun = new javax.swing.JLabel();
        outputLabelFun = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combobox_table.setModel(new javax.swing.DefaultComboBoxModel<>(databaseinterface.DatabaseInterface.user.selectTables));
        combobox_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_tableActionPerformed(evt);
            }
        });

        tablesTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablesTables);

        create_button.setText("Create");
        create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttonActionPerformed(evt);
            }
        });

        borrar_table.setText("Borrar Seleccionado");
        borrar_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_tableActionPerformed(evt);
            }
        });

        tableInfoLabel.setText("Buenos Dias");

        actualizar_table.setText("Actualizar Seleccionado");
        actualizar_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_tableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox_table, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableInfoLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(create_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(borrar_table)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actualizar_table)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combobox_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_button)
                    .addComponent(borrar_table)
                    .addComponent(actualizar_table))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(tableInfoLabel))
        );

        jTabbedPane1.addTab("Tablas", jPanel1);

        combobox_view.setModel(new javax.swing.DefaultComboBoxModel<>(databaseinterface.DatabaseInterface.user.selectVistas));
        combobox_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_viewActionPerformed(evt);
            }
        });

        tablesViews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablesViews);

        infoLabelView.setText("Buenos Dias");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox_view, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoLabelView))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combobox_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(infoLabelView))
        );

        jTabbedPane1.addTab("Vistas", jPanel6);

        combobox_view1.setModel(new javax.swing.DefaultComboBoxModel<>(databaseinterface.DatabaseInterface.user.procToString()));
        combobox_view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_view1ActionPerformed(evt);
            }
        });

        create_button2.setText("Ejecutar");
        create_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proceduresInputLayout = new javax.swing.GroupLayout(proceduresInput);
        proceduresInput.setLayout(proceduresInputLayout);
        proceduresInputLayout.setHorizontalGroup(
            proceduresInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        proceduresInputLayout.setVerticalGroup(
            proceduresInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        jLabel1.setText("Output");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proceduresInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(combobox_view1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(create_button2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_view1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(create_button2))
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(proceduresInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Procedimientos", jPanel7);

        combobox_view2.setModel(new javax.swing.DefaultComboBoxModel<>(databaseinterface.DatabaseInterface.user.funToString()));
        combobox_view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_view2ActionPerformed(evt);
            }
        });

        create_button3.setText("Ejecutar");
        create_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout funInputLayout = new javax.swing.GroupLayout(funInput);
        funInput.setLayout(funInputLayout);
        funInputLayout.setHorizontalGroup(
            funInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        funInputLayout.setVerticalGroup(
            funInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        jLabel2.setText("Output");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputLabelFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(funInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(combobox_view2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(infoLabelFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(create_button3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_view2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(create_button3))
                    .addComponent(infoLabelFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(funInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputLabelFun, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funciones", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_viewActionPerformed
        databaseinterface.DatabaseInterface.createTableViews(combobox_view.getSelectedIndex());
    }//GEN-LAST:event_combobox_viewActionPerformed

    private void combobox_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_tableActionPerformed
        databaseinterface.DatabaseInterface.createTableTables(combobox_table.getSelectedIndex());
    }//GEN-LAST:event_combobox_tableActionPerformed

    private void create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttonActionPerformed
        new ParamDialog(false).setVisible(true);
    }//GEN-LAST:event_create_buttonActionPerformed

    private void create_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_button2ActionPerformed
        Database.Procedimiento proc = (Database.getProcByName(combobox_view1.getSelectedItem().toString()));

        String[] params = new String[procTextFields.length];
        for (int i = 0; i < params.length; i++) {
            params[i]=procTextFields[i].getText();
        }
        if (proc.hasOutput) databaseinterface.DatabaseInterface.executeProcedureWithReturn(proc, params);
        else databaseinterface.DatabaseInterface.executeProcedure(proc, params);

    }//GEN-LAST:event_create_button2ActionPerformed

    private void combobox_view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_view1ActionPerformed
        String[] newLabels = (Database.getProcByName(combobox_view1.getSelectedItem().toString())).parametros;

        proceduresInput.removeAll();
        proceduresInput.setLayout(new GridLayout(newLabels.length, 1));

        LinkedList<JTextField> lista = new LinkedList();
        ParamDialog.PanelAttribute tmp;
        for (String newLabel : newLabels) {
            tmp = new ParamDialog.PanelAttribute(newLabel);
            proceduresInput.add(tmp);
            lista.add(tmp.textField);
        }

        procTextFields = lista.toArray(new JTextField[lista.size()]);

        //setSize(500, 180 + 40 * newLabels.length);
        //setLocationRelativeTo(null);
        revalidate();
        repaint();
    }//GEN-LAST:event_combobox_view1ActionPerformed


    private void borrar_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_tableActionPerformed
        String[] values = new String[tablesTables.getColumnCount()];
        int selected = tablesTables.getSelectedRow();
        for (int i = 0; i < values.length; i++) {
            values[i] = tablesTables.getValueAt(selected, i).toString();
        }

        databaseinterface.DatabaseInterface.delete(combobox_table.getSelectedIndex(), values, false);
    }//GEN-LAST:event_borrar_tableActionPerformed

    private void actualizar_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_tableActionPerformed

        int index = combobox_table.getSelectedIndex();

        String[] values = new String[tablesTables.getColumnCount()];
        int selected = tablesTables.getSelectedRow();
        for (int i = 0; i < values.length; i++) {
            values[i] = tablesTables.getValueAt(selected, i).toString();
        }

        new ParamDialog(index, values, false).setVisible(true);
    }//GEN-LAST:event_actualizar_tableActionPerformed

    private void combobox_view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_view2ActionPerformed
        String[] newLabels = (Database.getFunByName(combobox_view2.getSelectedItem().toString())).parametros;

        funInput.removeAll();
        funInput.setLayout(new GridLayout(newLabels.length, 1));

        LinkedList<JTextField> lista = new LinkedList();
        ParamDialog.PanelAttribute tmp;
        for (String newLabel : newLabels) {
            tmp = new ParamDialog.PanelAttribute(newLabel);
            funInput.add(tmp);
            lista.add(tmp.textField);
        }

        funTextFields = lista.toArray(new JTextField[lista.size()]);

        //setSize(500, 180 + 40 * newLabels.length);
        //setLocationRelativeTo(null);
        revalidate();
        repaint();
    }//GEN-LAST:event_combobox_view2ActionPerformed

    private void create_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_button3ActionPerformed
        Database.Funcion func = (Database.getFunByName(combobox_view2.getSelectedItem().toString()));

        String[] params = new String[funTextFields.length];
        for (int i = 0; i < params.length; i++) {
            params[i]=funTextFields[i].getText();
        }
        databaseinterface.DatabaseInterface.executeFun(func, params);
    }//GEN-LAST:event_create_button3ActionPerformed


    public void setTableModelInTables(String[][] vals, String[] titles){
        TableModel model = init(vals, titles);
        tablesTables.setModel(model);
    }


    public void setTableModelInViews(String[][] vals, String[] titles){
        TableModel model = init(vals, titles);
        tablesViews.setModel(model);
    }
    public void setProcInfo(String txt){
        infoLabel.setText(txt);
    }

    public void setTableInfoText(String info){
        tableInfoLabel.setText(info);
    }
    
    public void setViewInfoText(String info){
        infoLabelView.setText(info);
    }
    
    public void setProcOutput(String txt){
        outputLabel.setText(txt);
    }
    public void setFunInfo(String txt){
        infoLabelFun.setText(txt);
    }
    public void setFunOutput(String txt){
        outputLabelFun.setText(txt);
    }



    private static TableModel init(String[][] vals, String[] titles){
        return new DefaultTableModel(vals, titles){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar_table;
    private javax.swing.JButton borrar_table;
    private javax.swing.JComboBox<String> combobox_table;
    private javax.swing.JComboBox<String> combobox_view;
    private javax.swing.JComboBox<String> combobox_view1;
    private javax.swing.JComboBox<String> combobox_view2;
    private javax.swing.JButton create_button;
    private javax.swing.JButton create_button2;
    private javax.swing.JButton create_button3;
    private javax.swing.JPanel funInput;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabelFun;
    private javax.swing.JLabel infoLabelView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel outputLabelFun;
    private javax.swing.JPanel proceduresInput;
    private javax.swing.JLabel tableInfoLabel;
    private javax.swing.JTable tablesTables;
    private javax.swing.JTable tablesViews;
    // End of variables declaration//GEN-END:variables
}
