
import Backend.Utente;
import Backend.Utilizador;
import java.util.ArrayList;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class pp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      TreeMap<String, String> lista = new TreeMap<>();
      lista.put("ila","Ola");
      lista.put("oola","pap");
      lista.remove("ila");
      ArrayList<String> z = new ArrayList<>(lista.values());
      ArrayList<String> m = new ArrayList<>();
      m.add("pp");
     
      System.out.println(lista.values());
    }
    
}
