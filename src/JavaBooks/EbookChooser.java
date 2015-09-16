
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

import javax.swing.JFileChooser;

/**
 * Estende la classe JFileChooser per consentire la selezione dei seguenti file:<br>
 * - PDF<br>
 * - EPUB<br>
 * - HTML/HTM<br>
 * - TXT<br>
 * - MOBI<br>
 * 
 * @author  Simone Bisi
 * @see     JFileChooser
 */
public class EbookChooser extends JFileChooser
{
    /**
     * Costruttore per la classe EbookChooser
     */
    public EbookChooser()
    {
        super();

        FileTypeFilter filterJLib;
        
        filterJLib = new FileTypeFilter(".pdf", "Portable Document Format");
        this.addChoosableFileFilter(filterJLib);
        
        filterJLib = new FileTypeFilter(".epub", "Electronic Publication");
        this.addChoosableFileFilter(filterJLib);
        
        filterJLib = new FileTypeFilter(".html", "Hypertext Markup Language");
        this.addChoosableFileFilter(filterJLib);
        
        filterJLib = new FileTypeFilter(".htm", "Hypertext Markup Language");
        this.addChoosableFileFilter(filterJLib);
        
        filterJLib = new FileTypeFilter(".txt", "File di testo");
        this.addChoosableFileFilter(filterJLib);
        
        filterJLib = new FileTypeFilter(".mobi", "Mobipocket");
        this.addChoosableFileFilter(filterJLib);
    }
}
