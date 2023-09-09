import java.util.Scanner;

public class NumberGuess{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int givennos=1+(int)(100*Math.random());
        int t=5; // Nos of Trials 
        int i,guessans;
        System.out.println(
            "A number is chosen"
            + " between 1 to 100."
            + "Guess the number"
            + " within 5 trials.");
            for (i=0;i<t;i++){
                System.out.println("Guess The Number : ");  
                guessans=sc.nextInt();
                if (givennos == guessans) {
                    System.out.println(
                        "Congratulations!"
                        + " You guessed the number.");
                    break;
                }
                else if (givennos > guessans && i != t - 1) {
                    System.out.println(
                        "The number is "
                        + "greater than " + guessans);
                }
                else if (givennos < guessans
                         && i != t - 1) {
                    System.out.println(
                        "The number is"
                        + " less than " + guessans);
                }
            }

            if (i == t) {
                System.out.println(
                    "You have exhausted"
                    + " t trials.");
     
                System.out.println(
                    "The number was " + givennos);
            }
    }
}