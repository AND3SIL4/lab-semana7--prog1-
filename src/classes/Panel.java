package classes;

public class Panel {
    final int width = 3;
    final int height = 3;

    public String[][] setInitialPanel(){
        String[][] panel = new String[this.width][this.height];
        for (int row = 0; row < panel.length ; row++) {
            for (int col = 0; col < panel[row].length ; col++) {
                panel[row][col] = "[ ]";
            }
        }
        return panel;
    }

    public void showPanel(String[][] panel){
        for(String[] row: panel){
            for(String col: row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
