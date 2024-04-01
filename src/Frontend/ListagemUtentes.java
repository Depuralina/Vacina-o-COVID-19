
package Frontend;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Backend.ListaUtilizadores;
import Backend.Sistema;
import Backend.Utilizador;

public class ListagemUtentes extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    
    public ListagemUtentes(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Username", "Nome","Número SNS","Morada","Localidade","Data de Nascimento", "Contacto", "Email","Doenças","Centro"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                return sistema.getListaUtilizadores().get_Utente().size();
            }

            @Override
            public int getColumnCount() {
               
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
           
                switch (columnIndex) {
                    case 0: 
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getUsername();
                    case 1:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getNome();
                    case 2:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getSNS();
                    case 3: 
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getMorada();
                    case 4:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getLocalidade();
                    case 5:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getDataNas();
                    case 6: 
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getContacto();
                    case 7:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getEmail();
                    case 8: 
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getDoencas();
                    case 9:
                        return sistema.getListaUtentes().get_Utentes().get(rowIndex).getCentro().get_Nome();
                    default:
                        return "";
                }                              
            }            
        };
    }
    public void atualizar() {    
       
        modeloTabela.fireTableDataChanged();
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabUtilizadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Utentes");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
