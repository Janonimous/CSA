package Rochambeau_Project;
import java.util.Scanner;

class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CustomInput cinput = new CustomInput(false);
        
        System.out.println("Ready to play Rock Paper Scissors? [y/n]");
        boolean ready = cinput.yesNo(input.nextLine());
        System.out.println(ready);
    }
}