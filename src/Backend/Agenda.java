package Backend;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Agenda implements Serializable
{
    private HashMap<LocalDate, ArrayList<Utente>> agenda;
    private CentroVac centro;
	public Agenda() 
	{
        agenda = new HashMap<>();
    }
    public void set_Agendar(LocalDate data, Utente utente) 
	{
        ArrayList<Utente> agendamentos = agenda.get(data);
        if (agendamentos == null) 
		{
            agendamentos = new ArrayList<>();
            agendamentos.add(utente);
            agenda.put(data, agendamentos);
        } 
		else 
		{
			if (!agendamentos.contains(utente)) 
			{
				agendamentos.add(utente);
			}
		}
    }

    public void set_CancelarMarcacao(LocalDate data, Utente utente) 
	{
        ArrayList<Utente> agendamentos = agenda.get(data);
        if (agendamentos != null && agendamentos.contains(utente)) 
		{
            agendamentos.remove(utente);
            if (agendamentos.isEmpty()) 
			{
                agenda.remove(data);
            }
        }
    }
    public List<Utente> get_MarcacoesDia(LocalDate data) 
	{
        return agenda.get(data);
    }
    public List<LocalDate> get_DiasComMarcacoes() 
	{
        return new ArrayList<>(agenda.keySet());
    }
    public List<Utente> get_UtentesAgendados() 
	{
        ArrayList<Utente> lista = new ArrayList<>();
        for (LocalDate data : agenda.keySet()) 
		{
            List<Utente> agendamentos = agenda.get(data);
            for (Utente utente : agendamentos) 
			{    
				if (!lista.contains(utente)) 
				{
                    lista.add(utente);
                }
            }
        }
        return lista;
    }
	public CentroVac get_Centro()
	{
		return centro;
	}
}
