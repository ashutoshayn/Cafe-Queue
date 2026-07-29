import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeGUI extends JFrame {
    
    private CafeQueue cafequeue;
    private DefaultListModel<String> listModel;
    private JList<String> queueList;
    
    private JTextField nameInput;
    private JButton btnAddStudent, btnAddTeacher, btnServe;
    
    public CafeGUI() {
        setTitle("WHS Cafe Queue");
        this.getContentPane().setPreferredSize(new Dimension(450, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); 
        
        cafequeue = new CafeQueue();
        listModel = new DefaultListModel<>();
        queueList = new JList<>(listModel);
    
        JPanel inputPanel = new JPanel();
        nameInput = new JTextField(10);
        btnAddStudent = new JButton("Add Student");
        btnAddTeacher = new JButton("Add Teacher");
        
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameInput);
        inputPanel.add(btnAddStudent);
        inputPanel.add(btnAddTeacher);
    
        JPanel controlPanel = new JPanel();
        btnServe = new JButton("Serve Next");
        controlPanel.add(btnServe);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(queueList), BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);

        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                cafequeue.enqueue(new Person(name, false));
                nameInput.setText(""); 
                updateQueueDisplay();
            }
        });
        
        btnAddTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                cafequeue.enqueue(new Person(name, true));
                nameInput.setText(""); 
                updateQueueDisplay();
            }
        });
        
        btnServe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cafequeue.queueEmpty()) {
                    cafequeue.dequeue();
                    updateQueueDisplay();
                }
            }
        });
        
        updateQueueDisplay();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void updateQueueDisplay() {
        listModel.clear();
        
        if (cafequeue.queueEmpty()) {
            listModel.addElement("The queue is empty.");
        } else {
            for (int i = 0; i < cafequeue.getQueue().size(); i++) {
                Person p = cafequeue.getQueue().get(i);
                listModel.addElement("[" + (i + 1) + "] " + p.toString());
            }
        }
    }
}