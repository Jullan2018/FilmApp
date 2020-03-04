package filmapp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;

public class ReadFilmListDataFile
{
    public static final String filmListDataFilePath = "filmlistdata/";
    public static final String filmListDataFileName = "filmlist.txt";

    public static void saveFilmList(FilmList fl)
    {
        try{

            try(PrintWriter fileWriter = new PrintWriter(new File(filmListDataFilePath + filmListDataFileName)))
            {
                for(Film film : fl.getFilmList())
                {
                    fileWriter.println(film.getTitle()+"|"+film.getDirectorName()+"|"+film.getGenre()+"|"+film.getYear());
                }
                fileWriter.close();
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void loadFilmList(FilmList fl)
    {
        try {
            Scanner fileScan = new Scanner(new File(filmListDataFilePath + filmListDataFileName));

            //int nFilm = fileScan.nextInt();
           fileScan.nextLine();
           fl.clear();

            while(fileScan.hasNextLine())
            {
                StringTokenizer tokens = new StringTokenizer(fileScan.nextLine(),"|");
                String title = tokens.nextToken();
                String director = tokens.nextToken();
                String genre =tokens.nextToken();
                String year = tokens.nextToken();
                int yearx =  Integer.parseInt(year);

                Film aFilm = new Film(title,director,genre,yearx);
                fl.addFilm(aFilm);
            }

            fileScan.close();
            System.out.println("Loaded films");

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
