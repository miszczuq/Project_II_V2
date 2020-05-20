import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

public class GameControler extends Thread {
    private GameWindow gameWindow;
    private MenuWindow menuWindow;
    private GameModel gameModel;
    private ScoreWindow scoreWindow;

    public GameControler(GameModel gameModel,MenuWindow menuWindow, GameWindow gameWindow, ScoreWindow scoreWindow){
        this.gameModel = gameModel;
        this.menuWindow = menuWindow;
        this.gameWindow = gameWindow;
        this.scoreWindow = scoreWindow;
        start();
        menuWindow.setVisible(true);

        this.menuWindow.addStartGameListener(new StartGameListener());
        this.menuWindow.addScoreButtonListener(new ScoreButtonListener());
        this.menuWindow.addExitButtonListener(new ExitButtonListener());

    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameModel.fireEvent(new EventObject(this));

            gameWindow.getDayTimer().setText("Day: "+gameModel.getDay());
            gameWindow.getPointsLabel().setText("Points: "+Points.getPoints());

            gameModel.increaseDay();
        }
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
                gameWindow = new GameWindow();
                gameWindow.addCountryButton(gameModel.getWorld());
                menuWindow.addStartGameListener(new StartGameListener());

                gameWindow.setVisible(true);
                menuWindow.setVisible(false);
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



