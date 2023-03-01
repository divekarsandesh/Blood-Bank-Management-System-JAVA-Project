import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class update extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;    
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox cb1,cb2;
    DateButton calb;
    JPanel pnl;
	ImageIcon i;
	
	Connection cn;
    String sql;
    PreparedStatement prstm;
    Statement stm;
    ResultSet rs;
 	
	update(String t)
    {   
		super("Add New Donor");      
		setSize(1400,700);
        setLocation(0,0);
        setLayout(null);
		
		pnl = new JPanel();
        l1 = new JLabel("New Donor ID");
        l2 = new JLabel("Full Name");
        l3 = new JLabel("Father Name");
        l4 = new JLabel("Mother Name");
        l5 = new JLabel("Date Of Birth");
        l6 = new JLabel("Mobile No");
        l7 = new JLabel("Gender");
        l8 = new JLabel("Email");
        l9 = new JLabel("Blood Group");
        l10 = new JLabel("City");
        l11 = new JLabel("Complete Address");
        b1 = new JButton("Update");
		b2 = new JButton("Clear");
		b3 = new JButton("Back");
		b4 = new JButton("Search");
		t1 = new JTextField("");
		t2 = new JTextField("");
        t3 = new JTextField("");
		t4 = new JTextField("");
		t5 = new JTextField("");
		t6 = new JTextField("");
		t7 = new JTextField("");
		t8 = new JTextField("");
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		
        calb = new DateButton();	
	    i=new ImageIcon("blood1.jpg");
        l12=new JLabel(i);
	   
		pnl.add(calb); add(l12);
		pnl.add(l1); pnl.add(l2); pnl.add(l3); pnl.add(l4); pnl.add(l5); pnl.add(l6); pnl.add(l7); 
        pnl.add(l8); pnl.add(l9); pnl.add(l10); pnl.add(l11);
        pnl.add(b1); pnl.add(b2); pnl.add(b3); pnl.add(b4);
        pnl.add(t1); pnl.add(t2); pnl.add(t3); pnl.add(t4); pnl.add(t5); pnl.add(t6); pnl.add(t7); pnl.add(t8);
        pnl.add(cb1); pnl.add(cb2); add(pnl);		
        l12.add(pnl);
		
        pnl.setLayout(null);
        pnl.setBackground(Color.gray);
		
        cb1.addItem("select");
        cb1.addItem("Male");
		cb1.addItem("Female");
		cb1.addItem("Other");
		
		cb2.addItem("Blood Group Type");
		cb2.addItem("A+");
		cb2.addItem("O+");
		cb2.addItem("B+");
		cb2.addItem("AB+");
		cb2.addItem("A-");
		cb2.addItem("0-");
		cb2.addItem("B-");
		cb2.addItem("AB-");
		
		l12.setBounds(0,0,1400,700);
		pnl.setBounds(400,30,450,630);
        l1.setBounds(100,100,150,20);
		t1.setBounds(270,100,150,20);
		l2.setBounds(100,140,150,20);
		t2.setBounds(270,140,150,20);
	    l3.setBounds(100,180,150,20);
		t3.setBounds(270,180,150,20);
		l4.setBounds(100,220,150,20);
		t4.setBounds(270,220,150,20);
		l5.setBounds(100,260,150,20);
		calb.setBounds(270,260,150,20);
		l6.setBounds(100,300,150,20);
		t5.setBounds(270,300,150,20);
		l7.setBounds(100,340,150,20);
		cb1.setBounds(270,340,150,20);
		l8.setBounds(100,380,150,20);
		t6.setBounds(270,380,150,20);
		l9.setBounds(100,420,150,20);
		cb2.setBounds(270,420,150,20);
		l10.setBounds(100,460,150,20);
		t7.setBounds(270,460,150,20);
		l11.setBounds(100,500,150,20);
		t8.setBounds(270,500,150,20);
		b1.setBounds(100,540,150,20);
		b2.setBounds(270,540,150,20);
		b3.setBounds(100,580,150,20);
		b4.setBounds(270,580,150,20);
		
        b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
       
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
  //try
  //{
   if(e.getSource()==b1)
   {
	if(t1.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Donor ID","warning",JOptionPane.WARNING_MESSAGE);
	 t1.requestFocus();
	}
	else if(t2.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Full Name","warning",JOptionPane.WARNING_MESSAGE);
	 t2.requestFocus();
	}
	else if(t3.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Father Name","warning",JOptionPane.WARNING_MESSAGE);
	 t3.requestFocus();
	}
	else if(t4.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Mother Name","warning",JOptionPane.WARNING_MESSAGE);
	 t4.requestFocus();
	}
	else if(t5.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Mobile No","warning",JOptionPane.WARNING_MESSAGE);
	 t5.requestFocus();
	}
	else if(t6.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Email","warning",JOptionPane.WARNING_MESSAGE);
	 t6.requestFocus();
	}
	else if(t7.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given City","warning",JOptionPane.WARNING_MESSAGE);
	 t7.requestFocus();
	}
	else if(t8.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"Not Given Complete Address","warning",JOptionPane.WARNING_MESSAGE);
	 t8.requestFocus();
	}
	else
	{
	 try
	 {
	  sql = "update test0 set FFname = '" +t2.getText()+"', Fname = "+t3.getText()+
      "', Mname = "+t4.getText()+"', Date_Birth = "+calb.getText()+"', M_no = "+t5.getText()+
      "', Gender = "+cb1.getSelectedItem()+", Email = '"+t6.getText()+"', Blood_group = "+cb2.getSelectedItem()+
      "', city = "+t7.getText()+"', Address = "+t8.getText()+" where d_id = "+t1.getText();
      
	  prstm = cn.prepareStatement(sql);
	  prstm.execute(); 
	  prstm.close();
	  
	  JOptionPane.showMessageDialog(null,"Record Updated Successfully");
	 }
	 catch(Exception ex)
	 {
	  JOptionPane.showMessageDialog(null,"sql wrong allReady Exits","Duplicate Username",
	  JOptionPane.WARNING_MESSAGE);
	  
	  System.out.println(""+ex);
	 }
		 
		 
	/*String id = t1.getText();
	String FName = t2.getText();
	String FFName = t3.getText();
	String MName = t4.getText();
	String MNo = t5.getText();
	String Email = t6.getText();
	String City = t7.getText();
	String Address = t8.getText();
	rs = stm.executeQuery("select * from test0 where id ='"+id +"'");
	stm = cn.createStatement();
	rs.first();
	
	if(id.equals(rs.getString(1)) && FName.equals(rs.getString(2)) && FFName.equals(rs.getString(3)) && MName.equals(rs.getString(4)) && MNo.equals(rs.getString(5)) && Email.equals(rs.getString(6)) && City.equals(rs.getString(7)) && Address.equals(rs.getString(8)))
	{
	 JOptionPane.showMessageDialog(null,"Record Updated Successfully!!!");
	}
	else
	{
	JOptionPane.showMessageDialog(null,"Record Updated Failed!!!");
	}*/
	}
   }
    if(e.getSource() == b2)
	{
	 t1.setText("");
	 t2.setText("");
	 t3.setText("");
	 t4.setText("");
	 calb.setText("");
	 t5.setText("");
	 cb1.setSelectedIndex(0);
	 t6.setText("");
	 cb2.setSelectedIndex(0);
	 t7.setText("");
	 t8.setText("");
	 t1.requestFocus();
	}
     else if(e.getSource() == b3)
	  {
	   new menubar();
	   dispose();
	  }
	/*if(e.getSource()==b4)
    {
     System.exit(0);
	}*/
	else if(e.getSource()==b4)
    {
	 try
	 {
		 String d_id = t1.getText();
	 
	 rs = stm.executeQuery("select * from test0 where d_id ="+d_id);
	 rs.first();
	 
	 t1.setText(""+rs.getString(1));
	 t2.setText(""+rs.getString(2));
	 t3.setText(""+rs.getString(3));
	 t4.setText(""+rs.getString(4));
	 calb.setText(""+rs.getString(5));
	 t5.setText(""+rs.getString(6));
	 cb1.setSelectedItem(""+rs.getString(7));
	 t6.setText(""+rs.getString(8));
	 cb2.setSelectedItem(""+rs.getString(9));
	 t7.setText(""+rs.getString(10));
	 t8.setText(""+rs.getString(11));
	 }
	 catch(Exception ex)
	 {
		 
	 
	  t1.setText("");
	  t2.setText("");
	  t3.setText("");
	  t4.setText("");
	  t5.setText("");
	  t6.setText("");
	  t7.setText("");
	  calb.setText("");
	  t8.setText("");
	  cb1.setSelectedIndex(0);
	  cb2.setSelectedIndex(0);
	  
	  t1.requestFocus();
	  
	  JOptionPane.showMessageDialog(null, " Info.Not Found!!!","Duplicate ID",JOptionPane.WARNING_MESSAGE);
	  }
  
	//}
	
	
  }
 /* catch(SQLException e1)
  {
   System.out.println(e1);
  }*/
 }
 
  public static void main(String args[])
  {
   new update("update donor details");
  }
}