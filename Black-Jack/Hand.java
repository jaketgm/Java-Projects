public class Hand 
{
    private Card[] cards;
    private int cardCount;

    public Hand() 
    {
        cards = new Card[12];
        cardCount = 0;
    }

    public void addCard(Card newCard) 
    {
        if (cardCount == cards.length) 
        {
            increaseSize();
        }
        cards[cardCount++] = newCard;
    }

    public void clear() 
    {
        cards = new Card[12];
        cardCount = 0;
    }

    public void printHand() {
        for (int i = 0; i < cardCount; i++) 
        {
            System.out.print(cards[i]);
        }
    }

    public int computeValue() 
    {
        int value = 0;
        int acesCount = 0;
        for (int i = 0; i < cardCount; i++) 
        {
            int cardValue = cards[i].getValue();
            if (cardValue == 1) 
            { // Ace
                acesCount++;
                value += 11;
            } 
            else if (cardValue > 10) 
            { // Face cards
                value += 10;
            } 
            else 
            {
                value += cardValue;
            }
        }
        while (value > 21 && acesCount > 0) 
        {
            value -= 10;
            acesCount--;
        }
        return value;
    }

    private void increaseSize() 
    {
        Card[] newCards = new Card[cards.length * 2];
        System.arraycopy(cards, 0, newCards, 0, cards.length);
        cards = newCards;
    }
}