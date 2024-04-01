
package Frontend;
import Backend.*;
import Serial.*;

public class JavaApplication1{
        public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException {
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        
        if (! bd.getFicheiro().exists()) {
         
            sistema = new Sistema();      
           
            sistema.getListaUtilizadores().set_Utilizador(new Administrador("admin", "admin"));
        }else{
            sistema = bd.carregar();            
        }                 
                     
        JanelaLogin login = new JanelaLogin(sistema);               
        login.setVisible(true);
    
        JanelaPrincipal principal = new JanelaPrincipal(sistema, bd);
        principal.setVisible(true);        
        
    }
}

