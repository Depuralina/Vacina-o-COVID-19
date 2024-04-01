package Backend;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema implements Serializable 
{
    private ListaUtilizadores utilizadores;
    private ListaUtentes utentes;
    private ListaGestores gestores;
    private ListaCentros centros;
    private ListaStocks stocks;
    private List<RegistoAcesso> listaEntradas;
    private Utilizador utilizadorLigado;
    private ListaVacinas vacina;
    private ListaAgendas agenda;
    private ListaAdministracao administracao;

    public Sistema() 
    {
        utilizadores = new ListaUtilizadores();   
        listaEntradas = new ArrayList<>();
        centros = new ListaCentros();
        vacina = new ListaVacinas();
        utentes = new ListaUtentes();
        gestores = new ListaGestores();
        stocks = new ListaStocks();
        agenda = new ListaAgendas();
        administracao = new ListaAdministracao();
    }                       
    public ListaAgendas getListaAgendas()
    {
        return agenda;
    }
    public ListaAdministracao getListaAdministracao()
    {
        return administracao;
    }
    public ListaStocks getListaStocks()
    {
        return stocks;
    }
    public ListaGestores getListaGestores()
    {
        return gestores;
    }
    public ListaUtentes getListaUtentes()
    {
        return utentes;
    }
    public ListaVacinas getListaVacinas()
    {
        return vacina;
    }
    public ListaCentros getListaCentros()
    {
        return centros;
    }
    public ListaUtilizadores getListaUtilizadores() 
    {
        return utilizadores;
    }
    
    public List<RegistoAcesso> getListaEntradas() 
    {
        return listaEntradas;
    }
    
    public boolean autenticarUtilizador(String username, String password) 
    {        
        if (utilizadores.get_UtilizadorTrue(username)) 
        {
            try
            {
                Utilizador u = utilizadores.get_Utilizador(username);                
                if (u.getPassword().equals(password))
                {
                    utilizadorLigado = u;
                    listaEntradas.add(new RegistoAcesso(u, LocalDateTime.now()));
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public Utilizador getUtilizadorLigado() 
    {
        return utilizadorLigado;
    }
    
    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException, ListaCentros.CentroDuplicadoException
    {
        utilizadores.set_Utilizador(new Administrador("admin", "admin"));
    }
    
    public void terminar() {
        System.exit(0);
    }
}