import javax .swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblhead,lblRno;
JTextField txtRno;
JButton btnDelete, btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(null);
Color bgColor = Color.ORANGE;
c.setBackground(bgColor); 

lblhead = new JLabel(" !!!   Delete Record   !!! ");
lblRno = new JLabel("Enter Roll No. : ");
txtRno = new JTextField(20);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");

Font f = new Font("Courier", Font.BOLD | Font.ITALIC, 30);
lblhead.setFont(f);
lblRno.setFont(f);
txtRno.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);

lblhead.setBounds(200, 10, 400,30);
lblRno.setBounds(50, 100, 400,30);
txtRno.setBounds(50, 150, 500,40);
btnDelete.setBounds(50, 480, 150,60);
btnBack.setBounds(500, 480, 150,60);

c.add(lblhead);
c.add(lblRno);
c.add(txtRno);
c.add(btnDelete);
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
