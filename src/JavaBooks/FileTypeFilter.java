
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
import javax.swing.filechooser.FileFilter;
 
/**
 * Estende la classe FileFilter per utilizzare un formato personalizzato per
 * le estensioni ed un migliore gestione nella classe EbookChooser
 * @author  Simone Bisi
 * @see     FileFilter
 * @see     EbookChooser
 */
public class FileTypeFilter extends FileFilter
{
    private final String extension;
    private final String description;
 
    /**
     * Costruttore per la classe FileTypeFilter
     * @param extension estensione del file
     * @param description descrizione del file
     */
    public FileTypeFilter(String extension, String description)
    {
        this.extension = extension;
        this.description = description;
    }

    /**
     * Selettore del file
     * @param file file selezionato
     * @return true se accettato, false altrimenti
     */
    public boolean accept(File file)
    {
        if (file.isDirectory())
            return true;
            
        return file.getName().endsWith(extension);
    }
 
    /**
     * Ritorna la descrizione del file
     * @return la descrizione del file
     */
    public String getDescription()
    {
        return description + String.format(" (*%s)", extension);
    }
}
