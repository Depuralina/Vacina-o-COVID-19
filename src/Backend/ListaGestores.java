package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaGestores implements Serializable 
{
    private TreeMap<String, Gestor> lista;

    public class GestorNaoExistenteException extends Exception 
    {
        public GestorNaoExistenteException() { }
        public GestorNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class GestorDuplicadoException extends Exception 
    {
        public GestorDuplicadoException() { }
        public GestorDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaGestores() 
    {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void set_Gestor (Gestor gestor) throws GestorDuplicadoException 
    {
        if (gestor == null) 
        {
            throw new NullPointerException("O parâmetro 'gestor' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(gestor.getUsername())) 
        {
            lista.put(gestor.getUsername(), gestor);
        }
        else
        {
            throw new GestorDuplicadoException(String.format("O gestor '%s' já existe na coleção", gestor.getUsername()));
        }
        
    }        
    
    public boolean get_GestorTrue (String username) 
    {
        return lista.containsKey(username);
    }
    
    public int get_NumGestores () 
    {
        return lista.size();
    }
    
    public Gestor get_Gestor (String username) throws GestorNaoExistenteException {
        if (lista.containsKey(username))
        {
            return lista.get(username);
        }
        else
        {
            throw new GestorNaoExistenteException("O gestor '%s' já existe na lista");
        }
    }
    public void apagar(String username)
    {
        lista.remove(username);
    }
    public ArrayList<Gestor> get_Gestores() 
    {
        return new ArrayList<>(lista.values());
    }
    
}