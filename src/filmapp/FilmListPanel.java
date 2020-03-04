package filmapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class FilmListPanel extends JPanel
{
    private FilmList model;

    private JList<Film> filmList;
    private JTextField filmTitleInput;
    private JTextField filmDirectorInput;
    private JTextField filmGenreInput;
    private JTextField filmYearInput;


    private JLabel filmTitle;
    private JLabel filmDirector;
    private JLabel filmGenre;
    private JLabel filmYear;

    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton searchButton;

    public JList<Film> getFilmList()
    {
        return this.filmList;
    }

    public JTextField getFilmTitleInput() {
        return filmTitleInput;
    }
    public JTextField getFilmDirectorInput() {
        return filmDirectorInput;
    }
    public JTextField getFilmGenreInput() {
        return filmGenreInput;
    }
    public JTextField getFilmYearInput(){return filmYearInput;}

    public JButton getAddButton()
    {
        return this.addButton;
    }
    public JButton getRemoveButton() {
        return removeButton;
    }
    public JButton getSearchButton() {
        return searchButton;
    }
    public JButton getClearButton() {
        return clearButton;
    }
    public JButton getSaveButton() {
        return saveButton;
    }

    public JLabel getFilmTitle() {
        return filmTitle;
    }
    public JLabel getFilmDirector() {
        return filmDirector;
    }
    public JLabel getFilmGenre() {
        return filmGenre;
    }
    public JLabel getFilmYear() {
        return filmYear;
    }

    public FilmListPanel(FilmList model)
    {
        this.model = model;

        setLayout(null);

        this.filmList = new JList(this.model.getFilmList());

        this.filmList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(filmList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setLocation(30,175);
        scrollPane.setSize(800,600);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.add(scrollPane);
        this.filmTitle = new JLabel("Title:");
        this.filmTitle.setLocation(30,30);
        this.filmTitle.setSize(150,25);
        this.add(filmTitle);

        this.filmDirector = new JLabel("Director:");
        this.filmDirector.setLocation(30,70);
        this.filmDirector.setSize(150,25);
        this.add(filmDirector);

        this.filmGenre = new JLabel("Genre:");
        this.filmGenre.setLocation(30,100);
        this.filmGenre.setSize(150,25);
        this.add(filmGenre);

        this.filmYear = new JLabel("Year:");
        this.filmYear.setLocation(30,130);
        this.filmYear.setSize(150,25);
        this.add(filmYear);

        this.filmTitleInput = new JTextField("");
        this.filmTitleInput.setLocation(100,30);
        this.filmTitleInput.setSize(250,25);
        this.add(filmTitleInput);

        this.filmDirectorInput = new JTextField("");
        this.filmDirectorInput.setLocation(100,70);
        this.filmDirectorInput.setSize(250,25);
        this.add(filmDirectorInput);

        this.filmGenreInput = new JTextField("");
        this.filmGenreInput.setLocation(100,100);
        this.filmGenreInput.setSize(250,25);
        this.add(filmGenreInput);

        this.filmYearInput = new JTextField("");
        this.filmYearInput.setLocation(100,130);
        this.filmYearInput.setSize(250,25);
        this.add(filmYearInput);

        this.addButton = new JButton("Add");
        this.addButton.setLocation(490,30);
        this.addButton.setSize(100,25);
        this.add(addButton);

        this.removeButton = new JButton("Remove");
        this.removeButton.setLocation(490,70);
        this.removeButton.setSize(100,25);
        this.add(removeButton);

        this.clearButton = new JButton("Clear");
        this.clearButton.setLocation(390,70);
        this.clearButton.setSize(100,25);
        this.add(clearButton);

        this.searchButton = new JButton("Search");
        this.searchButton.setLocation(390,30);
        this.searchButton.setSize(100,25);
        this.add(searchButton);

        this.saveButton = new JButton("Save");
        this.saveButton.setLocation(490,120);
        this.saveButton.setSize(100,25);
        this.add(saveButton);

        setSize(800,700);
        this.update();
    }

    public void update()
    {
        this.filmList.setListData(this.model.getFilmList());
        this.removeButton.setEnabled(this.filmList.getSelectedIndex()!=-1);
    }


}
