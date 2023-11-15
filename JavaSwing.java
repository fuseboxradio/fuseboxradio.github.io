import javax.swing.*; //for being able to use Swing for a super basic graphical interface
import java.awt.event.ActionEvent; // for setting up an action for the button 
import java.awt.event.ActionListener; // for setting up what happens after the action [aka clicking on a button as an action event]

// More Information (Geeks for Geeks): https://www.geeksforgeeks.org/introduction-to-java-swing/# 
// Basically experimenting with a super basic use of Java Swing for creating a graphical user interface (GUI) that uses button clicks to move onto other steps - basically how most of us interact with computers on a regular basis.

public class JavaSwing {
	//the public class name for this example
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("A Super Simple Graphic User Interface"); 
        // sets up the description at the top of the frame
        
        JButton button = new JButton("Click Me!"); 
        // sets up a button and what the button will display as a message
        
        button.setBounds(50, 50, 100, 30); 
        // sets up the button's position and size
        // More Information (Tutorial Point): https://www.tutorialspoint.com/what-is-the-use-of-setbounds-method-in-java
        
        frame.add(button); 
        // adds a button into the frame
        
        frame.setSize(300, 200); 
        // sets up the frame's size
        
        frame.setLayout(null); 
        // Set up the overall layout (null for absolute aka exact positioning based off of bounds with x & y positioning   
        
        frame.setVisible(true); 
        // Make the graphic's frame visible for all to view via "true" statement
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Closes out the operation to move to next steps via the action listener on the button
        // AKA exits and moves to the next phase of action/actions after a user clicks the button (aka what is the actual action event)
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hi there - thanks for clicking me!"); 
                // Shows a message after clicking on the 1st button; you can hit ok and then exit out of this new frame with dialog
            }
        });
    }
}
