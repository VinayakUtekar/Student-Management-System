//Import Needed
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//Adding ViewFrame GUI Window Using Swings JFrame
class ViewFrame extends JFrame{
Container c;
JLabel lblhead;
TextArea taData;
JButton btnBack;

ViewFrame(){
c = getContentPane();
c.setLayout(null);

//Declaring Elements
lblhead = new JLabel(" !!!   View Record   !!! ");
taData = new TextArea(10,30);
btnBack = new JButton("Back");

//Setting up the Font
Font f = new Font("Courier", Font.BOLD, 30);
Font fe = new Font("Courier", Font.BOLD, 20);
lblhead.setFont(f);
taData.setFont(fe);
btnBack.setFont(f);

//Placing Elements
lblhead.setBounds(200, 10, 400,30);
taData.setBounds(50, 70, 560,400);
btnBack.setBounds(350, 550, 150,60);

//Reteriving Data From Database
StringBuffer data = new StringBuffer();
try{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	String url = "jdbc:mysql://localhost:3306/smsproject";
	String un = "root";
	String pw = "abc456";
	Connection con = DriverManager.getConnection(url,un,pw);
	String sql = "select * from student";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		int rno = rs.getInt(1);
		String name = rs.getString(2);
		Double sub1 = rs.getDouble(3);
		Double sub2 = rs.getDouble(4);
		Double sub3 = rs.getDouble(5);
		data.append("Rno:" + rno + " | " + " Name:" + name + " | "+ " Subject1:" + sub1 + " | "+ " Subject2:" + sub2 + " | "+ " Subject3:" + sub3 +"\n" );
	}
	taData.setText(data.toString());
	con.close();
}catch(SQLException e){
	JOptionPane.showMessageDialog(c, "Issue = " +e);
}

//Adding Elements
c.add(lblhead);
c.add(taData);
c.add(btnBack);

//Adding Action to Back Button to go back to MainFrame
ActionListener a1 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

//Setting up GUI Window Specifications
setTitle("Student Management System");
setSize(700,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
