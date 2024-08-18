public class CardDispenser {
    private final Deck deck;
    private final CardShuffle cardShuffle;

    public CardDispenser(CardShuffle cardShuffle){
        this.deck = new Deck();
        this.cardShuffle = cardShuffle;
    }

    public Card giveACard(){
        Card card;
        do {
            card = cardShuffle.shuffle();
        }while(!deck.hasCard(card));
        return card;
    }
}
