package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
public class ListaAgendas implements Serializable 
{
    private TreeMap<CentroVac, Agenda> lista;

    public class AgendaNaoExistenteException extends Exception 
    {
        public AgendaNaoExistenteException() { }
        public AgendaNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class AgendaDuplicadoException extends Exception 
    {
        public AgendaDuplicadoException() { }
        public AgendaDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaAgendas() 
    {
        lista = new TreeMap<>();        
    }
    
    public void set_Agenda (Agenda agenda) throws AgendaDuplicadoException 
    {
        if (agenda == null) 
        {
            throw new NullPointerException("O parâmetro 'agenda' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(agenda.get_Centro())) 
        {
            lista.put(agenda.get_Centro(), agenda);
        }
        else
        {
            throw new AgendaDuplicadoException(String.format("A agenda '%s' já existe na coleção", agenda.get_Centro()));
        }
        
    }        
    
    public boolean get_AgendaTrue (CentroVac centro) 
    {
        return lista.containsKey(centro);
    }
    
    public int get_NumAgendas () 
    {
        return lista.size();
    }
    
    public Agenda get_Agenda (CentroVac centro) throws AgendaNaoExistenteException {
        if (lista.containsKey(centro))
        {
            return lista.get(centro);
        }
        else
        {
            throw new AgendaNaoExistenteException("A agenda '%s' já existe na lista");
        }
    }
    
    public ArrayList<Agenda> get_Agendas() 
    {
        return new ArrayList<>(lista.values());
    }
    
}