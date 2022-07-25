//Imports needed
import javax .swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// Adding DeleteFrame to GUIWindow using Swings
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

//Declaring Elements
lblhead = new JLabel(" !!!   Delete Record   !!! ");
lblRno = new JLabel("Enter Roll No. : ");
txtRno = new JTextField(20);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");

//Setting up the Font
Font f = new Font("Courier", Font.BOLD | Font.ITALIC, 30);
lblhead.setFont(f);
lblRno.setFont(f);
txtRno.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);

//Placing Elements
lblhead.setBounds(200, 10, 400,30);
lblRno.setBounds(50, 100, 400,30);
txtRno.setBounds(50, 150, 500,40);
btnDelete.setBounds(50, 480, 150,60);
btnBack.setBounds(500, 480, 150,60);

//Adding Elements to Gui Window
c.add(lblhead);
c.add(lblRno);
c.add(txtRno);
c.add(btnDelete);
c.add(btnBack);

//Adding Action to Delete Button to delete a record
ActionListener a1 = (ae) ->{
try{
	int rno = Integer.parseInt(txtRno.getText());
	if (rno<1) {
		throw new Exception("Rno should be positive integer and greater then 0");
	}
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	String url = "jdbc:mysql://localhost:3306/smsproject";
	String un = "root";
	String pw = "abc456";
	Connection con = DriverManager.getConnection(url,un,pw);	
	String sql = "delete from student where rno=?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	pst.executeUpdate();
	JOptionPane.showMessageDialog(c, "Record Deleted");
	con.close();	
}catch(SQLException e){
	JOptionPane.showMessageDialog(c, "Issue = " +e);
}catch(NumberFormatException e){
	JOptionPane.showMessageDialog(c, "Issue = Field cannot be empty");
}catch(Exception e){
	JOptionPane.showMessageDialog(c, e.getMessage());
}
txtRno.setText("");
txtRno.requestFocus();
};
btnDelete.addActionListener(a1);

//Adding Action to Back Button to go back to HomePage
ActionListener a2 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);

//Setting the GUI Windiow Specifications
setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
