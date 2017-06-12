/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gamit
 */
public class SideBar {

    private JPanel PANEL;
    private JScrollPane SCROLLPANE;

    public SideBar(JPanel PANEL, JScrollPane SCROLLPANE) {
        this.SCROLLPANE = SCROLLPANE;
        this.PANEL = PANEL;
    }

    private void setDisplaySize(JScrollPane SCROLL, int width){
        int Width = SCROLL.getWidth();
        SCROLL.setBounds(SCROLL.getX(), SCROLL.getY(), width, SCROLL.getHeight());
    }
    
    public void Show(int OPEN, long DELAY) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                int width = OPEN - PANEL.getWidth();
                int SC_widt = SCROLLPANE.getWidth()+PANEL.getWidth();
                int SC_X = SCROLLPANE.getX()-PANEL.getWidth();
                
                for (int i = width; i < OPEN; i++) {
                    try {
                        PANEL.setSize(i, PANEL.getHeight());
                        SCROLLPANE.setBounds(SC_X+i, SCROLLPANE.getY(), SC_widt-i, SCROLLPANE.getHeight());
                        Thread.sleep(DELAY);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        }).start();
    }
    
}
