import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

public class GameControler {
    private GameWindow gameWindow;
    private MenuWindow menuWindow;
    private GameModel gameModel;
    private ScoreWindow scoreWindow;
    private StartGameListener startGameListener = new StartGameListener();
    private Thread thread ;

    public GameControler(GameModel gameModel,MenuWindow menuWindow, GameWindow gameWindow, ScoreWindow scoreWindow){
        this.gameModel = gameModel;
        this.menuWindow = menuWindow;
        this.gameWindow = gameWindow;
        this.scoreWindow = scoreWindow;
        this.thread = new Thread(gameWindow);

        menuWindow.setVisible(true);

        this.menuWindow.addStartGameListener(startGameListener);
        this.menuWindow.addScoreButtonListener(new ScoreButtonListener());
        this.menuWindow.addExitButtonListener(new ExitButtonListener());

    }


    public void gameStatusChange() {
        String s = (String)JOptionPane.showInputDialog(gameWindow, "Type your name: ","Anonymous"); //Wprowadzanie nicku
        if(s != null) {
            ScoreFileManager.addScore(s);
            menuWindow.setVisible(true);
            gameWindow.dispose();

            gameModel.setDay(0);
            GameModel.setPoints(0);

            thread.interrupt();
        }
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    class StartGameListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            Object[] level = {"easy","medium","hard"};
            String s = (String) JOptionPane.showInputDialog(null, "Difficult: ","Choice difficult",JOptionPane.QUESTION_MESSAGE,null,level,level[0]);

            //DIFFICULTY LEVEL
            if(s != null && s.length() > 0) {
                switch (s) {
                    case "easy":
                        Country.setDifficulty(2);
                        break;
                    case "medium":
                        Country.setDifficulty(3);
                        break;
                    case "hard":
                        Country.setDifficulty(4);
                        break;
                }
                menuWindow.removeStartGameListener(startGameListener);
                gameWindow = new GameWindow();
                gameWindow.setGameControler(GameControler.this);
                gameWindow.addCountryButton(gameModel.getWorld());

                startGameListener = new StartGameListener();
                menuWindow.addStartGameListener(startGameListener);

                gameWindow.setVisible(true);
                menuWindow.setVisible(false);

                thread = new Thread(gameWindow);
                thread.start();
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    class ScoreButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            scoreWindow = new ScoreWindow();
            scoreWindow.addBackButtonListener(new BackButtonListener());

            scoreWindow.setVisible(true);
            menuWindow.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    class ExitButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.exit(0);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    class BackButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            menuWindow.setVisible(true);
            scoreWindow.dispose();
        }
    }
}



