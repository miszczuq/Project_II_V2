import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

public class MenuWindow extends JFrame {
    Color backgroundColor = new Color(255, 209, 26);
    //private GameWindow gameWindow;
    ClickableLabel newGame;
    ClickableLabel highScores;
    ClickableLabel exit;
    public MenuWindow(){
        setLayout(null);
        getContentPane().setBackground(backgroundColor);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));
        buttons.setBackground(backgroundColor);

         exit = new ClickableLabel("Exit",backgroundColor);
         newGame = new ClickableLabel("New Game",backgroundColor);
         highScores = new ClickableLabel("High Scores",backgroundColor);

         //MOUSE NEW GAME LSITENER

       /* newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Object[] level = {"easy","medium","hard"};
                String s = (String)JOptionPane.showInputDialog(MenuWindow.this, "Difficult: ","Choice difficult",JOptionPane.QUESTION_MESSAGE,null,level,level[0]);

                //DIFFICULTY LEVEL
                if(s != null && s.length() > 0) {
                    switch (s) {
                        case "easy":
                            System.out.println("easy");
                            Country.setDifficulty(2);
                             new GameWindow();
                            break;
                        case "medium":
                            System.out.println("medium");
                            Country.setDifficulty(3);
                            new GameWindow();
                            break;
                        case "hard":
                            System.out.println("hard");
                            Country.setDifficulty(4);
                            new GameWindow().showWindow();
                            break;
                    }
                    dispose();
                }
            }
        });*/

        /*highScores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });*/

        buttons.add(newGame);
        buttons.add(highScores);
        buttons.add(exit);
        buttons.setBounds(100,100,300,250);
        add(buttons);

        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void addStartGameListener(MouseListener mouseListener){
        newGame.addMouseListener(mouseListener);
    }

    void addScoreButtonListener(MouseListener mouseListener){
        highScores.addMouseListener(mouseListener);
    }

    void addExitButtonListener(MouseListener mouseListener){
        exit.addMouseListener(mouseListener);
    }
}
