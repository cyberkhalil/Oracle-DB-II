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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import util.Pre;

/**
 *
 * @author A7med
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        if (!Pre.checkOracleInstalled()) {
            // TODO ..
        }
        invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

}
