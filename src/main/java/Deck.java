import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private final List<Card> deck = new ArrayList<>();

    public Deck() {
        Arrays.stream(CardShape.values()).forEach(shape ->
                Arrays.stream(CardNumber.values()).forEach(number ->
                        deck.add(new Card(shape,number))
                ));
    }

    public boolean hasCard(Card other){
        return deck.stream().anyMatch(card -> card.match(other));
    }
}
