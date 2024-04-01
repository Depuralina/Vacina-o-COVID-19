package Backend;
import java.io.Serializable;
public class Utilizador implements Serializable {
    private String username ,password;
    public Utilizador() { }    
    public Utilizador(String username, String password) 
    {
        this.username = username;
        this.password = password;
    }    
    public String getUsername() 
    {
        return username;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }
}
  /*  public String getNome() 
    {
        return nome;
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
*/