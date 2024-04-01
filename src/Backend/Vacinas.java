package Backend;
import java.io.Serializable;
public class Vacinas implements Serializable
{
	private String tipo, nome;
	private String quantidade;
	public Vacinas (){}
        public Vacinas (String tipo,String quantidade, String nome)
	{
            this.tipo = tipo;
            this.quantidade = quantidade;
            this.nome = nome;
	}
	public void set_Tipo(String tipo)
        {
            this.tipo = tipo;
        }
        public void set_Nome(String nome)
        {
            this.nome = nome;
        }
        public void set_Numero(String quantidade)
        {
            this.quantidade = quantidade;
        }
        public String get_Numer()
        {
            return "" + quantidade ;
        }
	public String get_Tipo()
	{
            return tipo;
	}
        public String get_Nome()
        {
            return nome;
        }
}