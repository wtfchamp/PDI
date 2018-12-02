import java.awt.image.BufferedImage;
import java.awt.Color;

public class FiltroPasaBajos {
	private BufferedImage Auxiliar;
	private Convolucion convo;
	
	public BufferedImage aplicarFiltro(BufferedImage imagen,float sigma){
		float kernel[][]= generarKernel(sigma);
		convo= new Convolucion();
		Auxiliar= convo.aplicarFiltro(kernel, imagen, Convolucion.SIN_BORDES);
		return Auxiliar;
	}
	public float[][] generarKernel(float sigma){
		float kernel[][]= new float[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				kernel[j][i]=this.generarGaussiano(sigma,i-(3/2),j-(3/2));
				System.out.println(kernel[j][i]);
			}
		}
		return kernel;
	}
	
	public float generarGaussiano(float sigma,int x,int y){
		float valor=0;
		for(double yPixel=y-0.5;yPixel<y+0.55;yPixel+=0.1){
			for(double xPixel=x-0.5;xPixel<x+0.55;xPixel+=0.1){
				valor= valor + (float)((1/(2*Math.PI*sigma*sigma)) *
			            Math.pow(Math.E,-(xPixel*xPixel+yPixel*yPixel)/
		                          (2*sigma*sigma)));
			}
		}
		valor=valor/121;
		return valor;
	}
}
