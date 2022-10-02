 

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Rehan Javed
 * @version 1.0
 *
 */
public class TomCatUI extends JFrame {

    // Attributes
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField pathField;
    private JLabel title, tomcatFolderTitleLabel, statusLabel;
    private JButton selectButton, startButton, stopButton;
    private PathHelper pathHelper;

    /**
     * Constructor for Tom Cat UI.
     */
    public TomCatUI() {
        
        // Path Helper..
        pathHelper = PathHelper.getPathHelper();
        
        setTitle("TOMCAT CONTROLLER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 210);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Adding Components..
        addComponents();
        
        // Listeners for buttons..

        startButton.addActionListener(action -> {
            
        
            try {
                ShellExecutor.executeShellFile(ShellExecutor.TOMCAT_START, pathHelper);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error occured while Starting Tomcat: "+e.toString());
            }
         
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            stopButton.setForeground(Color.RED);
            
        });
        
        stopButton.addActionListener(action -> {
            
       
            try {
                ShellExecutor.executeShellFile(ShellExecutor.TOMCAT_SHUTDOWN, pathHelper);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error occured while Stopping Tomcat: "+e.toString());
            }
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            startButton.setForeground(Color.GREEN);
            
        });
        
    }
    
    /**
     * Creating and adding components on the screen.
     */
    private void addComponents() {
        
   
        



      
        
        startButton = new JButton("Start");
        startButton.setBackground(Color.WHITE);
        startButton.setBounds(75, 20, 150, 70);
        contentPane.add(startButton);
        
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        stopButton.setBackground(Color.WHITE);
        stopButton.setBounds(75, 90, 150, 70);
        contentPane.add(stopButton);
        
    }
    
    /**
     * Main method to run the program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
    
            public void run() {
            
                // running the GUI.
                new TomCatUI().setVisible(true);
                
            }
        });
    
    }
    
}
