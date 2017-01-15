package windows;

import POJO.Film;
import POJO.Nosnik;
import POJO.Gatunek;
import POJO.GatunekFilmId;
import POJO.Klient;
import POJO.Pracownik;
import POJO.Rezyser;
import POJO.Transakcja;
import POJO.GatunekFilm;
import Proxy.FilmProxy;
import Proxy.GatunekProxy;
import Proxy.GatunekFilmProxy;
import Proxy.KlientProxy;
import Proxy.NosnikProxy;
import Proxy.PracownikProxy;
import Proxy.RezyserProxy;
import Proxy.TransakcjaProxy;
import displayers.FilmBasic;
import displayers.FilmDisplayer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

public class MainWindow extends JFrame {

    private static MainWindow instance;

    private int user = 0;
    private static int role = -1; // 0 -admin, 1- user, 2- pracownik
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
    private GatunekFilmProxy gatunkiFilmy;
    private TransakcjaProxy transakcje;
    private KlientProxy klienci;
    private PracownikProxy pracownicy;
    private WindowFactory windowFactory;
    private SessionFactory databaseUtil = HibernateUtil.getSessionFactory();
    JMenuBar menuBar;
    JMenuItem showWypozyczone;
    CustomWindowInterface window;

    public MainWindow() {
        this.filmy = new FilmProxy();
        this.rezyser = new RezyserProxy();
        this.movieDisplayer = new FilmBasic();
        this.nosniki = new NosnikProxy();
        this.gatunki = new GatunekProxy();
        this.gatunkiFilmy = new GatunekFilmProxy();
        this.transakcje = new TransakcjaProxy();
        this.klienci = new KlientProxy();
        this.pracownicy = new PracownikProxy();
        this.windowFactory = new WindowFactory();
        this.gatunkiFilmy = new GatunekFilmProxy();
        instance = this;
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
        this.gatunkiFilmy = new GatunekFilmProxy();
        this.transakcje = new TransakcjaProxy();
        this.klienci = new KlientProxy();
        this.pracownicy = new PracownikProxy();
        this.windowFactory = new WindowFactory();
        instance = this;
        prepareMenuBar();
        prepareComponents();

    }

