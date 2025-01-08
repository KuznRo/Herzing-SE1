import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int player1Score = 0;
        int player2Score = 0;

        boolean playAgain = true;

        System.out.println("This is a two player Rock, Paper, Scissor Game!");

        System.out.println("Player 1, enter your name: ");
        String player1 = scanner.nextLine();
        System.out.println("Player 2, enter your name: ");
        String player2 = scanner.nextLine();

        while(playAgain) {

            System.out.println("Enter 1 for Rock, 2 for Paper, and 3 for Scissors");
            System.out.println(player1 + " will start");
            
            System.out.println(player1 + ", choose 1, 2, or 3: ");
            int player1play = scanner.nextInt();
            scanner.nextLine();

            System.out.println(player2 + ", choose 1, 2, or 3: ");
            int player2play = scanner.nextInt();
            scanner.nextLine();

            if (player1play != 1 && player1play != 2 && player1play != 3 || player2play != 1 && player2play != 2 && player2play != 3) {
                System.out.println("Invalid input! Please choose 1 for Rock, 2 for Paper or 3 for Scissors.");
            }
            else if (player1play == player2play) {
                System.out.println("This round is a tie!");
            }
            else if (player1play == 1) {
                if (player2play == 2) {
                    System.out.println("Paper beats Rock! " + player2 + " wins!");
                    player2Score ++;
                } else if (player2play == 3) {
                    System.out.println("Rock beats Scissors! "+ player1 + " wins!");
                    player1Score ++;
                }
            }
            else if (player1play == 2) {
                if (player2play == 1) {
                    System.out.println("Paper beats Rock! " + player1 + " wins!");
                    player1Score ++;
                } else if (player2play == 3) {
                    System.out.println("Scissors beats Paper! " + player2 + " wins!");
                    player2Score ++;
                }
            }
            else if (player1play == 3) {
                if (player2play == 1) {
                    System.out.println("Rock beats Scissors! " + player2 + " wins!");
                    player2Score ++;
                } else if (player2play == 2) {
                    System.out.println("Scissors beats Paper! " + player1 + " wins!");
                    player1Score ++;
                }
            } 
            
            System.out.println("The current score is " + player1 + ": " + player1Score + " " + player2 + ": " + player2Score);
            
            System.out.println("Do you want to continue playing this match? (y/n)");
                    String nextGameInquiry = scanner.nextLine().toLowerCase();
                    playAgain = nextGameInquiry.equals("y");
 
        }

        System.out.println("Game Over!");
            System.out.println(player1 + " won " + player1Score + " rounds.");
            System.out.println(player2 + " won " + player2Score + " rounds.");

            if (player1Score == player2Score) {
                System.out.println("The match ended in a tie!");
            } else if (player1Score > player2Score) {
                System.out.println(player1 + " wins!");
            } else {
                System.out.println(player2 + " wins!");
            }

            System.out.println("Thanks for playing!");
            scanner.close();
    }
}