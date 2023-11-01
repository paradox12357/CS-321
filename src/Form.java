import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form extends JPanel
{
    private JLabel first, last, last4;
    public Form() 
    {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Enter Your Details");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel questions = new JPanel();
        questions.setLayout(new GridLayout(3,2));
        first = new JLabel("First Name: ");
        JTextField firstname = new JTextField(30);
        last = new JLabel("Last Name: ");
        JTextField lastname = new JTextField(30);
        last4 = new JLabel("SSN Last 4 Digits: ");
        JTextField ssn = new JTextField(30);

        questions.add(first);
        questions.add(firstname);
        questions.add(last);
        questions.add(lastname);
        questions.add(last4);
        questions.add(ssn);

        add(questions, BorderLayout.CENTER);

        JButton submit = new JButton("SUBMIT");
        submit.addActionListener(new SubmitListener());
        add(submit, BorderLayout.SOUTH);
    }

    public static boolean isAlphabetic(String s)
    {
        for(int x = 0; x < s.length(); x ++)
        {
            System.out.println(x + " " + s.charAt(x));
            if(!Character.isAlphabetic(s.charAt(x)))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String s)
    {
        for(int x = 0; x < s.length(); x ++)
        {
            if(!Character.isDigit(s.charAt(x)))
            {
                return false;
            }
        }
        return true;
    }

    private class SubmitListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            if(!isAlphabetic(first.getText().trim()) || first.getText().length() == 0) 
            {
                JOptionPane.showMessageDialog(null, "Please Enter A Valid First Name!");
            }
            else if(!isAlphabetic(last.getText().trim()) || last.getText().length() == 0)
            {
                JOptionPane.showMessageDialog(null, "Please Enter A Valid Last Name!");
            }
            else if(!isNumeric(last4.getText()))
            {
                JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN!");
            }
            else if(last4.getText().length() > 4)
            {
                JOptionPane.showMessageDialog(null, "Only Enter Last 4 Digits of SSN!");
            }
        }
    }
}

class FormFrame extends JFrame 
{
    public FormFrame() 
    {
        // Set the title of the JFrame
        setTitle("My Custom JFrame");

        // Create a JPanel of your choice
        Form form = new Form();
        // You can add components to the panel here if needed.

        // Add the panel to the JFrame
        add(form);

        // Set the size of the JFrame
        setSize(new Dimension(400, 300));

        // Make the JFrame close when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        // Create an instance of your custom JFrame
        FormFrame frame = new FormFrame();
    }
}