    private void prepareMenuBar() {
        menuBar = new JMenuBar();
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
                ((AddGenreWindow) windowFactory.getWindow(ADD_GENRE)).clear();
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
        JMenuItem showBazaFilmow = new JMenuItem("Przeglądaj");
        showBazaFilmow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBazaFilmowClicked(e);
            }
        });
        showWypozyczone = new JMenuItem("Zwróć Film");
        showWypozyczone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onZwrocFilmClicked(e);
            }
        });
        bazaFilmow.add(showBazaFilmow);
        bazaFilmow.add(showWypozyczone);
        

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
        menuBar.setVisible(false);
    }

    private void onTransakcjeClicked(MouseEvent e) {
        // zmiana widoku na TransactionWindow
        showTransactionWindow();
        ((CardLayout) cards.getLayout()).show(cards, TRANSACTION);
    }

    public void showTransactionWindow() {
        window = windowFactory.getWindow(TRANSACTION);
        // wypelnienie listy transakcji
        JTable transactions = window.getTable();
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector<>();
        tableHeaders.add("Id");
        tableHeaders.add("Id Klienta");
        tableHeaders.add("Tytuł Filmu");
        tableHeaders.add("Data Transakcji");
        tableHeaders.add("Typ Transakcji");

        try {
            List<Transakcja> trans = transakcje.getEachTransakcja(databaseUtil);
            for (Transakcja t : trans) {
                if (t.getIdPracownika() == null) {
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
            }
        } catch (HibernateException e) {
            e.printStackTrace();
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

    private void onBazaFilmowClicked(ActionEvent e) {
        // zmiana widoku na ShowMovieWindow
        showMovieWindow();
        ((CardLayout) cards.getLayout()).show(cards, SHOW_MOVIE);
    }

    public void showMovieWindow() {
        window = windowFactory.getWindow(SHOW_MOVIE);
        // wypelnienie tabeli filmow
        movieDisplayer.showFilmy(window.getTable(), filmy.getEachFilm(databaseUtil), rezyser.getEachRezyser(databaseUtil), nosniki.getEachNosnik(databaseUtil), gatunki.getEachGatunek(databaseUtil), null);
    }

    
    private void onZwrocFilmClicked(ActionEvent e) {
        
        window = windowFactory.getWindow(RETURN_MOVIE);
        
        
    }
    
    private void onWylogujClicked(MouseEvent e) {
        // wylogowanie i zmiana widoku na LoginWindow
        windowFactory.getWindow(LOGIN).clear();
        this.user = 0;
        this.role = -1;
        menuBar.setVisible(false);
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
        cards.add((JPanel) card, WELCOME);

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
        if (!login.trim().equals("") && pass.length() > 0) {

            for (Klient k : klienci.getEachKlient(databaseUtil)) {
                if (k.getHaslo().equals(pass) && k.getLogin().equals(login)) {
                    this.user = k.getIdKlienta();
                    this.role = 1;
                    this.showWypozyczone.setVisible(true);
                    break;
                }
            }
            if (this.role < 0) {
                this.showWypozyczone.setVisible(false);
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
                JOptionPane.showMessageDialog(this, "Bląd uwierzytelniania!");
            } else {
                ((CardLayout) cards.getLayout()).show(cards, WELCOME);
                menuBar.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bląd uwierzytelniania!");
        }

        ((JPanel) window).revalidate();
    }

    public void onZamowButtonClicked() {
        System.out.println("windows.MainWindow.onZamowButtonClicked()");
        //Zamow film
        window = windowFactory.getWindow(SHOW_MOVIE);
        JTable lista = ((ShowMovieWindow) window).getTable();

        if (lista.getSelectedRow() != -1) {
            if (lista.getValueAt(lista.getSelectedRow(), 4).toString().equalsIgnoreCase("Dostępny")) {
                try {
                    Transakcja t = new Transakcja();
                    t.setIdKlienta(user);
                    t.setIdFilmu(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()));
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    t.setDataTransakcji(date);
                    t.setTyp("WYP");
                    transakcje.addTransakcja(t, databaseUtil);
                    Film film = filmy.getFilm(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()), databaseUtil);
                    film.setIlosc(film.getIlosc() - 1);
                    filmy.editFilm(film, databaseUtil);
                    JOptionPane.showMessageDialog(this, "Zamówiono");
                } catch (HibernateException he) {
                    he.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Problem z zamówieniem!");
                } finally {

                }
            }
        }
    }

    public void onDodajFilmButtonClicked() {

        window = windowFactory.getWindow(ADD_MOVIE);
        String newMovieTitle = ((AddMovieWindow) window).getNewMovieName().getText();
        Short newMovieYear;
        Long newMovieQuant;
        try {
            newMovieYear = Short.parseShort(((AddMovieWindow) window).getNewMovieYear().getText());
            newMovieQuant = Long.parseLong(((AddMovieWindow) window).getNewMovieQuantity().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawne dane!");
            return;
        }
        JList newMovieGenre = ((AddMovieWindow) window).getGenreList();
        if (newMovieTitle.trim().equals("")
                || newMovieYear < 1895
                || newMovieYear > LocalDateTime.now().getYear()
                || newMovieQuant < 0
                || ((AddMovieWindow) window).getCarriers().getSelectedIndex() < 0
                || ((AddMovieWindow) window).getDirectors().getSelectedIndex() < 0
                || newMovieGenre.getSelectedIndices().length <= 0) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawne dane!");
        } else {

            Film newFilm = new Film();

            newFilm.setTytul(newMovieTitle);
            newFilm.setRokProdukcji(newMovieYear);
            newFilm.setIlosc(newMovieQuant);
            newFilm.setIdRezysera(((AddMovieWindow) window).getDirectors().getSelectedIndex() + 1);
            newFilm.setIdNosnika(((AddMovieWindow) window).getCarriers().getSelectedIndex() + 1);
            try {
                filmy.addFilm(newFilm, databaseUtil);
                ListModel model = newMovieGenre.getModel();
                int[] indexes = newMovieGenre.getSelectedIndices();
                GatunekFilm[] gatFilm = new GatunekFilm[newMovieGenre.getSelectedIndices().length];
                for (int i = 0; i < gatFilm.length; i++) {
                    gatunkiFilmy.addGatunekFilm(new GatunekFilm(new GatunekFilmId(Integer.parseInt(model.getElementAt(indexes[i]).toString().substring(0, model.getElementAt(indexes[i]).toString().indexOf("."))), newFilm.getIdFilmu())), databaseUtil);
                }

                JOptionPane.showMessageDialog(this, "Dodano film do bazy");
                window.clear();
            } catch (HibernateException he) {
                he.printStackTrace();

                JOptionPane.showMessageDialog(this, "Nie można dodać filmu!");

            }
        }
    }

    public void onUsunFilmButtonClicked() {
        window = windowFactory.getWindow(REMOVE_MOVIE);
        int abort = 0; 
        try {
            JTable lista = ((RemoveMovieWindow) window).getTable();
            int id = Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString());
            int tmp = role;
            role = 2;
            for (Transakcja t : transakcje.getEachTransakcja(databaseUtil)) {
                if (t.getIdFilmu() == id) {
                    abort = 1;
                    role = tmp;
                    break;
                }
            }
            role = tmp;

            for (GatunekFilm gf : gatunkiFilmy.getEachGatunekFilm(databaseUtil)) {
                if (gf.getId().getIdFilmu() == id && abort != 1) {
                    gatunkiFilmy.removeGatunekFilm(gf.getId(), databaseUtil);
                }
            }

            filmy.removeFilm(id, databaseUtil);
            JOptionPane.showMessageDialog(this, "Pomyślnie usunięto film");
        } catch (HibernateException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Nie można usunąć filmu!");
        }
        showRemoveMovieWindow();
    }

    public void onZwrocFilmButtonClicked() {

        //Zwroc film
        window = windowFactory.getWindow(RETURN_MOVIE);
        JTable lista = ((ShowMovieWindow) window).getTable();
        if (lista.getSelectedRow() != -1) {
            if (lista.getValueAt(lista.getSelectedRow(), 4).toString().equalsIgnoreCase("Dostępny")) {
                try {
                    Transakcja t = new Transakcja();
                    t.setIdKlienta(user);
                    t.setIdFilmu(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()));
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    t.setDataTransakcji(date);
                    t.setTyp("ZW");
                    transakcje.addTransakcja(t, databaseUtil);
                    Film film = filmy.getFilm(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()), databaseUtil);
                    film.setIlosc(film.getIlosc() + 1);
                    filmy.editFilm(film, databaseUtil);
                    JOptionPane.showMessageDialog(this, "Zwrócono film");
                } catch (HibernateException he) {
                    he.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Błąd zwrotu");
                } finally {

                }
            }
        }
    }

    public void onDodajGatunekButtonClicked() {

        window = windowFactory.getWindow(ADD_GENRE);

        if (((AddGenreWindow) window).getNewGenreNameTextField() != null) {
            Gatunek g = new Gatunek();
            g.setNazwa(((AddGenreWindow) window).getNewGenreNameTextField().getText());
            gatunki.addGatunek(g, databaseUtil);
        }
    }

    public void onUsunGatunekButtonClicked() {
        window = windowFactory.getWindow(REMOVE_GENRE);
        try {
            JTable lista = ((RemoveGenreWindow) window).getRemoveGenreTable();
            int id = Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString());
            gatunki.removeGatunek(id, databaseUtil);
            JOptionPane.showMessageDialog(this, "Pomyślnie usunięto gatunek!");
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(this, "Nie można usunąć gatunku");
        }
        showRemoveGenreWindow();
    }

    public void onOdrzucTransakcjeButtonClicked() {
        //Odrzuc Transakcje
        window = windowFactory.getWindow(TRANSACTION);
        JTable lista = ((TransactionWindow) window).getTable();
        if (lista.getSelectedRow() != -1) {
            if (lista.getValueAt(lista.getSelectedRow(), 3).toString().equalsIgnoreCase("Wypożyczenie")) {
                try {
                    transakcje.removeTransakcja(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()), databaseUtil);
                    JOptionPane.showMessageDialog(this, "Usunięto");
                } catch (HibernateException he) {
                    he.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Błąd, nie usunięto!");
                }
            }
        }
        showTransactionWindow();
    }

    public void onZatwierdzTransakcjeButtonClicked() {

        //Zatwierdz Transakcje
        window = windowFactory.getWindow(TRANSACTION);
        JTable lista = ((TransactionWindow) window).getTable();
        if (lista.getSelectedRow() != -1) {
            if (lista.getValueAt(lista.getSelectedRow(), 3).toString().equalsIgnoreCase("Wypożyczenie")) {
                try {
                    Transakcja transakcja = transakcje.getTransakcja(Integer.parseInt(lista.getModel().getValueAt(lista.getSelectedRow(), 0).toString()), databaseUtil);
                    transakcja.setIdPracownika(user);
                    transakcje.editTransakcja(transakcja, databaseUtil);
                    JOptionPane.showMessageDialog(this, "Zatwierdzono");
                } catch (HibernateException he) {
                    he.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Błąd!");
                }
            }
            showTransactionWindow();
        }

    }

    public static int getRole() {
        return role;
    }

    public static MainWindow getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1024, 728);
        mainWindow.setResizable(true);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
