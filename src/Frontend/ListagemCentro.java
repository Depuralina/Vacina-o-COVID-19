
package Frontend;
import javax.swing.table.AbstractTableModel;
import Backend.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListagemCentro extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    
    public ListagemCentro(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nome", "Localidade","Número de postos"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
               
                return 1;
            }

            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0: 
                    {
                        try {
                            return (sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername())).getCentro().get_Nome();
                        } catch (ListaGestores.GestorNaoExistenteException ex) {
                            Logger.getLogger(ListagemCentro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 1:
                         try {
                            return (sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername())).getCentro().get_Localidade();
                        } catch (ListaGestores.GestorNaoExistenteException ex) {
                            Logger.getLogger(ListagemCentro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    case 2:
                        try {
                            return (sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername())).getCentro().get_NumPostos();
                        } catch (ListaGestores.GestorNaoExistenteException ex) {
                            Logger.getLogger(ListagemCentro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                return 0;
                    default:
                        return "";
                }
            }            
        };
    }
    private void editar()
    {
        JanelaAlterarPostos janela = new JanelaAlterarPostos(sistema);
        janela.setVisible(true);
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Centros");

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

        jButton1.setText("Alterar NºPostos");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
