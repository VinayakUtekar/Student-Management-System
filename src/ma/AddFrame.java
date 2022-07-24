//Imports Needed
import javax .swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//AddFrame to set to GUI Window using Swings JFrame
class AddFrame extends JFrame{
Container c;
JLabel lblhead,lblRno, lblName, lblSub1, lblSub2, lblSub3;
JTextField txtRno, txtName, txtSub1, txtSub2, txtSub3;
JButton btnSave, btnBack;

AddFrame(){
c = getContentPane();
c.setLayout(null);
Color bgColor = Color.LIGHT_GRAY;
c.setBackground(bgColor); 

//Declaring Elements
lblhead = new JLabel(" !!!   Create Record   !!! ");
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

//Setting up the Font
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

//Placing the Elements
lblhead.setBounds(200, 10, 400,30);
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

//Adding the Elements
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

//Adding Action to Save Button and 
//Performing proper Syntax for Database Operations
ActionListener a1 = (ae) ->{
try
{
	int rno = Integer.parseInt(txtRno.getText());
	String name = txtName.getText();
	double sub1 = Double.parseDouble(txtSub1.getText());
	double sub2 = Double.parseDouble(txtSub2.getText());
	double sub3 = Double.parseDouble(txtSub3.getText());
	if (rno<1) {
		throw new Exception("Rno should be positive integer and greater then 0");
	}
	else if (! (name.matches("[a-zA-Z]+"))){
		throw new Exception("Name should conatins only letters");
	}
	else if(name.length()<2){
		throw new Exception("Name should contain atleast 2 Alphabets");
	}
	if((sub1 < 0) || (sub1 > 100)){
		throw new Exception("Marks should be between 0-100");
	}
	if((sub2 < 0) || (sub2 > 100)){
		throw new Exception("Marks should be between 0-100");
	}
	if((sub3 < 0) || (sub3 > 100)){
		throw new Exception("Marks should be between 0-100");
	}
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	String url = "jdbc:mysql://localhost:3306/smsproject";
	String un = "root";
	String pw = "abc456";
	Connection con = DriverManager.getConnection(url,un,pw);	
	String sql = "insert into student values(?, ?, ?, ?, ?)";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	pst.setString(2, name);
	pst.setDouble(3, sub1);
	pst.setDouble(4, sub2);
	pst.setDouble(5, sub3);
	pst.executeUpdate();
	JOptionPane.showMessageDialog(c, "Record Added");
	con.close();	
}catch(SQLException e){
	JOptionPane.showMessageDialog(c, "Issue = " +e);
}catch(NumberFormatException e){
	JOptionPane.showMessageDialog(c, "Issue = Field cannot be empty");
}catch(Exception e){
	JOptionPane.showMessageDialog(c, e.getMessage());
}
txtRno.setText("");
txtName.setText("");
txtSub1.setText("");
txtSub2.setText("");
txtSub3.setText("");
txtRno.requestFocus();
};
btnSave.addActionListener(a1);

//Adding Action to Back Button to go Back to MainFrame
ActionListener a2 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);

//Setting up the GUI Window Specifications
setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
