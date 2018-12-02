
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargarImagen {
	    
	    //Imagen actual que se ha cargado
	    private BufferedImage imagenActual1;
	    
	    //Método que devuelve una imagen abierta desde archivo
	    //Retorna un objeto BufferedImagen
	    public BufferedImage abrirImagen1(){
	        //Creamos la variable que será devuelta (la creamos como null)
	        BufferedImage bmp=null;
	        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
	        JFileChooser selector=new JFileChooser();
	        //Le damos un título
	        selector.setDialogTitle("Seleccione una imagen");
	        //Filtramos los tipos de archivos
	        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp","tif","png");
	        selector.setFileFilter(filtroImagen);
	        //Abrimos el cuadro de diálog
	        int flag=selector.showOpenDialog(null);
	        //Comprobamos que pulse en aceptar
	        if(flag==JFileChooser.APPROVE_OPTION){
	            try {
	                //Devuelve el fichero seleccionado
	                File imagenSeleccionada=selector.getSelectedFile();
	                //Asignamos a la variable bmp la imagen leida
	                bmp = ImageIO.read(imagenSeleccionada);
	            } catch (Exception e) {
	            }
	                 
	        }
	        //Asignamos la imagen cargada a la propiedad imageActual
	        imagenActual1=bmp;
	        //Retornamos el valor
	        return bmp;
	    }
	   	    
	    public BufferedImage getImagen(){
	    	return imagenActual1;
	    }
	    
	    
	    public BufferedImage escalaGrises(){
	        //Variables que almacenarán los píxeles
	        int mediaPixel,colorSRGB;
	        Color colorAux;
	                
	        //Recorremos la imagen píxel a píxel
	        for( int i = 0; i < imagenActual1.getWidth(); i++ ){
	            for( int j = 0; j < imagenActual1.getHeight(); j++ ){
	                //Almacenamos el color del píxel
	                colorAux=new Color(this.imagenActual1.getRGB(i, j));
	                //Calculamos la media de los tres canales (rojo, verde, azul)
	                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
	                //Cambiamos a formato sRGB
	                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
	                //Asignamos el nuevo valor al BufferedImage
	                imagenActual1.setRGB(i, j,colorSRGB);
	            }
	        }
	        //Retornamos la imagen
	        return imagenActual1;
	    }
	    
	    
	}

