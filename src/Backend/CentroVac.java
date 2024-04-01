package Backend;
import java.io.Serializable;
public class CentroVac implements Serializable
{
	private String nome, localidade;
	private int numero_postos;
	public CentroVac (String nome, String localidade) 
	{
		this.localidade = localidade;
		this.nome = nome;
	}
	public CentroVac ()
	{
		this.localidade = null;
		this.nome = null;
	}
	public void set_postos(int n)
	{
		this.numero_postos = n;
	}
        public void set_Localidade(String localidade)
        {
            this.localidade = localidade;
        }
	public void set_Nome(String nome)
	{
		this.nome = nome;
	}
	public String get_Localidade()
	{
		return localidade;
	}
	public int get_NumPostos()
	{
		return numero_postos;
	}
	public String get_Nome()
	{
		return nome;
	}
}