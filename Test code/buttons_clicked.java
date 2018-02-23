import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
public class buttons_clicked extends JFrame implements ActionListener{
  
  private JButton btn;
  private JButton red,blue,green;
  private JLabel label;
  
  public buttons_clicked()
  {
    btn = new JButton("Click here to change label");
    btn.addActionListener(this);
    add(btn);
    
    red = new JButton("red");
    red.addActionListener(this);
    add(red);
    
    green = new JButton("green");
    green.addActionListener(this);
    add(green);
    blue = new JButton("blue");
    blue.addActionListener(this);
    add(blue);
    
    setLayout(new FlowLayout());
    setSize(700,700);
    setTitle("Bit Life - Java program Buttons Clicked");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    label = new JLabel("what is happening ?");
    add(label);
    
  }
  
  public static void main(String[] args) 
  {
    new buttons_clicked();
  }
  
  public void actionPerformed(ActionEvent e) 
  {
    if(e.getSource() == btn)
    {
      label.setText("button clicked");
      
    }
    
    if (e.getSource() == red)
    {
      label.setText("red selected");
      getContentPane().setBackground(Color.RED);
      
    }
    
    if (e.getSource() == green)
    {
      label.setText("green selected");
      getContentPane().setBackground(Color.GREEN);
    }
    
    if(e.getSource() == blue)
    {
      label.setText("blue selected");
      getContentPane().setBackground(Color.BLUE);
    }
  }
}