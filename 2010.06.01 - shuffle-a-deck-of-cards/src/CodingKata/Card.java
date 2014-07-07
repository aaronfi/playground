package CodingKata;

public class Card
{
    private Suit suit;
    private Rank rank;
    
    public Card(Suit init_suit, Rank init_rank) {
        this.suit = init_suit;
        this.rank = init_rank;
    }
    
    public Rank getRank() {
        return this.rank;
    }
    
    public Suit getSuit() {
        return this.suit;
    }
    
    public boolean equals(Card that) {
        return (this.suit.equals(that.getSuit()) && this.rank.equals(that.getRank()));
    }
    
    public int hashCode() {
        return (this.getRank().ordinal() + 1) * 100 + (this.getSuit().ordinal() + 1);
    }
}