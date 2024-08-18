
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomCardShuffle implements CardShuffle{
    public Card shuffle(){
        List<CardShape> shapes = Arrays.asList(CardShape.values());
        List<CardNumber> numbers = Arrays.asList(CardNumber.values());

        Collections.shuffle(shapes);
        Collections.shuffle(numbers);
//        Collections.shuffle(deck);
        return new Card(shapes.get(0),numbers.get(0));
    }
}
