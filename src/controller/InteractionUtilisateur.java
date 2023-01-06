//TODO Implémenter la classe InteractionUtilisateur

//package controller;
//
//import model.BoardGamesModel;
//import view.DisplayView;
//
//import java.util.Scanner;
//
//public class InteractionUtilisateur {
//
//    Scanner scanner;
//    BoardGamesModel boardGames;
//    DisplayView display;
//
//    /** Function to get verified coords from player. Return an array of 2 integers
//     *
//     * @return
//     */
//    public int[] getMoveFromPlayer(){
//        boolean available = false;
//        int goodCoordX =-1;
//        int goodCoordY = -1;
//        while (!available){
//            int[] coords = getCoordsWithinBounds();
//            available = boardGames.cellIsEmpty(coords[0], coords[1]);
//            goodCoordX = coords[0];
//            goodCoordY = coords[1];
//        }
//        return new int[]{goodCoordX, goodCoordY};
//    }
//
//    /** Function to get the input from a player and verify if they are within the bounds. Return an array of 2 integers.
//     *
//     * @return
//     */
//    public int[] getCoordsWithinBounds() {
//        int x = -1;
//        int y = -1;
//        int tailleMaxAbscisse = boardGames.getDimensions()[0] - 1;
//        int tailleMaxOrdonnee = boardGames.getDimensions()[1] - 1;
//
//        while (x < 0 || x > tailleMaxAbscisse) {
//            display.instructionAbscisse(tailleMaxAbscisse);
//            if (scanner.hasNextInt()) {
//                x = scanner.nextInt();
//            } else {
//                display.errorEntier();
//                scanner.next();
//            }
//            if(x != -1 && (x < 0 || x > tailleMaxAbscisse)){
//                display.errorOutOfBounds(tailleMaxAbscisse);
//            }
//        }
//        while (y < 0 || y > tailleMaxOrdonnee) {
//            display.instructionOrdonnee(tailleMaxOrdonnee);
//
//            if (scanner.hasNextInt()) {
//                y = scanner.nextInt();
//            } else {
//                display.errorEntier();
//                scanner.next();
//            }
//            if(y != -1 && (y < 0 || y > tailleMaxOrdonnee)){
//                display.errorOutOfBounds(tailleMaxOrdonnee);
//            }
//        }
//        return new int[]{y, x};
//    }
//
//}
