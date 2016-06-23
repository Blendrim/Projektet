package Analize_Numerike_II;

public class MatrixOperations 
{ 
	 // Matrica e Transponuar
	 public static double [][] Transpose_Matrix (double[][]M)
	 {   
		 
		 int a = M.length;
		 
		 int t = M[0].length;
		 
		 double[][] Transpose_Matrix1 = new double[t][a];// Mbushja
		 
		 for(int i = 0; i < t; i++)
		   {
		       for(int j = 0; j < a; j++)
		       {
		    	   Transpose_Matrix1[i][j] = M[j][i];
		       }
		   }
		 return Transpose_Matrix1;
		 
	 }
	 
	 
	 // Shumzimi i Matricave
	 public static double[][] Shumzimi( double[][]m,double[][]n)
	 {	
		 double a = 0 ;
		double[][]A = new double[m.length][n[0].length];
		
		
		for(int i = 0;i<m.length;i++)
		 {  
			for(int k = 0;k<n[0].length;k++)
			{
			   for (int j = 0; j<m[0].length; j++)
				  {  a += m[i][j] * n[j][k]
				  ;}
			         A[i][k]=a;
			         a = 0;
						
					
			}
				
		 }
		 return A ;
	 }
	

}
