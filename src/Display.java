public class Display {
    //TODO Faire en sorte que la view gère toutes les interactions avec l'utilisateur (scanner) mais pas la logique.
    private String instructionAbscisse = "Entrez l'abscisse de la case libre ciblée sous forme d'entier entre 0 et ";

    private String instructionOrdonnee = "Entrez l'ordonnée de la case libre ciblée sous forme d'entier entre 0 et ";

    private String errorEntier = "RENSEIGNEZ UN ENTIER!";

    private String errorOutOfBounds = "ON A DIT ENTRE ET ";
    private String winMessage = "Bien joué vous avez gagné! ";
    private String drawMessage = "Match Nul! ";

    private String notEmptyMessage = "Cette case est déjà prise! Rejouez";

    private String whichGame = "A quel jeu voulez vous jouer? Entrez 1 pour le Morpions, 2 pour le Gomoku et enfin 3 pour le Puissance 4";
    private String whichPosition = "Quel joueur voulez vous être? Entrez 1 pour être le Joueur 1 ou 2 pour être le Joueur 2";
    private String whichOpponent = "Si vous voulez que votre adversaire soit l'ordinateur entrez Y";

    public void display(String s){
        System.out.println(s);
    }

    public String getInstructionAbscisse(){
        return this.instructionAbscisse;
    }
    public String getInstructionOrdonnee(){
        return this.instructionOrdonnee;
    }
    public String getErrorEntier(){
        return this.errorEntier;
    }
    public String getErrorOutOfBounds(){
        return this.errorOutOfBounds;
    }
    public String getWinMessage(){
        return this.winMessage;
    }
    public String getDrawMessage(){
        return this.drawMessage;
    }
    public String getNotEmptyMessage(){
        return this.notEmptyMessage;
    }
    public  String getWhichGame(){
        return this.whichGame;
    }
    public  String getWhichPosition(){
        return this.whichPosition;
    }
    public  String getWhichOpponent(){
        return this.whichOpponent;
    }
}
