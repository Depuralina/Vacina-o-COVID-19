
package Frontend;

import javax.swing.table.AbstractTableModel;
import Backend.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListagemMarcacoes extends javax.swing.JFrame {
    private Sistema sistema;
    private LocalDate data;
    private AbstractTableModel modeloTabela;
    
    public ListagemMarcacoes(Sistema sistema,LocalDate data) {
        initComponents();
        this.sistema = sistema;
        this.data = data;
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nome do Utente","Centro","Data"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                try {
                    try {
                        return sistema.getListaAgendas().get_Agenda(sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername()).getCentro()).get_UtentesAgendados().size();
                    } catch (ListaAgendas.AgendaNaoExistenteException ex) {
                        Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ListaGestores.GestorNaoExistenteException ex) {
                    Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0;
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
                            try {
                                return sistema.getListaAgendas().get_Agenda(sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername()).getCentro()).get_MarcacoesDia(data).get(rowIndex).getNome();
                            } catch (ListaAgendas.AgendaNaoExistenteException ex) {
                                Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (ListaGestores.GestorNaoExistenteException ex) {
                            Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 1:
                    {
                        try {
                            try {
                                return sistema.getListaAgendas().get_Agenda(sistema.getListaGestores().get_Gestor(sistema.getUtilizadorLigado().getUsername()).getCentro()).get_MarcacoesDia(data).get(rowIndex).getCentro().get_Nome();
                            } catch (ListaAgendas.AgendaNaoExistenteException ex) {
                                Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (ListaGestores.GestorNaoExistenteException ex) {
                            Logger.getLogger(ListagemMarcacoes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    case 2:
                    {
                        return data;
                    }

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
