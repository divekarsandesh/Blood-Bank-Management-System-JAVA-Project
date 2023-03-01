import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.text.*;
//import java.util.*;
//import java.lang.*;

class ADD2 extends JFrame implements ActionListener
{
    JLabel l1;
    JButton prt,ext,bck; 
	JTable tab;
    DefaultTableModel mdl;
	JPanel pnl;
	ImageIcon i1;
	
    JScrollPane jsp; int i=1;
	
    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
    PreparedStatement prstm;

    ADD2()
    {
        super("Add Donor Details");
        setLayout(null);
        setSize(1350,720);
        setVisible(true);
        setLocation(10,10);
         
		pnl = new JPanel();
		bck = new JButton("Back");
        prt = new JButton("Print");
        ext = new JButton("EXIT");
        i1=new ImageIcon("blood1.jpg");
        l1=new JLabel(i1);
		
		add(l1);
		add(bck);
        add(prt);       
		add(ext);
        add(pnl);
		l1.add(pnl);
		
		pnl.setLayout(null);
        prt.addActionListener(this);
        ext.addActionListener(this);
		bck.addActionListener(this);
       
	   
        prt.setBounds(300,500,150,20);    
        ext.setBounds(470,500,150,20);
		bck.setBounds(640,500,150,20);
		

        tab = new JTable(mdl)
        {   public Class getColumnClass(int column)
            { switch (column)
                {   case 0:     return String.class;
                    case 1:     return String.class;
				    case 2:     return String.class;
                    case 3:     return String.class; 
					case 4:     return String.class;
                    case 5:     return String.class; 
					case 6:     return String.class;
                    case 7:     return String.class;
					case 8:     return String.class;
                    case 9:     return String.class; 
					case 10:     return String.class;
                    
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
		 updateTable("select count(*) from test0","select * from test0 order by Date_Birth");
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
				try
				{
					MessageFormat header = new MessageFormat("JTable Report Print");
				   MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				   tab.print(JTable.PrintMode.NORMAL, header, footer);
			
			}
				catch(Exception exp){exp.printStackTrace();}
          }
		  
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

            String colHeads[] = { "id", "FName", "FFName", "MName", "Date_Birth", "MNo", "Gender", "Email", "Blood_Group", "City", "Address" };
            String data[][] = new String[rowcnt][11];

			// 2) Load Data into array
           rs = stm.executeQuery(s2);
            rs.first();

            for (int i=0;i<rowcnt;i++)
            {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
              data[i][3] = rs.getString(4);
			  data[i][4] = rs.getString(5);
			  data[i][5] = rs.getString(6);
			  data[i][6] = rs.getString(7);
			  data[i][7] = rs.getString(8);
			  data[i][8] = rs.getString(9);
			  data[i][9] = rs.getString(10);
			  data[i][10] = rs.getString(11);
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
        new ADD2();
    }
}