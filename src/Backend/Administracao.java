package Backend;
import java.io.Serializable;
public class Administracao implements Serializable
{
	private String efeitos;
	private Vacinas vacinas;
	private Utente utente;
	public Administracao (String efeitos, Vacinas vacina, Utente utente)
	{
            this.efeitos = efeitos;
            this.vacinas = vacina;
            this.utente = utente;
	}
	public Utente get_Utente()
        {
            return utente;
        }
        public String get_Efeitos()
        {
            return efeitos;
        }
        public String get_TipoVacina()
	{
            return vacinas.get_Tipo();
	}
}