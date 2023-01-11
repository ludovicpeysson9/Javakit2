package controller;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import view.DisplayView;
import model.PlayerModel;
import model.ArtificialPlayerModel;
import util.TupleUtil;

public class MenuController{
    Scanner scanner;
    DisplayView display = new DisplayView();
    private final int maxLimitGameComputerPlayer = 2;
    private Class whichGame;
    private int howManyComputers = -1;
    private int whichPosition = -1;

    public MenuController(){
        this.scanner = new Scanner(System.in);
    }

    /**
     *  Function which launches differents choices of the user (which game, how many computers and which position is the player).
     *
     */
    private void menuChoice(){

        setWhichGame();
        setHowManyComputers();

        if(howManyComputers < 2){
            setWhichPosition();
        }
    }


    /**
     *  Function which sets which game according to the user's choice
     *
     */
    private void setWhichGame() {
        int whichGameInt = -1;
        while(whichGameInt < 0 || whichGameInt > maxLimitGameComputerPlayer){
            display.whichGame();
            if(scanner.hasNextInt()){
                whichGameInt = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if (whichGameInt != -1 && (whichGameInt < 0 || whichGameInt > 3)){
                display.errorOutOfBounds(maxLimitGameComputerPlayer);
            }
        }
        switch (whichGameInt){
            case 0:
                whichGame = TicTacToeController.class;
                break;
            case 1:
                whichGame = GomokuController.class;
                break;
            case 2:
                whichGame = Puissance4Controller.class;
                break;
        }
    }

    /**
     * Function which sets how many computers will be used as players
     *
     */
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

    /**
     *  Function which sets the player's position
     *
     */
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

    /**
     *  TupleUtil is a function which returns 2 players (human or AI) according to the user choices
     *
     * @param howManyComputers
     * @param whichPosition
     * @return
     */
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

    /**
     * Function which creates an instance of a game according to the user's choice
     *
     */
    public GameController createGame(){
/*        if(whichGame == 0){
//            TicTacToeController ticTacToe = new TicTacToeController(createPlayer(howManyComputers, whichPosition));
            TicTacToeController ticTacToe = GameFactory.createGame(TicTacToeController.class, createPlayer(howManyComputers, whichPosition));
            ticTacToe.deroulementPartie();
        }
        if(whichGame == 1){
            GomokuController gomoku = new GomokuController(createPlayer(howManyComputers, whichPosition));
            gomoku.deroulementPartie();
        }
        if(whichGame == 2){
            Puissance4Controller puissance4 = new Puissance4Controller(createPlayer(howManyComputers, whichPosition));
//            puissance4.deroulementPartie();
        }*/
        try{
            return GameFactory.createGame(whichGame,createPlayer(howManyComputers, whichPosition));
        }
        catch (Exception e){
            System.err.println(e + e.getStackTrace().toString());
        }
        return null;
    }

    /**
     * Function which is called by the main class and launches menuChoice() and createGame().
     *
     */
    public void startAGame(){
        menuChoice();
        GameController gameController = this.createGame();
        gameController.deroulementPartie();
    }

}
