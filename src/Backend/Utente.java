package Backend;
import java.io.Serializable;
public class Utente extends Utilizador implements Serializable
{
    private CentroVac centro = null;
    private int sns;
    private String datanas ,morada, localidade ,email, doencas, nome, contacto;
    public Utente (){}
    public Utente (int sns, String morada, String localidade, String datanas, String contacto, String email,String username, String palavra_pass)
    {
        super(username, palavra_pass);
        this.sns = sns;
        this.morada = morada;
        this.contacto = contacto;
        this.localidade = localidade;
        this.datanas = datanas;
        this.email = email;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public void setSNS(int sns)
    {
        this.sns = sns;
    }
    public void setMorada(String morada)
    {
        this.morada = morada;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }
    public void setDoencas(String doencas)
    {
        this.doencas = doencas;
    }
    public void setContacto(String contacto)
    {
        this.contacto = contacto;
    }
    public void setDatanas(String data)
    {
        this.datanas = data;
    }

    public void setCentro(CentroVac centro)
    {
        this.centro = centro;
    }
    public void set_DoencasPrevias(String doencas)
    {
        this.doencas = doencas;
    }
    public void set_Centro (CentroVac centro)
    {
        this.centro = centro;
    }
     public String getNome() 
    {
        return nome;
    }
    public String getMorada()
    {
        return morada;
    }
    public int getSNS()
    {
        return sns;
    }
    public String getEmail()
    {
        return email;
    }
    public String getContacto()
    {
        return contacto;
    }
    public String getLocalidade()
    {
        return localidade;
    }
    public String getDataNas()
    {
        return datanas;
    }
    public CentroVac getCentro()
    {
        return centro;
    }
    public String getDoencas()
    {
        return doencas;
    }
}