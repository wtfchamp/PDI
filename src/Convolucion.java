import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;



public class Convolucion {
	private BufferedImage Auxiliar;
	public static final int SIN_BORDES = ConvolveOp.EDGE_NO_OP;
	
	
	public BufferedImage aplicarFiltro(float filtro[][], BufferedImage imagen, int tratBordes){
		try{
			float filtroK[]= new float[9];
			int k=0;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					System.out.println(filtro[i][j]);
					filtroK[k]=filtro[i][j];
					System.out.println(filtroK[k]);
					k++;
				}
			}
			Kernel kernel= new Kernel(3,3,filtroK);
			ConvolveOp convolucion= new ConvolveOp(kernel,tratBordes,null);
			Auxiliar = new BufferedImage(imagen.getWidth(),imagen.getHeight(),imagen.getType());
			convolucion.filter(imagen, Auxiliar);
			
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		
		return Auxiliar;
	}
	
}
