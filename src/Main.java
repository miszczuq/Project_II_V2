import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //SwingUtilities.invokeLater(()-> { new MenuWindow();});
        GameModel gm = new GameModel();
        MenuWindow mw = new MenuWindow();
        GameWindow gw = new GameWindow();
        ScoreWindow sw = new ScoreWindow();
        GameControler gc = new GameControler(gm,mw,gw, sw);
    }
}
