
package Frontend;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Backend.*;

public class ListagemVacinas extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    
    public ListagemVacinas(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Tipo","Número de Tomas","Nome da Vacina"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                return sistema.getListaVacinas().get_NumVacinas();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
           
                switch (columnIndex) {
                    case 0: 
                        return sistema.getListaVacinas().get_Vacinas().get(rowIndex).get_Tipo();
                    case 1:
                        return sistema.getListaVacinas().get_Vacinas().get(rowIndex).get_Numer();
                    case 2:
                        return sistema.getListaVacinas().get_Vacinas().get(rowIndex).get_Nome();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    private void adicionar() {
        JanelaDadosVacinas janela = new JanelaDadosVacinas(sistema, null, this);   
        janela.setVisible(true);
    }
    private void editar() {
        int rowIndex = tabUtilizadores.getSelectedRow();
       
        if (rowIndex == -1) return;
        
        String nome = (String) modeloTabela.getValueAt(rowIndex, 2);
        
        try {
            Vacinas vacina = sistema.getListaVacinas().get_Vacina(nome);
            JanelaDadosVacinas janela = new JanelaDadosVacinas(sistema, vacina, this);   
            janela.setVisible(true);
        } catch (ListaVacinas.VacinaNaoExistenteException ex) {            
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    private void apagar()
    {
        int rowIndex = tabUtilizadores.getSelectedRow();
        if (rowIndex == -1) return;
        String nome = (String) modeloTabela.getValueAt(rowIndex, 2);
        sistema.getListaVacinas().apagar(nome);
        atualizar();
    }
    public void atualizar() {    
       
        modeloTabela.fireTableDataChanged();
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabUtilizadores = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Vacinas");

        tabUtilizadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Número SNS", "Morada", "Localidade", "Data de Nascimento", "Contacto", "Email", "Username", "Password"
            }
        ));
        tabUtilizadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabUtilizadores);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jButton1.setText("Apagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       apagar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
