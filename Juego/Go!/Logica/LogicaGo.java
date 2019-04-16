package Logica;

import java.util.Hashtable;

import jpl.Query;

public class LogicaGo {
	//CONSTRUCTOR
	public LogicaGo(){
		String t="consult('JuegoGo.pl')";
		Query q = new Query(t);		
		System.out.println( t + " " + (q.hasSolution() ? "succeeded" : "failed") );		
	}
	
	public void reiniciar(){
		String t = "reiniciar";
		Query q = new Query(t);
		
		System.out.println( t + " " + (q.hasSolution() ? "succeeded" : "failed") );
	}
	
	public Hashtable colocarFichaNegra(int x,int y){
		String t="colocarFicha(n,"+x+","+y+",Atrapadas)";
		Query q = new Query(t);
		Hashtable sol=q.oneSolution();		
		return sol;		
	}
	
	public Hashtable colocarFichaBlanca(int x,int y){
		String t="colocarFicha(b,"+x+","+y+",Atrapadas)";
		Query q = new Query(t);
		Hashtable sol=q.oneSolution();
		return sol;
	}
	
	public Hashtable colocarFichaComputadora(){
		String t="fichaComputadora(X,Y,Atrapadas)";
		Query q = new Query(t);
		Hashtable sol=q.oneSolution();
		return sol;		
	}
	
	public String puntajeJ1(){
		String t="puntaje(n,P)";
		Query q = new Query(t);
		return(q.oneSolution().get("P").toString());		
	}
	
	public String puntajeJ2(){
		String t="puntaje(b,P)";
		Query q = new Query(t);
		return(q.oneSolution().get("P").toString());		
	}
	
	public boolean sigueJuego(){
		String t="finJuego";
		Query q = new Query(t);
		if(q.oneSolution()==null)
			return true;
		return false;		
	}
	
	public String armar(String lista){
		String limpio="";
		if(lista.charAt(0)!='['){
			limpio+="(";
			int pos=7;boolean par=true;
			while(pos<lista.length()){
				if((lista.charAt(pos)=='(')&&par){
					while((pos<lista.length())&&(lista.charAt(pos)!=',')){
						limpio+=lista.charAt(pos);pos++;}
					limpio+=lista.charAt(pos);pos++;
					pos++;
					while((pos<lista.length())&&(lista.charAt(pos)!=')')){
						limpio+=lista.charAt(pos);pos++;}
					limpio+=lista.charAt(pos);pos++;
					par=false;}
				else{if((lista.charAt(pos)=='(')&&!par)	{
						par=true;}
					pos++;}}
			limpio+=")";}
		return limpio;
	}
	

}
