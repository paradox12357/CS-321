import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormFrame extends JFrame 
{
    public FormFrame(Workflow workflow) 
    {
        setTitle("Form");

        DataEntry form = new DataEntry(workflow);
        add(form);

        setSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
