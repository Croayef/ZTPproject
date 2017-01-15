package windows;

import POJO.Nosnik;
import POJO.Gatunek;
import POJO.Klient;
import POJO.Pracownik;
import POJO.Rezyser;
import POJO.Transakcja;
import Proxy.FilmProxy;
import Proxy.GatunekProxy;
import Proxy.KlientProxy;
import Proxy.NosnikProxy;
import Proxy.PracownikProxy;
import Proxy.RezyserProxy;
import Proxy.TransakcjaProxy;
import displayers.FilmBasic;
import displayers.FilmDisplayer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.WindowFactory;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private int user = 0;
    private int role = -1; // 0 -admin, 1- user, 2- pracownik
    JPanel cards;
    final static String FIRSTCARD = "Card1";
    final static String SHOW_MOVIE = "SHOW_MOVIE";
    final static String ADD_MOVIE = "ADD_MOVIE";
    final static String REMOVE_MOVIE = "REMOVE_MOVIE";
    final static String RETURN_MOVIE = "RETURN_MOVIE";
    final static String TRANSACTION = "TRANSACTION";
    final static String LOGIN = "LOGIN";
    final static String ADD_GENRE = "ADD_GENRE";
    final static String REMOVE_GENRE = "REMOVE_GENRE";
    final static String WELCOME = "WELCOME";

    private FilmProxy filmy;
    private RezyserProxy rezyser;
    private FilmDisplayer movieDisplayer;
    private NosnikProxy nosniki;
    private GatunekProxy gatunki;
    private TransakcjaProxy transakcje;
    private KlientProxy klienci;
    private PracownikProxy pracownicy;
    private WindowFactory windowFactory;
    private SessionFactory databaseUtil = HibernateUtil.getSessionFactory();
    CustomWindowInterface window;

    public MainWindow() {
        this.filmy = new FilmProxy();
        this.rezyser = new RezyserProxy();
        this.movieDisplayer = new FilmBasic();
        this.nosniki = new NosnikProxy();
        this.gatunki = new GatunekProxy();
        this.transakcje = new TransakcjaProxy();
        this.klienci = new KlientProxy();
        this.pracownicy = new PracownikProxy();
        this.windowFactory = new WindowFactory();
        prepareMenuBar();
        prepareComponents();
    }

    public MainWindow(FilmDisplayer movieDisplayer) {
        this.movieDisplayer = movieDisplayer;
        this.filmy = new FilmProxy();
        this.rezyser = new RezyserProxy();
        this.movieDisplayer = new FilmBasic();
        this.nosniki = new NosnikProxy();
        this.gatunki = new GatunekProxy();
        this.transakcje = new TransakcjaProxy();
        this.klienci = new KlientProxy();
        this.pracownicy = new PracownikProxy();
        this.windowFactory = new WindowFactory();
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
        admGatunekDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onDodajGatunekClicked(evt);
            }
        });
        JMenuItem admGatunekUsun = new JMenuItem("Usuń Gatunek");
        admGatunekUsun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
        showTransactionWindow();
        ((CardLayout) cards.getLayout()).show(cards, TRANSACTION);
    }

    public void showTransactionWindow() {
        window = windowFactory.getWindow("TRANSACTION");
        // wypelnienie listy transakcji
        ((TransactionWindow) window).getOutcomeLabel().setVisible(false);

        JTable transactions = window.getTable();
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector<>();
        tableHeaders.add("Id");
        tableHeaders.add("Id Klienta");
        tableHeaders.add("Tytuł Filmu");
        tableHeaders.add("Data Transakcji");
        tableHeaders.add("Typ Transakcji");

        for (Transakcja t : transakcje.getEachTransakcja(databaseUtil)) {

            Vector<Object> oneRow = new Vector<>();
            oneRow.add(t.getIdTransakcji());
            oneRow.add(t.getIdKlienta());
            oneRow.add(filmy.getFilm(t.getIdFilmu(), databaseUtil).getTytul());
            oneRow.add(t.getDataTransakcji());
            if (t.getTyp().equals("WYP")) {
                oneRow.add("Wypożyczenie");
            } else {
                oneRow.add("Zwrot");
            }

            tableData.add(oneRow);
        }
        transactions.setModel(new DefaultTableModel(tableData, tableHeaders) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        });

        transactions.removeColumn(transactions.getColumnModel().getColumn(0));

    }

    private void onDodajFilmClicked(ActionEvent e) {
        // zmiana widoku na AddMovieWindow
        showAddMovieWindow();
        ((CardLayout) cards.getLayout()).show(cards, ADD_MOVIE);
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
        showRemoveMovieWindow();
        ((CardLayout) cards.getLayout()).show(cards, REMOVE_MOVIE);
    }

    public void showRemoveMovieWindow() {
        window = windowFactory.getWindow("REMOVE_MOVIE");
        movieDisplayer.showFilmy(window.getTable(), filmy.getEachFilm(databaseUtil), rezyser.getEachRezyser(databaseUtil), nosniki.getEachNosnik(databaseUtil), gatunki.getEachGatunek(databaseUtil), null);

    }

    private void onDodajGatunekClicked(ActionEvent e) {
        // zmiana widoku na AddGenreWIndow
        System.out.println("windows.MainWindow.onDodajGatunekClicked()");
        ((CardLayout) cards.getLayout()).show(cards, ADD_GENRE);
    }

    private void onUsunGatunekClicked(ActionEvent e) {
        // zmiana widoku na RemoveGenreWindow
        System.out.println("windows.MainWindow.onUsunGatunekClicked()");
        showRemoveGenreWindow();
        ((CardLayout) cards.getLayout()).show(cards, REMOVE_GENRE);
    }

    public void showRemoveGenreWindow() {
        window = windowFactory.getWindow("REMOVE_GENRE");
        JTable genres = ((RemoveGenreWindow) window).getRemoveGenreTable();
        genres.removeAll();
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector<>();
        tableHeaders.add("Id");
        tableHeaders.add("Nazwa Gatunku");
        for (Gatunek g : gatunki.getEachGatunek(databaseUtil)) {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(g.getIdGatunku());
            oneRow.add(g.getNazwa());
            tableData.add(oneRow);
        }
        genres.setModel(new DefaultTableModel(tableData, tableHeaders) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        });

        genres.removeColumn(genres.getColumnModel().getColumn(0));

    }

    private void onBazaFilmowClicked(MouseEvent e) {
        // zmiana widoku na ShowMovieWindow
        showMovieWindow();
        ((CardLayout) cards.getLayout()).show(cards, SHOW_MOVIE);
    }

    public void showMovieWindow() {
        window = windowFactory.getWindow("SHOW_MOVIE");
        // wypelnienie tabeli filmow
        movieDisplayer.showFilmy(window.getTable(), filmy.getEachFilm(databaseUtil), rezyser.getEachRezyser(databaseUtil), nosniki.getEachNosnik(databaseUtil), gatunki.getEachGatunek(databaseUtil), null);
    }

    private void onWylogujClicked(MouseEvent e) {
        // wylogowanie i zmiana widoku na LoginWindow
        windowFactory.getWindow("LOGIN").clear();
        this.user = 0;
        this.role = -1;
        ((CardLayout) cards.getLayout()).show(cards, LOGIN);
    }

    private void prepareComponents() {
        CustomWindowInterface card;
        cards = new JPanel(new CardLayout());

        card = windowFactory.getWindow(LOGIN);
        ((LoginWindow) card).getLoginButton().addActionListener((ActionEvent e) -> {
            onZalogujButtonClicked();
        });
        cards.add((JPanel) card, LOGIN);

        card = windowFactory.getWindow(WELCOME);
        cards.add((JPanel)card, WELCOME);
        
        card = windowFactory.getWindow(SHOW_MOVIE);
        ((ShowMovieWindow) card).getShowMovieButton().addActionListener((ActionEvent e) -> {
            onZamowButtonClicked();
        });
        cards.add((JPanel) card, SHOW_MOVIE);

        card = windowFactory.getWindow(ADD_MOVIE);
        ((AddMovieWindow) card).getAddMovieButton().addActionListener((ActionEvent e) -> {
            onDodajFilmButtonClicked();
        });
        cards.add((JPanel) card, ADD_MOVIE);

        card = windowFactory.getWindow(REMOVE_MOVIE);
        ((RemoveMovieWindow) card).getRemoveMovieButton().addActionListener((ActionEvent e) -> {
            onUsunFilmButtonClicked();
        });
        cards.add((JPanel) card, REMOVE_MOVIE);

        card = windowFactory.getWindow(RETURN_MOVIE);
        ((ReturnsMovieWindow) card).getReturnsMovieButton().addActionListener((ActionEvent e) -> {
            onZwrocFilmButtonClicked();
        });
        cards.add((JPanel) card, RETURN_MOVIE);

        card = windowFactory.getWindow(ADD_GENRE);
        ((AddGenreWindow) card).getAddGenreButton().addActionListener((ActionEvent e) -> {
            onDodajGatunekButtonClicked();
        });
        cards.add((JPanel) card, ADD_GENRE);

        card = windowFactory.getWindow(REMOVE_GENRE);
        ((RemoveGenreWindow) card).getRemoveGenreButton().addActionListener((ActionEvent e) -> {
            onUsunGatunekButtonClicked();
        });
        cards.add((JPanel) card, REMOVE_GENRE);

        card = windowFactory.getWindow(TRANSACTION);
        ((TransactionWindow) card).getRejectTransactionButton().addActionListener((ActionEvent e) -> {
            onOdrzucTransakcjeButtonClicked();
        });
        ((TransactionWindow) card).getApproveTransactionButton().addActionListener((ActionEvent e) -> {
            onZatwierdzTransakcjeButtonClicked();
        });
        cards.add((JPanel) card, TRANSACTION);

        this.add(cards, BorderLayout.CENTER);
    }

    public void onZalogujButtonClicked() {

        //Zaloguj
        window = windowFactory.getWindow(LOGIN);
        String pass = new String(((LoginWindow) window).getPasswordField().getPassword());
        String login = ((LoginWindow) window).getLoginField().getText();
        ((LoginWindow) window).getErrorField().setVisible(false);
        if (!login.trim().equals("") && pass.length() > 0) {

            for (Klient k : klienci.getEachKlient(databaseUtil)) {
                if (k.getHaslo().equals(pass) && k.getLogin().equals(login)) {
                    this.user = k.getIdKlienta();
                    this.role = 1;
                    break;
                }
            }
            if (this.role < 0) {
                for (Pracownik p : pracownicy.getEachPracownik(databaseUtil)) {
                    if (p.getLogin().equals(login) && p.getHaslo().equals(pass)) {
                        this.user = p.getIdPracownika();
                        if (p.getIdStanowiska() == 1) {
                            this.role = 0;
                        } else {
                            this.role = 2;
                        }
                        break;
                    }
                }
            }
            if (this.role < 0) {
                ((LoginWindow) window).getErrorField().setVisible(true);
            } else {
                ((CardLayout) cards.getLayout()).show(cards, WELCOME);
            }
        } else {
            ((LoginWindow) window).getErrorField().setVisible(true);
        }
    }

    public void onZamowButtonClicked() {

        //Zamow film
    }

    public void onDodajFilmButtonClicked() {

        //Dodaj film
    }

    public void onUsunFilmButtonClicked() {

        //Usun film
    }

    public void onZwrocFilmButtonClicked() {

        //Zwroc film
    }

    public void onDodajGatunekButtonClicked() {

        //Dodaj gatunek
    }

    public void onUsunGatunekButtonClicked() {

        //Usun gatunek
    }

    public void onOdrzucTransakcjeButtonClicked() {

        //Odrzuc Transakcje
    }

    public void onZatwierdzTransakcjeButtonClicked() {

        //Zatwierdz Transakcje
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
