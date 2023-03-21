package view;//package view;

import model.PlayerModel;

public class DisplayView {
    //TODO Faire en sorte que la view gère toutes les interactions avec l'utilisateur (scanner) mais pas la logique.
    private String instructionXAxis = "Entrez l'abscisse de la case libre ciblée sous forme d'entier entre 0 et ";

    private String instructionYAxis = "Entrez l'ordonnée de la case libre ciblée sous forme d'entier entre 0 et ";

    private String errorInteger = "RENSEIGNEZ UN ENTIER!";

    private String errorOutOfBounds = "ON A DIT ENTRE 0 ET ";
    private String winMessage = "Bien joué vous avez gagné Player";
    private String drawMessage = "Match Nul! ";

    private String notEmptyMessage = "Cette case est déjà prise! Rejouez mais pas en ";

    private String whichGame = "A quel jeu voulez vous jouer? Entrez 0 pour le Morpions, 1 pour le Gomoku et enfin 2 pour le Puissance 4";
    private String howManyComputers = "Combien de joueurs controlés par l'ordinateur voulez vous? ";

    private String whichPosition = "Quel joueur voulez vous être? Entrez 1 pour être le Joueur 1 ou 2 pour être le Joueur 2";

    /**
     *  These functions display texts
     *
     * @param s
     */
    public void display(String s){
        System.out.println(s);
    }

    public void instructionXAxis(int xAxisMaxSize){
        System.out.println((this.instructionXAxis + xAxisMaxSize));
    }

    public void instructionYAxis(int yAxisMaxSize){
        System.out.println(this.instructionYAxis + yAxisMaxSize);;
    }
    public void errorInteger(){
        System.out.println(errorInteger);
    }

    public void errorOutOfBounds(int tailleMax){
        System.out.println(errorOutOfBounds + tailleMax + "!!!");
    }

    public void winMessage(PlayerModel currentPlayer){
        System.out.println(this.winMessage + currentPlayer.getIdentity());
    }
    public void drawMessage(){
        System.out.println(this.drawMessage);
    }
    public void notEmptyMessage(int abscisse, int ordonnee){
        System.out.println(this.notEmptyMessage + abscisse + " | " + ordonnee);
    }
    public void whichGame(){
        System.out.println(this.whichGame);
    }
    public void howManyComputers(){
        System.out.println(this.howManyComputers);
    }
    public void whichPosition(){
        System.out.println(this.whichPosition);
    }
}
