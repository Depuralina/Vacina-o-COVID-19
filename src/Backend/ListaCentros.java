package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaCentros implements Serializable 
{
    private TreeMap<String, CentroVac> lista;

    public class CentroNaoExistenteException extends Exception 
    {
        public CentroNaoExistenteException() { }
        public CentroNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class CentroDuplicadoException extends Exception 
    {
        public CentroDuplicadoException() { }
        public CentroDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaCentros() 
    {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void set_Centro (CentroVac centro) throws CentroDuplicadoException 
    {
        if (centro == null) 
        {
            throw new NullPointerException("O parâmetro 'centro' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(centro.get_Nome())) 
        {
            lista.put(centro.get_Nome(), centro);
        }
        else
        {
            throw new CentroDuplicadoException(String.format("O centro '%s' já existe na coleção", centro.get_Nome()));
        }
        
    }        
    
    public boolean get_CentroTrue (String nome) 
    {
        return lista.containsKey(nome);
    }
    
    public int get_NumCentros () 
    {
        return lista.size();
    }
    
    public CentroVac get_Centro (String nome) throws CentroNaoExistenteException {
        if (lista.containsKey(nome))
        {
            return lista.get(nome);
        }
        else
        {
            throw new CentroNaoExistenteException("O centro '%s' já existe na lista");
        }
    }
    public void apagar(String nome)
    {
        lista.remove(nome);
    }
    public ArrayList<CentroVac> get_Centros() 
    {
        return new ArrayList<>(lista.values());
    }
    
}