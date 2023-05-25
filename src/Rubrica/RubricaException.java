package Rubrica;

public class RubricaException extends Exception {
    public RubricaException(String s) {
        super(s);
    }

    static class RubricaPiena extends RubricaException{
        public RubricaPiena() {
            super("rubrica piena");
        }
    }
    static class ContattoEsistente extends RubricaException{
        public ContattoEsistente(){
            super("Contatto Esistente");
        }
    }
}
