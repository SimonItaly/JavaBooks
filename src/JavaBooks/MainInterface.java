
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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import gui.ava.html.image.generator.HtmlImageGenerator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.viewer.Viewer;

/**
 * JavaBooks: un lettore di ebook, sviluppato per il corso di Programmazione<br>
 * ad oggetti dell'anno 2014/2015 del corso di Informatica presso il<br>
 * dipartimento di Scienze Matematiche, Fisiche, Informatiche dell'Università<br>
 * degli Studi di Modena e Reggio Emilia<br>
 * <br>
 * Dipendenze:<br>
 *      PDFRenderer-0.9.0<br>
 *      epublib-tools-3.1-complete0<br>
 *      html2image-0.9<br>
 *      PDFRenderer-0.9.0<br>
 *      slf4j-api-1.7.12<br>
 * 
 * @author Simone Bisi
 */
public class MainInterface extends javax.swing.JFrame {
    
    private Library curLib = null,
                    searchLib = null;
    
    private boolean searching = false;
    
    private int searchType;
    
    /**
     * Costruttore della classe MainInterface
     */
    public MainInterface()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
        catch (ClassNotFoundException e) { }
        catch (InstantiationException e) { }
        catch (IllegalAccessException e) { }
        catch (UnsupportedLookAndFeelException e) { }
        
