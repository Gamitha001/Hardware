/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gamit
 */
public class SideBar {

    private static boolean AUTO_CLOSE;
    private JPanel PANEL;
    private JScrollPane SCROLLPANE;

    public SideBar(JPanel PANEL, JScrollPane SCROLLPANE) {
        this.SCROLLPANE = SCROLLPANE;
        this.PANEL = PANEL;
    }

    public void Show(int OPEN, long DELAY) {
        Thread T = new Thread(new Runnable() {

            @Override
            public void run() {

                try {

                    int pane_widt = 50;
                    int width = OPEN - pane_widt;
                    int SC_widt = 1320 + pane_widt;
                    int SC_X = 50 - pane_widt;
                    if (AUTO_CLOSE) {

                        for (int i = width; i < OPEN + 1; i++) {

                            PANEL.setSize(i, PANEL.getHeight());
                            SCROLLPANE.setBounds(SC_X + i, SCROLLPANE.getY(), 1370 - i, SCROLLPANE.getHeight());
                            Thread.sleep(DELAY);

                        }

                        Thread.sleep(300);

                        for (int i = PANEL.getWidth(); i > pane_widt; i--) {
                            PANEL.setSize(i, PANEL.getHeight());
                            SCROLLPANE.setBounds(SC_X - i * -1, SCROLLPANE.getY(), 1265 + i, SCROLLPANE.getHeight());
                            Thread.sleep(DELAY);
                        }
                    } else {

                        if (PANEL.getWidth() == 50) {

                            for (int i = width; i < OPEN + 1; i++) {
                                PANEL.setSize(i, PANEL.getHeight());
                                SCROLLPANE.setBounds(SC_X + i, SCROLLPANE.getY(), 1370 - i, SCROLLPANE.getHeight());
                                SCROLLPANE.setHorizontalScrollBar(SCROLLPANE.getHorizontalScrollBar());
                                SCROLLPANE.setVerticalScrollBar(SCROLLPANE.getVerticalScrollBar());
                                Thread.sleep(DELAY);
                            }
                        } else {

                            for (int i = PANEL.getWidth(); i > pane_widt - 1; i--) {
                                PANEL.setSize(i, PANEL.getHeight());
                                SCROLLPANE.setBounds(SC_X - i * -1, SCROLLPANE.getY(), 1265 + i, SCROLLPANE.getHeight());
                                SCROLLPANE.setHorizontalScrollBar(SCROLLPANE.getHorizontalScrollBar());
                                SCROLLPANE.setVerticalScrollBar(SCROLLPANE.getVerticalScrollBar());
                                Thread.sleep(DELAY);                                
                            }
                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(SideBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        T.start();

    }
}
