package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaUtilizadores implements Serializable 
{
    private TreeMap<String, Utilizador> lista;

    public class UtilizadorNaoExistenteException extends Exception 
    {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception 
    {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaUtilizadores() 
    {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void set_Utilizador (Utilizador utilizador) throws UtilizadorDuplicadoException 
    {
        if (utilizador == null) 
        {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(utilizador.getUsername())) 
        {
            lista.put(utilizador.getUsername(), utilizador);
        }
        else
        {
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }
        
    }        
    
    public boolean get_UtilizadorTrue (String username) 
    {
        return lista.containsKey(username);
    }
    
    public int get_NumUtilizadores () 
    {
        return lista.size();
    }
    
    public Utilizador get_Utilizador (String username) throws UtilizadorNaoExistenteException 
    {
        if (lista.containsKey(username))
        {
            return lista.get(username);
        }
        else
        {
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }
    public ArrayList<Utilizador> get_Utente () 
    {
        ArrayList<Utilizador> z = new ArrayList<>(lista.values());
        ArrayList<Utilizador> f = new ArrayList<>();
         for (int i = 0; i < z.size();i++)
         {
            if (z.get(i) instanceof Utente)
            {
                f.add(z.get(i));
            }
        }
        return f;
    }
    public ArrayList<Utilizador> get_Gestor () 
    {
        ArrayList<Utilizador> z = new ArrayList<>(lista.values());
        ArrayList<Utilizador> f = new ArrayList<>();
         for (int i =0; i < z.size();i++)
         {
            if (z.get(i) instanceof Gestor)
            {
                f.add(z.get(i));
            }
        }
        return f;
    }
    public void apagar(String username)
    {
        lista.remove(username);
    }
    public ArrayList<Utilizador> get_Utilizadores() 
    {
        return new ArrayList<>(lista.values());
    }
    
}