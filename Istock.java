import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.text.*;
//import java.awt.*;
//import java.util.*;
//import java.lang.*;

class Istock extends JFrame implements ActionListener
{
    JLabel l1,l2;
	JTextField t1;
    JButton prt,ext,upt,bck;
    JComboBox cb1;	
	JTable tab;
    DefaultTableModel mdl;
	
	Object colHead[] = {"Blood_group","unit"};
	
    JScrollPane jsp; int i=1;
	
    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
    PreparedStatement prstm;

    Istock()
    {
        super("Add Donor Details");
        setLayout(null);
        setSize(800,200);
        setVisible(true);
        setLocation(10,10);
       
	    l1 = new JLabel("Blood_Group");
		l2 = new JLabel("unit");
		t1 = new JTextField("");
		cb1 = new JComboBox();
        prt = new JButton("Print");
        ext = new JButton("EXIT");
        upt = new JButton("update");
		bck = new JButton("Back");
		
		add(l1);
		add(l2);
		add(t1);
		add(cb1);
        add(prt);       
		add(ext);
		add(upt);
		add(bck);
       
		
        prt.addActionListener(this);
        ext.addActionListener(this);
		upt.addActionListener(this);
		bck.addActionListener(this);
		
	    cb1.addItem("Blood_Group");
		cb1.addItem("A+");
		cb1.addItem("B+");
		cb1.addItem("A-");
		cb1.addItem("B-");
		cb1.addItem("AB+");
		cb1.addItem("AB-");		
       
	    l1.setBounds(30,50,100,20);
		cb1.setBounds(140,50,100,20);
		l2.setBounds(30,80,100,20);
		t1.setBounds(140,80,100,20);
        prt.setBounds(300,500,150,20);    
        ext.setBounds(470,500,150,20);
		upt.setBounds(640,500,150,20);
		bck.setBounds(810,500,150,20);

        //md1 = new DefaultTableModel(data,colHead);
		
        tab = new JTable(mdl)
        {   public Class getColumnClass(int column)
            { switch (column)
                {   case 0:     return String.class;
                    case 1:     return String.class;
				    
                    default:    return Integer.class;
                }
            }
        };
		

        jsp = new JScrollPane(tab); add(jsp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  setVisible(true);
        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///project","root","12345678");
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		 updateTable("select count(*) from stock1","select * from stock1 order by Blood_Group");
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
          
   		    if (e.getSource() == ext)
            {
                System.exit(0);
            }
           else if(e.getSource()==prt)
          { 
		    MessageFormat header = new MessageFormat("JTable Report Print");
           MessageFormat footer = new MessageFormat("Page {0,number,integer}");
           tab.print(JTable.PrintMode.NORMAL, header, footer);
          }
          else if(e.getSource()==upt) 
          {
			//sql = "update stock1 set Blood_Group='" +cb1.getSelectedIndex()+"', unit=" +t1.getText();
      
	       sql = "insert into stock1 values(" +cb1.getSelectedIndex()+",'"+t1.getText()+"')";
	        prstm = cn.prepareStatement(sql);
	        prstm.execute(); 
	        prstm.close();
	  
	         JOptionPane.showMessageDialog(null,"Record Updated Successfully"); 
		  }
            //else
			//{
			//md1.addRow(colHead);	
			//Blood_Group = md1.getRowCount();
			
		//  }

           else if(e.getSource() == bck)
	       {
	         new menubar();
	         dispose();
	       }  
	     	

        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }

  

    void updateTable(String s1,String s2)
    {
        try
        {
			// 1) Memory allocation to Array
            rs = stm.executeQuery(s1);
            rs.first();
            int rowcnt = rs.getInt(1);

            String colHeads[] = { "Blood_Group", "unit" };
            String data[][] = new String[rowcnt][2];

			// 2) Load Data into array
           rs = stm.executeQuery(s2);
            rs.first();

            for (int i=0;i<rowcnt;i++)
            {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                rs.next();
            }

			// 3) create table
            JTable table = new JTable(data, colHeads);
            add(table);
            table.setEnabled(false);
            JScrollPane jsp = new JScrollPane(table);
            add(jsp);
            jsp.setBounds(300,10,800,400);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
	
	

    public static void main(String args[])
    {
        new Istock();
    }
}