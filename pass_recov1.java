import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class pass_recov1 extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JTextField t1,t2,t3,t4;
 JButton b1,b2,b3,b4;
 
 
 Connection cn;
 PreparedStatement prstm;
 Statement stm;
 ResultSet rs;
 String sql;
 
 pass_recov1()
 {
  setTitle("pass_recov");
  setSize(400,400);
  setLocation(250,150);
  setLayout(null);
  
  pnl = new JPanel();
  l1 = new JLabel("Username :");
  l2 = new JLabel("Email :");
  l3 = new JLabel("Reference No :");
  l4 = new JLabel("Enter OTP :");
  

  t1 = new JTextField("");
  t2 = new JTextField("");
  t3 = new JTextField("");
  t4 = new JTextField("");
  
  
  b1 = new JButton("Recover password");
  b2 = new JButton("Back");
  b3 = new JButton("Send Message");
  b4 = new JButton("Exit");

  
  pnl.add(l1); pnl.add(l2); pnl.add(l3); pnl.add(l4);
  pnl.add(t1); pnl.add(t2); pnl.add(t3); pnl.add(t4);
  pnl.add(b1); pnl.add(b2); pnl.add(b3); pnl.add(b4);
  add(pnl);
  
  pnl.setLayout(null);
  pnl.setBackground(Color.gray);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  
  pnl.setBounds(300,150,450,400);
  l1.setBounds(100,100,150,20);
  t1.setBounds(270,100,150,20);
  l2.setBounds(100,140,150,20);
  t2.setBounds(270,140,150,20);
  l3.setBounds(100,180,150,20);
  t3.setBounds(270,180,150,20);
  l4.setBounds(100,220,150,20);
  t4.setBounds(270,220,150,20);
  b1.setBounds(100,260,150,20);
  b2.setBounds(270,260,150,20);
  b3.setBounds(100,300,150,20);
  b4.setBounds(270,300,150,20);
  
  try
  {
	cn = DriverManager.getConnection("jdbc:mysql:///project","root","");
	stm = cn.createStatement();
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 public void actionPerformed(ActionEvent e)
 {
   try
  {
	  if(e.getSource() ==b1)
	  {
	   if(t1.getText().length()==0)
       {
		 JOptionPane.showMessageDialog(null,"not given Enter user name","warning",JOptionPane.WARNING_MESSAGE);
		 t1.requestFocus();
	   }		  
		else if(t2.getText().length()==0)
		 {
		  JOptionPane.showMessageDialog(null,"not given Enter Email","warning",JOptionPane.WARNING_MESSAGE);
		 t2.requestFocus();
		 }
        else if(t3.getText().length()==0)
		{
		 JOptionPane.showMessageDialog(null,"not given Enter References NO","Warning",JOptionPane.WARNING_MESSAGE);	
		}
        else if(t4.getText().length()==0)
		{
		 JOptionPane.showMessageDialog(null,"not given Enter OTP","Warning",JOptionPane.WARNING_MESSAGE);	
		}
		
      else 
	  {
	  String Username = t1.getText();
	  String Email= t2.getText();
	  String ReferenceNo = t3.getText();
	  String EnterOTP = t4.getText();
	  rs = stm.executeQuery("select * from login where Username ='"+Username +"'");
	  stm = cn.createStatement();
	  rs.first();
	    
	  if(Username.equals(rs.getString(1)) && Email.equals(rs.getString(2)) && ReferenceNo.equals(rs.getString(3)) && EnterOTP.equals(rs.getString(4)))
	 {
	  JOptionPane.showMessageDialog(null,"Record recover Successfully!!!");
	 }
	 else
	 {
      JOptionPane.showMessageDialog(null,"Record recover Failed!!!");
	 }
	  }
	  }
	  if(e.getSource() == b2)
	  {
	   new login0();
	   dispose();
	  }
	  if(e.getSource() == b3)
	  {
		  
	  }
	  if(e.getSource() == b4)
	  {
	   System.exit(0);	  
	  }
	 }
	 catch(Exception ex)
     {
	  ex.printStackTrace();
     }
 }
 public static void main(String args[])
 {
  new pass_recov1();
 }
 }