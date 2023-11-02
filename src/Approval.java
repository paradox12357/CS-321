import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Approval extends JPanel{

    private DocumentRequest DRform;
    private int SSN;
    private String firstname;
    private String lastname;
    private Workflow entry;

    public Approval(Workflow entry, DocumentRequest DRForm){
        loadData(entry, DRForm);

        JFrame frame = new JFrame("Approval Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JLabel displayArea = new JLabel();
        JButton showButton = new JButton("Show Information");
        JButton validateButton = new JButton("Validate Data");
        JButton returnButton = new JButton("Return to Previous Screen");


        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(checkData()){
                    displayArea.setText("Validation Successful!\n Documents have been sent to your email");
                }
                else{
                    displayArea.setText("Validation Failed\n Contact Reviewer to change Data");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve information from the Approval object and display it in the JTextArea

                String screenContent = "Name: " + firstname + " " + lastname + "\nSSN: " + SSN + "\nDocument Request Details:\n" +
                        "\tDocument : " + DRform.getField() + "\n";

                displayArea.setText(screenContent);
            }
        });

        /*
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        }); */

        // Create a panel for the components
        JPanel panel = new JPanel();
        panel.add(displayArea);
        panel.add(showButton);
        panel.add(validateButton);
        panel.add(returnButton);


        // Add the panel to the JFrame
        frame.add(panel, BorderLayout.CENTER);
        
        // Make the JFrame visible
        frame.setVisible(true);
    }

    /*public void showScreen(){
        new Approval();
    }*/
    
    public void loadData(Workflow entry, DocumentRequest DRForm){
        this.DRform = DRForm;
        this.entry = entry;
        this.SSN = entry.getEntry().getSSN();
        this.firstname = entry.getEntry().getFirstName();
        this.lastname = entry.getEntry().getLastName();
    }

    public boolean checkData(){
        if(DRform.getField() == null || entry == null || firstname == null || lastname == null){
            return false;
        }
        if(SSN < 1000 || SSN > 9999){
            return false;
        }
        return true;
    }
    
    public boolean edit(){
        return true;
    }

    public String generateEmail(){
        return "Documents: ";
    }

    public static void main(String[] args){
        DocumentRequest dr = new DocumentRequest();
        dr.update("Some Form");

        DataEntry en = new DataEntry("John", "Doe", 1111);

        Workflow entry = new Workflow();
        entry.addEntry(en);

        Approval approval = new Approval(entry, dr);
    }
}
