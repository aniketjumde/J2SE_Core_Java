import javax.swing.*;

public class FirstScreen extends JFrame 
{
    JLabel l;
    JTextField tf;
    JButton b1, b2;

    FirstScreen() 
    {
        setLayout(null);

        l = new JLabel("Message");
        l.setSize(100,30);
        l.setLoaction(50,30);
        add(l);

        tf = new JTextField();
        tf.setSize(200,30);
        tf.setLocation(200,30);
        add(tf);

        b1 = new JButton("OK");
        b1.setBounds(50, 100, 100, 30);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(200, 100, 100, 30);
        add(b2);

        setTitle("First Screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new FirstScreen();
    }
}

