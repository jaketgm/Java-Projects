public class Card 
{
    private int suitVal;
    private int cardVal;

    public Card(int suitVal, int cardVal) 
    {
        this.suitVal = suitVal;
        this.cardVal = cardVal;
    }

    public int getSuit() 
    {
        return suitVal;
    }

    public int getValue() 
    {
        return cardVal;
    }

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