package MyKata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

// author: aaronfi@, 2010.06.01
// Represent a deck of cards with operations to shuffle the deck and to deal one card. 

public class Deck 
{
    private List<Card> deck;
    private Random rnd = new Random();
    
    public Deck() {
        deck = new ArrayList<Card>(52);		
        for(Suit s : Suit.values()) {
            for(Rank r: Rank.values()) {
                deck.add(new Card(s, r)); 
            }
        }
	
        shuffle();
    }
    
    public Card deal() {
        return deck.remove(deck.size()-1);
    }
    
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    
    public void shuffle() {
        // Fisher-Yates shuffle algorithm, from http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
        // Yes, I also could have just used Collections.sort(deck)
        for(int i = deck.size()-1; i > 1; i--) {
            Collections.swap(deck, i, rnd.nextInt(i));  // 0 <= j <= i-1  (0-based array)
        }
    }
}
