
/**
 * @author Ashutosh Aryan
 * @version 19/06/2026
 */
import javax.swing.*;
import java.awt.*;
public class CafeGUI extends JFrame
{
    
    private CafeQueue cafequeue;
    private DefaultListModel<String> listModel;
    private JList <String> queueList;
    
    public CafeGUI(){
        setTitle("WHS Cafe Queue");
        
        // Window size
        this.getContentPane().setPreferredSize(new Dimension (400, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Most of code goes here.
        cafequeue = new CafeQueue();
        
        listModel = new DefaultListModel<>();
        listModel.addElement("Student 1");
        listModel.addElement("Student 2");
        listModel.addElement("Student 3");
        listModel.addElement("Student 4");
        listModel.addElement("Student 5");
        
        queueList = new JList<>(listModel);
        
        JScrollPane scrollPane = new JScrollPane(queueList);
        
        this.add(scrollPane, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        //Making the window visible
        this.pack();
        this.toFront();
        this.setVisible(true);
    }
    
    public void updateQueueDisplay(){
        listModel.clear();
        
        if (cafequeue.queueEmpty()) {
            listModel.addElement("The queue is empty.");
        } else {
            // Loop through the queue and add everyone to the screen
            for (Person p : cafequeue.getQueue()) {
                listModel.addElement(p.toString());
            }
        }
    }
}