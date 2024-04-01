package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
public class ListaStocks implements Serializable 
{
    private HashMap<CentroVac, Stock> lista;

    public class StockNaoExistenteException extends Exception 
    {
        public StockNaoExistenteException() { }
        public StockNaoExistenteException(String message) 
        {
            super(message);
        }        
    }
    
    public class StockDuplicadoException extends Exception 
    {
        public StockDuplicadoException() { }
        public StockDuplicadoException(String message) 
        {
            super(message);
        }        
    }
    
    public ListaStocks() 
    {
        lista = new HashMap<>();        
    }
    
    public void set_Stock (Stock stock) throws StockDuplicadoException 
    {
        if (stock == null) 
        {
            throw new NullPointerException("O parâmetro 'stock' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(stock.get_Centro())) 
        {
            lista.put(stock.get_Centro(), stock);
        }
        else
        {
            throw new StockDuplicadoException(String.format("O stock '%s' já existe na coleção", stock.get_Centro()));
        }
        
    }        
    
    public boolean get_StockTrue (CentroVac nome) 
    {
        return lista.containsKey(nome);
    }
    
    public int get_NumStocks () 
    {
        return lista.size();
    }
    
    public Stock get_Stock (CentroVac nome) throws StockNaoExistenteException {
        if (lista.containsKey(nome))
        {
            return lista.get(nome);
        }
        else
        {
            throw new StockNaoExistenteException("O stock '%s' não existe na lista");
        }
    }
    public void apagar(CentroVac nome)
    {
        lista.remove(nome);
    }
    public ArrayList<Stock> get_Stocks() 
    {
        return new ArrayList<>(lista.values());
    }
    
}