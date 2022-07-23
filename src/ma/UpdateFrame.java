import javax .swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblhead,lblRno, lblName, lblSub1, lblSub2, lblSub3;
JTextField txtRno, txtName, txtSub1, txtSub2, txtSub3;
JButton btnSave, btnBack;

UpdateFrame(){
c = getContentPane();
c.setLayout(null);
Color bgColor = Color.LIGHT_GRAY;
c.setBackground(bgColor); 

lblhead = new JLabel(" !!!   Update Record   !!! ");
lblRno = new JLabel("Enter Roll No. : ");
txtRno = new JTextField(20);
lblName = new JLabel("Enter Name : ");
txtName = new JTextField(20);
lblSub1 = new JLabel("Enter Marks of Subject 1 : "); 
txtSub1 = new JTextField(20);
lblSub2 = new JLabel("Enter Marks of Subject 2 : "); 
txtSub2 = new JTextField(20);
lblSub3 = new JLabel("Enter Marks of Subject 3 : "); 
txtSub3 = new JTextField(20);
btnSave = new JButton("Save");
btnBack = new JButton("Back");

Font f = new Font("Courier", Font.BOLD | Font.ITALIC, 20);
lblhead.setFont(f);
lblRno.setFont(f);
txtRno.setFont(f);
lblName.setFont(f);
txtName.setFont(f);
lblSub1.setFont(f);
txtSub1.setFont(f);
lblSub2.setFont(f);
txtSub2.setFont(f);
lblSub3.setFont(f);
txtSub3.setFont(f);
btnSave.setFont(f);
btnBack.setFont(f);

lblhead.setBounds(250, 10, 400,30);
lblRno.setBounds(50, 50, 400,30);
txtRno.setBounds(50, 80, 500,40);
lblName.setBounds(50, 150, 400,30);
txtName.setBounds(50, 180, 500,40);
lblSub1.setBounds(50, 250, 400,30);
txtSub1.setBounds(50, 280, 500,40);
lblSub2.setBounds(50, 350, 400,30);
txtSub2.setBounds(50, 380, 500,40);
lblSub3.setBounds(50, 450, 400,30);
txtSub3.setBounds(50, 480, 500,40);
btnSave.setBounds(50, 570, 100,60);
btnBack.setBounds(500, 570, 100,60);

c.add(lblhead);
c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblSub1);
c.add(txtSub1);
c.add(lblSub2);
c.add(txtSub2);
c.add(lblSub3);
c.add(txtSub3);
c.add(btnSave);
c.add(btnBack);

ActionListener a2 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);

setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
