package Backend;
import java.io.Serializable;
public class Gestor extends Utilizador implements Serializable
{
	private CentroVac centro;
        private String nome;
	public Gestor (){}
        public Gestor (String username, String palavra_pass, CentroVac centro, String nome)
	{
		super(username, palavra_pass);
                this.centro = centro;
                this.nome = nome;
	}
        public void setCentro(CentroVac centro)
        {
            this.centro = centro;
        }
        public void setNome(String nome)
        {
            this.nome = nome;
        }
        public CentroVac getCentro()
        {
            return centro;
        }
        public String getNome()
        {
            return nome;
        }
}