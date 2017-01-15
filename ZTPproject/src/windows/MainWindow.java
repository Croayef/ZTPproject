package windows;

import POJO.Nosnik;
import POJO.Gatunek;
import POJO.Rezyser;
import Proxy.FilmProxy;
import Proxy.GatunekProxy;
import Proxy.NosnikProxy;
import Proxy.RezyserProxy;
import displayers.FilmBasic;
import displayers.FilmDisplayer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.WindowFactory;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class MainWindow extends JFrame {

    private static int view = 0;
    JPanel cards;
    final static String FIRSTCARD = "Card1";
    final static String SECONDCARD = "Card2";
    final static String SHOW_MOVIE = "SHOW_MOVIE";
    final static String ADD_MOVIE = "ADD_MOVIE";
    final static String REMOVE_MOVIE = "REMOVE_MOVIE";
    
    private FilmProxy filmy;
    private RezyserProxy rezyser;
    private FilmDisplayer movieDisplayer;
    private NosnikProxy nosniki;
    private GatunekProxy gatunki;
    private WindowFactory windowFactory;
    private SessionFactory databaseUtil = HibernateUtil.getSessionFactory();
    CustomWindowInterface window;

    public MainWindow() {
        prepareMenuBar();
        prepareComponents();
    }

    public MainWindow(FilmProxy filmy, RezyserProxy rezyser, FilmDisplayer movieDisplayer, NosnikProxy nosniki, GatunekProxy gatunki, WindowFactory windowFactory) {
        this.filmy = filmy;
        this.rezyser = rezyser;
        this.movieDisplayer = movieDisplayer;
        this.nosniki = nosniki;
        this.gatunki = gatunki;
        this.windowFactory = windowFactory;

        prepareMenuBar();
        prepareComponents();

    }

    private void prepareMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu transakcje = new JMenu("Transakcje");
        transakcje.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onTransakcjeClicked(evt);
            }
        });

        JMenu administracja = new JMenu("Administracja");
        JMenu admFilm = new JMenu("Film");
        JMenuItem admFilmDodaj = new JMenuItem("Dodaj Film");
        admFilmDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDodajFilmClicked(e);
            }
        });
        JMenuItem admFilmUsun = new JMenuItem("Usuń Film");
        admFilmUsun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onUsunFilmClicked(e);
            }
        });
        admFilm.add(admFilmDodaj);
        admFilm.add(admFilmUsun);
        administracja.add(admFilm);

        JMenu admGatunek = new JMenu("Gatunek");
        JMenuItem admGatunekDodaj = new JMenuItem("Dodaj Gatunek");
        admGatunekDodaj.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onDodajGatunekClicked(evt);
            }
        });
        JMenuItem admGatunekUsun = new JMenuItem("Usuń Gatunek");
        admGatunekUsun.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onUsunGatunekClicked(evt);
            }
        });
        admGatunek.add(admGatunekDodaj);
        admGatunek.add(admGatunekUsun);
        administracja.add(admGatunek);

        JMenu bazaFilmow = new JMenu("Baza Filmów");
        bazaFilmow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onBazaFilmowClicked(evt);
            }
        });

        JMenu wyloguj = new JMenu("Wyloguj");
        wyloguj.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onWylogujClicked(evt);
            }
        });

        menuBar.add(transakcje);
        menuBar.add(administracja);
        menuBar.add(bazaFilmow);
        menuBar.add(wyloguj);
        this.setJMenuBar(menuBar);
    }

    private void onTransakcjeClicked(MouseEvent e) {
        // zmiana widoku na TransactionWindow
    }

    private void onDodajFilmClicked(ActionEvent e) {
        // zmiana widoku na AddMovieWindow
        ((CardLayout) cards.getLayout()).show(cards, ADD_MOVIE);
        showAddMovieWindow();
        
    }
    
    public void showAddMovieWindow() {
        window = windowFactory.getWindow("ADD_MOVIE");
        // wypełnienie listy nosników, reżyserów i gatunków do wyboru
        JComboBox carriers = ((AddMovieWindow) window).getCarriers();
        JComboBox directors = ((AddMovieWindow) window).getDirectors();
        JList genres = ((AddMovieWindow) window).getGenreList();
        
        carriers.removeAllItems();
        for (Nosnik n : nosniki.getEachNosnik(databaseUtil)) {
            carriers.addItem(n.getTyp());
        }
        
        directors.removeAllItems();
        for (Rezyser r : rezyser.getEachRezyser(databaseUtil)) {
            directors.addItem(r.getImie() + " " + r.getNazwisko());
        }
        
        genres.removeAll();
        DefaultListModel listModel = new DefaultListModel();
        listModel.removeAllElements();
        for (Gatunek g : gatunki.getEachGatunek(databaseUtil)) {
            listModel.addElement(g.getIdGatunku() + ". " + g.getNazwa());
        }
        genres.setModel(listModel);

    }
    
    private void onUsunFilmClicked(ActionEvent e) {
        // zmiana widoku na RemoveMovieWindow
    }

    private void onDodajGatunekClicked(MouseEvent e) {
        // zmiana widoku na AddGenreWIndow
    }

    private void onUsunGatunekClicked(MouseEvent e) {
        // zmiana widoku na RemoveGenreWindow
    }

    private void onBazaFilmowClicked(MouseEvent e) {
        // zmiana widoku na ShowMovieWindow

        //to tylko w ramach testu:
        view = 1;
        showMovieWindow();
        ((CardLayout) cards.getLayout()).show(cards, SHOW_MOVIE);
    }

    private void onWylogujClicked(MouseEvent e) {
        // wylogowanie i zmiana widoku na LoginWindow
    }

    private void prepareComponents() {
        JPanel mainPane = new JPanel();
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

        mainPane.add(changeButton);

        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        CustomWindowInterface card;
        cards = new JPanel(new CardLayout());
        cards.add(card1, FIRSTCARD);
        card =  windowFactory.getWindow("SHOW_MOVIE");
        ((ShowMovieWindow)card).getShowMovieButton().addActionListener((ActionEvent e) -> {
            onZamowButtonClicked();
        });
        cards.add((JPanel)card, SHOW_MOVIE);
        card = windowFactory.getWindow("ADD_MOVIE");
        ((AddMovieWindow)card).getAddMovieButton().addActionListener((ActionEvent e) -> {
            onDodajFilmButtonClicked();
        });
        cards.add((JPanel)card, ADD_MOVIE);
        card = windowFactory.getWindow("REMOVE_MOVIE");
        ((RemoveMovieWindow)card).getRemoveMovieButton().addActionListener((ActionEvent e) -> {
            onUsunFilmButtonClicked();
        });
        cards.add((JPanel)card, REMOVE_MOVIE);

        this.add(mainPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
    }
    
    public void onZamowButtonClicked() {
        
        //Zamow film
        
    }
    
    public void onDodajFilmButtonClicked() {
        
        //Dodaj film
        
    }
    
    public void onUsunFilmButtonClicked() {
        
        //Dodaj film
        
    }
    
    
    public void showMovieWindow() {
        window = windowFactory.getWindow("SHOW_MOVIE");
        // wypelnienie tabeli filmow
        // movieDisplayer.showFilmy(window.getTable(), filmy.getEachFilm(databaseUtil), rezyser.getEachRezyser(databaseUtil), nosniki.getEachNosnik(databaseUtil), gatunki.getEachGatunek(databaseUtil), null);
    }

    

    public void showRemoveMovieWindow() {
        window = windowFactory.getWindow("REMOVE_MOVIE");
        // wypełnienie listy nosników, reżyserów i gatunków do wyboru
    }

    public void showAddGenreWindow() {

    }

    public void showRemoveGenreWindow() {
        window = windowFactory.getWindow("REMOVE_GENRE");
        // wypelnienie listy gatunkow do wyboru
    }

    public void showTransactionWindow() {
        window = windowFactory.getWindow("TRANSACTION");
        // wypelnienie listy transakcji
    }

    
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(
                new FilmProxy(), new RezyserProxy(),
                new FilmBasic(), new NosnikProxy(),
                new GatunekProxy(), new WindowFactory()
        );
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
