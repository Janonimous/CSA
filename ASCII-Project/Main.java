import java.io.*;
import java.util.Scanner;

/*
  This is an ASCII Project for my AP CSA class
  Link to source of all the ASCII art: https://www.asciiart.eu/
*/

public class Main {

  static void wait(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
     }
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    boolean loading = true;
    boolean again = true;
    String[] asciiImages = {"batman", "bulbasaur", "calvin", "charizard", "charmander",  "gameboy", "hello kitty", "hobbes", "mortal kombat", "pacman", "pikachu", "pokemon",  "sonic", "spiderman", "squirtle", "zelda"};

    while (again) {

      System.out.println("Type in one of the \"character\" options below to have them printed as an ASCII image!");
      for (String imgName: asciiImages) {
        String name = imgName.substring(0,1).toUpperCase() + imgName.substring(1);
        if (!asciiImages[asciiImages.length -1].equals(imgName)) {
          System.out.print(name + ", ");
        } else {
          System.out.print(name);
        }
      }
      System.out.println();
      String requestedImage = input.nextLine().toLowerCase();

      int index = -1;
      for (int i=0; i < asciiImages.length; i++) {
        if (asciiImages[i].equals(requestedImage)) {
          index = i;
          break;
        }
      }
      
      String foundImage = requestedImage;
      try {
        foundImage = asciiImages[index];
      } catch (IndexOutOfBoundsException e) {
        System.out.println("The requested image was not found");
      }

      try {
        File asciiFile = new File("images/" + foundImage + ".txt");
        Scanner fileReader = new Scanner(asciiFile);

        if (loading) {
          System.out.print("Loading");
          for (int i=0; i < 3; i++) {
            System.out.print(" . ");
            wait(250);
          }
          System.out.println();
        }

        while(fileReader.hasNextLine()) {
          String line = fileReader.nextLine();
          System.out.println(line);
          wait(10);
        }
        fileReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error has occured when retrieving the image");
        e.printStackTrace();
      }

      System.out.println("Do you want to print another character? [Type yes or y]");
      String redo = input.nextLine().toLowerCase();
      if (redo.equals("yes") || redo.equals("y")) {
        again = true;
      } else {
        again = false;
        System.out.println("Thanks for viewing my ASCII Project!");
      }
    
    }

    input.close();

  }
}