package Rubrica;

import Contatti.Contatto;

import java.io.IOException;
import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> rubrica;
    private int MAX_DIM;
    public String NOME;
    private static int numRubriche = 0;

    public Rubrica(String nome, int max_dim) {
        this.MAX_DIM = max_dim;
        this.NOME = nome;
        rubrica = new ArrayList<Contatto>();
        numRubriche++;
    }

    public Rubrica(String nome) {
        this(nome, 3);
    }

    public Rubrica(int maxDim) {
        this("Rubrica n." + numRubriche, maxDim);
    }

    public Rubrica() {
        this(3);
    }

    public String getNome() {
        return this.NOME;
    }

    public void setNome(String stringa) {
        this.NOME = stringa;
    }

    public int numEl() {
        return rubrica.size();
    }

    public int aggiungi(Contatto contatto) throws RubricaException {
        if (rubrica.size() >= this.MAX_DIM) {
            throw new RubricaException.RubricaPiena();
        }

        for(Contatto c: this.rubrica){
            if(c.Equals(contatto)){
                throw new RubricaException.ContattoEsistente();
            }
        }
        rubrica.add(contatto);
        return 1;
    }

    public int aggiungi(Contatto contatto) {
        if (rubrica.size() >= this.MAX_DIM) {
            return -1;
        }
        for (Contatto c : this.rubrica) {
            if (c.Equals(contatto)) return 0;
        }
        rubrica.add(contatto);
        return 1;
    }


    public static void pulisci() {
        numRubriche = 0;
    }

    public Contatto get(int i) {
        return rubrica.get(i);
    }

    public ArrayList<Contatto> CercaPerNome(String s) {
        ArrayList<Contatto> ris = new ArrayList<>();
        for (Contatto c : this.rubrica) {
            if (c.MatchNome(s)) {
                ris.add(c);
            }
        }
        return ris;
    }
    public ArrayList<Contatto> CercaPerEmail(String s) {
        ArrayList<Contatto> ris = new ArrayList<>();
        for (Contatto c : this.rubrica) {
            if (c.MatchEmail(s)) {
                ris.add(c);
            }
        }
        return ris;
    }
    public boolean EliminaPerNome(String s){
        for(Contatto c: this.rubrica){
            if(c.getNome().equals(s)){
                rubrica.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean EliminaPerEmail(String s){
        for(Contatto c: this.rubrica){
            if(c.getEmail().equals(s)){
                rubrica.remove(c);
                return true;
            }
        }
        return false;
    }
    public String toStringR(){
        String Ret="";
        for(Contatto c: this.rubrica){
            Ret+=c.toString();
        }
        return Ret;
    }
}
