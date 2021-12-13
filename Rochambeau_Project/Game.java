package Rochambeau_Project;
import java.util.Scanner;

class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CustomInput cinput = new CustomInput(false);
        
        boolean ready;
        do {
            System.out.println("Ready to play Rock Paper Scissors? [y/n]");
            ready = cinput.yesNo(input.nextLine());
            if(ready) {
                System.out.println("Would you like instructions for the this game? [y/n]");
                if(cinput.yesNo(input.nextLine())) {
                    /* To be implemented; Provide instructions on how to play this version of RPS
                       then re-ask if they are ready to play the game */
                }
                /* To be implemented */
            } else {
                System.out.println("Would you like to quit the game? [y/n]");
                if(cinput.yesNo(input.nextLine())) break;
            }
        } while(ready);

        input.close();
    }
}
