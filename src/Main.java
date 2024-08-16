import classes.Game;
import classes.Panel;
import classes.Player;

import java.util.Scanner;

/**
 * TIC-TAC-TOE/TRES EN RAYA
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Java game TIK-TAK-TOE");
        Scanner scanner = new Scanner(System.in);

        //Create the players
        Player player = new Player();

        //Instance the Panel class
        Panel panelClass = new Panel();
        String[][] panel = panelClass.setInitialPanel();
        panelClass.showPanel(panel);

        //Instance the Game class
        Game game = new Game(player);
        while (true){
            try {
                game.gameOver(panel);
                if (game.winner != 0){
                    System.out.println("Player " + (game.winner == 1 ? "1 wins" : "2 wins"));
                    break;
                } else if (game.isTie){
                    System.out.println("Its a tie");
                }
                game.updatePanel(scanner, panel, player);
                panelClass.showPanel(panel);
                player.isPlayerOne = !player.isPlayerOne;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}