package domain.card;

public enum CardShape {
    SPADE("스페이드"),HEART("하트"),CLOVER("클로버"),DIAMOND("다이아몬드");

    private final String denomination;

    CardShape(String denomination){
        this.denomination = denomination;
    }

    public String getDenomination() {
        return denomination;
    }
}
