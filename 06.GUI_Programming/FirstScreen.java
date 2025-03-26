import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstScreen extends JFrame implements ActionListener 
{
    JLabel l;
    JTextField tf;
    JButton b1, b2;

    FirstScreen() 
    {
        setLayout(null);

        l = new JLabel("Message");
        l.setSize(100, 30);
        l.setLocation(50, 30); // ✅ Corrected typo
        add(l);

        tf = new JTextField();
        tf.setSize(200, 30);
        tf.setLocation(150, 30);
        add(tf);

        b1 = new JButton("OK");
        b1.setSize(100, 30);
        b1.setLocation(50, 100);
        b1.addActionListener(this); // ✅ Added ActionListener
        add(b1);

        b2 = new JButton("Cancel");
        b2.setSize(100, 30);
        b2.setLocation(200, 100);
        b2.addActionListener(this); // ✅ Added ActionListener
        add(b2);

        setTitle("First Screen");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == b1) {
            System.out.println("Welcome to Screen");
        } else if (ae.getSource() == b2) {
            System.out.println("Cancel button clicked");
        }
    }

    public static void main(String[] args) {
        new FirstScreen();
    }
}

