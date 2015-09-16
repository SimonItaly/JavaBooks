
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

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import static java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * Definisce un lettore personalizzato per i file PDF
 * @author  Simone
 * @see     JavaBooksReader
 */
public class PDFReader extends JavaBooksReader
{
    private PagePanel PDFpanel;
    
    private int curPage;
    
    private PDFFile pdffile;
    
    private BufferedImage img;
    
    private JButton prevButton,
                    nextButton;
    
    private File file;
    
    /**
     * Costruttore per la classe PDFReader
     * @param file il file da leggere
     * @throws FileNotFoundException
     * @throws IOException
     */
    public PDFReader(File file) throws FileNotFoundException, IOException
    {
        super(file);
    
        curPage = 1;
        
        setupInterface(file);
        
        this.file = file;
        
        setTitle("JavaBooksReader - " + file.getAbsolutePath() + " - 1/" + pdffile.getNumPages());
    }
    
    /**
     * Definisce l'interfaccia grafica del lettore PDF
     */
    private void setupInterface(File file) throws FileNotFoundException, IOException
    {
        setLayout(new BorderLayout());
        
        //Evento: rotellina del mouse
        this.addMouseWheelListener(new MouseWheelListener()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                e.consume();
                
                int notches = e.getWheelRotation();
                if (notches < 0)
                {
                    prevButtonActionPerformed(null);
                }
                else
                {
                    nextButtonActionPerformed(null);
                }
            }
        });
        
        //**********************************************************************
        
        prevButton = new JButton("<<<");
        prevButton.setFont(prevButton.getFont().deriveFont(Font.BOLD));

        prevButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                prevButtonActionPerformed(evt);
            }
        });

        //Evento: freccia sinistra
        AbstractAction prevAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                prevButtonActionPerformed(evt);
            }
        };
        prevButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Sinistra");
        prevButton.getActionMap().put("Sinistra", prevAction);
        
        add(prevButton, BorderLayout.WEST);
        
        //**********************************************************************
        
        nextButton = new JButton(">>>");
        nextButton.setFont(nextButton.getFont().deriveFont(Font.BOLD));
        
        nextButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextButtonActionPerformed(evt);
            }
        });
        
        //Evento: freccia destra
        AbstractAction nextAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                nextButtonActionPerformed(null);
            }
        };
        nextButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Destra");
        nextButton.getActionMap().put("Destra", nextAction);

        add(nextButton, BorderLayout.EAST);

        //**********************************************************************
        
        PDFpanel = new PagePanel();
        PDFpanel.setVisible(true);
        
        add(PDFpanel);
        pack();
        setVisible(true);
        
        //**********************************************************************
        
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

        pdffile = new PDFFile(buf);

        PDFPage page = pdffile.getPage(1);
        PDFpanel.showPage(page);
    }
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt)
    {  
        if(curPage > 1)
        {
            curPage--;
        
            PDFPage page = pdffile.getPage(curPage);
            PDFpanel.showPage(page);
            
            setTitle("JavaBooksReader - " + file.getAbsolutePath() + " - " + curPage + "/" + pdffile.getNumPages());
        }
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                               
        if(curPage < pdffile.getNumPages())
        {
            curPage++;
        
            PDFPage page = pdffile.getPage(curPage);
            PDFpanel.showPage(page);
            
            setTitle("JavaBooksReader - " + file.getAbsolutePath() + " - " + curPage + "/" + pdffile.getNumPages());
        }
    }
}
