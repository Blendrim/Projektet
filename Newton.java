package Analize_Numerike_II;

public class Newton
{
	
	// VectorLtwoNewton
	public static double VectorLtwoNorm(double[] vektori)
	{
		double rezultati = 0;
		for(int i=0;i<vektori.length;i++){		
			rezultati = rezultati + Math.pow(vektori[i], 2);
		}
		return Math.sqrt(rezultati);
	}
	
	
	// Matrix Substraction
	public static double[][] matrixSubtraction(double[][] matrica1,double[][] matrica2)
	{
		double[][] rezultati = new double[matrica1.length][matrica1.length];
		for(int i=0;i<matrica1.length;i++)
		{
			for(int j=0;j<matrica1.length;j++){
				rezultati[i][j] = matrica1[i][j] - matrica2[i][j];
			}
		}
		return rezultati;
	}
	
	// MatrixInverseofRank3 
	
    public static double[][] MatrixInverseofRank3(double[][] A) {
        double[][] rez = new double[3][3];
        double detA = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1]
        			+ A[2][0] * A[1][2] * A[0][1]- A[2][0] * A[1][1] * A[0][2] 
        			- A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2]; 
                      
        rez[0][0] = 1 / detA * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
        rez[0][1] = 1 / detA * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
        rez[0][2] = 1 / detA * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
        rez[1][0] = 1 / detA * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
        rez[1][1] = 1 / detA * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
        rez[1][2] = 1 / detA * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
        rez[2][0] = 1 / detA * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
        rez[2][1] = 1 / detA * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
        rez[2][2] = 1 / detA * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);
        
        return rez;
    }
	
    //Shumzimi i Matricave
    public static double[][] ShumzimiMatricave(double[][] A, double[][] B) 
    {
        double[][] rezultati = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) 
        {
            for (int j = 0; j < B[0].length; j++){ 
            
                for (int k = 0; k < A[0].length; k++) {
                
                    rezultati[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return rezultati;
    }
	
    
       //funksioni
	public static double[][] funksioni(double x1,double x2,double x3)
	{
		double[][] rezultati = new double[3][3];		
		rezultati[0][0] = 3.0*x1 - Math.cos(x2*x3) - 1.0/2;
		rezultati[1][0] = x1*x1 - 81.0*Math.pow(x2+0.1,2) + Math.sin(x3) + 1.06;
		rezultati[2][0] = Math.exp(-x1*x2) + 20.0*x3 + (10*Math.PI - 3)/3.0;
		return rezultati;
	}
	
	  //derivati_funksionit
	public static double[][] derivati_funksionit(double x1,double x2,double x3)
	{
		double[][] rezultati = new double[3][3];
		rezultati[0][0] = 3;
		rezultati[0][1] = x3*Math.sin(x2*x3);
		rezultati[0][2] = x2*Math.sin(x2*x3);
		rezultati[1][0] = 2*x1;
		rezultati[1][1] = -162*(x2+0.1);
		rezultati[1][2] = Math.cos(x3);
		rezultati[2][0] = -1*x2*Math.exp(-1*x1*x2);
		rezultati[2][1] = -1*x1*Math.exp(-1*x1*x2);
		rezultati[2][2] = 20;
		return rezultati;
	}
	
	 //EkuacioniNewtonit
	public static double[][] EkuacioniNewtonit(int N, double[][] x, double TOL)
	{
		double[][] y = new double[x.length][x.length];
		int k = 0;
		while(k<N)
		{
			double[][] inversedJ = MatrixInverseofRank3(derivati_funksionit(x[0][0],x[1][0],x[2][0]));
			
			y = ShumzimiMatricave(inversedJ,funksioni(x[0][0],x[1][0],x[2][0]));
			
			x = matrixSubtraction(x,y);
			double[] y1 = {y[0][0],y[1][0],y[2][0]};
			if(VectorLtwoNorm(y1)<TOL)
			{return x;}
			k++;
		}
		return x;
	}
	
	// Metoda main
	public static void main(String[] args)
	{
		double[][] A = {{0.1,0,0},	
						{0.1,0,0},
					    {-0.1,0,0}};
		double[][] x = EkuacioniNewtonit(6,A,0.000000000000000001);
		System.out.println("Zgjidhjet"+"\n--------------------------------");
		System.out.println("x1: "+x[0][0] + "\nx2: " +x[1][0] + "\nx3: " + x[2][0]);
		System.out.println("\nTestimi i saktësisë " + "\n------------------------------------------------");
		System.out.println("Ekuacioni I: "+(3.0*x[0][0] - Math.cos(x[1][0]*x[2][0]) - 1.0/2)+" = 0"); 
		System.out.println();
		System.out.println("Ekuacioni II: "+(x[0][0]*x[0][0] - 81.0*Math.pow(x[1][0]+0.1,2) + Math.sin(x[2][0]) + 1.06)+" = 0");
		System.out.println();
		System.out.println("Ekuacioni III: "+(Math.exp(-x[0][0]*x[1][0]) + 20.0*x[2][0] + (10*Math.PI - 3)/3.0)+" = 0"); 
		System.out.println("-----------------------------------");
	}

}

