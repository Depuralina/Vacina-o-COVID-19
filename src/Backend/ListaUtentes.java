package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaUtentes implements Serializable 
{
    private TreeMap<String, Utente> lista;

    public class UtenteNaoExistenteException extends Exception 
    {
        public UtenteNaoExistenteException() { }
        public UtenteNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class UtenteDuplicadoException extends Exception 
    {
        public UtenteDuplicadoException() { }
        public UtenteDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaUtentes() 
    {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void set_Utente (Utente utente) throws UtenteDuplicadoException 
    {
        if (utente == null) 
        {
            throw new NullPointerException("O parâmetro 'utente' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(utente.getUsername())) 
        {
            lista.put(utente.getUsername(), utente);
        }
        else
        {
            throw new UtenteDuplicadoException(String.format("O centro '%s' já existe na coleção", utente.getUsername()));
        }
        
    }        
    
    public boolean get_UtenteTrue (String username) 
    {
        return lista.containsKey(username);
    }
    
    public int get_NumUtentes () 
    {
        return lista.size();
    }
    
    public Utente get_Utente (String username) throws UtenteNaoExistenteException {
        if (lista.containsKey(username))
        {
            return lista.get(username);
        }
        else
        {
            throw new UtenteNaoExistenteException("O utente '%s' já existe na lista");
        }
    }
    public void apagar(String username)
    {
        lista.remove(username);
    }
    public ArrayList<Utente> get_Utentes() 
    {
        return new ArrayList<>(lista.values());
    }
    
}