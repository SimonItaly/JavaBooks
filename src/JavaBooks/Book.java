
/*
    JavaBooks is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.
    Duck Hunt is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    Developed in Java by:
            - Bisi Simone 	 [ bisi.simone (at) gmail (dot) com ]
    for studying purposes ONLY, between 2014/2015.
*/

package JavaBooks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Definisce il tipo di dato libro (Book) che verrà successivamente
 * implementato nella classe libreria (Library)
 * @author  Simone Bisi
 * @see     Library
 */
public class Book implements Serializable
{
    private String  author,
                    title;

    private int     num_pages,
                    rel_year;				

    private String  path;
	
    /**
     * Costruttore della classe Book
     * @param _path         percorso assoluto del libro sul filesystem
     * @param _author       autore del libro
     * @param _title        titolo del libro
     * @param _num_pages    pagine del libro
     * @param _rel_year     anno di pubblicazione
     */
    public Book(String _path,
				String _author,
				String _title,
				int _num_pages,
				int _rel_year)
	{
            path = _path;
            author = _author;
            title = _title;
            num_pages = _num_pages;
            rel_year = _rel_year;
	}

    /**
     * Ritorna l'autore del libro
     * @return l'autore del libro
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Modifica l'autore del libro
     * @param author il nuovo autore del libro
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Ritorna il titolo del libro
     * @return il titolo del libro
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Modifica il titolo del libro
     * @param title il nuovo titolo del libro
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Ritorna il percorso del libro su filesystem
     * @return il percorso assoluto del libro
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Modifica il percorso su filesystem del libro
     * @param path il nuovo percorso assoluto del libro
     */
    public void setPath(String path)
    {
        this.path = path;
    }
	
    /**
     * Modifica l'anno di pubblicazione del libro
     * @param rel_year il nuovo anno di pubblicazione del libro
     */
    public void setYear(int rel_year)
    {
        this.rel_year = rel_year;
    }

    /**
     * Ritorna l'anno di pubblicazione del libro
     * @return l'anno di pubblicazione del libro
     */
    public int getYear()
    {
        return rel_year;
    }

    /**
     * Modifica il numero di pagine del libro
     * @param num_pages il nuovo numero di pagine del libro
     */
    public void setPages(int num_pages)
    {
        this.num_pages = num_pages;
    }

    /**
     * Ritorna il numero di pagine del libro
     * @return il numero di pagine del libro
     */
    public int getPages()
    {
        return num_pages;
    }
        
    /**
     * Stampa il contenuto della libreria su una stampante configurata del sistema
     * @return true se è possibile stampare il libro, false altrimenti
     * @throws NullPointerException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     * @throws IOException
     * @throws SecurityException
     */
    public boolean print() throws NullPointerException, IllegalArgumentException, UnsupportedOperationException, IOException, SecurityException
    {
        if (java.awt.Desktop.isDesktopSupported())
        {
            try
            {
                Desktop d = java.awt.Desktop.getDesktop();
                d.print(new File(path));
            }
            catch (IOException iOException)
            {
            }
            return true;
        }
        return false;
    }
}
