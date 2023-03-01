import java.io.*; 
import javax.swing.*;
import java.awt.*;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class BarChart3D extends JFrame
{
    JLabel l1;

	BarChart3D()
	{
		super("BarChart3D Demo");
		setSize(1400,750);
		setLocation(10,10);
		
		l1 = new JLabel(new ImageIcon("barChart3D.jpeg"));
		add(l1);        
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main( String[ ] args )throws Exception 
	{
		final String cell = "CELL";              
		final String unit = "UNIT";              
		final String stock = "STOCK";              
		final String ap="AP";              
		final String abp = "ABP";              
		final String an = "AN";              
		final String abn = "ABN";              
		final String bn = "BN"; 
		final String bp = "BP"; 
		final String op = "OP"; 
		final String on = "ON"; 
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
		
		dataset.addValue( 1.0 , cell , ap );              
		dataset.addValue( 4.0 , cell , abp );              
		dataset.addValue( 3.0 , cell , an );              
		dataset.addValue( 5.0 , cell , abn );              
		dataset.addValue( 5.0 , cell , bn );
		dataset.addValue( 6.0 , cell , bp );
		dataset.addValue( 9.0 , cell , op );
		dataset.addValue( 3.0 , cell , on );
		
		dataset.addValue( 5.0 , unit , ap );              
		dataset.addValue( 7.0 , unit , abp );              
		dataset.addValue( 6.0 , unit , an );              
		dataset.addValue( 10.0 , unit , abn );              
		dataset.addValue( 4.0 , unit , bn ); 
		dataset.addValue( 5.0 , unit , bp ); 
		dataset.addValue( 7.0 , unit , op ); 
		dataset.addValue( 4.0 , unit , on ); 
		
		dataset.addValue( 4.0 , stock , ap );              
		dataset.addValue( 3.0 , stock , abp );              
		dataset.addValue( 2.0 , stock , an );              
		dataset.addValue( 3.0 , stock , abn );              
		dataset.addValue( 6.0 , stock , bn );
        dataset.addValue( 8.0 , stock , bp );
        dataset.addValue( 5.0 , stock , op );
        dataset.addValue( 6.0 , stock , on );		
		
		JFreeChart barChart = ChartFactory.createBarChart3D(
			"Blood Bank Datils",             
			"Blood Group Type",             
			"Blood Group Score",             
			dataset,            
			PlotOrientation.VERTICAL,             
		true, true, false);
		
		int width = 1000; /* Width of the image */
		int height = 600; /* Height of the image */
		File barChart3D = new File( "barChart3D.jpeg" );
		ChartUtilities.saveChartAsJPEG( barChart3D, barChart, width, height);
		
		new BarChart3D();	// call to con_or
	}
}