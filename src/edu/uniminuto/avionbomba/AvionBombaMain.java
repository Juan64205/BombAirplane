/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniminuto.avionbomba;

import edu.uniminuto.avionbomba.view.MainView;
import javax.swing.SwingUtilities;

/**
 *
 * @author Yoiner Montoya
 */
public class AvionBombaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }
}
