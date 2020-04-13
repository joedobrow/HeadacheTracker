import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HeadacheTrackerMain {

   public static void main(String[] args) {

      new SimpleJButton();
   }

}

public class SimpleJButton {

   SimpleJButton(){    

      JFrame f = new JFrame("Headache Reporter");            
      JButton b = new JButton("New Headache");
      JButton c = new JButton("See Data");
      b.setBounds(50, 20, 140, 40);
      c.setBounds(240, 20, 140, 40);  
      f.setLocationRelativeTo(null);
      f.add(c);   
      f.add(b);   
      f.setSize(430, 100);    
      f.setLayout(null);
      f.setVisible(true);    
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            new HeadacheReport();
         }
      });   
   }         
}

public class HeadacheReport {
   static JTextField textfield1, textfield2, textfield3;

   HeadacheReport() {

      String filepath = "/Users/jdobrow/Code/HeadacheTracker/records.txt";
      String id = "1";
      String length;
      String intensity;
      String taken;

      JFrame f = new JFrame("Headache Report");
      f.getContentPane().setLayout(new FlowLayout());
      textfield1 = new JTextField("Length in Hours",10);
      textfield2 = new JTextField("Intensity",10);
      textfield3 = new JTextField("Advil Taken?",10);
      f.setLocationRelativeTo(null);
      f.getContentPane().add(textfield1);
      f.getContentPane().add(textfield2);
      f.getContentPane().add(textfield3);
      textfield1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String length=textfield1.getText();
            String intensity=textfield2.getText();
            String taken=textfield3.getText();
            WriteRecord.saveRecord(id, length, intensity, taken, filepath);
         }
      });
      textfield2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String length=textfield1.getText();
            String intensity=textfield2.getText();
            String taken=textfield3.getText();
            WriteRecord.saveRecord(id, length, intensity, taken, filepath);
         }
      });
      textfield3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String length=textfield1.getText();
            String intensity=textfield2.getText();
            String taken=textfield3.getText();
            WriteRecord.saveRecord(id, length, intensity, taken, filepath);
         }
      });
      
      f.pack();
      f.setVisible(true);
   }
}

public class WriteRecord {

   public static void saveRecord(String id, String length, String intensity, String taken, String filepath) {

      try {
         FileWriter fw = new FileWriter(filepath, true);
         PrintWriter pw = new PrintWriter(fw);

         pw.println(id+","+length+","+intensity+","+taken);
         pw.flush();
         pw.close();

         JOptionPane.showMessageDialog(null, "Record saved.");
      }
      catch(Exception E) {
         JOptionPane.showMessageDialog(null, "Error.");
      }
   }
}