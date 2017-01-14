package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    private static int view = 0;
    JPanel cards;
    private RemoveMovieWindow window= RemoveMovieWindow.getInstance();
    final static String FIRSTCARD = "Card1";
    final static String SECONDCARD = "Card2";

    public void addComponentToPane(Container pane) {
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        JButton changeButton = new JButton("Change View");
        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                if (view == 0) {
                    view = 1;
                    cl.show(cards, SECONDCARD);
                } else {
                    view = 0;
                    cl.show(cards, FIRSTCARD);
                }
            }
        });

        comboBoxPane.add(changeButton);

        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
 JPanel card3 = window;
 card3.revalidate();
        cards = new JPanel(new CardLayout());
        cards.add(card1, FIRSTCARD);
        cards.add(card3, SECONDCARD);
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindow demo = new MainWindow();
        demo.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
