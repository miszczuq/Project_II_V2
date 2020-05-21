import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import static java.lang.Thread.sleep;

public class GameWindow extends JFrame implements Runnable  {
    private JPanel screen;
    private JLabel dayTimer;
    private JLabel pointsLabel;
    private GameControler gameControler;

    public GameWindow(){
        final int WAOFC= JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        Font myFont = new Font("Arial",Font.BOLD,34);
        setLayout(new BorderLayout());

        JPanel topBar = new JPanel();
        add(topBar,BorderLayout.PAGE_START);

        dayTimer = new JLabel("Day: 1");
        dayTimer.setFont(myFont);
        topBar.add(dayTimer);

        pointsLabel = new JLabel("Points: 0");
        pointsLabel.setFont(myFont);
        topBar.add(pointsLabel);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel mods = new JPanel();
        mods.setLayout(new GridLayout(4,1));

        for(int i = 1 ; i <= 4 ; i++){
            mods.add(new JButton(i+ "przycisk"));
        }
        contentPane.add(mods,BorderLayout.LINE_END);

        //Mapa IMAGE
        screen = new JPanel(){
            ImageIcon worldMap = new ImageIcon("worldMap.jpg");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(worldMap.getImage(),0,0,1150,800,this);
            }
        };
        screen.setLayout(null);

        JLabel map = new JLabel();
        screen.add(map);
        contentPane.add(screen, BorderLayout.CENTER);

        contentPane.getInputMap(WAOFC).put(KeyStroke.getKeyStroke("control shift Q"),"press scq");
        contentPane.getActionMap().put("press scq", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameControler.gameStatusChange();
            }
        });

        add(contentPane,BorderLayout.CENTER);


        setTitle("Anti Plague Inc.");
        setResizable(false);
        setSize(1250,820);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addCountryButton(java.util.List<Country> list) {
        for(Country c : list) {
            CountryNameButton button = new CountryNameButton(c.getName(), 13);
            button.setBounds(c.getX(), c.getY(), c.getName().length()*12, 20);
            screen.add(button);
        }
    }

    public JLabel getPointsLabel() {
        return pointsLabel;
    }

    public JLabel getDayTimer() {
        return dayTimer;
    }

    public void setGameControler(GameControler gameControler) {
        this.gameControler = gameControler;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            gameControler.getGameModel().fireEvent(new EventObject(this));

            getDayTimer().setText("Day: "+gameControler.getGameModel().getDay());
            getPointsLabel().setText("Points: "+GameModel.getPoints());

            gameControler.getGameModel().increaseDay();
        }
    }
}
