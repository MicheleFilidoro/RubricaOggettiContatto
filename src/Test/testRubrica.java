package Test;
import Contatti.Contatto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import Rubrica.Rubrica;
import static org.junit.jupiter.api.Assertions.*;
import Rubrica.RubricaException;
public class testRubrica {
    @AfterEach
    void svuota(){
        Rubrica.pulisci();
    }
    @Test
    void AggiungiCorrettamente() throws RubricaException {
        Rubrica r1=new Rubrica("casa", 3);
        Rubrica r2=new Rubrica("amici", 2);
        //int ris1= r2.aggiungi("sus");
        /*assertEquals(1,r1.aggiungi("michele.filidoro"));
        assertEquals(1,r2.aggiungi("ciao"));
        assertEquals(-1,r2.aggiungi("tommy.debe"));
        assertEquals(0,r1.aggiungi("michele.filidoro"));
         */

        /*assertEquals("michele.filidoro", r1.get(0).getEmail());
        assertEquals("michele.filidoro", r1.get(0).getEmail());
        assertEquals("ciao", r2.get(1).getEmail());
         */
        Contatto c1= new Contatto("mike", "mike");
        assertEquals(1,r1.aggiungi(c1));
    }
    @Test
    void RicercaPerNome(){
        Rubrica r1=new Rubrica("casa", 3);
        int ris1=r1.aggiungi("mike","mike");
        int ris2=r1.aggiungi("michela","michele");
        int ris3=r1.aggiungi("andre","andrea");
        assertEquals(2,(r1.CercaPerNome("mi").size()));
    }

    @Test
    void RicercaPerEmail(){
        Rubrica r1=new Rubrica("casa", 3);
        int ris1=r1.aggiungi("mike","mike");
        int ris2=r1.aggiungi("michela","michele");
        int ris3=r1.aggiungi("andre","andrea");
        assertEquals(2,(r1.CercaPerEmail("mi").size()));
    }

    @Test
    void EliminaPerEmail(){
        Rubrica r1=new Rubrica("casa", 3);
        int ris1=r1.aggiungi("mike","mike");
        int ris2=r1.aggiungi("michela","michele");
        int ris3=r1.aggiungi("andre","andrea");
        assertEquals(true,r1.EliminaPerEmail("mike"));
        assertEquals(2,r1.numEl());
    }
    @Test
    void EliminaPerNome(){
        Rubrica r1=new Rubrica("casa", 3);
        int ris1=r1.aggiungi("mike","mike");
        int ris2=r1.aggiungi("michela","michele");
        int ris3=r1.aggiungi("andre","andrea");
        assertEquals(true,r1.EliminaPerNome("mike"));
        assertEquals(2,r1.numEl());
    }
    @Test
    void toStringRubrica(){
        Rubrica r1=new Rubrica("casa", 3);
        int ris1=r1.aggiungi("mike","mike");
        int ris2=r1.aggiungi("michela","michele");
        int ris3=r1.aggiungi("andre","andrea");
        assertEquals("Nome: mike Email: mike Numeri: Nome: michele Email: michela Numeri: Nome: andrea Email: andre Numeri: ", r1.toStringR());
    }

}
