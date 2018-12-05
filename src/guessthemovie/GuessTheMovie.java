
package guessthemovie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessTheMovie {
    static ArrayList<String> ck = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filmname;
        ArrayList<String> arr = new ArrayList<>();
        ReadFile read = new ReadFile();
        arr = read.ReadFileIO();
        //Random filmname
        int rd = new Random().nextInt(arr.size());
        filmname = arr.get(rd);
        //Creat
        FactoryString fs = new FactoryString(filmname);
        int miss=0;
        
        do{
            System.out.print("Guess a letter:");
            String g = sc.nextLine();
            if(!checkCharGuess(g)){
                System.out.println("The letter is guess!");
                continue;
            }
            if(fs.checkFilm(g)){
                if(fs.getNamefilm().equals(fs.getGuess())){
                    System.out.println("You Win!!");
                    break;
                }
                System.out.println("You have guessed ("+miss+") wrong the letter!");
                
            }else{
                miss+=1;
                if(miss==10){
                    System.out.println("You close!");
                    break;
                }
                System.out.println("You have guessed ("+miss+") wrong the letter!");
            }
            
        }while(true);
    }
    public static boolean checkCharGuess(String g){
        for(int i=0;i<ck.size();i++){
            if(g.equals(ck.get(i))){
                return false;
            }
        }
        ck.add(g);
        return true;
    }
}
