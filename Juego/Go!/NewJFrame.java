import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class NewJFrame extends javax.swing.JFrame {
	private JLabel Salida;
	private JLabel PuntajeJ1;
	private JLabel PuntajeJ2;
	private JButton ColocarBlanca;
	private JButton ColocarNegra;
	private JTextField PosY;
	private JTextArea Tablero;
	private JTextField PosX;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			String t1 = "consult('proyecto.pl')";
			Query q1 = new Query(t1);
			
			System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				Salida = new JLabel();
				getContentPane().add(Salida, "Center");
				Salida.setText("");
				Salida.setBounds(74, 6, 317, 49);
			}
			{
				ColocarBlanca = new JButton();
				getContentPane().add(ColocarBlanca);
				ColocarBlanca.setText("Colocar Blanca");
				ColocarBlanca.setBounds(62, 62, 122, 40);
				ColocarBlanca.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ColocarBlancaMouseClicked(evt);
					}
				});
			}
			{
				ColocarNegra = new JButton();
				getContentPane().add(ColocarNegra);
				ColocarNegra.setText("Colocar Negra");
				ColocarNegra.setBounds(263, 62, 131, 43);
				ColocarNegra.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ColocarNegraMouseClicked(evt);
					}
				});
			}
			{
				PosX = new JTextField();
				getContentPane().add(PosX);
				PosX.setText("");
				PosX.setBounds(105, 129, 81, 34);
			}
			{
				PosY = new JTextField();
				getContentPane().add(PosY);
				PosY.setText("");
				PosY.setBounds(231, 130, 80, 36);
			}
			{
				Tablero = new JTextArea();
				getContentPane().add(Tablero);
				Tablero.setText("");
				Tablero.setBounds(27, 178, 508, 358);
				String tablero="-----01-02-03-04-05-06-07-08-09-10-11-12-13-14-15-16-17-18-19\n";
				for(int i=1;i<=19;i++){
					String num=(new Integer(i)).toString();
					if(i<10){
						tablero+="-0"+num;}
					else{tablero+="-"+num;}
					for(int j=1;j<=19;j++){
						String t3 = "negra("+i+", "+j+")";
						Query q3 = new Query(t3);
						if(q3.hasSolution()){
							tablero+="-nn";}
						String t4 = "blanca("+i+", "+j+")";
						Query q4 = new Query(t4);
						if(q4.hasSolution()){
							tablero+="-bb";}
						String t5 = "libre("+i+", "+j+")";
						Query q5 = new Query(t5);
						if(q5.hasSolution()){
							tablero+="-00";}}
					tablero+='\n';}
				Tablero.setText(tablero);
			}
			{
				PuntajeJ1 = new JLabel();
				getContentPane().add(PuntajeJ1);
				PuntajeJ1.setText("0");
				PuntajeJ1.setBounds(463, 67, 66, 29);
			}
			{
				PuntajeJ2 = new JLabel();
				getContentPane().add(PuntajeJ2);
				PuntajeJ2.setText("0");
				PuntajeJ2.setBounds(463, 114, 41, 22);
			}
			pack();
			this.setSize(593, 596);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
		
	}
	
	private void ColocarBlancaMouseClicked(MouseEvent evt) {
		System.out.println("ColocarBlanca.mouseClicked, event="+evt);
		//TODO add your code for ColocarBlanca.mouseClicked
		String x=PosX.getText();String y=PosY.getText();
		String t2 = "colocarBlanca("+x+","+y+")";
		Query q2 = new Query(t2);
		String t="";
		if(q2.hasSolution()){
			t="Se coloco la ficha blanca en ("+x+","+y+")";}
		else{
			t="No se pudo colocar ficha blanca en ("+x+","+y+")";}
		Salida.setText(t);
		PosX.setText("");PosY.setText("");
		String tablero="-----01-02-03-04-05-06-07-08-09-10-11-12-13-14-15-16-17-18-19\n";
		for(int i=1;i<=19;i++){
			String num=(new Integer(i)).toString();
			if(i<10){
				tablero+="-0"+num;}
			else{tablero+="-"+num;}
			for(int j=1;j<=19;j++){
				String t3 = "negra("+i+", "+j+")";
				Query q3 = new Query(t3);
				if(q3.hasSolution()){
					tablero+="-nn";}
				String t4 = "blanca("+i+", "+j+")";
				Query q4 = new Query(t4);
				if(q4.hasSolution()){
					tablero+="-bb";}
				String t5 = "libre("+i+", "+j+")";
				Query q5 = new Query(t5);
				if(q5.hasSolution()){
					tablero+="-00";}}
			tablero+='\n';}
		Tablero.setText(tablero);
		String t6 = "puntaje(j1,X)";
		Query q6 = new Query(t6);
		String p1=q6.oneSolution().get("X").toString();
	
		String t7 = "puntaje(j2,X)";
		Query q7 = new Query(t7);
		String p2=q7.oneSolution().get("X").toString();
		
		PuntajeJ1.setText(p1);
		PuntajeJ2.setText(p2);
	}
	
	private void ColocarNegraMouseClicked(MouseEvent evt) {
		System.out.println("ColocarNegra.mouseClicked, event="+evt);
		//TODO add your code for ColocarNegra.mouseClicked
		String x=PosX.getText();String y=PosY.getText();
		String t2 = "colocarNegra("+x+", "+y+")";
		Query q2 = new Query(t2);
		String t="";
		if(q2.hasSolution()){
			t="Se coloco la ficha negra en ("+x+","+y+")";}
		else{
			t="No se pudo colocar ficha negra en ("+x+","+y+")";}
		Salida.setText(t);
		PosX.setText("");PosY.setText("");
		String tablero="-----01-02-03-04-05-06-07-08-09-10-11-12-13-14-15-16-17-18-19\n";
		for(int i=1;i<=19;i++){
			String num=(new Integer(i)).toString();
			if(i<10){
				tablero+="-0"+num;}
			else{tablero+="-"+num;}
			for(int j=1;j<=19;j++){
				String t3 = "negra("+i+", "+j+")";
				Query q3 = new Query(t3);
				if(q3.hasSolution()){
					tablero+="-nn";}
				String t4 = "blanca("+i+", "+j+")";
				Query q4 = new Query(t4);
				if(q4.hasSolution()){
					tablero+="-bb";}
				String t5 = "libre("+i+", "+j+")";
				Query q5 = new Query(t5);
				if(q5.hasSolution()){
					tablero+="-00";}}
			tablero+='\n';}
		Tablero.setText(tablero);
		String t6 = "puntaje(j1,X)";
		Query q6 = new Query(t6);
		String p1=q6.oneSolution().get("X").toString();
	
		String t7 = "puntaje(j2,X)";
		Query q7 = new Query(t7);
		String p2=q7.oneSolution().get("X").toString();
		
		PuntajeJ1.setText(p1);
		PuntajeJ2.setText(p2);
}
}
