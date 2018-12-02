
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ProcesamientoPDI extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnCargarImagen1;
	private JButton btnFiltroPB;
	private JButton btnSalir;
	private JLabel lblImagen1;
	private CargarImagen cargar;
	private JScrollPane scrollImagen2;
	private JLabel lblImagen2;
	private JButton btnFiltroPA;
	private JButton btnEscala;
	private JLabel lblImagenOriginal;
	private JLabel lblImagenFiltrada;
	private FiltroPasaAltos fPA;
	private FiltroPasaBajos fPB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcesamientoPDI frame = new ProcesamientoPDI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProcesamientoPDI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		fPA= new FiltroPasaAltos();
		fPB= new FiltroPasaBajos();
		cargar = new CargarImagen();
		
		btnCargarImagen1 = new JButton("Cargar Imagen 1");
		btnCargarImagen1.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCargarImagen1, 23, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCargarImagen1, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnCargarImagen1);
		
		btnFiltroPB = new JButton("Filtro Pasa-Bajos");
		btnFiltroPB.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFiltroPB, 0, SpringLayout.NORTH, btnCargarImagen1);
		btnFiltroPB.addActionListener(this);
		contentPane.add(btnFiltroPB);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSalir, 0, SpringLayout.SOUTH, btnCargarImagen1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnSalir);
		
		JScrollPane scrollImagen1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollImagen1, 23, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollImagen1, 21, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollImagen1, 348, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollImagen1, 412, SpringLayout.WEST, contentPane);
		contentPane.add(scrollImagen1);
		
		lblImagen1 = new JLabel("Imagen1");
		scrollImagen1.setViewportView(lblImagen1);
		
		scrollImagen2 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollImagen2, 23, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollImagen2, 35, SpringLayout.EAST, scrollImagen1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollImagen2, 348, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollImagen2, 444, SpringLayout.EAST, scrollImagen1);
		contentPane.add(scrollImagen2);
		
		lblImagen2 = new JLabel("Imagen2");
		scrollImagen2.setViewportView(lblImagen2);
		
		btnFiltroPA = new JButton("Filtro Pasa-Altos");
		btnFiltroPA.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFiltroPB, 41, SpringLayout.EAST, btnFiltroPA);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFiltroPA, 0, SpringLayout.NORTH, btnCargarImagen1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFiltroPA, 26, SpringLayout.EAST, btnCargarImagen1);
		contentPane.add(btnFiltroPA);
		
		btnEscala = new JButton("Escala de Grises");
		btnEscala.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEscala, 35, SpringLayout.EAST, btnFiltroPB);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEscala, 0, SpringLayout.SOUTH, btnCargarImagen1);
		contentPane.add(btnEscala);
		
		lblImagenOriginal = new JLabel("Imagen Original");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagenOriginal, 95, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagenOriginal, -6, SpringLayout.NORTH, scrollImagen1);
		contentPane.add(lblImagenOriginal);
		
		lblImagenFiltrada = new JLabel("Imagen Con Filtro");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagenFiltrada, 0, SpringLayout.NORTH, lblImagenOriginal);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagenFiltrada, -251, SpringLayout.EAST, contentPane);
		contentPane.add(lblImagenFiltrada);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnCargarImagen1){
			lblImagen1.setText("");
			lblImagen1.setIcon(new ImageIcon(cargar.abrirImagen1()));
			//lblImagen1.setIcon(new ImageIcon(cargar.escalaGrises()));
		}
		if(e.getSource()==btnFiltroPA){
			try{
				String opcion=JOptionPane.showInputDialog( "Elige una opción: \n1)\n2)\n3)\n4)" );
				int opc= Integer.parseInt(opcion);
				lblImagen2.setIcon(new ImageIcon(fPA.aplicarFiltro(cargar.getImagen(),opc)));
			}catch(Exception c){
				
			}
		}
		if(e.getSource()==btnFiltroPB){
			lblImagen2.setText("");
			try{
				String opcion=JOptionPane.showInputDialog( "Introduce Sigma: " );
				float op= Float.parseFloat(opcion);
				lblImagen2.setIcon(new ImageIcon(fPB.aplicarFiltro(cargar.getImagen(),op)));
			}catch(Exception g){
				
			}
		}
		if(e.getSource()==btnEscala){
			lblImagen2.setText("");
			lblImagen2.setIcon(new ImageIcon(cargar.escalaGrises()));
		}
		if(e.getSource()==btnSalir){
			System.exit(0);
		}
	}
}
