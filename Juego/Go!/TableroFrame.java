import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Logica.LogicaGo;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import jpl.Query;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class TableroFrame extends javax.swing.JFrame{
	protected JPanel PanelFondo;
	protected JLabel JLabelFondo;
	protected JButton Boton1Jugador;
	protected JLabel JLabelTiempo;
	protected JButton BotonReiniciar;
	protected JButton Boton2Jugadores;
	protected JLabel JLabelModoJuego;
	protected JPanel PanelPresentacion;
	protected JLabel JLabelFondoPresentacion;
	protected JLabel LabelNombreJ2;
	protected JLabel LabelNombreJ1;
	protected JButton JBotonSalir;
	protected JButton JBotonIniciarJuego;
	protected boolean juegaNegro;
	protected JLabel JLabelFlecha;
	protected JLabel JLabelReloj;
	protected JLabel[][] labels;
	protected Contador contador;
	protected JPanel PanelModoJuego;
	protected JLabel parteDerecha;
	protected String jugador1,jugador2;
	protected BasicPlayer reproductor;
	protected JLabel sonido1,sonido2,sonido3;
	private JButton BotonInformacion;
	private JButton BotonVolver;
	private JMenuItem ItemSalir;
	private JMenuItem ItemMenuPrincipal;
	private JMenu Juego;
	private JMenuBar MenuBarra;
	private JLabel LabelEnlace;
	private JLabel LabelInformacion;
	private JOptionPane OptionPaneInformacion;
	protected boolean sonido;
	protected LogicaGo logica;
	protected int panelActivo;
	private JButton BotonPasar;
	private JLabel PuntajeJ2;
	private JLabel PuntajeJ1;
	private JMenuItem ItemAyuda;
	private JMenu JMenuAyuda;
	private JMenuItem ItemDosJugadores;
	private JMenuItem ItemUnJugador;
	private JMenu JMenuNuevaPartida;
	private JMenuItem ItemReiniciar;
	protected boolean unJugador;
	protected boolean pasoJ1,pasoJ2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroFrame inst = new TableroFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		logica=new LogicaGo();
		jugador1=null;
		jugador2=null;
		juegaNegro=true;
		reproductor=new BasicPlayer();
		panelActivo=1;
		try {
			reproductor.open(getClass().getClassLoader().getResource("cancion.mp3"));
			reproductor.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Go!");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				PanelModoJuego = new JPanel();
				//getContentPane().add(PanelModoJuego);
				PanelModoJuego.setBounds(0, 0, 796, 571);
				PanelModoJuego.setLayout(null);
				{
					JLabelModoJuego = new JLabel();
					PanelModoJuego.add(JLabelModoJuego);
					JLabelModoJuego.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/FondoModoJuego.jpg")));
					JLabelModoJuego.setBounds(0, 0, 796, 571);
					{
						Boton1Jugador = new JButton();
						JLabelModoJuego.add(Boton1Jugador);
						Boton1Jugador.setText("Un jugador");
						Boton1Jugador.setBounds(300, 160, 194, 57);
						Boton1Jugador.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								Boton1JugadorMouseClicked(evt);
							}
						});
					}
					{
						Boton2Jugadores = new JButton();
						JLabelModoJuego.add(Boton2Jugadores);
						Boton2Jugadores.setText("Dos jugadores");
						Boton2Jugadores.setBounds(300, 275, 194, 57);
						Boton2Jugadores.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								Boton2JugadoresMouseClicked(evt);
							}
						});
					}
					{
						BotonVolver = new JButton();
						JLabelModoJuego.add(BotonVolver);
						BotonVolver.setText("Volver");
						BotonVolver.setBounds(300, 390, 194, 57);
						BotonVolver.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								BotonVolverMouseClicked(evt);
							}
						});
					}					
				}
			}
			{
				PanelFondo = new JPanel();
				//getContentPane().add(PanelFondo);
				PanelFondo.setBounds(0, 0, 794, 610);
				PanelFondo.setLayout(null);
				PanelFondo.setBackground(Color.WHITE);
				{
					JLabelFondo = new JLabel();
					PanelFondo.add(JLabelFondo);
					JLabelFondo.setBounds(0, 0, 610, 610);
					JLabelFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/FondoJuego.png")));
				
					
					JLabelFondo.addMouseListener(new MouseAdapter() {
						public void mouseExited(MouseEvent evt) {
							JLabelFondoMouseExited(evt);
						}
						public void mouseEntered(MouseEvent evt) {
							JLabelFondoMouseEntered(evt);
						}
						public void mouseClicked(MouseEvent evt) {
							JLabelFondoMouseClicked(evt);
						}
					});
				}
				{
				parteDerecha=new JLabel();
				PanelFondo.add(parteDerecha);
				parteDerecha.setBounds(610, 0, 184, 610);
				parteDerecha.setVerticalAlignment(SwingConstants.BOTTOM);
				parteDerecha.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fondoOriental.png")));}
				//parteDerecha.setBackground(Color.WHITE);}
				
				{
					BotonPasar = new JButton();
					parteDerecha.add(BotonPasar);
					BotonPasar.setText("Pasar");
					BotonPasar.setBounds(50, 289, 81, 22);
					BotonPasar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							BotonPasarMouseClicked(evt);
						}
					});
				}
				
				JLabel FichaNegra = new JLabel();
				parteDerecha.add(FichaNegra);
				FichaNegra.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fichaNegra.png")));
				FichaNegra.setBounds(15, 45, 35, 30);
				
				JLabel FichaBlanca = new JLabel();
				parteDerecha.add(FichaBlanca);
				FichaBlanca.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fichaBlanca.png")));
				FichaBlanca.setBounds(15, 135, 35, 30);
				{
					PuntajeJ1 = new JLabel();
					parteDerecha.add(PuntajeJ1);
					PuntajeJ1.setBounds(55,80,80,30);
					PuntajeJ1.setText("Puntos: 0");
					PuntajeJ1.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					PuntajeJ2 = new JLabel();
					parteDerecha.add(PuntajeJ2);
					PuntajeJ2.setBounds(55,170,80,30);
					PuntajeJ2.setText("Puntos: 0");
					PuntajeJ2.setHorizontalAlignment(SwingConstants.CENTER);
				}
				
				{
					LabelNombreJ1 = new JLabel();
					LabelNombreJ1.setHorizontalAlignment(SwingConstants.CENTER);
					LabelNombreJ1.setOpaque(true);
					LabelNombreJ1.setBackground(Color.BLACK);
					LabelNombreJ1.setForeground(Color.WHITE);
					LabelNombreJ1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					parteDerecha.add(LabelNombreJ1);
					LabelNombreJ1.setBounds(55, 45, 80, 30);
				}
				{
					LabelNombreJ2 = new JLabel();
					LabelNombreJ2.setHorizontalAlignment(SwingConstants.CENTER);
					LabelNombreJ2.setOpaque(true);
					LabelNombreJ2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					LabelNombreJ2.setBackground(Color.WHITE);
					parteDerecha.add(LabelNombreJ2);
					LabelNombreJ2.setBounds(55, 135, 80, 30);
				}
			}
			{
				PanelPresentacion = new JPanel();
				getContentPane().add(PanelPresentacion);
				PanelPresentacion.setBounds(0, 0, 796, 571);
				PanelPresentacion.setLayout(null);
				{
					JLabelFondoPresentacion = new JLabel();
					PanelPresentacion.add(JLabelFondoPresentacion);
					JLabelFondoPresentacion.setBounds(0, 0, 796, 571);
					JLabelFondoPresentacion.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/FondoPresentacion.jpg")));
				}
				{
					JBotonIniciarJuego = new JButton();
					JLabelFondoPresentacion.add(JBotonIniciarJuego);
					JBotonIniciarJuego.setText("Nuevo Juego");
					JBotonIniciarJuego.setBounds(300, 160, 194, 57);
					JBotonIniciarJuego.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							JBotonIniciarJuegoMouseClicked(evt);
						}
					});
				}
				
				{
					BotonInformacion = new JButton();
					JLabelFondoPresentacion.add(BotonInformacion);
					BotonInformacion.setText("Informacion");
					BotonInformacion.setBounds(300, 275, 194, 57);
					BotonInformacion.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							BotonInformacionMouseClicked(evt);
						}
					});
				}
				
				{
					JBotonSalir = new JButton();
					JLabelFondoPresentacion.add(JBotonSalir);
					JBotonSalir.setText("Salir del Juego");
					JBotonSalir.setBounds(300, 390, 194, 57);
					JBotonSalir.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							JBotonSalirMouseClicked(evt);
						}
					});
				}
				/*
				{
					BotonReiniciar = new JButton();
					parteDerecha.add(BotonReiniciar);
					BotonReiniciar.setText("Reiniciar Partida");
					BotonReiniciar.setBounds(18, 344, 137, 26);
					BotonReiniciar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							BotonReiniciarMouseClicked(evt);
						}
					});
				}*/
				
				{
				
					
					{
						JLabelReloj = new JLabel();
						parteDerecha.add(JLabelReloj);
						JLabelReloj.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Reloj.gif")));
						JLabelReloj.setBounds(20,215,46,49);						
					}
					
					{
						JLabelFlecha = new JLabel();
						parteDerecha.add(JLabelFlecha);
						JLabelFlecha.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Flecha.gif")));
						JLabelFlecha.setBounds(140, 45, 38, 29);
					}
					
					
					{
						JLabelTiempo = new JLabel();
						JLabelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
						//parteDerecha.add(JLabelTiempo);
						JLabelTiempo.setText("Tiempo");
						JLabelTiempo.setBounds(35, 215, 100, 20);
					}
					//getContentPane().add(JOptionNombres);
				}
			}
			

			sonido1=new JLabel();
			JLabelFondoPresentacion.add(sonido1);
			sonido1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));
			sonido1.setBounds(700, 483, 50, 50);
			

			sonido1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					sonido1MouseClicked(evt);
				}
			});

			sonido2=new JLabel();
			JLabelModoJuego.add(sonido2);
			sonido2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));
			sonido2.setBounds(700, 483, 50, 50);
			
			sonido2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					sonido2MouseClicked(evt);
				}
			});

			sonido3=new JLabel();
			parteDerecha.add(sonido3);
			sonido3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));
			sonido3.setBounds(90, 483, 50, 50);
			sonido3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					sonido3MouseClicked(evt);
				}
			});
						
			
			sonido=true;

			pack();
			setSize(800, 623);
			
			labels=new JLabel[19][19];
			setResizable(false);
			{
				MenuBarra = new JMenuBar();
				setJMenuBar(MenuBarra);
				{
					Juego = new JMenu();
					MenuBarra.add(Juego);
					Juego.setText("Juego");
					{
						ItemMenuPrincipal = new JMenuItem();
						Juego.add(ItemMenuPrincipal);
						ItemMenuPrincipal.setText("Menu principal");
						ItemMenuPrincipal.addActionListener(new ActionListener(){
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent e){
								int rta=JOptionPane.showConfirmDialog(null,"¿Desea volver al menu principal?", "Menu principal", JOptionPane.YES_NO_OPTION);
								if(rta==0){
									if(panelActivo==2){
										getContentPane().remove(PanelModoJuego);
										getContentPane().add(PanelPresentacion);
										repaint();}
									else if(panelActivo==3){
											terminarPartida();
											getContentPane().add(PanelPresentacion);
											repaint();}
								panelActivo=1;
								resize(800,623);}}});
					}
					{
						ItemReiniciar = new JMenuItem();
						Juego.add(ItemReiniciar);
						ItemReiniciar.setText("Reiniciar partida");
						ItemReiniciar.setEnabled(false);
						ItemReiniciar.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								int rta=JOptionPane.showConfirmDialog(null,"¿Desea reiniciar la partida actual?","Reiniciar",JOptionPane.YES_NO_OPTION);
								if(rta==0){
									terminarPartida();		
									iniciarJuego();
									panelActivo=3;}}
						});
					}
					{
						ItemSalir = new JMenuItem();
						Juego.add(ItemSalir);
						ItemSalir.setText("Salir");
						ItemSalir.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									int rta=JOptionPane.showConfirmDialog(null,"¿Desea realmente salir del juego?", "Salir", JOptionPane.YES_NO_OPTION);
									if(rta==0){
										System.exit(0);}}});
					}
					
				}
				{
					JMenuNuevaPartida = new JMenu();
					MenuBarra.add(JMenuNuevaPartida);
					JMenuNuevaPartida.setText("Nueva partida");
					{
						ItemUnJugador = new JMenuItem();
						JMenuNuevaPartida.add(ItemUnJugador);
						ItemUnJugador.setText("Un jugador");
						ItemUnJugador.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								if(panelActivo==3){
									int rta=JOptionPane.showConfirmDialog(null,"¿Desea realmente salir de la partida actual?", "Salir partida", JOptionPane.YES_NO_OPTION);
									if(rta==0){									
										jugador1=JOptionPane.showInputDialog(null, "Nombre Jugador 1", "Jugadores",JOptionPane.QUESTION_MESSAGE);
										terminarPartida();
										panelActivo=3;
										unJugador=true;
										iniciarJuego();}}
								else{ 
									  jugador1=JOptionPane.showInputDialog(null, "Nombre Jugador 1", "Jugadores",JOptionPane.QUESTION_MESSAGE);
									  if(panelActivo==1){
										getContentPane().remove(PanelPresentacion);}
									  else{
										  getContentPane().remove(PanelModoJuego);}
									  repaint();
									  panelActivo=3;
									  unJugador=true;
									  iniciarJuego();}
								}
							});
					}
					{
						ItemDosJugadores = new JMenuItem();
						JMenuNuevaPartida.add(ItemDosJugadores);
						ItemDosJugadores.setText("Dos jugadores");
						ItemDosJugadores.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								if(panelActivo==3){
									int rta=JOptionPane.showConfirmDialog(null,"¿Desea realmente salir de la partida actual?", "Salir partida", JOptionPane.YES_NO_OPTION);
								if(rta==0){									
									jugador1=JOptionPane.showInputDialog(null, "Nombre Jugador 1", "Jugadores",JOptionPane.QUESTION_MESSAGE);
									if(jugador1!=null)
										jugador2=JOptionPane.showInputDialog(null, "Nombre Jugador 2", "Jugadores",JOptionPane.QUESTION_MESSAGE);
									if((jugador1!=null)&&(jugador2!=null)){
										terminarPartida();
										repaint();
										panelActivo=3;
										unJugador=false;
										iniciarJuego();}}}
								else{
									jugador1=JOptionPane.showInputDialog(null, "Nombre Jugador 1", "Jugadores",JOptionPane.QUESTION_MESSAGE);
									jugador2=JOptionPane.showInputDialog(null, "Nombre Jugador 2", "Jugadores",JOptionPane.QUESTION_MESSAGE);
									if(panelActivo==1){
										getContentPane().remove(PanelPresentacion);}
									else{
										getContentPane().remove(PanelModoJuego);}
									repaint();
									panelActivo=3;
									unJugador=false;
									iniciarJuego();}
								}
							});
					}
						
				}
				{
					JMenuAyuda = new JMenu();
					MenuBarra.add(JMenuAyuda);
					JMenuAyuda.setText("Ayuda");
					{
						ItemAyuda = new JMenuItem();
						JMenuAyuda.add(ItemAyuda);
						ItemAyuda.setText("Acerca de Go!");
						ItemAyuda.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								JOptionPane.showMessageDialog(null, "<html><a href='www.google.com'>Google</a>  El go es un juego de mesa estratégico para dos jugadores. Se originó en China hace más de 2500 años<br>  y aunque no se sabe con exactitud cuándo fue inventado, hacia el 300 a. C.<br>  El objetivo del juego es controlar una porción más grande del tablero que el oponente. Una piedra o grupo<br>  de piedras se captura y retira del juego si no tiene intersecciones vacías adyacentes, esto es,<br>si se encuentra completamente rodeada de piedras del color contrario.</html>", "Acerca de GO!",JOptionPane.INFORMATION_MESSAGE);
								
							}
						});
					}
				}
			}

			//String t1 = "consult('proyecto.pl')";
			
			String t1="consult('JuegoGo.pl')";
			Query q1 = new Query(t1);
			
			System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	private void limpiarTablero(){
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				if(labels[i][j]!=null){
					JLabelFondo.remove(labels[i][j]);
					labels[i][j]=null;}}}	
	}
	
	private void terminarPartida(){
		getContentPane().remove(PanelFondo);
		parteDerecha.remove(contador);
		limpiarTablero();
		repaint();
		logica.reiniciar();
		ItemReiniciar.setEnabled(false);
		
	}
	
	@SuppressWarnings("deprecation")
	private void iniciarJuego(){
		pasoJ1=false;
		pasoJ2=false;
		BotonPasar.setEnabled(true);
		ItemReiniciar.setEnabled(true);
		JLabelFlecha.setBounds(140, 45, 38, 29);
		juegaNegro=true;
		if((jugador1==null)||(jugador1.length()==0)){
			jugador1="Jugador 1";}
		if((jugador2==null)||(jugador2.length()==0)){
			jugador2="Jugador 2";}
		LabelNombreJ1.setText(jugador1);
		LabelNombreJ2.setText(jugador2);
		resize(800,662);
		contador=new Contador();
		contador.setOpaque(true);
		contador.setHorizontalAlignment(SwingConstants.CENTER);
		contador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contador.setBackground(Color.BLACK);
		contador.setForeground(Color.RED);
		parteDerecha.add(contador);
		contador.setBounds(70, 215, 100, 50);
		contador.repaint();
		getContentPane().add(PanelFondo);		
		repaint();
		Image im=Toolkit.getDefaultToolkit().createImage("C:/Users/Luciano/Pictures/NegraChica.png");
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
		setCursor(cur); 
		
	}
	
	private void finPartida(){
		System.out.println("Termino partida");
	}
	
	
	private void borrarFichasAtrapadas(String fichas){
		if(fichas.length()>0){
			int pos=1;
			while(pos<fichas.length()){
				if(fichas.charAt(pos)=='('){
					pos++;int x=0;int y=0;int dig;
					while((pos<fichas.length())&&(fichas.charAt(pos)!=',')){
						dig=fichas.charAt(pos)-'0';
						x=x*10+dig;
						pos++;}
					pos++;
					while((pos<fichas.length())&&(fichas.charAt(pos)!=')')){
						dig=fichas.charAt(pos)-'0';
						y=y*10+dig;
						pos++;}
					pos++;
					System.out.println(x+":"+y);
					JLabelFondo.remove(labels[x-1][y-1]);
					JLabelFondo.repaint();
					labels[x-1][y-1]=null;}
				else pos++;}}
	}
	
	private void actualizarPuntajeJ1(){
		//String t2 = "puntaje(j1,P)";		
		PuntajeJ1.setText(" "+jugador1+": "+logica.puntajeJ1());		
	}
	private void actualizarPuntajeJ2(){
		//String t2 = "puntaje(j2,P)";
		//String t2="puntaje(b,P)";
		//Query q2 = new Query(t2);
		PuntajeJ2.setText(" "+jugador2+": "+logica.puntajeJ2());		
	}
	
	private void JBotonSalirMouseClicked(MouseEvent evt) {
		System.out.println("JBotonSalir.mouseClicked, event="+evt);
		//TODO add your code for JBotonSalir.mouseClicked
		int rta=JOptionPane.showConfirmDialog(this, "¿Desea realmente salir del juego?","Salir",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(rta==0){
			System.exit(0);}
	}
	
	private void JBotonIniciarJuegoMouseClicked(MouseEvent evt) {
		System.out.println("JBotonIniciarJuego.mouseClicked, event="+evt);
		//TODO add your code for JBotonIniciarJuego.mouseClicked
		//getContentPane().remove(PanelPresentacion);
		//iniciarJuego();
		getContentPane().remove(PanelPresentacion);
		repaint();
		getContentPane().add(PanelModoJuego);
		panelActivo=2;
	}
	
	private void JLabelFondoMouseClicked(MouseEvent evt) {
		System.out.println("JLabelFondo.mouseClicked, event="+evt);
		//TODO add your code for JLabelFondo.mouseClicked
		Point p=evt.getPoint();
		int x=(int)Math.round((p.getX()-18)/31)+1;
		int y=(int)Math.round((p.getY()-18)/31)+1;
		System.out.println("Pos: "+x+" "+y);
		if((x>0 && x<20)&&(y>0 && y<20)){
		if(juegaNegro){
			Hashtable sol=logica.colocarFichaNegra(x,y);
			if(sol!=null){
				int posX=(x-1)*31+(28-14);
				int posY=(y-1)*31+(28-14);
				JLabel f = new JLabel();
				JLabelFondo.add(f);
				f.setBounds(posX, posY, 35, 30);
				f.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fichaNegra.png")));
				labels[x-1][y-1]=f;
				juegaNegro=false;
				actualizarPuntajeJ1();
				String lista=logica.armar(sol.get("Atrapadas").toString());
				borrarFichasAtrapadas(lista);
				JLabelFlecha.setBounds(140, 150, 38, 29);				
				if(!unJugador){
					Image im=Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("Imagenes/fichaBlanca.png"));
					Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
					setCursor(cur);
					if(!pasoJ2){
						BotonPasar.setEnabled(true);}
					else BotonPasar.setEnabled(false);}
				else{
					Hashtable solPC=logica.colocarFichaComputadora();
					if(solPC!=null){
						x=Integer.parseInt(solPC.get("X").toString());
						y=Integer.parseInt(solPC.get("Y").toString());
						posX=(x-1)*31+(28-14);
						posY=(y-1)*31+(28-14);
						JLabel blanca = new JLabel();
						JLabelFondo.add(blanca);
						blanca.setBounds(posX, posY, 35, 30);
						blanca.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fichaBlanca.png")));
						labels[x-1][y-1]=blanca;
						lista=logica.armar(solPC.get("Atrapadas").toString());
						borrarFichasAtrapadas(lista);
						actualizarPuntajeJ2();
						juegaNegro=true;
						JLabelFlecha.setBounds(140, 45, 38, 29);
						if(!pasoJ1){
							BotonPasar.setEnabled(true);}
						else BotonPasar.setEnabled(false);
						System.out.println("Computadora: "+x+":"+y);
						}
					else{
						pasoJ2=true;
						if(pasoJ1){
							finPartida();}
					}
				}
			
			}
			else{
				if(sonido){
					try {
						BasicPlayer error=new BasicPlayer();
						error.open(getClass().getClassLoader().getResource("Sonidos/sonido.mp3"));
						error.play();
					} catch (BasicPlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}}
				JOptionPane.showMessageDialog(this, "La jugada realizada no es válida.", "Jugada inválida", JOptionPane.INFORMATION_MESSAGE);}}
		else{
			Hashtable sol=logica.colocarFichaBlanca(x,y);
			if(sol!=null){
				int posX=(x-1)*31+(28-14);
				int posY=(y-1)*31+(28-14);
				JLabel f = new JLabel();
				JLabelFondo.add(f);
				f.setBounds(posX, posY, 35, 30);
				f.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/fichaBlanca.png")));
				labels[x-1][y-1]=f;
				juegaNegro=true;
				actualizarPuntajeJ2();
				String lista=logica.armar(sol.get("Atrapadas").toString());
				System.out.println(lista==""?"Vacia":lista);
				borrarFichasAtrapadas(lista);
				Image im=Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("Imagenes/fichaNegra.png"));
				Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
				setCursor(cur);
				JLabelFlecha.setBounds(140, 45, 38, 29);
				if(!pasoJ1){
					BotonPasar.setEnabled(true);}
				else BotonPasar.setEnabled(false);}
			else{
				if(sonido){
					try {
						BasicPlayer error=new BasicPlayer();
						error.open(getClass().getClassLoader().getResource("Sonidos/sonido.mp3"));
						error.play();
					} catch (BasicPlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}}
				JOptionPane.showMessageDialog(this, "La jugada realizada no es válida.", "Jugada inválida", JOptionPane.INFORMATION_MESSAGE);}}	
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		int rta=JOptionPane.showConfirmDialog(this, "¿Desea realmente salir del juego?","Salir",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(rta==0){
			System.exit(0);}
	}
	
	private void Boton1JugadorMouseClicked(MouseEvent evt) {
		System.out.println("Boton1Jugador.mouseClicked, event="+evt);
		//TODO add your code for Boton1Jugador.mouseClicked
		jugador1=JOptionPane.showInputDialog(this, "Nombre Jugador", "Jugadores",JOptionPane.QUESTION_MESSAGE);
		panelActivo=3;
		jugador2="PC";
		unJugador=true;
		getContentPane().remove(PanelModoJuego);
		repaint();
		iniciarJuego();
	}
	
	private void Boton2JugadoresMouseClicked(MouseEvent evt) {
		System.out.println("Boton2Jugadores.mouseClicked, event="+evt);
		//TODO add your code for Boton2Jugadores.mouseClicked
		jugador1=JOptionPane.showInputDialog(this, "Nombre Jugador 1", "Jugadores",JOptionPane.QUESTION_MESSAGE);
		if(jugador1!=null)
			jugador2=JOptionPane.showInputDialog(this, "Nombre Jugador 2", "Jugadores",JOptionPane.QUESTION_MESSAGE);
		if((jugador1!=null)&&(jugador2!=null)){
			getContentPane().remove(PanelModoJuego);
			repaint();
			iniciarJuego();}
		panelActivo=3;
		unJugador=false;
	}
	
		
	private void JLabelFondoMouseEntered(MouseEvent evt) {
		System.out.println("JLabelFondo.mouseEntered, event="+evt);
		//TODO add your code for JLabelFondo.mouseEntered
		//Image im = Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("Imagenes/Otros/humano4.png")); 
		Image im;
		if(juegaNegro){
			im=Toolkit.getDefaultToolkit().createImage("C:/Users/Luciano/Pictures/NegraChica.png");}
		else im=Toolkit.getDefaultToolkit().createImage("C:/Users/Luciano/Pictures/BlancaChica.png");
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
		setCursor(cur);  

	}
	
	private void JLabelFondoMouseExited(MouseEvent evt) {
		System.out.println("JLabelFondo.mouseExited, event="+evt);
		//TODO add your code for JLabelFondo.mouseExited
		setCursor(null);
	}
	
	private void sonido1MouseClicked(MouseEvent evt) {
		System.out.println("sonido1.mouseClicked, event="+evt);
		//TODO add your code for sonido1.mouseClicked
		if(sonido){
			try {
				reproductor.stop();
			} catch (BasicPlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sonido=false;
			sonido1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/mute2.png")));
			sonido2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/mute2.png")));
			sonido3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/mute2.png")));}
		else{
			try {
				reproductor.play();
			} catch (BasicPlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sonido=true;
			sonido1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));
			sonido2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));
			sonido3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sonido2.png")));}		
	}
	
	private void sonido2MouseClicked(MouseEvent evt) {
		System.out.println("sonido2.mouseClicked, event="+evt);
		//TODO add your code for sonido2.mouseClicked
		sonido1MouseClicked(evt);
	}
	
	private void sonido3MouseClicked(MouseEvent evt) {
		System.out.println("sonido3.mouseClicked, event="+evt);
		//TODO add your code for sonido3.mouseClicked
		sonido1MouseClicked(evt);
	}
	
	private void BotonVolverMouseClicked(MouseEvent evt) {
		System.out.println("BotonVolver.mouseClicked, event="+evt);
		//TODO add your code for BotonVolver.mouseClicked
		getContentPane().remove(PanelModoJuego);
		getContentPane().add(PanelPresentacion);				
		repaint();
		panelActivo=1;
	}
	
	
	
	private void BotonInformacionMouseClicked(MouseEvent evt) {
		System.out.println("BotonInformacion.mouseClicked, event="+evt);
		//TODO add your code for BotonInformacion.mouseClicked
		//JOptionPane.showMessageDialog(this,"<html><a href=http://http://playgo.to/iwtg/en/</a></html>", "Informacion",JOptionPane.INFORMATION_MESSAGE);
		//JLabelFondoPresentacion.add(OptionPaneInformacion);
		JOptionPane.showMessageDialog(this, "<html><aligneament=center> Proyecto realizado por los estudiantes<br> Luciano Aguirre y Traian Alimenti Bel.<br>Logica para Ciencias de la Computacion, 2013.</aligneament></html>","Informacion",JOptionPane.INFORMATION_MESSAGE);
		panelActivo=1;
		
	}
	
	private void BotonPasarMouseClicked(MouseEvent evt) {
		System.out.println("BotonPasar.mouseClicked, event="+evt);
		//TODO add your code for BotonPasar.mouseClicked
		if(juegaNegro){
			if(!pasoJ1){
				if(!unJugador){
					juegaNegro=false;
					pasoJ1=true;
					if(!pasoJ2){
						BotonPasar.setEnabled(true);}
					else{
						finPartida();}
					System.out.println("Paso negro");}
				}}
		else{
			if(!pasoJ2){
				juegaNegro=true;
				pasoJ2=true;
				if(!pasoJ1){
					BotonPasar.setEnabled(true);}
				else finPartida();
				System.out.println("Pasa blanco");}}
	}

}
