
import java.util.Hashtable;
import jpl.Query;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		String t1 = "consult('proyecto.pl')";
		Query q1 = new Query(t1);

		System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
		
		String t2 = "colocarBlanca(1,1)";
		Query q2 = new Query(t2);

		System.out.println( t2 + " " + (q2.hasSolution() ? "succeeded" : "failed") );*/
		
		String path=System.getProperty("java.library.path");
		System.out.println(path);
	/*	String t1 = "consult('family.pl')";
		Query q1 = new Query(t1);

		System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
		System.out.println("".length());*/

		//--------------------------------------------------
/*
		String t2 = "child_of(joe, ralf)";
		Query q2 = new Query(t2);

		System.out.println( t2 + " is " + (q2.hasSolution() ? "provable" : "not provable") );

		//--------------------------------------------------

		String t3 = "descendent_of(steve, ralf)";
		Query q3 = new Query(t3);

		System.out.println( t3 + " is " +(q3.hasSolution() ? "provable" : "not provable") );*/

		//--------------------------------------------------
/*
		String t4 = "lista(X)";
		Query q4 = new Query(t4);
		System.out.println(q4.hasSolution()?"Si":"No");
		Object lista=q4.oneSolution();
		System.out.println(lista==null?"Si":"No");
		
		System.out.println(lista);
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
		System.out.println(limpio);*/

		//System.out.println( "first solution of " + t4 + ": X = " + q4.oneSolution().get("X"));

		//--------------------------------------------------
/*
		Hashtable[] ss4 = q4.allSolutions();

		System.out.println( "all solutions of " + t4);
		for ( int i=0 ; i<ss4.length ; i++ ) {
			System.out.println( "X = " + ss4[i].get("X"));
		}*/

		//--------------------------------------------------
/*
		System.out.println( "each solution of " + t4);
		while ( q4.hasMoreSolutions() ){
			Hashtable s4 = q4.nextSolution();
			System.out.println( "X = " + s4.get("X"));
		}

		//--------------------------------------------------

		String t5 = "descendent_of(X,Y)";
		Query q5 = new Query(t5);

		System.out.println( "each solution of " + t5 );
		while ( q5.hasMoreSolutions() ){
			Hashtable s5 = q5.nextSolution();
			System.out.println( "X = " + s5.get("X") + ", Y = " + s5.get("Y"));

		}*/

	}

}
