import java.util.ArrayList;
import java.util.List;

public class CardLump {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public Integer sum(){
        return cards.stream()
                .map(Card::getScore)
                .reduce(0, Integer::sum);
    }
}
