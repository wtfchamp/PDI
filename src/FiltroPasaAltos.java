import java.awt.image.BufferedImage;
import java.awt.Color;

public class FiltroPasaAltos {
	private BufferedImage Auxiliar;
	private Convolucion convo;
	
	public BufferedImage aplicarFiltro(BufferedImage imagen,int opcion){
		float kernel[][];
		convo= new Convolucion();
		if(opcion==1){
			kernel=this.generarKernel1();
			Auxiliar= convo.aplicarFiltro(kernel, imagen, Convolucion.SIN_BORDES);
		}
		if(opcion==2){
			kernel=this.generarKernel2();
			Auxiliar= convo.aplicarFiltro(kernel, imagen, Convolucion.SIN_BORDES);
		}
		if(opcion==3){
			kernel=this.generarKernel3();
			Auxiliar= convo.aplicarFiltro(kernel, imagen, Convolucion.SIN_BORDES);
		}
		if(opcion==4){
			kernel=this.generarKernel4();
			Auxiliar= convo.aplicarFiltro(kernel, imagen, Convolucion.SIN_BORDES);
		}
		return Auxiliar;
	}
	public float[][] generarKernel1(){
		float kernel[][]= new float[3][3];
		kernel[0][0]=0; kernel[0][1]=-1; kernel[0][2]=0;
		kernel[1][0]=-1; kernel[1][1]=5; kernel[1][2]=-1;
		kernel[2][0]=0; kernel[2][1]=-1; kernel[2][2]=0;
		return kernel;
	}

	public float[][] generarKernel2(){
		float kernel[][]= new float[3][3];
		kernel[0][0]=-1; kernel[0][1]=-1; kernel[0][2]=-1;
		kernel[1][0]=-1; kernel[1][1]=9; kernel[1][2]=-1;
		kernel[2][0]=-1; kernel[2][1]=-1; kernel[2][2]=-1;
		return kernel;
	}
	public float[][] generarKernel3(){
		float kernel[][]= new float[3][3];
		kernel[0][0]=-2; kernel[0][1]=0; kernel[0][2]=-2;
		kernel[1][0]=0; kernel[1][1]=5; kernel[1][2]=0;
		kernel[2][0]=-2; kernel[2][1]=0; kernel[2][2]=-2;
		return kernel;
	}
	public float[][] generarKernel4(){
		float kernel[][]= new float[3][3];
		kernel[0][0]=1; kernel[0][1]=-2; kernel[0][2]=1;
		kernel[1][0]=-2; kernel[1][1]=4; kernel[1][2]=-1;
		kernel[2][0]=1; kernel[2][1]=-2; kernel[2][2]=1;
		return kernel;
	}
}

