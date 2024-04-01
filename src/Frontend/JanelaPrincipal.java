package Frontend;
import javax.swing.JOptionPane;
import Serial.Serializacao;
import Backend.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.time.LocalDate.now;

public class JanelaPrincipal extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;
    
    public JanelaPrincipal(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setExtendedState(JanelaPrincipal.MAXIMIZED_BOTH);    
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        mnuAdministrador.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        mnuGestor.setVisible(sistema.getUtilizadorLigado() instanceof Gestor);
        mnuUtente.setVisible(sistema.getUtilizadorLigado() instanceof Utente);      
    }      
    
    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    private void alterarPassword() {        
        JanelaDadosUtentes psw = new JanelaDadosUtentes(sistema, sistema.getUtilizadorLigado(), null);
        psw.setVisible(true);
    }
    
    private void listarUtentes() {
        ListagemUtentes listagem = new ListagemUtentes(sistema);
        listagem.setVisible(true);        
    }
    private void listarGestores() {
        ListagemGestores listagem = new ListagemGestores(sistema);
        listagem.setVisible(true);        
    }
    private void listarCentros() {
        ListagemCentros listagem = new ListagemCentros(sistema);
        listagem.setVisible(true);
    }
    private void listarRegistoAcessos() {
        JanelaRegistoAcessos acessos = new JanelaRegistoAcessos(sistema);
        acessos.setVisible(true);
    }
    private void listaVacinas(){
        ListagemVacinas listagem = new ListagemVacinas(sistema);
        listagem.setVisible(true);
    }
    private void listaStocks(){
        ListagemStocks listagem = new ListagemStocks(sistema);
        listagem.setVisible(true);
    }
    private void listarVacinas(){
        ListagemStockVacinas listagem = new ListagemStockVacinas(sistema);
        listagem.setVisible(true);
    }
    private void listaCentro(){
        ListagemCentro listagem = new ListagemCentro(sistema);
        listagem.setVisible(true);
    }
    private void registardoencas(){
        RegistarDoencas listagem = new RegistarDoencas(sistema);
        listagem.setVisible(true);
    }
    private void setCentro(){
        try {
            if (sistema.getListaUtentes().get_Utente(sistema.getUtilizadorLigado().getUsername()).getCentro() == null)
            {
                RegistarCentro listagem;
                try {
                    listagem = new RegistarCentro(sistema, sistema.getListaUtentes().get_Utente(sistema.getUtilizadorLigado().getUsername()));
                    listagem.setVisible(true);
                } catch (ListaUtentes.UtenteNaoExistenteException ex) {
                    Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Já está associado a um centro");
            }   } catch (ListaUtentes.UtenteNaoExistenteException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void setregisto()
    {
        Registar registo = new Registar(sistema);
        registo.setVisible(true);
    }
    private void listarmarcacoes()
    {
        ListagemMarcacoes janela = new ListagemMarcacoes(sistema,now());
        janela.setVisible(true);
    }
    private void listarUtentesCentro()
    {
        ListagemUtentesCentro janela = new ListagemUtentesCentro(sistema);
        janela.setVisible(true);
    }
    private void terminar() {        
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente terminar o programa?", 
                "Terminar", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            guardarAlteracoes();
            sistema.terminar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuGeral = new javax.swing.JMenu();
        mniGuardar = new javax.swing.JMenuItem();
        mniAlterarPassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniTerminar = new javax.swing.JMenuItem();
        mnuAdministrador = new javax.swing.JMenu();
        mniRegistoAcessos = new javax.swing.JMenuItem();
        mnuListarUtilizadores = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        mnuUtente = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        mnuGestor = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenu1.setText("jMenu1");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem16.setText("jMenuItem16");

        jMenuItem19.setText("jMenuItem19");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("O meu programa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mnuGeral.setText("Geral");

        mniGuardar.setText("Guardar dados");
        mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuardarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniGuardar);

        mniAlterarPassword.setText("Alteração de dados de utilizador");
        mniAlterarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAlterarPasswordActionPerformed(evt);
            }
        });
        mnuGeral.add(mniAlterarPassword);
        mnuGeral.add(jSeparator1);

        mniTerminar.setText("Terminar");
        mniTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTerminarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniTerminar);

        mnuPrincipal.add(mnuGeral);

        mnuAdministrador.setText("Administrador");
        mnuAdministrador.setToolTipText("");

        mniRegistoAcessos.setText("Registo de Acessos");
        mniRegistoAcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistoAcessosActionPerformed(evt);
            }
        });
        mnuAdministrador.add(mniRegistoAcessos);

        mnuListarUtilizadores.setText("Utentes");
        mnuListarUtilizadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarUtilizadoresActionPerformed(evt);
            }
        });
        mnuAdministrador.add(mnuListarUtilizadores);

        jMenuItem7.setText("Centros Vacinação");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuAdministrador.add(jMenuItem7);

        jMenuItem8.setText("Gestores");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnuAdministrador.add(jMenuItem8);

        jMenuItem9.setText("Vacinas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnuAdministrador.add(jMenuItem9);

        jMenuItem21.setText("Stocks");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        mnuAdministrador.add(jMenuItem21);

        mnuPrincipal.add(mnuAdministrador);

        mnuUtente.setText("Utente");

        jMenuItem2.setText("Doenças ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuUtente.add(jMenuItem2);

        jMenuItem11.setText("Centro Vacinação");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        mnuUtente.add(jMenuItem11);

        jMenuItem12.setText("Marcações");
        mnuUtente.add(jMenuItem12);

        mnuPrincipal.add(mnuUtente);

        mnuGestor.setText("Gestor");

        jMenuItem6.setText("Centros Vacinação");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuGestor.add(jMenuItem6);

        jMenuItem14.setText("Marcações");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        mnuGestor.add(jMenuItem14);

        jMenuItem15.setText("Vacinas");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        mnuGestor.add(jMenuItem15);

        jMenuItem17.setText("Utentes");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        mnuGestor.add(jMenuItem17);

        jMenuItem18.setText("Estatisticas");
        mnuGestor.add(jMenuItem18);

        mnuPrincipal.add(mnuGestor);
        mnuGestor.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTerminarActionPerformed
        terminar();
    }//GEN-LAST:event_mniTerminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        terminar();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       registardoencas();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniAlterarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlterarPasswordActionPerformed
        alterarPassword();
    }//GEN-LAST:event_mniAlterarPasswordActionPerformed

    private void mnuListarUtilizadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarUtilizadoresActionPerformed
        listarUtentes();
    }//GEN-LAST:event_mnuListarUtilizadoresActionPerformed

    private void mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuardarActionPerformed
        guardarAlteracoes();
        JOptionPane.showMessageDialog(this, "Alterações guardadas.");
    }//GEN-LAST:event_mniGuardarActionPerformed

    private void mniRegistoAcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistoAcessosActionPerformed
        listarRegistoAcessos();
    }//GEN-LAST:event_mniRegistoAcessosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        listaCentro();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        listarCentros();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        listarGestores();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        listaVacinas();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        listaStocks();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
       listarVacinas();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
       listarUtentesCentro();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        setCentro();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        
    }//GEN-LAST:event_jMenuItem14ActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mniAlterarPassword;
    private javax.swing.JMenuItem mniGuardar;
    private javax.swing.JMenuItem mniRegistoAcessos;
    private javax.swing.JMenuItem mniTerminar;
    private javax.swing.JMenu mnuAdministrador;
    private javax.swing.JMenu mnuGeral;
    private javax.swing.JMenu mnuGestor;
    private javax.swing.JMenuItem mnuListarUtilizadores;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuUtente;
    // End of variables declaration//GEN-END:variables
}
