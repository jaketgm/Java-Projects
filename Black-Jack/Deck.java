import java.util.Random;

/******************************************************************************
 * Class: Deck: 
 * 
 * - Creates a deck of cards with a size of 52.
 *
 * Input: None.
 *
 * Output: Deck of 52 cards.
 *
******************************************************************************/
public class Deck 
{
    private static final int SIZE = 52;
    private Card[] cards;
    private int nextCardIndex;

    /******************************************************************************
     * Method: Deck: 
     * 
     * - Initializes a deck of cards with a size of 52 * numOfDecks.
     *
     * Input: int numOfDecks.
     *
     * Output: Deck of (52 * numOfDecks) cards.
     *
    ******************************************************************************/
    public Deck(int numOfDecks) 
    {
        cards = new Card[SIZE * numOfDecks];
        initializeDeck(numOfDecks);
    }

    /******************************************************************************
     * Method: initializeDeck: 
     * 
     * - Initializes the deck of cards.
     *
     * Input: int numOfDecks.
     *
     * Output: Deck of cards.
     *
    ******************************************************************************/
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

    /******************************************************************************
     * Method: shuffle: 
     * 
     * - Shuffles the deck of cards using Fisher Yates.
     *
     * Input: None.
     *
     * Output: Shuffled deck.
     *
    ******************************************************************************/
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

    /******************************************************************************
     * Method: deal: 
     * 
     * - Deals cards from the deck.
     *
     * Input: None.
     *
     * Output: Dealt cards.
     *
    ******************************************************************************/
    public Card deal() 
    {
        return cards[nextCardIndex++];
    }
}
