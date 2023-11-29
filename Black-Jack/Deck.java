import java.util.Random;

public class Deck 
{
    private static final int SIZE = 52;
    private Card[] cards;
    private int nextCardIndex;

    public Deck(int numOfDecks) 
    {
        cards = new Card[SIZE * numOfDecks];
        initializeDeck(numOfDecks);
    }

    private void initializeDeck(int numOfDecks) 
    {
        int index = 0;
        for (int i = 0; i < numOfDecks; i++) 
        {
            for (int suit = 1; suit <= 4; suit++) 
            {
                for (int value = 1; value <= 13; value++) 
                {
                    cards[index++] = new Card(suit, value);
                }
            }
        }
    }

    public void shuffle() 
    {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) 
        {
            int index = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
        nextCardIndex = 0;
    }

    public Card deal() 
    {
        return cards[nextCardIndex++];
    }
}