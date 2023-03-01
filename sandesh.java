import java.sql.*;

class sandesh
{
    public static void main(String arg[]) throws Exception
    {
         String URL = "jdbc:mysql://project","root","12345678";  //cn = DriverManager.getConnection("jdbc:mysql:///project","root","12345678");
        
	    String Username = "root";
        String Password = "12345678";
        String Query = "select * from student";
        try
		{
        Connection cobj = DriverManager.getConnection("jdbc:mysql:///project","root","12345678");//(URL,Username,Password);
        Statement sobj = cobj.createStatement();
		}
        catch(Exception e)
        {
        e.printStackTrace();
        }
        ResultSet robj = sobj.executeQuery(Query);

        while(robj.next())
        {
            System.out.println("RID : "+robj.getInt("RID"));
            System.out.println("Name : "+robj.getString("Name"));
            System.out.println("City : "+robj.getString("City"));
            System.out.println("Marks : "+robj.getInt("Marks"));                                    
        }
    }
}
/*
     try
        {
        cn = DriverManager.getConnection("jdbc:mysql:///project","root","12345678");
        stm = cn.createStatement();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
		*/
		