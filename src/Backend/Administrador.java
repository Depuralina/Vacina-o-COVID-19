package Backend;
import java.io.Serializable;
public class Administrador extends Utilizador implements Serializable
{
    public Administrador (){}
    public Administrador (String username, String palavra_pass)
    {
	super(username, palavra_pass);
    }
}