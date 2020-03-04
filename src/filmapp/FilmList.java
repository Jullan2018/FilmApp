package filmapp;

import java.util.ArrayList;

public class FilmList
{
    private ArrayList<Film> filmList;

    public FilmList()
    {
        this.filmList = new ArrayList<>();
    }

    public void addFilm(Film aFilm)
    {
        this.filmList.add(aFilm);
    }
    public void removeFilm(int index)
    {
        this.filmList.remove(index);
    }
    public Film[] getFilmList()
    {
        Film[] array = new Film[this.filmList.size()];

        for(int i=0;i<array.length;i++)
        {
            array[i] = this.filmList.get(i);
        }

        return array;
    }

    public boolean hasFilmItem(Film aFilm)
    {
        return this.filmList.contains(aFilm);
    }
    public void clear()
    {
        this.filmList.clear();
    }
}
