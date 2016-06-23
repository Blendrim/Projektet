package Analize_Numerike_II;

import java.text.*;
import javax.swing.*;

public class PageRank 
{
	private static double[][] Vector ;
	
	public static double[][] Matrica( int x)
	{
		double[][] Matrica1 = new double[x][x];
		for (int i = 0; i <= x - 1; i++)
		{
			int f = new Integer(JOptionPane.showInputDialog("  Jepni numrin e faqeve per lidhje "+ (i + 1))).intValue();
			
			int numruesi = f;
			
			while(numruesi > 0)
			{
				int b = new Integer(JOptionPane.showInputDialog("Me cilen faqe behet lidhja "+ (i + 1))).intValue();
				
				Matrica1[i][b - 1] = 1.0 / f;
				
				numruesi --;
			}
			
		}
		return Matrica1;
		
	}
	// Vektor matrica 
	public static double [][] Vector_matrix( double[][] v ,double[][]a)
	{
		boolean procesimi = true;
		
		Matrix_Operations  c = new Matrix_Operations(); 
		
		double[][] rezultati = new double[v.length][1]; 
		 
	    double[][]AV= Matrix_Operations.Shumzimi(a ,v);
	    
	    for(int i = 0; i < a.length; i++ )
	    {	
	      for (int j = 0; j < a[0].length; j++)
	      {
	    	  while( procesimi )
	    	  { 
		         rezultati =Matrix_Operations.Shumzimi(a ,AV);
		         
		         if(AV [i][j] == rezultati[i][j])
		        	 
	         	  {procesimi = false;} 
		         
		         else{ AV = rezultati;}
		          
		      }
	      }
	      
	    }
	    return rezultati;
 
	
	
	}
	// Definimi i vektorit 
public static double[][]Define_vector(int A)
	
	{  Vector = new double[A][1];
	
	   for(int i = 0; i <Vector.length; i++ )
	      
	    for(int j = 0; j <Vector[0].length; j++ )
			   
	  {{Vector[i][j] = 1.0/A ;}}
	   
	   
	return Vector;
		
	}
	        
	
	
	public static void main(String[] args) 
	{  Matrix_Operations  c = new Matrix_Operations(); 
		int  a = new Integer(JOptionPane.showInputDialog("* Jepni  numrin e  faqeve *")).intValue();
		double [][]u =Define_vector(a);
		double[][] p = Matrix_Operations.Transpose_Matrix(Matrica(a));
		p = Vector_matrix(u , p);
		
		DecimalFormat f = new DecimalFormat("0.00");
		for (int i = 0; i <u.length; i++)
		{
			System.out.println(" ");
			
			for (int j = 0; j < u[0].length; j++)
			{
				System.out.println();
				System.out.print(f.format(p[i][j]) + " ");
			}
			
		}
	}

}
