import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.text.*;
//import java.util.*;
//import java.lang.*;

class stock extends JFrame implements ActionListener
{
    
    JButton prt,ext,back; 
	JTable tab;
    DefaultTableModel mdl;
	
    JScrollPane jsp; int i=1;
	
    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
    PreparedStatement prstm;

    stock()
    {
        super("Add Donor Details");
        setLayout(null);
        setSize(1350,720);
        setVisible(true);
        setLocation(0,0);

        prt = new JButton("Print");
        ext = new JButton("EXIT");
		back = new JButton("Back");

        add(prt);       
		add(ext);
       add(back);
		
        prt.addActionListener(this);
        ext.addActionListener(this);
        back.addActionListener(this);       
	   
        prt.setBounds(300,500,150,20);    
        ext.setBounds(470,500,150,20);
		back.setBounds(640,500,150,20);

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
		 updateTable("select count(*) from stock","select * from stock order by Blood_Group");
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
           else if(e.getSource() == back)
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
                data[i][0] = rs.getString(3);
                data[i][1] = rs.getString(2);
                rs.next();
            }

			// 3) create table
            JTable table = new JTable(data, colHeads);
            add(table);
            table.setEnabled(false);
            JScrollPane jsp = new JScrollPane(table);
            add(jsp);
            jsp.setBounds(100,10,1200,400);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
	
	

    public static void main(String args[])
    {
        new stock();
    }
}