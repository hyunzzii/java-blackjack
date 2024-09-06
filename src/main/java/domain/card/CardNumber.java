package domain.card;

public enum CardNumber {
//    ACE(1,"A"),
//    TWO(2,"2"),
//    THREE(3,"3"),
//    FOUR(4,"4"),
//    FIVE(5,"5"),
//    SIX(6,"6"),
//    SEVEN(7,"7"),
//    EIGHT(8,"8"),
//    NINE(9,"9"),
//    TEN(10,"10"),
//    JACK(10,"J"),
//    QUEEN(10,"Q"),
//    KING(10,"K");
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private final Integer number;
//    private final String name;

    CardNumber(Integer number) {
        this.number = number;
//        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }
}