        initComponents();
        //TODO sposta in initComponents
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        WindowListener exitListener = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                PromptForExit();
            }
        };
        addWindowListener(exitListener);
        
        ImageIcon ico = new ImageIcon("res/book.png");
        this.setIconImage(ico.getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        libList = new javax.swing.JList();
        bookPanel = new javax.swing.JPanel();
        authorField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        pagesLabel = new javax.swing.JLabel();
        pagesField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        yearField = new javax.swing.JTextField();
        savePropButton = new javax.swing.JButton();
        previewPanel = new javax.swing.JPanel();
        openButton = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        searchLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchBox = new javax.swing.JComboBox();
        caseSensBox = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        libMenuTab = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        menuNew = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        menuSaveName = new javax.swing.JMenuItem();
        menuReload = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        otherMenuTab = new javax.swing.JMenu();
        menuPrint = new javax.swing.JMenuItem();
        menuPrintAll = new javax.swing.JMenuItem();
        infoMenuTab = new javax.swing.JMenu();
        menuInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JavaBooks");
        setIconImages(null);

        libList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        libList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                libListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(libList);
        libList.getAccessibleContext().setAccessibleName("");

        bookPanel.setBackground(new java.awt.Color(203, 203, 203));
        bookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        authorField.setEnabled(false);

        authorLabel.setText("Autore");
        authorLabel.setEnabled(false);

        titleLabel.setText("Titolo");
        titleLabel.setEnabled(false);

        titleField.setEnabled(false);

        pagesLabel.setText("Pagine");
        pagesLabel.setEnabled(false);

        pagesField.setEnabled(false);

        yearLabel.setText("Anno");
        yearLabel.setEnabled(false);

        yearField.setEnabled(false);

        savePropButton.setText("Salva");
        savePropButton.setEnabled(false);
        savePropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePropButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout bookPanelLayout = new org.jdesktop.layout.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bookPanelLayout.createSequentialGroup()
                .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(bookPanelLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(authorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, titleLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, pagesLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, yearLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(34, 34, 34)
                        .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, titleField)
                            .add(authorField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, pagesField)
                            .add(yearField)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, bookPanelLayout.createSequentialGroup()
                        .addContainerGap(290, Short.MAX_VALUE)
                        .add(savePropButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bookPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(authorField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(authorLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(titleField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(titleLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(pagesField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pagesLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bookPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(yearField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(yearLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(savePropButton)
                .add(5, 5, 5))
        );

        previewPanel.setBackground(new java.awt.Color(203, 203, 203));
        previewPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        openButton.setText("Apri...");
        openButton.setEnabled(false);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        previewLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        previewLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout previewPanelLayout = new org.jdesktop.layout.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(previewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, previewPanelLayout.createSequentialGroup()
                        .add(0, 280, Short.MAX_VALUE)
                        .add(openButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(previewLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, previewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(previewLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(openButton)
                .addContainerGap())
        );

        addButton.setText("Aggiungi");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Rimuovi");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        searchLabel.setText("Ricerca...");
        searchLabel.setEnabled(false);

        searchField.setToolTipText("");
        searchField.setEnabled(false);
        searchField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchFieldCaretUpdate(evt);
            }
        });

        searchBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Titolo", "Autore", "Anno" }));
        searchBox.setEnabled(false);
        searchBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchBoxItemStateChanged(evt);
            }
        });

        caseSensBox.setText("Case Sensitive");
        caseSensBox.setEnabled(false);

        libMenuTab.setText("Libreria");

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setText("Apri Libreria");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        libMenuTab.add(menuOpen);

        menuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuNew.setText("Nuova Libreria");
        menuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewActionPerformed(evt);
            }
        });
        libMenuTab.add(menuNew);

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setText("Salva");
        menuSave.setEnabled(false);
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        libMenuTab.add(menuSave);

        menuSaveName.setText("Salva con nome");
        menuSaveName.setEnabled(false);
        menuSaveName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveNameActionPerformed(evt);
            }
        });
        libMenuTab.add(menuSaveName);

        menuReload.setText("Ricarica");
        menuReload.setEnabled(false);
        menuReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReloadActionPerformed(evt);
            }
        });
        libMenuTab.add(menuReload);

        menuClose.setText("Chiudi");
        menuClose.setEnabled(false);
        menuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseActionPerformed(evt);
            }
        });
        libMenuTab.add(menuClose);
        libMenuTab.add(jSeparator1);

        menuExit.setText("Esci");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        libMenuTab.add(menuExit);

        menuBar.add(libMenuTab);

        otherMenuTab.setText("Altro");
        otherMenuTab.setEnabled(false);

        menuPrint.setText("Stampa libro");
        menuPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrintActionPerformed(evt);
            }
        });
        otherMenuTab.add(menuPrint);

        menuPrintAll.setText("Stampa libreria");
        menuPrintAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrintAllActionPerformed(evt);
            }
        });
        otherMenuTab.add(menuPrintAll);

        menuBar.add(otherMenuTab);

        infoMenuTab.setText("?");

        menuInfo.setText("Informazioni su JavaBooks");
        menuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInfoActionPerformed(evt);
            }
        });
        infoMenuTab.add(menuInfo);

        menuBar.add(infoMenuTab);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 403, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(addButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(bookPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(previewPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(searchLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(caseSensBox)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(bookPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(previewPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 447, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(addButton)
                        .add(removeButton))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(searchLabel)
                        .add(searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(searchBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(caseSensBox)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseActionPerformed
        PromptForClosing();
    }//GEN-LAST:event_menuCloseActionPerformed

    private void menuSaveNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveNameActionPerformed

        JLibChooser fdia = new JLibChooser();
        fdia.setAcceptAllFileFilterUsed(false);
        
        int ret = fdia.showDialog((JPanel) getContentPane(), "Salva con nome");

        if (ret == JLibChooser.APPROVE_OPTION)
        {
            File file = fdia.getSelectedFile();

            if(!file.getName().endsWith(".jlib"))
            {
                file = new File(file.getAbsolutePath() + ".jlib");
            }

            if(file.exists())
            {
                String ObjButtons[] = { "Sì", "No" };

                int PromptResult = JOptionPane.showOptionDialog(null, 
                                                                "Il file è già esistente.\n"
                                                                        + "Sovrascrivere il file?",
                                                                "JavaBooks", 
                                                                JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.WARNING_MESSAGE,
                                                                null, 
                                                                ObjButtons,
                                                                ObjButtons[1]);
                
                if(PromptResult != 0)
                    return;
            }
            
            curLib.setPath(file.getAbsolutePath());
            try
            {
                curLib.save();
            }
            catch (IOException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

            setTitle("JavaBooks - " + file.getAbsolutePath());

            addButton.setEnabled(true);
            searchField.setEnabled(true);
            searchLabel.setEnabled(true);
            searchBox.setEnabled(true);
            caseSensBox.setEnabled(true);
            
            menuSave.setEnabled(true);
            menuSaveName.setEnabled(true);
            menuReload.setEnabled(true);
            menuClose.setEnabled(true);
        }
    }//GEN-LAST:event_menuSaveNameActionPerformed

    private void menuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInfoActionPerformed
        String ObjButtons[] = { "OK" };
       
        JOptionPane.showOptionDialog(null, 
                        "JavaBooks\n"
                        + "Developed in Java for a college project\n"
                        + "(C) Simone Bisi",
                        "JavaBooks", 
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        ObjButtons,
                        ObjButtons[0]);
    }//GEN-LAST:event_menuInfoActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        PromptForExit();
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        
        JLibChooser fdia = new JLibChooser();
        fdia.setAcceptAllFileFilterUsed(false);
        
        int ret = fdia.showDialog((JPanel) getContentPane(), "Apri libreria");

        if (ret == JLibChooser.APPROVE_OPTION)
        {
            File file = fdia.getSelectedFile();

            openLibrary(file);
        }
        
    }//GEN-LAST:event_menuOpenActionPerformed

    /**
     * Apre una libreria
     * @param file file libreria da aprire
     * @return
     */
    private void openLibrary(File file)
    {
        if(!file.getName().endsWith(".jlib"))
        {
            file = new File(file.getAbsolutePath() + ".jlib");
        }

        if(file.exists())
        {
            curLib = new Library(file.getAbsolutePath());
            
            try
            {
                curLib.read();
            }
            catch (IOException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

            setTitle("JavaBooks - " + file.getAbsolutePath());

            libList.setCellRenderer(new ListCellRenderer());
            libList.setModel(curLib.getList());

            addButton.setEnabled(true);
            searchField.setEnabled(true);
            searchLabel.setEnabled(true);
            searchBox.setEnabled(true);
            caseSensBox.setEnabled(true);
            
            menuSave.setEnabled(true);
            menuSaveName.setEnabled(true);
            menuReload.setEnabled(true);
            menuClose.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "File non valido",
                                                "JavaBooks", 
                                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void libListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_libListValueChanged

        if (!evt.getValueIsAdjusting())
        {
            int index = libList.getSelectedIndex();
            
            if(index != -1)
            {
                Book b = curLib.getBookAtIndex(index);

                authorLabel.setEnabled(true);
                titleLabel.setEnabled(true);
                pagesLabel.setEnabled(true);
                yearLabel.setEnabled(true);

                authorField.setText(b.getAuthor());
                titleField.setText(b.getTitle());
                pagesField.setText("" + b.getPages());
                yearField.setText("" + b.getYear());

                authorField.setEnabled(true);
                titleField.setEnabled(true);
                pagesField.setEnabled(true);
                yearField.setEnabled(true);

                otherMenuTab.setEnabled(true);

                if(!searching)
                {
                    savePropButton.setEnabled(true);
                    removeButton.setEnabled(true);
                }
                
                openButton.setEnabled(true);
                
                try
                {
                    previewLabel.setText("");
                    previewLabel.setIcon(null);
                    previewLabel.setBackground(null);
                    
                    File file = new File(b.getPath());
                    
                    String extension = getFileExtension(file);
                                
                    if(extension.equalsIgnoreCase("pdf"))
                    {
                        SetupPDFPreview(index);
                    }
                    else if(extension.equalsIgnoreCase("html") || extension.equalsIgnoreCase("htm") || extension.equalsIgnoreCase("txt"))
                    {
                        SetupHTMLPreview(index);
                    }
                    else if(extension.equalsIgnoreCase("mobi"))
                    {
                        SetupMobiPreview(index);
                    }
                    else if(extension.equalsIgnoreCase("epub"))
                    {
                        SetupEpubPreview(index);
                    }
                    else
                    {
                        previewLabel.setText("<html><b>File non supportato</b></html>");
                    }
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_libListValueChanged

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        int index = libList.getSelectedIndex();
        if(index != -1)
        {
            clearBookGUI();

            otherMenuTab.setEnabled(false);

            removeButton.setEnabled(false);
            
            openButton.setEnabled(false);

            libList.clearSelection();

            curLib.removeBookAtIndex(index);

            libList.setCellRenderer(new ListCellRenderer());
            libList.setModel(curLib.getList());

            libList.validate();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed

        int index = libList.getSelectedIndex();
        if(index != -1)
        {
            Book b = curLib.getBookAtIndex(index);
            
            File file = new File(b.getPath());
            if(file.exists())
            {
                String ObjButtons[] = { "Lettore di sistema", "Lettore JavaBooks", "Annulla" };

                int PromptResult = JOptionPane.showOptionDialog(null, 
                                                                "Come vuoi aprire l'e-book?",
                                                                "JavaBooks", 
                                                                JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE,
                                                                null, 
                                                                ObjButtons,
                                                                ObjButtons[1]);
            
                if(PromptResult != 2)
                {
                    switch(PromptResult)
                    {
                        case 0: //Lettore di sistema
                        {
                            try
                            {
                                Desktop.getDesktop().open(file);
                            }
                            catch (IOException ex)
                            {
                                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            break;
                        }
                        case 1: //Lettore JavaBooks
                        {
                            try
                            {
                                JavaBooksReader j;
         
                                String extension = getFileExtension(file);
                                
                                if(extension.equalsIgnoreCase("pdf"))
                                {
                                    j = new PDFReader(file);
                                }
                                else if(extension.equalsIgnoreCase("html") || extension.equalsIgnoreCase("htm") || extension.equalsIgnoreCase("txt"))
                                {
                                    j = new HTMLReader(file);
                                }
                                else if(extension.equalsIgnoreCase("epub"))
                                {
                                    j = new EpubReaderEx(file);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Lettore .mobi non implementato",
                                                                        "JavaBooks", 
                                                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            catch (IOException ex)
                            {
                                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Percorso non valido",
                                                    "JavaBooks", 
                                                    JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_openButtonActionPerformed

    /**
     * Ritorna l'estensione di un file
     * @param file file di cui ottenere l'estensione
     * @return l'estensione del file
     */
    private String getFileExtension(File file)
    {
        String extension = "";
        int i = file.getAbsolutePath().lastIndexOf('.');
        if (i > 0)
        {
            extension = file.getAbsolutePath().substring(i+1);
        }

        return extension;
    }
    
    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveActionPerformed

        if(curLib != null)
        try
        {
            curLib.save();
        }
        catch (IOException ex)
        {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menuSaveActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        EbookChooser fdia = new EbookChooser();
        fdia.setAcceptAllFileFilterUsed(false);
        fdia.setMultiSelectionEnabled(true);
        
        int ret = fdia.showDialog((JPanel) getContentPane(), "Aggiungi libro");

        if (ret == JLibChooser.APPROVE_OPTION)
        {
            File[] files = fdia.getSelectedFiles();
            
            for(int i = 0; i < files.length; i++)
            {
                Book b = new Book(files[i].getAbsolutePath(), "", "", 0, 0);

                curLib.addBook(b);
            }
            
            libList.setModel(curLib.getList());
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void menuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewActionPerformed

        if(curLib != null)
            PromptForClosing();
        
        JLibChooser fdia = new JLibChooser();
        fdia.setAcceptAllFileFilterUsed(false);
        
        int ret = fdia.showDialog((JPanel) getContentPane(), "Crea nuova libreria");

        if (ret == JLibChooser.APPROVE_OPTION)
        {
            File file = fdia.getSelectedFile();
            if(!file.exists())
            {
                if(!file.getName().endsWith(".jlib"))
                {
                    file = new File(file.getAbsolutePath() + ".jlib");
                }
                
                try
                {
                    file.createNewFile();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                curLib = new Library(file.getAbsolutePath());
                searchLib = new Library(file.getAbsolutePath());
                        
                setTitle("JavaBooks - " + file.getAbsolutePath());

                libList.setCellRenderer(new ListCellRenderer());
                libList.setModel(curLib.getList());

                addButton.setEnabled(true);
                searchField.setEnabled(true);
                searchLabel.setEnabled(true);
                searchBox.setEnabled(true);
                caseSensBox.setEnabled(true);
                
                menuSave.setEnabled(true);
                menuSaveName.setEnabled(true);
                menuReload.setEnabled(true);
                menuClose.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Il file è già esistente",
                                                    "JavaBooks", 
                                                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuNewActionPerformed

    private void savePropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePropButtonActionPerformed
        
        int index = libList.getSelectedIndex();
        if(index != -1)
        {
            Book b = curLib.getBookAtIndex(index);

            b.setAuthor(authorField.getText());

            b.setTitle(titleField.getText());

            b.setPages(Integer.parseInt(pagesField.getText()));

            b.setYear(Integer.parseInt(yearField.getText()));

            curLib.setBookAtIndex(index, b);         
        }
        
    }//GEN-LAST:event_savePropButtonActionPerformed

    private void menuPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrintActionPerformed
        int index = libList.getSelectedIndex();
        if(index != -1)
        {
            Book b = curLib.getBookAtIndex(index);
            
            try
            {
                b.print();
            }
            catch (NullPointerException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalArgumentException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (UnsupportedOperationException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SecurityException ex)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuPrintActionPerformed

    private void menuPrintAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrintAllActionPerformed
        try
        {
            curLib.print();
        }
        catch (NullPointerException ex)
        {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedOperationException ex)
        {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalArgumentException ex)
        {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPrintAllActionPerformed

    private void menuReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReloadActionPerformed
        openLibrary(new File(curLib.getPath()));
    }//GEN-LAST:event_menuReloadActionPerformed

    private void searchBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            searchType = searchBox.getSelectedIndex();
        }
    }//GEN-LAST:event_searchBoxItemStateChanged

    private void searchFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchFieldCaretUpdate

        String searchFor = searchField.getText();
        
        if(searchFor.isEmpty())
        {
            if(!searching)
            {
                curLib.backup();
                searchLib = new Library(curLib);
                
                //System.out.println("Backup done - " + curLib.size() + " size");
            }
            else
            {
                searching = false;
                curLib.restoreBackup();
                
                libList.setCellRenderer(new ListCellRenderer());
                libList.setModel(curLib.getList());

                libList.validate();
                
                setTitle("JavaBooks - " + curLib.getPath());
                
                addButton.setEnabled(true);
                removeButton.setEnabled(true);
                menuSave.setEnabled(true);
                menuSaveName.setEnabled(true);
                
                //System.out.println("Backup restored - " + curLib.size() + " size");
            }
        }
        else
        {
            clearBookGUI();
            
            if(!searching)
            {
                curLib.backup();
                searchLib = new Library(curLib);
                
                //System.out.println("Backup done (inside check) - " + curLib.size() + " size");
            }
            
            searching = true;
            
            addButton.setEnabled(false);
            removeButton.setEnabled(false);
            menuSave.setEnabled(false);
            menuSaveName.setEnabled(false);

            Library tempLib = curLib.getBackup();
            
            Book b;
            
            curLib.clear();

            //Gestione case-sensitive
            boolean result = false;
            
            //Ricerca per...
            switch(searchType)
            {
                //Titolo
                case 0:
                {
                    for(int i = 0; i < tempLib.size(); i++)
                    {
                        b = tempLib.getBookAtIndex(i);

                        if(!caseSensBox.isSelected())
                            result = b.getTitle().toLowerCase().contains(searchFor.toLowerCase());
                        else
                            result = b.getTitle().contains(searchFor);
                        
                        if(result)
                            curLib.addBook(b);
                    }
                    break;
                }

                //Autore
                case 1:
                {
                    for(int i = 0; i < tempLib.size(); i++)
                    {
                        b = tempLib.getBookAtIndex(i);
 
                        if(!caseSensBox.isSelected())
                            result = b.getAuthor().toLowerCase().contains(searchFor.toLowerCase());
                        else
                            result = b.getAuthor().contains(searchFor);
                        
                        if(result)
                            curLib.addBook(b);
                    }
                    break;
                }

                //Anno di pubblicazione
                case 2:
                {
                    for(int i = 0; i < tempLib.size(); i++)
                    {
                        b = tempLib.getBookAtIndex(i);

                        if(Integer.getInteger(searchFor) == b.getYear())
                            curLib.addBook(b);
                    }
                    break;
                }
            }
            
            setTitle("JavaBooks - " + tempLib.getPath() + " - " + curLib.size() + " occorrenze trovate");
            
            /*
            System.out.println("tempLib.size(): " + tempLib.size() + " size");
            System.out.println("JavaBooks - " + tempLib.getPath() + " - " + curLib.size() + " occorrenze trovate");
            for(int i = 0; i < curLib.size(); i++)
            {
                b = curLib.getBookAtIndex(i);
                
                System.out.println(b.getPath());
            }
            */
            
            libList.setCellRenderer(new ListCellRenderer());
            libList.setModel(curLib.getList());

            libList.validate();
        }
    }//GEN-LAST:event_searchFieldCaretUpdate
    
    /**
     * Chiede all'utente una conferma tramite JOptionPane per la chiusura della libreria
     */
    private void PromptForClosing()
    {
        String ObjButtons[] = { "Sì", "No" };

        int PromptResult = JOptionPane.showOptionDialog(null, 
                                                        "Sei sicuro di voler chiudere la libreria?",
                                                        "JavaBooks", 
                                                        JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.WARNING_MESSAGE,
                                                        null, 
                                                        ObjButtons,
                                                        ObjButtons[1]);
       
        if(PromptResult == 0)
        {
            curLib.clear();
            libList.setModel(curLib.getList());

            addButton.setEnabled(false);
            searchField.setEnabled(false);
            searchLabel.setEnabled(false);
            searchBox.setEnabled(false);
            caseSensBox.setEnabled(false);
                    
            clearBookGUI();

            otherMenuTab.setEnabled(false);
            
            menuSave.setEnabled(false);
            menuSaveName.setEnabled(false);
            menuReload.setEnabled(false);
            menuClose.setEnabled(false);
            
            setTitle("JavaBooks");
            
            curLib = null;
        }
    }
    
    /**
     * Chiede all'utente una conferma tramite JOptionPane per la chiusura del programma
     */
    private void PromptForExit()
    {
        String ObjButtons[] = { "Sì", "No" };

        int PromptResult = JOptionPane.showOptionDialog(null, 
                                                        "Sei sicuro di voler uscire dall'applicazione?",
                                                        "JavaBooks", 
                                                        JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.ERROR_MESSAGE,
                                                        null, 
                                                        ObjButtons,
                                                        ObjButtons[1]);

        if(PromptResult == 0)
        {
            System.exit(NORMAL);
        }
    }
    
    /**
     * Anteprima per i file PDF
     * @param index indice del libro nella libreria
     * @throws IOException
     * @throws FileNotFoundException
     */
    private void SetupPDFPreview(int index) throws IOException, FileNotFoundException
    {
        Book b = curLib.getBookAtIndex(index);
        
	File file = new File(b.getPath());
        if(file.exists())
        {
            RandomAccessFile raf = new RandomAccessFile(file, "r");

            FileChannel channel = raf.getChannel();
            
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

            PDFFile pdffile = new PDFFile(buf);
            PDFPage page = pdffile.getPage(0);

            Rectangle rect = new Rectangle(0,0,
            (int)page.getBBox().getWidth(),
            (int)page.getBBox().getHeight());

            Image img = page.getImage(rect.width, rect.height, rect, null, true, true);

            previewLabel.setIcon(new ImageIcon(img.getScaledInstance(140, 200, java.awt.Image.SCALE_AREA_AVERAGING)));
        }
        else
        {
            previewLabel.setText("<html><b>File<br/>non<br/>trovato</b></html>");
        }
    }
    
    /**
     * Anteprima per i file HTML e TXT
     * @param index indice del libro nella libreria
     * @throws IOException
     */
    private void SetupHTMLPreview(int index)
    {
        Book b = curLib.getBookAtIndex(index);
        
	File file = new File(b.getPath());
        if(file.exists())
        {
            StringBuilder contentBuilder = new StringBuilder();
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsolutePath()));
                String str;
                while ((str = in.readLine()) != null)
                {
                    contentBuilder.append(str);
                }
                in.close();
            }
            catch (IOException e)
            {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, e);
            }

            String content = contentBuilder.toString();

            HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
            imageGenerator.loadHtml(content);

            previewLabel.setIcon(new ImageIcon(imageGenerator.getBufferedImage().getSubimage(0, 0, 350, 200)));
        }
        else
        {
            previewLabel.setText("<html><b>File<br/>non<br/>trovato</b></html>");
        }
    }

    /**
     * Anteprima per i file EPUB
     * @param index indice del libro nella libreria
     */
    private void SetupEpubPreview(int index) throws IOException
    {
        Book b = curLib.getBookAtIndex(index);
        
	File file = new File(b.getPath());
        if(file.exists())
        {
            EpubReader epubReader = new EpubReader();

            nl.siegmann.epublib.domain.Book book = epubReader.readEpub(new FileInputStream(file.getAbsolutePath()));

            Resource coverImage = book.getCoverImage();

            if(coverImage != null)
            {
                byte[] coverBytes = coverImage.getData();

                InputStream in = new ByteArrayInputStream(coverBytes);
                BufferedImage img = ImageIO.read(in);

                previewLabel.setIcon(new ImageIcon(img.getScaledInstance(140, 200, java.awt.Image.SCALE_AREA_AVERAGING)));
            }
            else
            {
                previewLabel.setText("<html><b>EPUB</b></html>");
            }
        }
        else
        {
            previewLabel.setText("<html><b>File<br/>non<br/>trovato</b></html>");
        }
    }
    
    /**
     * Anteprima per i file MOBI (non implementato)
     * @param index indice del libro nella libreria
     */
    private void SetupMobiPreview(int index)
    {
        Book b = curLib.getBookAtIndex(index);
        
	File file = new File(b.getPath());
        if(file.exists())
        {
            previewLabel.setText("<html><b>MOBI</b></html>");
        }
        else
        {
            previewLabel.setText("<html><b>File<br/>non<br/>trovato</b></html>");
        }
    }
    
    private void clearBookGUI()
    {
        authorLabel.setEnabled(false);
        titleLabel.setEnabled(false);
        pagesLabel.setEnabled(false);
        yearLabel.setEnabled(false);

        authorField.setText("");
        titleField.setText("");
        pagesField.setText("");
        yearField.setText("");

        authorField.setEnabled(false);
        titleField.setEnabled(false);
        pagesField.setEnabled(false);
        yearField.setEnabled(false);
        
        savePropButton.setEnabled(false);
        
        previewLabel.setText("");
        previewLabel.setIcon(null);
        previewLabel.setBackground(null);
    }
    
    //**************************************************************************
    
    /**
     * Classe main di JavaBooks
     * @param args argomenti da linea di comando
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainInterface().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JCheckBox caseSensBox;
    private javax.swing.JMenu infoMenuTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList libList;
    private javax.swing.JMenu libMenuTab;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuClose;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuInfo;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuPrint;
    private javax.swing.JMenuItem menuPrintAll;
    private javax.swing.JMenuItem menuReload;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JMenuItem menuSaveName;
    private javax.swing.JButton openButton;
    private javax.swing.JMenu otherMenuTab;
    private javax.swing.JTextField pagesField;
    private javax.swing.JLabel pagesLabel;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton savePropButton;
    private javax.swing.JComboBox searchBox;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
