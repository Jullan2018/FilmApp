package filmapp;

public class Film
{
    private String title;
    private String directorName;
    private String genre;
    private int year;

    public Film(String title,String directorName,String genre,int year)
    {
        this.title = title;
        this.directorName = directorName;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString()
    {
        return "Title: "+this.title+"  Director: "+this.directorName+"  Genre: "+this.genre+"  Year: "+this.year+"";
    }

}
