import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Approval extends JPanel{

    private DocumentRequest DRform;
    private int SSN;
    private String firstname;
    private String lastname;
    private Workflow entry;
    private String email;
    private boolean finished;

    public Approval(Workflow entry, DocumentRequest DRForm){
        loadData(entry, DRForm);
        finished = false;
        showScreen();
    }

    public void showScreen(){
        JFrame frame = new JFrame("Approval Screen");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        // Create components
        JLabel displayArea = new JLabel();
        JButton validateButton = new JButton("Validate Data");
        JButton returnButton = new JButton("Return to Previous Screen");
        JButton exitButton = new JButton("Exit Screen");

        String screenContent = "Name: " + firstname + " " + lastname + "\nSSN: " + SSN + "\nDocument Request Details:\n" +
                        "\tDocument : " + DRform.getField() + "\n";

        displayArea.setText(screenContent);

        
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement logic for returning to the previous screen
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new FlowLayout()); // Use FlowLayout
        panel.add(displayArea);
        panel.add(validateButton);
        panel.add(returnButton);

        frame.add(panel, BorderLayout.CENTER);

        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkData()) {
                    displayArea.setText("Validation Successful!\n Documents:" + DRform.getField() + " have been sent to your email.");
                    panel.remove(returnButton);
                    panel.remove(validateButton);
                    panel.add(exitButton);
            
                    panel.revalidate();
                    panel.repaint();

                    finished = true;

                } else {
                    displayArea.setText("Validation Failed.\n Return to previous screen to change information.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearScreen(frame);
            }
        });

        frame.setVisible(true);
    }
    
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

    public String generateEmail(){
        return "Documents: " + DRform.getField();
    }

    public void clearScreen(JFrame frame){
        frame.dispose();
    }

    public boolean getFinished(){
        return finished;
    }

    public static void main(String[] args){
        DocumentRequest dr = new DocumentRequest();
        dr.update("Form 1, Form 2, Form 3");

        DataEntry en = new DataEntry("John", "Doe", 1111);

        Workflow entry = new Workflow();
        entry.addEntry(en);

        Approval approval = new Approval(entry, dr);
    }
}
