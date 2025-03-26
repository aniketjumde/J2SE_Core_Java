import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener 
{
    JLabel l1, l2;
    JTextField u;
    JPasswordField p;
    JButton b1, b2;

    LoginForm() {
        setLayout(null);

        l1 = new JLabel("Username:");
        l1.setSize(100, 30);
        l1.setLocation(30, 30);
        add(l1);

        u = new JTextField();
        u.setSize(200, 30);
        u.setLocation(150, 30);
        add(u);

        l2 = new JLabel("Password:");
        l2.setSize(100, 30);
        l2.setLocation(30, 80);
        add(l2);

        p = new JPasswordField();
        p.setSize(200, 30);
        p.setLocation(150, 80);
        add(p);

        b1 = new JButton("Login");
        b1.setSize(100, 30);
        b1.setLocation(50, 150);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setSize(100, 30);
        b2.setLocation(200, 150);
        b2.addActionListener(this);
        add(b2);

        setTitle("Login Form");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
    
        String S = ae.getActionCommand();

        if (S.equals("Login")) {
            String user = u.getText();
            String pass = new String(p.getPassword()); 

            if (user.equals("Aniket") && pass.equals("123")) {
                JOptionPane.showMessageDialog(this, "Login Successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed. Invalid Username or Password.");
            }
        }

        if (S.equals("Cancel")) {
            u.setText("");
            p.setText("");
        }
    }

    public static void main(String[] args) 
    {
        new LoginForm();
    }
}

