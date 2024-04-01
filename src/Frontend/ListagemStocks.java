
package Frontend;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Backend.*;

public class ListagemStocks extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    
    public ListagemStocks(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Centro"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                return sistema.getListaStocks().get_NumStocks();
            }

            @Override
            public int getColumnCount() {
              
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
           
                switch (columnIndex) {
                    case 0: 
                        return sistema.getListaStocks().get_Stocks().get(rowIndex).get_Centro().get_Nome();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    private void adicionar() {
        JanelaDadosStocks janela = new JanelaDadosStocks(sistema, null, this);   
        janela.setVisible(true);
    }
    private void editar() {
        int rowIndex = tabUtilizadores.getSelectedRow();
        
        if (rowIndex == -1) return;
        
        CentroVac nome = (CentroVac) modeloTabela.getValueAt(rowIndex, 0);
        
        try {
            Stock stock = sistema.getListaStocks().get_Stock(nome);
            JanelaDadosStocks janela = new JanelaDadosStocks(sistema, stock, this);   
            janela.setVisible(true);
        } catch (ListaStocks.StockNaoExistenteException ex) {            
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    private void apagar()
    {
        int rowIndex = tabUtilizadores.getSelectedRow();
        if (rowIndex == -1) return;
        CentroVac nome = (CentroVac) modeloTabela.getValueAt(rowIndex, 0);
        sistema.getListaStocks().apagar(nome);
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Stocks");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       apagar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
