import java.util.Scanner;
import java.util.Random;

public class SourceCode {

    public static String greeting(Scanner scanner) {
        String player;

        System.out.print("Enter your name: ");
        player = scanner.nextLine();

        System.out.println("Hello, " + player + "!");
        System.out.println("Welcome to Magic Elements Game!");
        System.out.println("Enter fire water and plant to play");
        System.out.println("If you want to know the score enter \"!score\"");
        System.out.println("If you want to end this game enter \"!exit\"");
        System.out.println("Let's play Magic Elements!");

        return player;
    }

    public static int userWin(String win,String computer){
        System.out.println(win +" Because the computer .... ");
        System.out.println("Pick " + computer + "!!");
        return 50;
    }

    public static int userLose(String lose,String computer){
        System.out.println(lose);
        System.out.println("Because the computer pick " + computer + " !!");
        return 0;
    }

    public static int userDraw(String computer) {
        System.out.println("At least you didn't lose.");
        System.out.println("Because the computer pick "+ computer + " too.");
        return 25;
    }

    public static int playGame(String win,String lose,String playerChoice, String computer){
        int point =0 ;

        if(playerChoice.equals(computer)){
            point = userDraw(computer);
        }else if (playerChoice.equals("fire")){ 
            if(computer.equals("plant")){
                point = userWin(win, computer);
            }else{
                point = userLose(lose,computer);
            }

        }else if(playerChoice.equals("water")){
            if(computer.equals("fire")){
                point = userWin(win, computer);
            }else{
                point = userLose(lose,computer);
            }

        }else if(playerChoice.equals("plant")){
            if(computer.equals("water")){
                point = userWin(win, computer);
            }else{
                point = userLose(lose,computer);
            }

        }else {
            System.out.println("Invalid input!");
        }

        return point;
    }

    public static String getComputerChoice(){
        String[] computerChoice = {"fire","water","plant"};
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(computerChoice.length); 

        return computerChoice[computerChoiceIndex];
    }

    public static String Winchooice(){
        String[] Win = {"Nice pick!!", "Nice choice!!", "Good pick!!", "Well played!!"};
        Random rd = new Random();
        int WinchoiceIndex = rd.nextInt(Win.length);

        return Win[WinchoiceIndex];
    }

    public static String Losechooice(){
        String[] Lose = {"Bad luck T-T", "Unlucky T-T", "Better luck next time...", "Nice try."};
        Random RD = new Random();
        int WinchoiceIndex = RD.nextInt(Lose.length);

        return Lose[WinchoiceIndex];
    }

    public static void main(String[] args) {
        int point = 0;
        Scanner scanner = new Scanner(System.in);
        
        greeting(scanner);

        while(true){
        System.out.print("> ");
        String choice = scanner.nextLine();

        if(choice.equals("!exit")){
            System.out.println("Your total score is " + point + "!");
            System.out.println("See ya!");
            break;
        }
        if(choice.equals("!score")){
            System.out.println("Your score: " + point);
            continue;
        }

        String computer = getComputerChoice();
        String win = Winchooice();
        String lose = Losechooice();
        point += playGame(win,lose,choice, computer);
        
        }
    }
    
}

