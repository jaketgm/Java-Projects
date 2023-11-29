/******************************************************************************
 * Class: Card: 
 * 
 * - Creates a card with a suit and value.
 *
 * Input: None.
 *
 * Output: Card with a suit and value.
 *
******************************************************************************/
public class Card 
{
    private int suitVal;
    private int cardVal;

    /******************************************************************************
     * Method: Card: 
     * 
     * - Initializes a card with a suit and value.
     *
     * Input: int suitVal, int cardVal.
     *
     * Output: Card with a suit and value.
     *
    ******************************************************************************/
    public Card(int suitVal, int cardVal) 
    {
        this.suitVal = suitVal;
        this.cardVal = cardVal;
    }

    /******************************************************************************
     * Method: getSuit: 
     * 
     * - Returns the suite of a card.
     *
     * Input: None.
     *
     * Output: Suite of card.
     *
    ******************************************************************************/
    public int getSuit() 
    {
        return suitVal;
    }

    /******************************************************************************
     * Method: getValue: 
     * 
     * - Returns the value of a card.
     *
     * Input: None.
     *
     * Output: Value of card.
     *
    ******************************************************************************/
    public int getValue() 
    {
        return cardVal;
    }

    /******************************************************************************
     * Method: toString: 
     * 
     * - Prints out the cards suit and value.
     *
     * Input: None.
     *
     * Output: String with suit and value of card.
     *
    ******************************************************************************/
    @Override
    public String toString() 
    {
        String suit;
        switch (suitVal) 
        {
            case 1:
                suit = "Hearts";
                break;
            case 2:
                suit = "Clubs";
                break;
            case 3:
                suit = "Spades";
                break;
            case 4:
                suit = "Diamonds";
                break;
            default:
                suit = "Unknown";
                break;
        }

        String value;
        switch (cardVal) 
        {
            case 1:
                value = "Ace";
                break;
            case 11:
                value = "Jack";
                break;
            case 12:
                value = "Queen";
                break;
            case 13:
                value = "King";
                break;
            default:
                value = String.valueOf(cardVal);
                break;
        }

        return value + " of " + suit + "\n";
    }
}
