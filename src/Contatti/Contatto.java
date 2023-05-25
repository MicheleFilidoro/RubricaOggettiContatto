package Contatti;

import java.util.ArrayList;
import java.util.Arrays;

public class Contatto {
    private String Nome;
    private String Email;
    private ArrayList<String> Telefoni;

    public Contatto(String email, String nome) {
        this.Email = email;
        this.Nome = nome;
        Telefoni = new ArrayList<String>();
    }

    public Contatto(String email) {
        this(email, "");
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String string) {
        this.Nome = string;
    }

    public String getEmail() {
        return this.Email;
    }

    public Boolean CercaNumero(String num) {
        for (int i = 0; i < Telefoni.size(); i++) {
            if (num == Telefoni.get(i)) {
                return true;
            }
        }
        return false;
    }

    public Boolean InserisciNumTel(String num) {
        if (CercaNumero(num) == true) {
            return false;
        }
        this.Telefoni.add(num);
        return true;
    }

    public Boolean EliminaNumTel(String num) {
        return this.Telefoni.remove(num);
    }

    public int numEl() {
        return this.Telefoni.size();
    }

    public String numTel() {
        StringBuilder rit = new StringBuilder();
        for (String s : this.Telefoni) {
            rit.append(s).append(",");
        }
        return rit.toString();
    }

    public Boolean MatchNome(String string) {
        return this.Nome.contains(string);
    }

    public Boolean MatchEmail(String string) {
        return this.Email.contains(string);
    }

    public String toString() {
        String contatto = "";
        contatto += "Nome: " + this.Nome + " ";
        for (String s : Arrays.asList("Email: " + this.Email + " ", "Numeri: " + this.numTel())) {
            contatto += s;
        }
        return contatto;
    }

    public boolean Equals(Object contatto) {
        return (contatto instanceof Contatto && ((Contatto) contatto).getEmail().equals(this.Email));
    }


}
