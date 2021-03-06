
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
 * Estende la classe JFileChooser per consentire la selezione dei file .jlib
 * @author  Simone Bisi
 * @see     JFileChooser
 */
public class JLibChooser extends JFileChooser
{
    /**
     * Costruttore della classe JLibChooser
     * @see FileTypeFilter
     */
    public JLibChooser()
    {
        super();

        FileTypeFilter filterJLib = new FileTypeFilter(".jlib", "JavaBooks Library");

        this.setFileFilter(filterJLib);
    }
}
