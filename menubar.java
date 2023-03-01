import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class menubar extends JFrame implements ActionListener
{ 
  Font f1,f2,f3;
  JPanel pnl;
  JLabel l1,l2;
  ImageIcon i;
  JMenuBar mbr;
  JMenu menu,menu1,menu2,menu3,menu4;
  JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11;
  
  Connection cn;
  String sql;
  PreparedStatement prstm;
  Statement stm;
  ResultSet rs;
    
  menubar()
  {
	  setTitle("Home Page");
	  setSize(1920,1030);
	  setLocation(0,0);
	  setLayout(null);
	  
	  f1 = new Font("Arial",Font.BOLD,24);
	  f2 = new Font("Arial",Font.BOLD,60);
	  f3 = new Font("Arial",Font.BOLD,20);
	  
	  l2 = new JLabel("Blood Bank Management System");
	  l2.setFont(f2);
	  
	  mbr = new JMenuBar();
	  menu = new JMenu("Donar");
	  menu1 = new JMenu("Search blood donor");
	  menu2 = new JMenu("Stalk");
	  menu3 = new JMenu("delete donor");
	  menu4 = new JMenu("Exit");
	  mi1 = new JMenuItem("Add new donor");
	  mi2 = new JMenuItem("Update details");
	  mi3 = new JMenuItem("All donar details");
	  mi4 = new JMenuItem("Location");
	  mi5 = new JMenuItem("Blood group");
	  mi6 = new JMenuItem("Increase");
	  mi7 = new JMenuItem("Decrease");
	  mi8 = new JMenuItem("Detail");
	  mi9 = new JMenuItem("Delete donor");
	  mi10 = new JMenuItem("Log out");
	  mi11 = new JMenuItem("Exit Application");
	  i=new ImageIcon("blood1.jpg");
      l1=new JLabel(i);
	  pnl = new JPanel();
	  
	  add(l1);
	  menu.add(mi1);
	  menu.add(mi2);
	  menu.add(mi3);
	  menu1.add(mi4);
	  menu1.add(mi5);
	  menu2.add(mi6);
	  menu2.add(mi7);
	  menu2.add(mi8);
	  menu3.add(mi9);
	  menu4.add(mi10);
	  menu4.add(mi11);
	  mbr.add(menu);
	  mbr.add(menu1);
	  mbr.add(menu2);
	  mbr.add(menu3);
	  mbr.add(menu4);
	  l1.add(pnl);
	  
	  setJMenuBar(mbr);
	 
	  pnl.setLayout(null);
	  pnl.setBackground(Color.yellow);
	  
	  l1.add(l2);
	  
	 // pnl.setBounds(0,0,2000,50);
	 
	  l1.setBounds(0,0,1400,700);
	  mbr.setBounds(0,0,2000,50);
	  l2.setBounds(200,150,1000,100);
	  
	  mi1.addActionListener(this);
	  mi2.addActionListener(this);
	  mi3.addActionListener(this);
	  mi4.addActionListener(this);
	  mi5.addActionListener(this);
	  mi6.addActionListener(this);
	  mi7.addActionListener(this);
	  mi8.addActionListener(this);
	  mi9.addActionListener(this);
	  mi10.addActionListener(this);
	  mi11.addActionListener(this);
	
	  setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
      }
	  
	  public void actionPerformed(ActionEvent e)
	  {
	  if(e.getSource() == mi1)
      {
	   new donor2("hii");
	   dispose();
      }
      else if(e.getSource() == mi2)
      {
	  new update("hii");
	  dispose();
      }
	  else if(e.getSource() == mi3)
      {
	  new ADD2();
	  dispose();
      }
	  else if(e.getSource() == mi4)
      {
	  new pdf();
	  dispose();
      }
	  else if(e.getSource() == mi5)
      {
	  new BarChart3D();
	  dispose();
      }
	  else if(e.getSource() == mi6)
      {
	  new Istock();
	  dispose();
      }
	  else if(e.getSource() == mi8)
      {
	  new stock();
	  dispose();
      }
	  
	  else if(e.getSource() == mi10)
	  {
	   System.exit(0);
	  }
	  else if(e.getSource() == mi9)
	  {
	   new delete();
	   dispose();
	  }
	  }
  
      public static void main(String args[])
      {
       new menubar();
      }
}