import java.util.*;

public class GuessANumber {

    public static boolean numberLogic(){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber;
        int counter = 0;
        boolean hadGuessed = false;
    
        System.out.println("Wanna guess a number?");
        System.out.println("Choose difficulty: Easy, Medium, Hard");

        String difficulty = scanner.nextLine().toLowerCase();
    
        switch(difficulty){
            case "easy":
                targetNumber = random.nextInt(50) + 1;
                break;

            case "medium":
                targetNumber = random.nextInt(100) + 1;
                break;

            case "hard":
                targetNumber = random.nextInt(500) + 1;
                break;
            
            default:
                targetNumber = random.nextInt(50) + 1;
        }

        System.out.println("Start Guessing ...");
        System.out.println("Guess a number between 1 and " + (difficulty.equals("hard") ? 500 : difficulty.equals("medium") ? 100 : 50));
        //System.out.println(targetNumber);

        while(true){
            int guess = scanner.nextInt();
            scanner.nextLine();

            if(guess > targetNumber){
                System.out.println("Too high! Try again");
                hadGuessed = false;
            }else if(guess < targetNumber){
                System.out.println("Too low! Try again");
                hadGuessed = false;
            }else{
                hadGuessed = true;
                return hadGuessed;
            } 

            if(counter>5){
                System.out.println("The number you had to guess was "+ targetNumber);
                return hadGuessed;
            }

            counter++; 
        }
        
    }
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        do{
            boolean hadGuessed = numberLogic();
        
            if(hadGuessed){
                System.out.println("Wohooooo! You won");
            }else{
                System.out.println("You lost! Better luck next time");
            }
    
            System.out.println("Wanna play again? ");
            System.out.println("Enter 'Y' to restart the game");
    
            String restart = scan.nextLine();

            if(!restart.equalsIgnoreCase("Y")){
                System.out.println("Thanks for playing!");
                break;
            }

        }while(true);
       

        
        scan.close();  
    }
}
