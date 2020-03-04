package filmapp;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;

public class FilmListApp extends JFrame
{
    private FilmList model;
    private FilmListPanel view;
    private ArrayList<Film> copyOforiginalListFilm;

    private void eventHandleListSelection()
    {
        this.view.getRemoveButton().setEnabled(this.view.getFilmList().getSelectedIndex()!=-1);
    }

    private void eventHandleKeyReleased(KeyEvent e)
    {
        this.view.getAddButton().setEnabled(!this.view.getFilmTitleInput().getText().isEmpty());
    }

    private void eventHandleRemoveButton()
    {
        int index = this.view.getFilmList().getSelectedIndex();
        if(index !=-1)
        {
            this.model.removeFilm(index);
            this.copyOforiginalListFilm.remove(index);
        }

        this.view.update();
    }

    private void eventHandleWindowOpened()
    {
        System.out.println("Window opened!");
        this.view.update();
    }

    private void updateCopyOfOriginalFilmList()
    {
        this.model.clear();
        for(Film film : this.copyOforiginalListFilm)
        {
            this.model.addFilm(film);
        }
    }

    private void populateCopyOfFilmList()
    {
        for(Film film : this.model.getFilmList())
        {
            this.copyOforiginalListFilm.add(film);
        }
    }

    private void eventHandleSearchButton()
    {
        JFrame frame = new JFrame();
        String title = this.view.getFilmTitleInput().getText().toLowerCase().trim();
        String director = this.view.getFilmDirectorInput().getText().toLowerCase().trim();
        String genre = this.view.getFilmGenreInput().getText().toLowerCase().trim();
        String year = this.view.getFilmYearInput().getText().trim();

        ArrayList<Film> filteredFilm = new ArrayList<>();

        for(Film film : this.copyOforiginalListFilm)
        {
            if(!"".equals(director))
            {
                if(film.getDirectorName().toLowerCase().contains(director))
                {
                    if(!filteredFilm.contains(film)) {
                        filteredFilm.add((film));
                    }
                }
            }
            if(!"".equals(title))
            {
                if(film.getTitle().toLowerCase().contains(title))
                {
                    if(!filteredFilm.contains(film)) {
                        filteredFilm.add((film));
                    }
                }
            }
            if(!"".equals(genre))
            {
                if(film.getGenre().toLowerCase().contains(genre))
                {
                    if(!filteredFilm.contains(film)) {
                        filteredFilm.add((film));
                    }
                }
            }
            if(!"".equals(year))
            {
                if(Integer.toString(film.getYear()).contains(year))
                {
                    if(!filteredFilm.contains(film))
                    {
                        filteredFilm.add((film));
                    }
                }
            }
        }
        this.model.clear();
        for (Film filtered : filteredFilm)
        {
            this.model.addFilm(filtered);
        }
        this.view.update();

    }

    private void eventHandleClearButton()
    {
        this.view.getFilmTitleInput().setText("");
        this.view.getFilmDirectorInput().setText("");
        this.view.getFilmGenreInput().setText("");
        this.view.getFilmYearInput().setText("");

        updateCopyOfOriginalFilmList();
        this.view.update();
    }
    private void eventHandleSaveButton()
    {
        ReadFilmListDataFile.saveFilmList(this.model);
        this.view.update();
    }

    private void eventHandleAddButton()
    {
        String title = this.view.getFilmTitleInput().getText().trim();
        String director = this.view.getFilmDirectorInput().getText().trim();
        String genre = this.view.getFilmGenreInput().getText().trim();
        String year = this.view.getFilmYearInput().getText().trim();
        int yearx = 0;

        try
        {
            yearx = Integer.parseInt(year);
        }
        catch (NumberFormatException e)
        {

        }

        Film film = new Film(title,director,genre,yearx);
        if((!title.isEmpty())&&(!this.model.hasFilmItem(film)))
        {
            this.model.addFilm(film);
            this.copyOforiginalListFilm.add(film);

            this.view.getFilmTitleInput().setText("");
            this.view.getFilmDirectorInput().setText("");
            this.view.getFilmGenreInput().setText("");
            this.view.getFilmYearInput().setText("");
        }

        this.view.update();
    }

    public FilmListApp(String title)
    {
        super(title);
        this.copyOforiginalListFilm = new ArrayList<>();
        this.model = new FilmList();
        ReadFilmListDataFile.loadFilmList(this.model);
        populateCopyOfFilmList();
        this.view = new FilmListPanel(this.model);

        this.view.getSaveButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eventHandleSaveButton();
                    }
                }
        );

        this.view.getFilmTitleInput().addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                eventHandleKeyReleased(e);
            }
        });

        this.view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleSearchButton();
            }
        });
        this.view.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleClearButton();
            }
        });

        this.view.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleRemoveButton();
            }
        });

        this.view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleAddButton();
            }
        });

        this.view.getFilmList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eventHandleListSelection();
            }
        });

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                eventHandleWindowOpened();
            }
        });

        this.getContentPane().setLayout(null);
        this.getContentPane().add(this.view);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        setResizable(false);
    }

    public static void main(String[] args)
    {
        JFrame frame = new FilmListApp("My Film Database");
        frame.setVisible(true);
    }
}
