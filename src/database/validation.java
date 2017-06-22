/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXTextArea;
import org.jdesktop.swingx.JXTextField;

/**
 *
 * @author vextroidMAC
 */
public class validation {

    public static String emailget(String email) {
        String okemail = "wrong";
        String emailpattern = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailpattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            okemail = email;
        }

        return okemail;
    }

    public static String usernameget(String usr) {
        String usr2 = "";
        String usrpattern = "^[a-z0-9_-]{3,15}$";

        Pattern pattern = Pattern.compile(usrpattern);
        Matcher matcher = pattern.matcher(usr);

        if (matcher.matches()) {
            usr2 = usr;
        }

        return usr2;
    }

    public static boolean ValidatePhoneNumber(String sPhoneNumber) {

        Pattern pattern = Pattern.compile("\\d{9}");
        Matcher matcher = pattern.matcher(sPhoneNumber);

        if (matcher.matches()) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean emptyString(String emptytext) {

        Pattern pattern = Pattern.compile("/^$|\\s+/");
        Matcher matcher = pattern.matcher(emptytext);

        if (matcher.matches()) {
            return false;
        } else {

            return true;
        }
    }

    public static boolean onlyString(String onlystring) {

        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(onlystring);

        if (matcher.matches()) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean onlytextno(String textno) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9/]+");
        Matcher matcher = pattern.matcher(textno);

        if (matcher.matches()) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean gamiya(String textno) {

        Pattern pattern = Pattern.compile("[^/']+");
        Matcher matcher = pattern.matcher(textno);

        if (matcher.matches()) {

            return false;

        } else {
            System.out.println("42");
            return true;
        }
    }

    public static boolean ValidatePhoneNumbertxt(JXTextField jft) {

        Pattern pattern1 = Pattern.compile("[+]?[0-9]{2}[0-9]{9}");
        Pattern pattern2 = Pattern.compile("[0-9]{10}");
        Matcher matcher1 = pattern1.matcher(jft.getText());
        Matcher matcher2 = pattern2.matcher(jft.getText());

        if (matcher1.matches() || matcher2.matches()) {
            return true;
        } else {

            jft.setText("Phone number is invalid");
            jft.setForeground(Color.red);

            return false;
        }
    }

    public static boolean emptyStringtxt(JXTextField jft) {

        Pattern pattern = Pattern.compile("/^$|\\s+/");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            jft.setText("Please enter a value");
            jft.setForeground(Color.red);
            return false;
        } else {

            return true;
        }
    }

    public static boolean onlyStringtxt(JXTextField jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only String are allowed");
            jft.setForeground(Color.red);
            return false;
        }
    }

    public static boolean onlyStringtxt(JXTextArea jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only Letters are allowed");
            jft.setForeground(Color.red);

            return false;
        }
    }

    public static boolean onlytextnotxt(JXTextField jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9/ ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only Letters,Digits and / is allowed");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean gamiyatxt(JXTextField jft) {

        Pattern pattern = Pattern.compile("[^/']+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            jft.setText("");
            return false;

        } else {
            return true;
        }
    }

    public static boolean nictxt(JXTextField jft) {
        Pattern pattern;
        if (jft.getText().length() < 12) {
            pattern = Pattern.compile("^[0-9]{9}[vVxX]$");
            System.out.println("yes1");
        } else {
            pattern = Pattern.compile("^[0-9]{12}$");
            System.out.println("yes2");
        }
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("NIC is invalid");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean emailtxt(JXTextField jft) {

        String emailpattern = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailpattern);
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {

            return true;
        } else {
            jft.setText("Email is invalid");
            jft.setForeground(Color.red);
            return false;
        }
    }

    public static boolean priceamount(JXTextField jft) {

        Pattern p = Pattern.compile("[0-9.]+");
        Matcher m = p.matcher(jft.getText());
        if (m.find() && m.group().equals(jft.getText())) {
            return true;
        } else {
            jft.setText("Price include is incorrect");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean no(JXTextField jft) {

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(jft.getText());
        if (m.find() && m.group().equals(jft.getText())) {
            return true;
        } else {
            jft.setText("Only digits are allowed");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean ValidatePhoneNumbertxt(JTextField jft) {

        Pattern pattern1 = Pattern.compile("[+]?[0-9]{2}[0-9]{9}");
        Pattern pattern2 = Pattern.compile("[0-9]{10}");
        Matcher matcher1 = pattern1.matcher(jft.getText());
        Matcher matcher2 = pattern2.matcher(jft.getText());

        if (matcher1.matches() || matcher2.matches()) {
            return true;
        } else {

            jft.setText("Phone number is invalid");
            jft.setForeground(Color.red);

            return false;
        }
    }

    public static boolean emptyStringtxt(JTextField jft) {

        Pattern pattern = Pattern.compile("/^$|\\s+/");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            jft.setText("Please enter a value");
            jft.setForeground(Color.red);
            return false;
        } else {

            return true;
        }
    }

    public static boolean onlyStringtxt(JTextField jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only String are allowed");
            jft.setForeground(Color.red);
            return false;
        }
    }

    public static boolean onlyStringtxt(JTextArea jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only Letters are allowed");
            jft.setForeground(Color.red);

            return false;
        }
    }

    public static boolean onlytextnotxt(JTextField jft) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9/ ]+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("Only Letters,Digits and / is allowed");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean gamiyatxt(JTextField jft) {

        Pattern pattern = Pattern.compile("[^/']+");
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            jft.setText("");
            return false;

        } else {
            return true;
        }
    }

    public static boolean nictxt(JTextField jft) {
        Pattern pattern;
        if (jft.getText().length() < 12) {
            pattern = Pattern.compile("^[0-9]{9}[vVxX]$");
            System.out.println("yes1");
        } else {
            pattern = Pattern.compile("^[0-9]{12}$");
            System.out.println("yes2");
        }
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {
            return true;
        } else {
            jft.setText("NIC is invalid");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean emailtxt(JTextField jft) {

        String emailpattern = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailpattern);
        Matcher matcher = pattern.matcher(jft.getText());

        if (matcher.matches()) {

            return true;
        } else {
            jft.setText("Email is invalid");
            jft.setForeground(Color.red);
            return false;
        }
    }

    public static boolean priceamount(JTextField jft) {

        Pattern p = Pattern.compile("[0-9.]+");
        Matcher m = p.matcher(jft.getText());
        if (m.find() && m.group().equals(jft.getText())) {
            return true;
        } else {
            jft.setText("Price include is incorrect");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean no(JTextField jft) {

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(jft.getText());
        if (m.find() && m.group().equals(jft.getText())) {
            return true;
        } else {
            jft.setText("Only digits are allowed");
            jft.setForeground(Color.red);
            return false;

        }
    }

    public static boolean empfields(JTextField[] jtfa) {
        boolean b = true;
        for (int i = 0; i < jtfa.length; i++) {
            if (jtfa[i].getText().isEmpty()) {
                b = false;
                break;
            }
        }
        return b;
    }
    public static void makeempty(JTextField[] jtfa) {
        boolean b = true;
        for (int i = 0; i < jtfa.length; i++) {
          jtfa[i].setText("");
          jtfa[i].setForeground(Color.BLACK);
        }
        
    }
    
    
}
