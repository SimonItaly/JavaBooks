
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JEditorPane;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 * Definisce un lettore personalizzato per i file HTML
 * @author  Simone
 * @see     JavaBooksReader
 */
public class HTMLReader extends JavaBooksReader
{
    private JEditorPane HTMLpanel;
    
    /**
     * Costruttore per la classe HTMLReader
     * @param file il file da leggere
     * @throws FileNotFoundException
     * @throws IOException
     */
    public HTMLReader(File file) throws FileNotFoundException, IOException
    {
        super(file);
        
        setupInterface(file);
    }
    
    /**
     * Definisce l'interfaccia grafica del lettore PDF
     */
    private void setupInterface(final File file) throws FileNotFoundException, IOException
    {
        setLayout(new BorderLayout());

        this.setMinimumSize(new Dimension(700, 500));
        
        pack();
        setVisible(true);
        
        final JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel);
        
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                WebView webView = new WebView();
                jfxPanel.setScene(new Scene(webView));
                
                String path = file.getAbsolutePath();
                path.replace("\\\\", "/");  

                webView.getEngine().load("file:///" + path);  
                
                webView.setVisible(true);
            }
        });
    }
}
