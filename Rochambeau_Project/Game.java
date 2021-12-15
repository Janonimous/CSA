package Rochambeau_Project;
import java.util.Scanner;

class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CustomInput cinput = new CustomInput(false);
        
        boolean ready;
        do {
            System.out.println("Ready to play a game of Rock Paper Scissors? [y/n]");
            ready = cinput.yesNo(input.nextLine());

            if(ready) {
                RPS gamer = new RPS();
                System.out.println("Would you like instructions for this game? [y/n]");

                if(cinput.yesNo(input.nextLine())) {
                    System.out.println("You and another player or the computer chooses between playing a rock [r], paper [p], or scissors [s] \nrock beats scissors, scissors beats paper, and paper beats rock. \nYou get to choose how many round to play and whether you'd like to play against another player or the computer");
                    System.out.println();
                }

                System.out.println("How many rounds would you like to play?");
                int numRounds = input.nextInt();
                gamer.setRounds(numRounds);
                System.out.println("Player vs Player or Player vs Computer? [pvp/pvc]");
                String type = input.nextLine();
                type = input.nextLine();
                gamer.setGameType(cinput.equals(type, "pvp"));

                gamer.playGame();

                System.out.println("Ready to play another game of Rock Paper Scissors?");
                ready = cinput.yesNo(input.nextLine());
                
            } else {
                System.out.println("Would you like to quit the game? [y/n]");
                if(cinput.yesNo(input.nextLine())) break;
                ready = true;
            }
        } while(ready);

        input.close();
    }
}
