package controller;
import java.util.Scanner;
import view.DisplayView;
import model.PlayerModel;
import model.ArtificialPlayerModel;
import util.TupleUtil;

public class MenuController implements GameControllerInterface {
    Scanner scanner;
    DisplayView display = new DisplayView();
    private int maxLimitGameComputerPlayer = 2;
    private int whichGame = -1;
    private int howManyComputers = -1;
    private int whichPosition = -1;

    public MenuController(){
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
                whichPosition =-1;
            }
        }
    }

    public TupleUtil<PlayerModel, PlayerModel> createPlayer(int howManyComputers, int whichPosition){
        PlayerModel player1 = new PlayerModel("| X ", 1);;
        PlayerModel player2 = new PlayerModel("| O ", 2);
        if(howManyComputers >= 2){
            player1 = new ArtificialPlayerModel( "| X ", 1);
            player2 = new ArtificialPlayerModel("| O ", 2);
        }
        if(howManyComputers == 1){
            if(whichPosition == 1){
                player2 = new ArtificialPlayerModel( "| O ", 2);
            }else if (whichPosition == 2){
                player1 = new ArtificialPlayerModel( "| X ", 1);
            }
        }
        return new TupleUtil<PlayerModel, PlayerModel>(player1, player2);
    }

    public void createGame(){
        if(whichGame == 0){
            TicTacToeController ticTacToe = new TicTacToeController(createPlayer(howManyComputers, whichPosition));
            ticTacToe.deroulementPartie();
        }
        if(whichGame == 1){
            GomokuController gomoku = new GomokuController(createPlayer(howManyComputers, whichPosition));
            gomoku.deroulementPartie();
        }
        if(whichGame == 2){
            Puissance4Controller puissance4 = new Puissance4Controller(createPlayer(howManyComputers, whichPosition));
//            puissance4.deroulementPartie();
        }
    }
    public void startGame(){
        menuChoice();
        createGame();
    }

}
