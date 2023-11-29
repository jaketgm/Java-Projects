/******************************************************************************
 * Class: Hand: 
 * 
 * - Creates a current hand.
 *
 * Input: None.
 *
 * Output: The hand.
 *
******************************************************************************/
public class Hand 
{
    private Card[] cards;
    private int cardCount;

    /******************************************************************************
     * Method: Hand: 
     * 
     * - Initializes a current hand.
     *
     * Input: None.
     *
     * Output: The hand.
     *
    ******************************************************************************/
    public Hand() 
    {
        cards = new Card[12];
        cardCount = 0;
    }

    /******************************************************************************
     * Method: addCard: 
     * 
     * - Adds a card to the current hand.
     *
     * Input: Card newCard.
     *
     * Output: The hand with the new card.
     *
    ******************************************************************************/
    public void addCard(Card newCard) 
    {
        if (cardCount == cards.length) 
        {
            increaseSize();
        }
        cards[cardCount++] = newCard;
    }

    /******************************************************************************
     * Method: clear: 
     * 
     * - Clears the current hand.
     *
     * Input: None.
     *
     * Output: Cleared hand.
     *
    ******************************************************************************/
    public void clear() 
    {
        cards = new Card[12];
        cardCount = 0;
    }

    /******************************************************************************
     * Method: printHand: 
     * 
     * - Prints the current hand.
     *
     * Input: None.
     *
     * Output: Printed hand.
     *
    ******************************************************************************/
    public void printHand() {
        for (int i = 0; i < cardCount; i++) 
        {
            System.out.print(cards[i]);
        }
    }

    /******************************************************************************
     * Method: computeValue: 
     * 
     * - Computes the value of the current hand.
     *
     * Input: None.
     *
     * Output: Computed hand.
     *
    ******************************************************************************/
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

    /******************************************************************************
     * Method: increaseSize: 
     * 
     * - Increases the size of the Card[] array.
     *
     * Input: None.
     *
     * Output: Card[] array with increased size.
     *
    ******************************************************************************/
    private void increaseSize() 
    {
        Card[] newCards = new Card[cards.length * 2];
        System.arraycopy(cards, 0, newCards, 0, cards.length);
        cards = newCards;
    }
}
