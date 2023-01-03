import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Display display = new Display();
    private int maxLimitGameComputerPlayer = 2;
    private int whichGame = -1;
    private int howManyComputers = -1;
    private int whichPosition = -1;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    private void menuChoice(){

        setWhichGame();
        setHowManyComputers();

        if(howManyComputers < 2){
            setWhichPosition();
        }
    }

    private void setWhichGame() {
        while(whichGame < 0 || whichGame > maxLimitGameComputerPlayer){
            display.whichGame();
            if(scanner.hasNextInt()){
                this.whichGame = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if (whichGame != -1 && (whichGame < 0 || whichGame > 3)){
                display.errorOutOfBounds(maxLimitGameComputerPlayer);
            }
        }
    }
    private void setHowManyComputers() {
        while(howManyComputers < 0 || howManyComputers > maxLimitGameComputerPlayer){
            display.howManyComputers();
            if(scanner.hasNextInt()){
                this.howManyComputers = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if(howManyComputers != -1 && (howManyComputers < 0 || howManyComputers > maxLimitGameComputerPlayer)){
                display.errorOutOfBounds(maxLimitGameComputerPlayer);
            }
        }
    }
    private void setWhichPosition() {
        while(whichPosition == -1){
            display.whichPosition();
            if (scanner.hasNextInt()){
                this.whichPosition = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if (whichPosition != -1 && (whichPosition < 0 || whichPosition > maxLimitGameComputerPlayer)){
                display.errorOutOfBounds(maxLimitGameComputerPlayer);
            }
        }
    }

    public int[] menu(){
        menuChoice();
        return new int[]{this.whichGame, this.howManyComputers, this.whichPosition};
        //TODO init game
    }
}
