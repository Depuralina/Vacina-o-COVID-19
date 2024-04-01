
package Frontend;
import javax.swing.table.AbstractTableModel;
import Backend.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ListagemUtentesCentro extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    
    public ListagemUtentesCentro(Sistema sistema) {
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
                int l=0;
                for(Utente m: sistema.getListaUtentes().get_Utentes())
                {
                    try {
                        if (m.getCentro() == sistema.getListaGestores().get_Gestor((sistema.getUtilizadorLigado().getUsername())).getCentro())
                        {
                            l++;
                        }
                    } catch (ListaGestores.GestorNaoExistenteException ex) {
                        Logger.getLogger(ListagemUtentesCentro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return l;
            }

            @Override
            public int getColumnCount() {
               
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<Utente> utente = new ArrayList <Utente>();
                for(Utente m: sistema.getListaUtentes().get_Utentes())
                {
                    try {
                        if (m.getCentro() == sistema.getListaGestores().get_Gestor((sistema.getUtilizadorLigado().getUsername())).getCentro())
                        {
                            utente.add(m);
                        }
                    } catch (ListaGestores.GestorNaoExistenteException ex) {
                        Logger.getLogger(ListagemUtentesCentro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                switch (columnIndex) {
                    case 0: 
                        return utente.get(rowIndex).getUsername();
                    case 1:
                        return utente.get(rowIndex).getNome();
                    case 2:
                        return utente.get(rowIndex).getSNS();
                    case 3: 
                        return utente.get(rowIndex).getMorada();
                    case 4:
                        return utente.get(rowIndex).getLocalidade();
                    case 5:
                        return utente.get(rowIndex).getDataNas();
                    case 6: 
                        return utente.get(rowIndex).getContacto();
                    case 7:
                        return utente.get(rowIndex).getEmail();
                    case 8: 
                        return utente.get(rowIndex).getDoencas();
                    case 9:
                        return utente.get(rowIndex).getCentro();
                    default:
                        return "";
                }                              
            }            
        };
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
