package Rochambeau_Project;
import java.util.Scanner;
import java.io.Console;

/**
 * Link to Rock Paper Scissors statistics:
 * https://www.inverse.com/mind-body/rock-paper-scissors-not-sports#:~:text=Both%20Psychology%20Today%20and%20The,29.6%20percent%20of%20the%20time.
 */

public class RPS {
    
    private int rounds;
    private int bestOf = (int) rounds/2;
    private int cRound; // Current round
    private int[] scores = {0, 0}; // Player 1 and Player 2/Computer
    private static String[] options = {"r", "p", "s"};
    private String[] choices = {"", ""};
    private boolean pvp;

    Scanner input = new Scanner(System.in);
    CustomInput cinput = new CustomInput(false);
    Console console = System.console();

    public RPS() {
        this.rounds = 3;
        this.cRound = 1;
    }

    public RPS(int rounds, boolean pvp) {
        this.rounds = rounds;
        this.cRound = 1;
        this.pvp = pvp;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setGameType(boolean pvp) {
        this.pvp = pvp;
    }

    // Precondition: p1Choice and p2Choice are only "r", "p", or "s"
    public void determineScore(String p1Choice, String p2Choice) {
        if(!p1Choice.equals(p2Choice)) {
            String result = "";
            switch(p1Choice) {
                case "r":
                    if(p2Choice.equals("p")) {
                        result = "Player 2/Computer wins round with Paper!";
                        scores[1]++;
                    } else {
                        result = "Player 1 wins round with Rock!";
                        scores[0]++;
                    }
                    break;
                case "p":
                    if(p2Choice.equals("r")) {
                        result = "Player 1 wins round Paper!";
                        scores[0]++;
                    } else {
                        result = "Player 2/Computer wins round with Scissors!";
                        scores[1]++;
                    }
                    break;
                case "s":
                    if(p2Choice.equals("r")) {
                        result = "Player 2/Computer wins round with Rock!";
                        scores[1]++;
                    } else {
                        result = "Player 1 wins round with Scissors!";
                        scores[0]++;
                    }
                    break;
            }
            System.out.println("Player 1 Score: " + scores[0] + "\nPLayer 2/Computer Score: " + scores[1]);
            System.out.println(result);
            System.out.println();
            cRound++;
        } else {
            System.out.println("**Redoing round; both players choose same option**");
            playRound();
        }
    }

    public void getPlayerMove(int numPlayer) { // numPlayer: 1 or 2
        System.out.println("Please choose Rock, Paper, or Scissors [r/p/s]");
        String choice = "";
        boolean foo = false;
        do {
            if(pvp) choice = String.valueOf(console.readPassword()); // Hides input in console
            else choice = input.nextLine();
            foo = cinput.multipleEquals(choice, options);
            if(!foo) System.out.println("Please enter either r, p, or s");
        } while(!foo);
        choices[numPlayer-1] = choice;
    }

    public void getComputerMove() {
        double bar = Math.random()*100;
        String choice = "";
        if(bar >= 70.4) choice = "r";
        else if(bar >= 35.4) choice = "s";
        else choice = "p";
        choices[1] = choice;
    }

    public void playRound() {
        System.out.println("Round " + cRound);
        System.out.print("Player 1, ");
        getPlayerMove(1);
        if(pvp) {
            System.out.print("Player 2, ");
            getPlayerMove(2);
        } else {
            getComputerMove();
        }
        determineScore(choices[0], choices[1]);
        if(cRound == (rounds+1)) {
            if (scores[0] > scores[1])
                System.out.println("Player 1 wins the game with a score of " + scores[0]);
            if (scores[1] > scores[0])
                System.out.println("Player 2/Computer wins the game with a score of " + scores[1]);
        }
    }

    public void playGame() {
        for(int i=0; i < rounds; i++) {
            playRound();
        }
    }

    public void resetScores() {
        scores[0] = scores[1] = 0;
    }

}
