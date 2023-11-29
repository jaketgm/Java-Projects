/******************************************************************************
 * @author Jake Brockbank
 * Nov 29th, 2023 (Original)
 * Plays a game of black jack.
******************************************************************************/

import java.util.Scanner;

/******************************************************************************
 * Method: BlackJackClient (Driver): 
 * 
 * - Plays a game of black jack.
 *
 * Input: None.
 *
 * Output: The game of Black Jack.
 *
******************************************************************************/
public class BlackJackClient 
{
    public static void main(String[] args) 
    {
        Deck deck = new Deck(6);
        deck.shuffle();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        int playerBalance = 100;
        Scanner scanner = new Scanner(System.in);

        while (playerBalance > 0) 
        {
            startNewRound(deck, playerHand, dealerHand);

            if (checkForBlackjack(playerHand, dealerHand)) 
            {
                playerBalance += 10;  // Assuming player wins on blackjack
                continue;
            }

            boolean playerBusted = playerTurn(scanner, deck, playerHand);
            if (playerBusted) 
            {
                System.out.println("You busted.");
                playerBalance -= 10;
                if (!askToPlayAgain(scanner)) 
                {
                    break;
                }
                continue;
            }

            boolean dealerBusted = dealerTurn(deck, dealerHand);
            playerBalance = updateBalance(playerHand, dealerHand, playerBalance, dealerBusted);

            if (!askToPlayAgain(scanner)) 
            {
                break;
            }
        }

        System.out.println("Your final balance was: " + playerBalance);
        scanner.close();
    }

    /******************************************************************************
     * Method: startNewRound: 
     * 
     * - Starts a new round of Black Jack.
     *
     * Input: Deck deck, Hand playerHand, Hand dealerHand.
     *
     * Output: The new round.
     *
    ******************************************************************************/
    private static void startNewRound(Deck deck, Hand playerHand, Hand dealerHand) 
    {
        playerHand.clear();
        dealerHand.clear();
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        System.out.println("Round Started.");
    }

    /******************************************************************************
     * Method: checkForBlackjack: 
     * 
     * - Checks to see if anyone has won (i.e. got blackjack (21)).
     *
     * Input: Hand playerHand, Hand dealerHand.
     *
     * Output: True if blackjack, false if not.
     *
    ******************************************************************************/
    private static boolean checkForBlackjack(Hand playerHand, Hand dealerHand) 
    {
        if (playerHand.computeValue() == 21 || dealerHand.computeValue() == 21) 
        {
            System.out.println("Blackjack!");
            return true;
        }
        return false;
    }

    /******************************************************************************
     * Method: playerTurn: 
     * 
     * - Checks to see is its the players turn.
     *
     * Input: Scanner scanner, Deck deck, Hand playerHand.
     *
     * Output: True so long as no blackjack and not the dealers, false otherwise.
     *
    ******************************************************************************/
    private static boolean playerTurn(Scanner scanner, Deck deck, Hand playerHand) 
    {
        while (playerHand.computeValue() < 21) 
        {
            System.out.print("Your Hand: ");
            playerHand.printHand();
            System.out.println("Hand Value: " + playerHand.computeValue());
            System.out.print("Would you like to Hit or Stay? (Hit/Stay): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Hit")) 
            {
                playerHand.addCard(deck.deal());
            } 
            else 
            {
                break;
            }
        }
        return playerHand.computeValue() > 21;
    }

    /******************************************************************************
     * Method: dealerTurn: 
     * 
     * - Checks to see if its the dealers turn.
     *
     * Input: Deck deck, Hand dealerHand.
     *
     * Output: True so long as no blackjack and not the players, false otherwise.
     *
    ******************************************************************************/
    private static boolean dealerTurn(Deck deck, Hand dealerHand) 
    {
        while (dealerHand.computeValue() < 17) 
        {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.computeValue() > 21;
    }

    /******************************************************************************
     * Method: updateBalance: 
     * 
     * - Updates current balance based off when you loose or win a game.
     *
     * Input: Hand playerHand, Hand dealerHand, int playerBalance, boolean 
     * dealerBusted.
     *
     * Output: The updated balance.
     *
    ******************************************************************************/
    private static int updateBalance(Hand playerHand, Hand dealerHand, int playerBalance, boolean dealerBusted) 
    {
        int playerValue = playerHand.computeValue();
        int dealerValue = dealerHand.computeValue();

        if (dealerBusted || playerValue > dealerValue) 
        {
            System.out.println("You win this round!");
            return playerBalance + 10;
        } 
        else if (playerValue < dealerValue) 
        {
            System.out.println("Dealer wins this round.");
            return playerBalance - 10;
        } 
        else 
        {
            System.out.println("It's a tie.");
            return playerBalance;
        }
    }

    /******************************************************************************
     * Method: askToPlayAgain: 
     * 
     * - Asks player whether they wish to play another game.
     *
     * Input: Scanner scanner.
     *
     * Output: Closes if no, continues if yes.
     *
    ******************************************************************************/
    private static boolean askToPlayAgain(Scanner scanner) 
    {
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }
}
