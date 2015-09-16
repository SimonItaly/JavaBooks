
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

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * Applica un override sul metodo DefaultListCellRenderer per
 * personalizzare il testo della JList libList in MainInterface.java
 * @author  Simone Bisi
 * @see     DefaultListCellRenderer
 */
public class ListCellRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        JLabel label;
        label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Book b = (Book) value;

        label.setText(b.getPath());

        return label;
    }
}