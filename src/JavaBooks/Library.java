
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultListModel;

/**
 * Definisce una libreria (Library) come una raccolta (DefaultListModel)
 * di libri (Book)
 * @author  Simone Bisi
 * @see     DefaultListModel
 * @see     Book
 */
public final class Library
{
    private DefaultListModel<Book> booksList;

    private String  name,
                    path;
    
    private Library backup = null;
    
    /**
     * Costruttore per la classe Library
     * @param save_path percorso assoluto per il salvataggio della libreria
     */
    public Library(String save_path)
    {
        booksList = new DefaultListModel<Book>();
        
        File f = new File(save_path);
        if(f.isFile())
        {
            path = save_path;
        }
    }

    /**
     * Costruttore clone per la classe Library
     * @param lib libreria da copiare
     */
    public Library(Library lib)
    {
        booksList = new DefaultListModel<Book>();
        
        this.name = lib.name;
        this.path = lib.path;

        for(int i = 0; i < lib.size(); i++)
        {
            this.addBook(lib.getBookAtIndex(i));
        }
    }
    
    /**
     * Svuota completamente la libreria
     */
    public void clear()
    {
        booksList.clear();
    }
    
    /**
     * Ritorna la lista di libri
     * @return  una lista di libri (Book) in formato DefaultListModel
     * @see     Book
     */
    public DefaultListModel<Book> getList()
    {
        return booksList;
    }
    
    /**
     * Sostituisce o inserisce un libro ad un indice specifico
     * @param index indice a cui inserire il libro
     * @param b     il libro da rimpiazzare
     * @return      il valore di DefaultListModel.set (l'elemento precedente a quell'indice)
     * @see         Book
     */
    public Book setBookAtIndex(int index, Book b)
    {
        return booksList.set(index, b);
    }
    
    /**
     * Ritorna un libro ad un indice specifico
     * @param index indice di cui ottenere il libro
     * @return      il libro all'indice specificato
     * @see         Book
     */
    public Book getBookAtIndex(int index)
    {
        return booksList.get(index);
    }
    
    /**
     * Aggiunge un libro alla lista
     * @param b il libro da inserire nella lista
     */
    public void addBook(Book b)
    {
        booksList.addElement(b);
    }
    
    /**
     * Rimuove un libro dalla lista ad un indice specificato
     * @param index indice a cui rimuovere il libro
     * @return      il valore di DefaultListModel.remove (l'elemento precedente a quell'indice)
     */
    public Book removeBookAtIndex(int index)
    {
        return booksList.remove(index);
    }

    /**
     * Rimuove un libro dalla lista
     * @param b il libro da rimuovere
     * @return  il valore di DefaultListModel.removeBook (true se l'elemento esiste nella lista, false altrimenti)
     */
    public boolean removeBook(Book b)
    {
        return booksList.removeElement(b);
    }

    /**
     * Ritorna il nome della libreria
     * @return il nome della libreria
     */
    public String getName()
    {
        return name;
    }

    /**
     * Modifica il nome della libreria
     * @param name il nuovo nome della libreria
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Ritorna la dimensione della libreria
     * @return la dimensione della libreria
     */
    public int size()
    {
        return booksList.size();
    }
    
    /**
     * Ritorna il percorso della libreria
     * @return il percorso assoluto della libreria
     */
    public String getPath()
    {
        return path;
    }
    
    /**
     * Modifica il percorso della libreria
     * @param save_path il nuovo percorso assoluto della libreria
     */
    public void setPath(String save_path)
    {
        this.path = save_path;
    }   
    
    /**
     * Salva la libreria nel proprio percorso
     * @throws IOException
     */
    public void save() throws IOException
    {
        FileOutputStream outFile = new FileOutputStream(path);
        ObjectOutputStream outStream = new ObjectOutputStream(outFile);
        
        Book b;

        for(int i = 0; i < booksList.size(); i++)
        {
            b = booksList.get(i);
            outStream.writeObject(b);
        }

        outStream.close();
    }
    
    /**
     * Legge la libreria dal proprio percorso
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void read() throws ClassNotFoundException, FileNotFoundException, IOException
    {
        booksList.clear();

        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream inStream = new ObjectInputStream(inFile);

        Book b;

        try
        {
            while(true)
            {
                b = (Book) inStream.readObject();
                booksList.addElement(b);
            }
        }
        catch(IOException e)
        {
            //NOP
        }
    }
    
    /**
     * Effettua il backup della libreria (usato per le funzioni di ricerca)
     */
    public void backup()
    {
        backup = new Library(this);
    }
    
    /**
     * Ritorna il backup della libreria (usato per le funzioni di ricerca)
     * @return il backup della libreria
     */
    public Library getBackup()
    {
        return new Library(backup);
    }
    
    /**
     * Ripristina il backup della libreria (usato per le funzioni di ricerca)
     */
    public void restoreBackup()
    {
        if(backup != null)
        {
            this.booksList = backup.booksList;
            this.name = backup.name;
            this.path = backup.path;
            backup = null;
        }
    }
    
    /**
     * Stampa il contenuto della libreria su una stampante configurata del sistema
     * @return true se l'operazione ha successo, false altrimenti
     * @throws NullPointerException
     * @throws UnsupportedOperationException
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public boolean print() throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException
    {
        Book b;
        boolean print;
        
        for(int i = 0; i < booksList.size(); i++)
        {
            b = booksList.get(i);
            print = b.print();
            if(!print)
                return false;
        }
        return true;
    }
}
