import java.io.*;
import java.util.Scanner;

public class Heroswar {
    public static void main(String args[]){
        Novice novice = new Novice();

        boolean selectOc = false;

        System.out.println("========Welcome to My Games=======");

        novice.createCharacter();
        do{
            novice.playGame();
            if (novice.getCharacterLevel() == 10 && !selectOc){
                System.out.println("Success LEVEL 10");
                selectOc = novice.selectOccupation();
            }
            if(novice.getCharacterHp() <= 0)
                return;
        }
        while (novice.playGame());
    }

}
