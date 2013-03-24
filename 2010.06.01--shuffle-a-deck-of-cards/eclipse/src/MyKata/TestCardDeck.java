package MyKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCardDeck {
    
    @Test
    public void test() { 
    	Deck deck = new Deck();
    	Card c1 = deck.deal();
    	Card c2 = deck.deal();
    	
    	assertNotSame("You dealt the same card twice in row, shouldn't be possible!", c1, c2);
    }
}
