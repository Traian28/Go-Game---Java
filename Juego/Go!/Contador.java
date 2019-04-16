import javax.swing.JLabel;


public class Contador extends JLabel implements Runnable{
	//ATRIBUTOS DE INSTANCIA
	protected int segundos;
	protected int minutos;
	protected int horas;
	protected Thread hilo;
	
	//CONSTRUCTOR
	public Contador(){
		hilo=new Thread(this);
		hilo.start();
		segundos=0;minutos=0;horas=0;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread ct = Thread.currentThread();
		String s,m,h;String tiempo;
		while(ct==hilo){
			segundos++;
			if(segundos==60){
				segundos=0;
				minutos++;
				if(minutos==60){
					minutos=0;
					horas++;}}
			if(segundos<10){
				s="0";}
			else s="";
			if(minutos<10){
				m="0";}
			else m="";
			if(horas<10){
				h="0";}
			else h="";
			setText(h+horas+":"+m+minutos+":"+s+segundos);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	}
}
