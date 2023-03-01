/*
javac -cp ".;c:\*" PDFDemo_Database.java
java -cp ".;c:\*" PDFDemo_Database

export CLASSPATH=/root/*:/root:.
*/

import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.sql.*;
import java.awt.Desktop;


class pdfproject
{
    String path;
    OutputStream file ;
    Document document;
    Paragraph p;

    PdfPTable table;
    PdfPCell c1;
    Font big,small;

    Connection cn;
    Statement stm;
    ResultSet rs;
    int cnt;

    pdfproject()
    {
        big = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
        small = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);

        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///project","root", "12345678");
            stm = cn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
		create_pdf();
		      write_heading();
			  create_tab_heading();
			  add_rows();
			  close_pdf();
    }

    void create_pdf()
    {
        try
        {
            path="Test.pdf";
            file = new FileOutputStream(new File(path));

            document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();
            //document.newPage();   // for new page
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void write_heading()
    {
        try
        {
            //Write in a PDF
            p = new Paragraph("Retrive the Info from table",big);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));

            p = new Paragraph("Date = " + new java.util.Date());
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p);
            document.add(new Paragraph(" "));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void create_tab_heading()
    {
        /*
        table = new PdfPTable(3);
        // Width of Table - same for each coloumn
        table.setWidthPercentage(80);
        */

        float[] colsWidth = {40,40,40,40,40,40,40,40,40,40,40};
		table = new PdfPTable(colsWidth);
		table.setWidthPercentage(80);

        c1 = new PdfPCell(new Phrase("id",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("FName",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
            
          c1 = new PdfPCell(new Phrase("FFName",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("MName",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
          c1 = new PdfPCell(new Phrase("Date_Birth",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("MNo",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("Gender",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("Email",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("Blood_group",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("City",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
		
		 c1 = new PdfPCell(new Phrase("Address",small));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
    }

    void add_rows()
    {
        cnt=0;
        try
        {
            rs = stm.executeQuery("select * from test0");
           // for(int i=0;i<10;i++)
            {
                rs.beforeFirst();
                while(rs.next())
                {
                    cnt++;

                   // c1 = new PdfPCell(new Phrase(Integer.toString(cnt)));
                    //c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //table.addCell(c1);
                    
                    c1 = new PdfPCell(new Phrase(rs.getString(1)));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    table.addCell(rs.getString(2));
					table.addCell(rs.getString(3));
					table.addCell(rs.getString(4));
					table.addCell(rs.getString(5));
					table.addCell(rs.getString(6));
					table.addCell(rs.getString(7));
					table.addCell(rs.getString(8));
					table.addCell(rs.getString(9));
					table.addCell(rs.getString(10));
					table.addCell(rs.getString(11));
                }
            }
            rs.close();
            cn.close();

            // Coloumn Spanning
            PdfPCell cell = new PdfPCell(new Paragraph("Total No. Records  = "+cnt));
            cell.setColspan(3);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            document.add(table);
            document.add(new Paragraph(" "));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void close_pdf()
    {
        try
        {
            document.close();
            file.close();

			//To open the pdf file in linux & windows
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new java.io.File(path));
        }
        catch (Exception e)
        {  e.printStackTrace();
        }
    }
}

class pdf
{    public static void main(String[] args)
    {
         pdfproject obj = new pdfproject();
        // obj.create_pdf();
         //obj.write_heading();
         //obj.create_tab_heading();
         //obj.add_rows();
         //obj.close_pdf();
     }
}