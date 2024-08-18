public class Player {
    private final CardLump cardLump;
    private final String name;

    public Player(String name){
        cardLump = new CardLump();
        this.name = name;
    }

    public void receiveCard(Card card){
        cardLump.addCard(card);
    }

    public boolean isPossibleBonus(){
        return cardLump.sum() <= 21;
    }
}
