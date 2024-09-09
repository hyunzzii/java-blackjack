package domain.card;

import java.util.Arrays;
import java.util.List;

public class Card {
    private static final List<Card> INSTANCES;

    private final CardShape shape;
    private final CardNumber number;

    private Card(CardShape shape, CardNumber number) {
        validate(shape, number);

        this.shape = shape;
        this.number = number;
    }

    private void validate(CardShape shape, CardNumber number) {
        if (shape == null || number == null) {
            throw new IllegalArgumentException("값이 null입니다.");
        }
    }

    static {
        INSTANCES = Arrays.stream(CardShape.values()).flatMap(shapeElement ->
                Arrays.stream(CardNumber.values()).map(numberElement -> new Card(shapeElement, numberElement))
        ).toList();
    }

    public static Card getInstance(
            final CardShape shape,
            final CardNumber number
    ) {
        return INSTANCES.stream()
                .filter(value -> value.shape == shape && value.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 값이 없습니다."));
    }

    public boolean match(Card other) {
        return this.shape.equals(other.shape) && this.number.equals(other.number);
    }

    public Integer getNumber() {
        return number.getNumber();
    }

    public Boolean isAce() {
        return this.number == CardNumber.ACE;
    }

    @Override
    public String toString() {
        return number.getSuit() + shape.getDenomination();
    }
}
