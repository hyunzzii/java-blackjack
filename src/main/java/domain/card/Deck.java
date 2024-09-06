package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
    }
//    public Deck(final Collection<Card> cards){
//        deck = new ArrayList<>(cards);
//    }
//
//    //뒤에 상태에서 Hit은 카드가 없는채로 시작하지만, 나머지는 있어야 하기때문에 생성자 2개

    public void addCard(Card card){
        deck.add(card);
    }

    public Integer sum(){
        return deck.stream()
                .map(Card::getNumber)
                .reduce(0, Integer::sum);
    }

    public Long aceCount(){
        return deck.stream().map(Card::isAce).count();
    }
}
