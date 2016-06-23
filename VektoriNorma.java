 package Analize_Numerike_II;

import javax.swing.JOptionPane;

public class VektoriNorma 
// * Deklarimi i vektorit
{ public static double[] Vektori(int v )
	{
		double [] v1 = new double [v];
		return v1;
	 
	}
// * Inicializimi i vektorit
  public static double [] Vektori_1(double[]v1)
  {
	  for(int i=0;i<v1.length;i++)
	  {
		  double mbush = new Double(JOptionPane.showInputDialog("Jepni vleren e vektorit  "+i)).doubleValue();
		  v1[i]= mbush;
	  }
	  return v1;
	  
  }
  // * Mbledhja e vektoreve
  public static double [] Mbledhja (double[]a,double[]b)
  {
	  double []m = new double[a.length];
	  for(int i =0;i<a.length;i++)
	  {
		  m[i]=a[i]+b[i];
	  }
	  return m;
	  
  }
  // * Zbritja e vektoreve
  public static double [] Zbritja(double[]z1,double[]z2)
  {
	  double z[] = new double [z1.length];
	  for(int i = 0;i<z1.length;i++)
	  {
		  z[i]= z1[i]-z2[i];
		  
	  }
	  return z;  
  }
  //* L2 Norma
  public static double L2_Norma(double[]L)
  {    
	  double rezultati=0;
	  for(int i =0;i<L.length;i++)
	  {
		   rezultati = Math.sqrt(Math.pow(L[0],2)+ Math.pow(L[1],2)+ Math.pow(L[2],2) );
	  }
	  return rezultati;
  }
  // * Infinit Norma 
  public static double Infinit_Norma(double []I)
  {
	  double maksimumi = Math.abs(I[0]);
	  for(int j=0;j<I.length;j++)
	  { if(Math.abs(I[j])>maksimumi)
		  {maksimumi = Math.abs(I[j]);}
	  }
	  return maksimumi;
  }
   // * Deklarimi i matrices
  public static double [][] matrica(int a )
    {
	   double[][] a1 = new double [a][a];
	   return a1;
    }
  // * Inicializimi i matrices 
  public static double [][]matrica1  (double[][] b)
    {
	  for (int i = 0; i < b.length; i++)
      {
          for (int j = 0; j < b.length; j++)
          {  double k = new Double(JOptionPane.showInputDialog("Sheno elementin [" + i + "]" +"[" + j + "]"+" te matrices:")).doubleValue();
          	  b[i][j] = k;
          }
      }
	  return b;
    }
  // * Distanca Euklidiane 
  public static double Distanca_Euklidiane(double[] m, double[] p)
  {
      
      double rez = 0;
    	  for(int j =0;j<m.length;j++)
    	  {
    		  
    		  rez = rez+Math.pow((m[j]- p[j]),2);
    	  }
      return Math.sqrt(rez);
  }
  //* Distanca Maksimale 
  public static double Distanaca_Maksimale (double[]x,double[]y)
  {
	  double[] a = Zbritja(x,y);
      double max = Math.abs(a[0]);

      for (int i = 0; i < x.length; i++)
      {
          if (Math.abs(a[i]) > max)
          {
              max = Math.abs(a[i]);
          }
      }

      return max;
	  
  }
  //* Inifinit Norma Matricore
  public static double Infinit_norma_matricore(double[][]n)
      {
	  double[] k = new double[n.length];
      double max = k[0];
      for(int i = 0; i<n.length; i++)
      {
          for (int j = 0; j < n.length; j++)
          {
              k[i] += Math.abs(n[i][j]);
          }
      }

      for(int i = 0; i<k.length;i++)
      {
          if(k[i]>max)
          {
              max=k[i];
          }

      }

      return max;
      }
  // * Norma Frobenius 
  public static double  Norma_Frobenius(double[][]v)
  	{
	  double rezultati = 0;
	  
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				rezultati = Math.pow(v[i][j], 2);
			}
		}
		return Math.sqrt(rezultati);
  	}

  
  
 public static void main(String[]args)
 {
	   int b = new Integer(JOptionPane.showInputDialog("Sheno gjatesine e vektorit:")).intValue();
	   if(b<=0) 
	   { JOptionPane.showMessageDialog(null, "Gabim "); }
	   		else
	   		{ 
                Vektori(b);

                double[] v = Vektori_1(Vektori(b));
                System.out.println("Vektori:");
                for (int i = 0; i < v.length; i++)
                 {

                     System.out.println(v[i]);
                 }
	           System.out.println();
	           
	           double[] v1 = Vektori_1(Vektori(b));
	            System.out.println("Vektori perafrues:");
	            for (int i = 0; i < v1.length; i++)
	            {

	              System.out.println(v1[i]);

	            }
	           System.out.println();
	           
	           System.out.println("Shuma e vektoreve eshte:");
	            double[] shuma = Mbledhja(v,v1);
	            for (int i =0; i < v.length; i++)
	            {
	                System.out.println(shuma[i]);
	            }

	            
	            System.out.println();
	            System.out.println("L2 Norma e Vektorit : " + L2_Norma(v));
	            System.out.println();
	            System.out.println("Infinit Norma e Vektorit : " + Infinit_Norma(v));
	            System.out.println();
	            System.out.println("Distanca Euklidiane e Vektoreve : " +  Distanca_Euklidiane(v,v1));
	            System.out.println();
	            System.out.println("Distanca Maksimale e Vektoreve : " + Distanaca_Maksimale(v,v1));
	            System.out.println();
	   		}
	   int c = new Integer(JOptionPane.showInputDialog("Sheno numrin e rreshtave te matrices katrore:")).intValue();

       if(c<=0) 
       { JOptionPane.showMessageDialog(null, "Gabim "); }
       else
       {
           matrica(c);
           double[][] m = matrica1(matrica(c));
           System.out.println("Matrica:");
           for (int i = 0; i < m.length; i++)
           {
               for (int j = 0; j < m.length; j++)
               {
                   System.out.print(m[i][j] + " ");
               }
               System.out.println();
           }

           System.out.println();
           
           System.out.println("Norma infinit e matrices : " + Infinit_norma_matricore(m));
           System.out.println();
           System.out.println("Norma Frobenius e matrices : " + Norma_Frobenius(m));

       }
   }

 }
