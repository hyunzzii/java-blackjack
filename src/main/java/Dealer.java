public class Dealer {
    private final CardLump cardLump;

    public Dealer(){
        cardLump = new CardLump();
    }

    public void receiveCard(Card card){
        cardLump.addCard(card);
    }

    public boolean isPossibleBonus(){
        //추가 구현
        return cardLump.sum() <= 16;
    }
}
