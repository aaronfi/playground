package MyKata;

public enum Rank {
    Two, Three, Four, Five, Six, Seven, 
    Eight, Nine, Ten, Jack, Queen, King, Ace;
	
    // TODO(aaronfi) 2010.06.21
    // Doesn't properly handle games where Ace is the lowest, not highest card.
    // I think this is moot, as you could sort the deck using a custom comparator
    // /TODO
}