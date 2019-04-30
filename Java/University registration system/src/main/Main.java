/*
 * Copyright (C) 2019 AyShe2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import gui.Login;
import static java.awt.EventQueue.invokeLater;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author A7med
 */
public class Main {

    public static void main(String[] args) {
        // TODO check database oracle is installed..

        try {
            System.out.println(Arrays.toString(getInstalledLookAndFeels()));
            // TODO change look and feel to be great !
            setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //setLookAndFeel(new MetalLookAndFeel());
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

}
