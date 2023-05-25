package Test;
import Contatti.Contatto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class testContatti{

    @Test
    void AggiungiNumero(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        int n=c1.numEl();
        assertEquals(c1.InserisciNumTel("3315854979"),true);
        assertEquals(n+1,c1.numEl());
    }

    @Test
    void AggiungiNumeroEsistente(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Boolean ris1=c1.InserisciNumTel("3315854979");
        assertEquals(c1.InserisciNumTel("3315854979"),false);
    }

    @Test
    void CancellaCorrettamente(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Boolean ris1=c1.InserisciNumTel("3315854979");
        int n=c1.numEl();
        assertEquals(c1.EliminaNumTel("3315854979"),true);
        assertEquals(n-1,c1.numEl());
    }

    @Test
    void CancellaFallita(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Boolean ris1=c1.InserisciNumTel("3315854979");
        int n=c1.numEl();
        assertEquals(c1.EliminaNumTel("345253"),false);
        assertEquals(n,c1.numEl());
    }

    @Test
    void numTelStringa(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Boolean ris1=c1.InserisciNumTel("3315854979");
        Boolean ris2=c1.InserisciNumTel("366789");
        assertEquals(c1.numTel(),"3315854979,366789,");
    }

    @Test
    void MatchVeroNome(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        assertEquals(c1.MatchNome("Mich"),true);
    }

    @Test
    void MatchFalsoNome(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        assertEquals(c1.MatchNome("Gino"),false);
    }
    @Test
    void MatchVeroEmail(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        assertEquals(c1.MatchEmail("michele.fil"),true);
    }

    @Test
    void MatchFalsoEmail(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        assertEquals(c1.MatchEmail("Gino"),false);
    }
    @Test
    void ContattoStringa(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Boolean ris1=c1.InserisciNumTel("3315854979");
        Boolean ris2=c1.InserisciNumTel("366789");
        assertEquals(c1.toString(), "Nome: Michele Email: michele.filidoro@gmail.com Numeri: 3315854979,366789,");
    }
    @Test
    void ContattiEqualsTrue(){
        Contatto c1=new Contatto("michele.filidoro@gmail.com", "Michele");
        Contatto c2=new Contatto("michele.filidoro@gmail.com", "Gino");
        assertEquals(true, c1.Equals(c2));
    }
    @Test
    void ContattiEqualsFalse(){
        Contatto c4=new Contatto("michele.filidoro@gmail.com", "Michele");
        Contatto c5=new Contatto("Gino@gmail.com", "Nome");
        assertFalse(c4.Equals(c5));
    }
}
