package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaVacinas implements Serializable 
{
    private TreeMap<String, Vacinas> lista;

    public class VacinaNaoExistenteException extends Exception 
    {
        public VacinaNaoExistenteException() { }
        public VacinaNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class VacinaDuplicadoException extends Exception 
    {
        public VacinaDuplicadoException() { }
        public VacinaDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaVacinas() 
    {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void set_Vacina (Vacinas vacina) throws VacinaDuplicadoException 
    {
        if (vacina == null) 
        {
            throw new NullPointerException("O parâmetro 'vacina' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(vacina.get_Nome())) 
        {
            lista.put(vacina.get_Nome(), vacina);
        }
        else
        {
            throw new VacinaDuplicadoException(String.format("A vacina '%s' já existe na coleção", vacina.get_Nome()));
        }
        
    }        
    
    public boolean get_VacinaTrue (String nome) 
    {
        return lista.containsKey(nome);
    }
    
    public int get_NumVacinas () 
    {
        return lista.size();
    }
    
    public Vacinas get_Vacina (String nome) throws VacinaNaoExistenteException {
        if (lista.containsKey(nome))
        {
            return lista.get(nome);
        }
        else
        {
            throw new VacinaNaoExistenteException("A vacina '%s' já existe na lista");
        }
    }
     public void apagar(String nome)
    {
        lista.remove(nome);
    }
    public ArrayList<Vacinas> get_Vacinas() 
    {
        return new ArrayList<>(lista.values());
    }
    
}