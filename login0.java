import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class login0 extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JTextField t1,t2;
 JButton b1,b2,b3;
 JPanel pnl;
 ImageIcon i;
 Font f,f1;
 
 Connection cn;
 String sql;
 PreparedStatement prstm;
 Statement stm;
 ResultSet rs;
 	
 login0()
 {
	 
	 	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();	
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();		
		setSize(width,height-40);


     f=new Font("Arial",Font.BOLD,20);
	  f1=new Font("Arial",Font.BOLD,60);
  setTitle("Login");
  //setSize(500,500);  //width,height-40
  //setLocation(250,150);
  setLayout(null);
  
  l4 = new JLabel("Login Page");
	  l4.setFont(f1);
  
  pnl = new JPanel();
  //pnl2 = new JPanel();
  b1 = new JButton("login");
  b2 = new JButton("exit");
  b3 = new JButton("next");
  
  l1 = new JLabel("username");
  l2 = new JLabel("Password");
  t1 = new JTextField("");
  t2 = new JTextField("");
  i=new ImageIcon("blood.jpg");
  l3=new JLabel(i);
  
  b1.setFont(f);
  b2.setFont(f);
  b3.setFont(f);
  l1.setFont(f);
  l2.setFont(f);
  t1.setFont(f);
  t2.setFont(f);
  
  
  add(l3);
  pnl.add(b1); pnl.add(b2); 
  pnl.add(b3);
  pnl.add(l1); pnl.add(l2);
  pnl.add(t1); pnl.add(t2); 
  l3.add(pnl);
  l3.add(l4);
  
  pnl.setLayout(null);
  pnl.setBackground(Color.gray);

  l3.setBounds(0,0,1500,768);

  pnl.setBounds(750,150,350,450);
  
  l1.setBounds(30,150,100,40);
  t1.setBounds(150,150,170,30);
  l2.setBounds(30,210,100,40);
  t2.setBounds(150,210,170,30);
 
  b1.setBounds(50,330,130,30);
  b2.setBounds(190,330,130,30);
  b3.setBounds(120,370,130,30);
  l4.setBounds(200,150,1000,100);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  try
  {
   cn = DriverManager.getConnection("jdbc:mysql:///project","root","12345678");
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
   if(e.getSource()==b1)
   {
	if(t1.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"not given user name","warning",JOptionPane.WARNING_MESSAGE);
	 t1.requestFocus();
	}
	else if(t2.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"not given password","warning",JOptionPane.WARNING_MESSAGE);
	 t2.requestFocus();
	}
	else
	{
	String name = t1.getText();
	String password = t2.getText();
	rs = stm.executeQuery("select * from user_login where u_name ='"+name +"'");
	stm = cn.createStatement();
	rs.first();
	
	if(name.equals(rs.getString(2)) && password.equals(rs.getString(3)))
	{
	 JOptionPane.showMessageDialog(null,"login successfully!!!");
	}
	else
	{
	//JOptionPane.showMessageDialog(null,"login Failed!!!");
	}
	}
   }
	if(e.getSource()==b2)
    {
     System.exit(0);
	}
	if(e.getSource()==b3)
    {
     new menubar();
	   dispose();
	}
  }
  catch(SQLException e1)
  {
  // System.out.println(e1);
  JOptionPane.showMessageDialog(null,"login Failed!!!");
  }
 }
  public static void main(String args[])
  {
   new login0();
  }
 }