public class Card {
    private final CardShape shape;
    private final CardNumber number;

    public Card(CardShape shape, CardNumber number) {
        this.shape = shape;
        this.number = number;
    }

    public boolean match(Card other){
        return this.shape.equals(other.shape) && this.number.equals(other.number);
    }

    public Integer getScore(){
        return number.getScore();
    }
}
