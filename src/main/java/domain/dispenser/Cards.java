package domain.dispenser;

import domain.card.Card;
import domain.card.CardNumber;
import domain.card.CardShape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> deck;

    public Cards() {
        deck = Arrays.stream(CardShape.values())
                .flatMap(shape -> Arrays.stream(CardNumber.values())
                        .map(number -> Card.getInstance(shape, number)))
                .collect(Collectors.toList());
    }

    public List<Card> getDeck(){
        return new ArrayList<>(deck);
    }


    public void subCard(final Card given){
        deck.stream()
                .filter(card -> card.match(given))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 카드가 없습니다."));
        deck.remove(given);
    }
}
