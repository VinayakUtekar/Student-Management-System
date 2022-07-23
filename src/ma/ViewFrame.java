import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFrame extends JFrame{
Container c;
JLabel lblhead;
TextArea taData;
JButton btnBack;

ViewFrame(){
c = getContentPane();
c.setLayout(null);

lblhead = new JLabel(" !!!   View Record   !!! ");
taData = new TextArea(10,30);
btnBack = new JButton("Back");

Font f = new Font("Courier", Font.BOLD, 30);
Font fe = new Font("Courier", Font.BOLD, 20);
lblhead.setFont(f);
taData.setFont(fe);
btnBack.setFont(f);

lblhead.setBounds(200, 10, 400,30);
taData.setBounds(50, 70, 560,400);
btnBack.setBounds(350, 550, 150,60);

c.add(lblhead);
c.add(taData);
c.add(btnBack);
ActionListener a1 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
