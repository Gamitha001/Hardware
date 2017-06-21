/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.LinkedHashSet;

/**
 *
 * @author Gamit
 */
public class MainScreen extends javax.swing.JFrame {
    
    private LinkedHashSet<String> CLIPBORD;
    private Clipboard Clip;
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();      
        this.setExtendedState(MAXIMIZED_BOTH);
        CLIPBORD = new LinkedHashSet<>();
        Clip = Toolkit.getDefaultToolkit().getSystemClipboard();      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SIDEBAR_LEFT = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        STASTU = new javax.swing.JPanel();
        DISPLAY = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        MENU_BAR = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        EDIT = new javax.swing.JMenu();
        UNDO = new javax.swing.JMenuItem();
        REDO = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CUT = new javax.swing.JMenuItem(new javax.swing.text.DefaultEditorKit.CutAction());
        COPY = new javax.swing.JMenuItem(new javax.swing.text.DefaultEditorKit.CopyAction());
        PASTE = new javax.swing.JMenuItem(new javax.swing.text.DefaultEditorKit.PasteAction());
        HIS_PASTE = new javax.swing.JMenuItem();
        DELETE = new javax.swing.JMenuItem();
        VIEW = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        WINDOW = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1370, 660));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIDEBAR_LEFT.setBackground(new java.awt.Color(38, 50, 56));
        SIDEBAR_LEFT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIDEBAR_LEFTMouseClicked(evt);
            }
        });
        SIDEBAR_LEFT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(55, 71, 79));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Speedometer_50px_1.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 110, 122));
        jLabel2.setText("Dashboard");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, -1));

        jPanel4.setBackground(new java.awt.Color(55, 71, 79));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Invoice_50px.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 110, 122));
        jLabel4.setText("Invoice");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 124, 190, -1));

        jPanel5.setBackground(new java.awt.Color(55, 71, 79));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Purchase Order_50px.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 110, 122));
        jLabel6.setText("GRN");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 178, 190, -1));

        jPanel6.setBackground(new java.awt.Color(55, 71, 79));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Return Purchase_50px.png"))); // NOI18N
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(84, 110, 122));
        jLabel8.setText("Return Stock");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 232, 190, -1));

        jPanel8.setBackground(new java.awt.Color(55, 71, 79));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Settings_50px.png"))); // NOI18N
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(84, 110, 122));
        jLabel12.setText("Settings");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 553, 190, -1));

        jPanel7.setBackground(new java.awt.Color(55, 71, 79));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Gender Neutral User_50px.png"))); // NOI18N
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(84, 110, 122));
        jLabel10.setText("Username");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 86, -1));

        SIDEBAR_LEFT.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 607, 190, -1));

        jPanel9.setBackground(new java.awt.Color(55, 71, 79));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Sider_Image/Geo-fence_50px.png"))); // NOI18N
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(84, 110, 122));
        jLabel14.setText("Company Name");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 110, -1));

        SIDEBAR_LEFT.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        getContentPane().add(SIDEBAR_LEFT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        STASTU.setBackground(new java.awt.Color(97, 97, 97));

        javax.swing.GroupLayout STASTULayout = new javax.swing.GroupLayout(STASTU);
        STASTU.setLayout(STASTULayout);
        STASTULayout.setHorizontalGroup(
            STASTULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        STASTULayout.setVerticalGroup(
            STASTULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(STASTU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, -1, -1));

        DISPLAY.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        DISPLAY.setAutoscrolls(true);

        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 700));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        DISPLAY.setViewportView(jPanel2);

        getContentPane().add(DISPLAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1320, 660));

        jMenu1.setText("File");
        MENU_BAR.add(jMenu1);

        EDIT.setText("Edit");

        UNDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        UNDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Undo_15px.png"))); // NOI18N
        UNDO.setText("Undo");
        UNDO.setEnabled(false);
        EDIT.add(UNDO);

        REDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        REDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Redo_15px.png"))); // NOI18N
        REDO.setText("Redo");
        REDO.setEnabled(false);
        EDIT.add(REDO);

        jSeparator1.setEnabled(false);
        EDIT.add(jSeparator1);

        CUT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Cut_15px.png"))); // NOI18N
        CUT.setText("Cut");
        EDIT.add(CUT);

        COPY.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        COPY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Copy_15px.png"))); // NOI18N
        COPY.setText("Copy");
        EDIT.add(COPY);

        PASTE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        PASTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Paste_15px.png"))); // NOI18N
        PASTE.setText("Paste");
        PASTE.setEnabled(false);
        EDIT.add(PASTE);

        HIS_PASTE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        HIS_PASTE.setText("Paste History");
        HIS_PASTE.setEnabled(false);
        EDIT.add(HIS_PASTE);

        DELETE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Delete_15px.png"))); // NOI18N
        DELETE.setText("Delete");
        DELETE.setEnabled(false);
        EDIT.add(DELETE);

        MENU_BAR.add(EDIT);

        VIEW.setText("View");

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jCheckBoxMenuItem1.setText("Status Bar");
        VIEW.add(jCheckBoxMenuItem1);

        MENU_BAR.add(VIEW);

        WINDOW.setText("Window");
        MENU_BAR.add(WINDOW);

        jMenu5.setText("About");
        MENU_BAR.add(jMenu5);

        setJMenuBar(MENU_BAR);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SIDEBAR_LEFTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIDEBAR_LEFTMouseClicked
            SideBar Slider_Animation = new SideBar(SIDEBAR_LEFT, DISPLAY); 
            Slider_Animation.Show(190, 3);                
    }//GEN-LAST:event_SIDEBAR_LEFTMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem COPY;
    private javax.swing.JMenuItem CUT;
    private javax.swing.JMenuItem DELETE;
    private javax.swing.JScrollPane DISPLAY;
    private javax.swing.JMenu EDIT;
    private javax.swing.JMenuItem HIS_PASTE;
    private javax.swing.JMenuBar MENU_BAR;
    private javax.swing.JMenuItem PASTE;
    private javax.swing.JMenuItem REDO;
    private javax.swing.JPanel SIDEBAR_LEFT;
    private javax.swing.JPanel STASTU;
    private javax.swing.JMenuItem UNDO;
    private javax.swing.JMenu VIEW;
    private javax.swing.JMenu WINDOW;
    public static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

}
