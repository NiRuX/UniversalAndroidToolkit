/*
 * Copyright (C) 2014 beatsleigher
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


package eu.m4gkbeatz.androidtoolkit.ui.menus;


import JDroidLib.android.controllers.*;
import JDroidLib.android.device.*;

import eu.m4gkbeatz.androidtoolkit.language.*;
import eu.m4gkbeatz.androidtoolkit.logging.*;
import static eu.m4gkbeatz.androidtoolkit.logging.Logger.Level;
import eu.m4gkbeatz.androidtoolkit.settings.*;

import javax.swing.*;
import java.awt.Component;
import java.util.*;
import java.io.*;

public class RestoreManager extends javax.swing.JFrame {
    
    private final LangFileParser parser;
    private final Logger logger;
    private final ADBController adbController;
    private final Device device;
    private final SettingsManager settings;
    private final boolean debug;

    public RestoreManager(Logger logger, ADBController adbController, SettingsManager settings, Device device, boolean debug, LangFileParser parser) {
        initComponents();
        this.parser = parser;
        this.logger = logger;
        this.adbController = adbController;
        this.settings = settings;
        this.device = device;
        this.debug = debug;
        this.setIconImage(new ImageIcon(this.getClass().getResource("/eu/m4gkbeatz/androidtoolkit/resources/UniversalAndroidToolkit_logo.png")).getImage());
        this.setLocationRelativeTo(null);
        try {
            loadTranslations();
        } catch (IOException ex) {
            logger.log(Level.ERROR, "An error occurred while loading the translations for Restore Manager: " + ex.toString() + "\n"
                    + "The error stack trace will be printed to the console...");
            ex.printStackTrace(System.err);
        }
    }
    
    private IOException exception = null;
    private void loadTranslations() throws IOException {
        new Thread() {
            @Override
            public void run() {
                try {
                    setTitle("Universal Android Toolkit | " + parser.parse("restoreManager:title"));
                } catch (IOException ex) { exception = ex; }
                interrupt();
            }
        }.start();
        if (exception != null)
            throw exception;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
