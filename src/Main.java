public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Menu menu = new Menu();
        ticTacToe.boardGames.setPlayers(menu.menu()[1], menu.menu()[2]);
//        ticTacToe.display.display();
//        ticTacToe.getMoveFromPlayer();
//        ticTacToe.tourJoueur1();
//        ticTacToe.tourJoueur1();
//        ticTacToe.tourJoueur();
        ticTacToe.deroulementPartie();
    }
}