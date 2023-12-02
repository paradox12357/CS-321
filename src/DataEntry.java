import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataEntry extends JPanel
{
    private JTextField firstname, lastname, ssn, email, id;
    private Workflow workflow;
    public DataEntry(Workflow workflow) 
    {
        this.workflow = workflow;

        setLayout(new BorderLayout());
        JLabel title = new JLabel("Enter Your Details");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel questions = new JPanel();
        questions.setLayout(new GridLayout(3,2));
        JLabel first = new JLabel("First Name: ");
        firstname = new JTextField(30);
        JLabel last = new JLabel("Last Name: ");
        lastname = new JTextField(30);
        JLabel last4 = new JLabel("SSN Last 4 Digits: ");
        ssn = new JTextField(30);
        JLabel mail = new JLabel("Email: ");
        email = new JTextField(30);
        JLabel ide = new JLabel("ID: ");
        id = new JTextField(30);

        questions.add(first);
        questions.add(firstname);
        questions.add(last);
        questions.add(lastname);
        questions.add(last4);
        questions.add(ssn);
        questions.add(mail);
        questions.add(email);
        questions.add(ide);
        questions.add(id);

        add(questions, BorderLayout.CENTER);

        JButton submit = new JButton("SUBMIT");
        submit.addActionListener(new SubmitListener(this));
        add(submit, BorderLayout.SOUTH);
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

    public String getEmail()
    {
        return email.getText().trim();
    }

    public String getID()
    {
        return id.getText().trim();
    }

    public void validateData()
    {
        if(!isAlphabetic(firstname.getText()) || firstname.getText().length() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid First Name!");
        }
        else if(!isAlphabetic(lastname.getText()) || lastname.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid Last Name!");
        }
        else if(!isNumeric(ssn.getText()))
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN!");
        }
        else if(ssn.getText().trim().length() < 4)
        {
            JOptionPane.showMessageDialog(null, "Please Enter Last 4 Digits Of SSN!");
        }
        else if(ssn.getText().trim().length() > 4)
        {
            JOptionPane.showMessageDialog(null, "Please Only Enter Last 4 Digits Of SSN!");
        }
    }

    private class SubmitListener implements ActionListener 
    {
        private DataEntry form;
        public SubmitListener(DataEntry d)
        {
            this.form = d;
        }
        public void actionPerformed(ActionEvent e)
        {
            form.validateData();
            workflow.addEntry(form);
            setVisible(false);
            workflow.continueWorkflow = true;
        }
    }
}


