import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreWindow extends JFrame {
    private JButton back;

    public ScoreWindow(){
        setLayout(new BorderLayout());

        JList<String> list = new JList<>(ScoreFileManager.getScoreList());
        add(new JScrollPane(list),BorderLayout.CENTER);

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jp,BorderLayout.PAGE_END);

        back = new JButton("back");
        /*back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWindow();
                ScoreWindow.this.dispose();
            }
        });*/
        jp.add(back);



        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
    }
    public void addBackButtonListener(ActionListener actionListener){
        back.addActionListener(actionListener);
    }
}
