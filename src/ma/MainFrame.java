//Imports Needed
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//MainFrame Which shows GUI window using swings JFrame
class MainFrame extends JFrame{
Container c;
JLabel lblhead;
JButton btnAdd, btnView, btnUpdate, btnDelete;

MainFrame(){
c = getContentPane();
c.setLayout(null);
Color bgColor = Color.CYAN;
c.setBackground(bgColor); 

//Declaring Labels
lblhead = new JLabel(" !!!   Student Managemet System   !!! ");
btnAdd = new JButton("ADD");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");

//Setting Font
Font f = new Font("Courier", Font.BOLD, 30);
lblhead.setFont(f);
btnAdd.setFont(f);
btnView.setFont(f);
btnUpdate.setFont(f);
btnDelete.setFont(f);

//Placing Elements
lblhead.setBounds(80, 30, 550,60);
btnAdd.setBounds(150, 130, 400,60);
btnView.setBounds(150, 230, 400,60);
btnUpdate.setBounds(150, 330, 400,60);
btnDelete.setBounds(150, 430, 400,60);

//Adding Elements to Window
c.add(lblhead);
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

//Adding Action to Add Button
ActionListener a1 = (ae) ->{
AddFrame a = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

//Adding Action to View Button
ActionListener a2 = (ae) ->{
ViewFrame v = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

//Adding Action to Update Button
ActionListener a3 = (ae) ->{
UpdateFrame u = new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a3);

//Adding Action to Delete Button
ActionListener a4 = (ae) ->{
DeleteFrame d = new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a4);

//Setting up GUI Window Specifications
setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
