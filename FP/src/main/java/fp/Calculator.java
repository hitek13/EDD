package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		return x.getClass();
		//DONE
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> listInt = new ArrayList<Integer>();
		int x = 0 , y = 1, aux = 0;
		
		for (int i = 0; i < n; i++){
			aux = x;
			x = y;
			y += aux;
			listInt.add(x);
		}
		
		return listInt;
		//DONE
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int count = number, j = 0;
		
		do{
			count -=step;
			j++;
		}	
		while(count > 0);

		j--;
		
		int v[] = new int[j];
		
		for(int i = 0; i<j ; i++){
			number -= step;
			v[i] = number;
		}
		
		return v;
		//DONE
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		  List listaDiv=new ArrayList<>();
	        for(int i=1; i<=(int)n/2; i++){
	            if(n%i==0){
	                listaDiv.add(i);
	            }
	        }
	        listaDiv.add(n);
	        
		Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(listaDiv, comparador);
        
        int[] array=new int[listaDiv.size()];
        
        Iterator it=listaDiv.iterator();
        
        for(int i=0; i<listaDiv.size();i++){
            if(it.hasNext()){
                array[i]=(int) it.next();
            }
        }
        if(n==0)
        	return new int [0];
        return array;  
        //DONE
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null)
			return false;
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		//String output = cadena;
		for (int i=0; i<original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			cadena=cadena.replace(original.charAt(i), ascii.charAt(i));
		}
		
		cadena=cadena.toLowerCase();
		for(int i=0; i<cadena.length();i++){
			if(cadena.charAt(i) > 'z' || cadena.charAt(i) < 'a')
				cadena=cadena.replace(cadena.charAt(i),' ');
		}
		cadena=cadena.replace(" ", "");
		
		//System.out.println(cadena);
		for (int i = 0; i < cadena.length()/2; i++){
			if(cadena.charAt(i) != cadena.charAt(cadena.length()-1-i))
			return false;
		}
		return true;
		//DUNE
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int d = (int)n/10;
		//System.out.println(d);
		String numero = "", sub = "";
		switch (d) {
		case 0:
			switch (n) {
			case 0:
				return "Cero";
			case 1:
				return "Uno";
			case 2:
				return "Dos";
			case 3:
				return "Tres";
			case 4:
				return "Cuatro";
			case 5:
				return "Cinco";
			case 6:
				return "Seis";
			case 7:
				return "Siete";
			case 8:
				return "Ocho";
			case 9:
				return "Nueve";
			}
			break;
		case 1:
			switch (n) {
			case 10:
				numero = "diez";
				break;
			case 11:
				numero = "once";
				break;
			case 12:
				numero = "doce";
				break;
			case 13:
				numero = "trece";
				break;
			case 14:
				numero = "catorce";
				break;
			case 15:
				numero = "quince";
				break;
				
			default:
				numero = "dieci"+speakToMe(n-(d*10));
				break;
			}
			break;
		case 2:
			switch (n) {
			case 20:
				numero = "veinte";
				break;
				
			default:
				numero = "venti"+speakToMe(n-(d*10));
				break;
			}
			break;
		case 3:
			switch (n) {
			case 30:
				numero = "treinta";
				break;
				
			default:
				numero = "trenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 4:
			switch (n) {
			case 40:
				numero = "cuarenta";
				break;
				
			default:
				numero = "cuarenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 5:
			switch (n) {
			case 50:
				numero = "cincuenta";
				break;
				
			default:
				numero = "cincuenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 6:
			switch (n) {
			case 60:
				numero = "sesenta";
				break;
				
			default:
				numero = "sesenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 7:
			switch (n) {
			case 70:
				numero = "setenta";
				break;
				
			default:
				numero = "setenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 8:
			switch (n) {
			case 80:
				numero = "ochenta";
				break;
				
			default:
				numero = "tochenta y "+speakToMe(n-(d*10));
				break;
			}
			break;
		case 9:
			switch (n) {
			case 90:
				numero = "noventa";
				break;
				
			default:
				numero = "noventa y "+speakToMe(n-(d*10));
				break;
			}
			break;
		default:
			numero = "NaN";
			break;
		}
		
		numero = numero.toLowerCase();
		sub += numero.charAt(0);
		sub = sub.toUpperCase();
		for (int i = 1; i < numero.length(); i++) {
			sub += numero.charAt(i);
		}
		
		return sub;
		//DONE
	}

	
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "")
			return false;
		int anno = 0;
		int potencia=0;
		int pot [] = {1, 10, 100, 1000};
		for (int i = fecha.length()-1; i >= fecha.length()-4; i--) {
			anno+=(Integer.parseInt(""+fecha.charAt(i)))*pot[potencia];
			potencia++;
		}
		
		return (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0));
		//DONE
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		int dias [] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		
		if (date == "")
			return false;
	
		try{
			Integer.parseInt(""+date.charAt(0));
		}catch(NumberFormatException nfe){
			return false;
		}
		
		int potencia = 3, count = 0; 
		int pot [] = {1000, 100, 10, 1};
		int fecha [] = {0, 0, 0};
		//System.out.println( date );
		//System.out.println("Flag");
		for (int i = date.length() - 1; i >= 0; i--) {
			
			if(date.charAt(i) == '-'){
				count++;
				potencia = 3;
			}else{
			//	System.out.println(date.charAt(i) + " " + pot[potencia]);
			fecha[count] += Integer.parseInt(""+date.charAt(i))*pot[potencia];
			potencia--;
			System.out.println(fecha[count]);
			}
		}
		
		
		System.out.println("El anno es "+fecha[0]+" el mes es "+fecha[1]+" el dia es "+fecha[2]+" ");
		
		if(fecha[0] == 0 ||fecha[1] == 0 ||fecha[2] == 0){
			System.out.println("Flag 0");
			return false;}
		System.out.println("PosFlag 0");
		if(fecha[2] == 29 && isLeapYear(date) == false){
			System.out.println("Flag bisiesto");
			return false;}
		System.out.println("PosFlag dossiestas");
		
		if( fecha[1] > 12 || fecha[2] > dias[fecha[1]-1]){
			System.out.println("Flag dias extras");
			return false;}
		System.out.println("PosFlag Extra");
		System.out.println("Flag esta todo bien");
		return true;
		}
}