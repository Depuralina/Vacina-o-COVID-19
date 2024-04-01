package Backend;
import java.io.Serializable;
import java.util.HashMap;
public class Stock implements Serializable
{
	private CentroVac centro;
	private HashMap <Vacinas, Integer> stock ;
	public Stock (CentroVac centro)
	{
            this.centro = centro;
            stock = new HashMap<>();
	}
	public void set_Centro(CentroVac centro)
	{
		this.centro = centro;
	}
	public void set_StockVacina(Vacinas vacina, int quantidade)
	{
		stock.put(vacina, quantidade);
	}
	public void set_Remover(Vacinas vacina)
	{
		stock.remove(vacina);
	}
        public int get_size()
        {
            return stock.size();
        }
	public CentroVac get_Centro()
	{
		return centro;
	}
	public HashMap <Vacinas , Integer> get_Stock ()
	{
		return stock;
	}
	public int get_QuantidadeVacina(Vacinas vacina)
	{
		return stock.get(vacina);
	}
}