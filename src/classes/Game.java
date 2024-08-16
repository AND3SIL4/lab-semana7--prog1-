
package classes;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Game {

    Player player;
    public int winner;
    public boolean isTie;

    public Game(Player player) {
        this.player = player;
    }

    public void updatePanel(Scanner scanner, String[][] panel, Player player) throws Exception {
        System.out.print("Row: ");
        int row = scanner.nextInt();
        System.out.print("Col: ");
        int col = scanner.nextInt();

        if (row > panel.length - 1 || col > panel[0].length - 1 || row < 0 || col < 0) {
            throw new Exception("The position is not valid");
        }

        if (panel[row][col].equals("[ ]")) {
            panel[row][col] = player.isPlayerOne ? "[X]" : "[O]";
        } else {
            System.out.println("Position (" + row + "," + col + ") is already full");
            player.isPlayerOne = !player.isPlayerOne;
        }
    }

    public void gameOver(String[][] panel) {
        // Verificar filas y columnas para un ganador
        for (int i = 0; i < 3; i++) {
            // Verificar fila i
            if (panel[i][0].equals(panel[i][1]) && panel[i][1].equals(panel[i][2]) && !panel[i][0].equals("[ ]")) {
                this.winner = panel[i][0].equals("[X]") ? 1 : 2;
                return;
            }
            // Verificar columna i
            if (panel[0][i].equals(panel[1][i]) && panel[1][i].equals(panel[2][i]) && !panel[0][i].equals("[ ]")) {
                this.winner = panel[0][i].equals("[X]") ? 1 : 2;
                return;
            }
        }

        // Verificar diagonales para un ganador
        if (panel[0][0].equals(panel[1][1]) && panel[1][1].equals(panel[2][2]) && !panel[0][0].equals("[ ]")) {
            this.winner = panel[0][0].equals("[X]") ? 1 : 2;
            return;
        }
        if (panel[0][2].equals(panel[1][1]) && panel[1][1].equals(panel[2][0]) && !panel[0][2].equals("[ ]")) {
            this.winner = panel[0][2].equals("[X]") ? 1 : 2;
            return;
        }

        // Verificar si el tablero está lleno (para un empate)
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (panel[i][j].equals("[ ]")) {
                    full = false;  // Si se encuentra una celda vacía, el tablero no está lleno
                    break;
                }
            }
            if (!full) break;  // Romper el bucle exterior si ya sabemos que no está lleno
        }
        if (full && this.winner == 0) {
            this.isTie = true;
        }
    }
}
