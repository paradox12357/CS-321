import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Review extends JPanel 
{
    private JTextField firstname, lastname, ssn;
    private String first = "";
    private String last = "";
    private String social = "";
    private int immigrant;
    JPanel questions = new JPanel();
    public Review() 
    {
        loadData();
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Review the following information:");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
        questions.setLayout(new GridLayout(3,2));
        JLabel first = new JLabel("First Name = " + this.first);
        firstname = new JTextField(30);
        JLabel last = new JLabel("Last Name = " + this.last);
        lastname = new JTextField(30);
        JLabel last4 = new JLabel("SSN Last 4 Digits = " + this.social);
        ssn = new JTextField(30);

        questions.add(first);
        questions.add(firstname);
        questions.add(last);
        questions.add(lastname);
        questions.add(last4);
        questions.add(ssn);

        add(questions, BorderLayout.CENTER);

        JButton submit = new JButton("SUBMIT CHANGES");
        submit.addActionListener(new SubmitListener(this));
        add(submit, BorderLayout.SOUTH);
        JButton confirm = new JButton("FINALIZE CHANGES");
        confirm.addActionListener(new ConfirmListener(this));
        add(confirm, BorderLayout.NORTH);
    }

    public static boolean isAlphabetic(String s)
    {
        s = s.trim();
        for(int x = 0; x < s.length(); x ++)
        {
            if(!Character.isAlphabetic(s.charAt(x)))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String s)
    {
        s = s.trim();
        for(int x = 0; x < s.length(); x ++)
        {
            if(!Character.isDigit(s.charAt(x)))
            {
                return false;
            }
        }
        return true;
    }

    public String getFirstName()
    {
        return firstname.getText().trim();
    }

    public String getLastName()
    {
        return lastname.getText().trim();
    }

    public String getSSN()
    {
        return ssn.getText().trim();
    }

    public void loadData()
    {
        this.first = "John";
        this.last = "Doe";
        this.social = "1234";
    }

    public void editData()
    {
        this.first = getFirstName();
        this.last = getLastName();
        this.social = getSSN();
    }

    public boolean validateData()
    {
        if(!isAlphabetic(firstname.getText()) || firstname.getText().length() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid First Name!");
            return false;
        }
        else if(!isAlphabetic(lastname.getText()) || lastname.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid Last Name!");
            return false;
        }
        else if(!isNumeric(ssn.getText()))
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN!");
            return false;
        }
        else if(ssn.getText().trim().length() < 4)
        {
            JOptionPane.showMessageDialog(null, "Please Enter Last 4 Digits Of SSN!");
            return false;
        }
        else if(ssn.getText().trim().length() > 4)
        {
            JOptionPane.showMessageDialog(null, "Please Only Enter Last 4 Digits Of SSN!");
            return false;
        }
        return true;
    }

    private class SubmitListener implements ActionListener 
    {
        private Review form;
        public SubmitListener(Review r)
        {
            this.form = r;
        }
        public void actionPerformed(ActionEvent e)
        {

            if(!form.validateData())
            {
                return;
            }
            form.editData();
            questions.removeAll();
            setLayout(new BorderLayout());
            JLabel title = new JLabel("Review the following information:");
            title.setHorizontalAlignment(JLabel.CENTER);
            add(title, BorderLayout.NORTH);
            questions.setLayout(new GridLayout(3,2));
            JLabel first = new JLabel("First Name = " + form.first);
            firstname = new JTextField(30);
            JLabel last = new JLabel("Last Name = " + form.last);
            lastname = new JTextField(30);
            JLabel last4 = new JLabel("SSN Last 4 Digits = " + form.social);
            ssn = new JTextField(30);

            questions.add(first);
            questions.add(firstname);
            questions.add(last);
            questions.add(lastname);
            questions.add(last4);
            questions.add(ssn);

            add(questions, BorderLayout.CENTER);

            JButton submit = new JButton("SUBMIT CHANGES");
            submit.addActionListener(new SubmitListener(form));
            add(submit, BorderLayout.SOUTH);
            JButton confirm = new JButton("FINALIZE CHANGES");
            confirm.addActionListener(new ConfirmListener(form));
            add(confirm, BorderLayout.NORTH);
            questions.validate();
            questions.repaint();
        }
    }

    public class ConfirmListener implements ActionListener
    {
        private Review form;
        public ConfirmListener(Review r)
        {
            this.form = r;
        }
        public void actionPerformed(ActionEvent e)
        {
            form.pass();
        }
    }

    public void pass()
    {
        //pass data to next screen
        JOptionPane.showMessageDialog(null, "Review Complete.");
    }

    public static void showScreen()
    {
        ReviewFrame frame = new ReviewFrame();
    }

    public static void main(String[] args) 
    {
        showScreen();
    }
}

class ReviewFrame extends JFrame 
{
    public ReviewFrame() 
    {
        setTitle("Review");

        Review form = new Review();
        add(form);

        setSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
