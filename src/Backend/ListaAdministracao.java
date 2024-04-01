package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaAdministracao implements Serializable 
{
    private TreeMap<Utente, Administracao> lista;

    public class AdministracaoNaoExistenteException extends Exception 
    {
        public AdministracaoNaoExistenteException() { }
        public AdministracaoNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class AdministracaoDuplicadoException extends Exception 
    {
        public AdministracaoDuplicadoException() { }
        public AdministracaoDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaAdministracao() 
    {
        lista = new TreeMap<>();        
    }
    
    public void set_Administracao (Administracao administracao) throws AdministracaoDuplicadoException 
    {
        if (administracao == null) 
        {
            throw new NullPointerException("O parâmetro 'Administracao' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(administracao.get_Utente())) 
        {
            lista.put(administracao.get_Utente(), administracao);
        }
        else
        {
            throw new AdministracaoDuplicadoException(String.format("A administracao '%s' já existe na coleção", administracao.get_Utente()));
        }
        
    }        
    
    public boolean get_AdministracaoTrue (Utente nome) 
    {
        return lista.containsKey(nome);
    }
    
    public int get_NumAdministracao () 
    {
        return lista.size();
    }
    
    public Administracao get_Administracao (Utente nome) throws AdministracaoNaoExistenteException {
        if (lista.containsKey(nome))
        {
            return lista.get(nome);
        }
        else
        {
            throw new AdministracaoNaoExistenteException("A administracao '%s' já existe na lista");
        }
    }
    
    public ArrayList<Administracao> get_Administracao() 
    {
        return new ArrayList<>(lista.values());
    }
    
}