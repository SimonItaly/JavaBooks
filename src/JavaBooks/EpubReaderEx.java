
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

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.viewer.Viewer;

/**
 * Definisce un lettore personalizzato per i file HTML
 * @author  Simone
 * @see     JavaBooksReader
 */
public class EpubReaderEx extends JavaBooksReader
{
    private JEditorPane HTMLpanel;
    
    private JFXPanel jfxPanel;
    
    private int curPage;
    
    private JButton prevButton,
            nextButton;
    
    private File file;
    
    /**
     * Costruttore per la classe EpubReader
     * @param file il file da leggere
     * @throws FileNotFoundException
     * @throws IOException
     */
    public EpubReaderEx(File file) throws FileNotFoundException, IOException
    {
        super(file);

        this.file = file;
        
        curPage = 0;
        
        this.setMinimumSize(new Dimension(700, 500));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setupInterface(file);
    }

    /**
     * Definisce l'interfaccia grafica del lettore PDF
     */
    private void setupInterface(File file) throws FileNotFoundException, IOException
    {
        EpubReader epubReader = new EpubReader();
        
        //TODO: chiude il JFrame parent alla chiusura
        Viewer v = new Viewer(epubReader.readEpub(new FileInputStream(file.getAbsolutePath())));
    }
}
