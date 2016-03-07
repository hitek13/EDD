package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.hamcrest.core.SubstringMatcher;

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
		//Iniciamos dos variables, las cuales serán la posicion de la series y su anterior
		for (int i = 0; i < n; i++){
			aux = x;
			x = y;
			y += aux;
			listInt.add(x);
		}
		//De forma recursiva utilizamos la funcion para obtener la lista de los anteriores, de este modo llegamos hasta 
		// 1, dicho valor es el dado a Y
		return listInt;
		//DONE
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int count = number, j = 0;
		//nuestro problema es que no sabemos cuantos numeros entraran en nuestro array
		//Can la siguiente funcion calculamos dicha longitud
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
		//Ahora sencillamente cargamos los valores en el array
		return v;
		//DONE
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		  List listaDiv=new ArrayList<>();
		  //Como no sabemos el numero de divisores los cargamos en un list 
		  if(n==0)
			  return null;
		  for(int i=1; i<=(int)n/2; i++){
	            if(n%i==0){
	                listaDiv.add(i);
	            }
	        }
		  listaDiv.add(n);
	        //Añadimos el propio numero, pues todo numero es divisible por si mismo, y por uno, el cual se ah incluido en 
	        //el bucle.
	        //Con  el comparador y la funcion sort hacemos que lo elementos se comparen entre si y se ordenen inversamente
		Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(listaDiv, comparador);
        //Volcamos la lista en un array de enteros y lo devolvemos
        int[] array=new int[listaDiv.size()];
        Iterator it=listaDiv.iterator();
        for(int i=0; i<listaDiv.size();i++){
            if(it.hasNext()){
                array[i]=(int) it.next();
            }
        }
        return array;  
        //DONE
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null)
			return false;
		//El subalgortimo acentos, que está debajo de este método, quita los acentos a todas las letras
		cadena = quitarAcentos(cadena);
		// lo ponemos todo en minúsculas y quitamos espacios, ademas de los caraceteres que no son letras (? , ; . ...)
		cadena = normaliza(cadena);
		//Comparamos la cadena con los pares simétricos por medio de la funcion compara
		
		return compara(cadena);
		//DUNE
	}
	public static String quitarAcentos (String cadena){
		
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		for (int i=0; i<original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			cadena=cadena.replace(original.charAt(i), ascii.charAt(i));
		}
		return cadena;
	}
	public static String normaliza (String cadena){
		cadena=cadena.toLowerCase();
		for(int i=0; i<cadena.length();i++){
			if(cadena.charAt(i) > 'z' || cadena.charAt(i) < 'a')
				cadena=cadena.replace(cadena.charAt(i),' ');
		}
		cadena=cadena.replace(" ", "");
		return cadena;
	}
	public static boolean compara (String cadena){
		for (int i = 0; i < cadena.length()/2; i++){
			if(cadena.charAt(i) != cadena.charAt(cadena.length()-1-i))
				return false;
		}
		return true;
	}
	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int d = (int)n/10;
		//Cargamos todos las palabras en strings según si son decenas o unidades
		String numero;
		String unidades [] = {"Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince"};
		String decenas [] = {"Dieci", "Veinti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		if(n < 16) return unidades[n];
		if(n == 20) return "Veinte";
		if(n < 30)
		numero = decenas[d-1]+speakToMe(n-d*10);
		//A pesar de las excepciones, hacemos una composicion de las dos cadenas
		if(n%10 == 0) numero = decenas[d-1];
		else numero = decenas[d-1]+" y "+speakToMe(n-d*10);
		//Ponemos solo la primera letra en mayusculas
		return empiezaMayus(numero);
				//DONE
	}
	public static String empiezaMayus (String numero){
		String sub = "";
		numero = numero.toLowerCase();
		sub += numero.charAt(0);
		sub = sub.toUpperCase();
		for (int i = 1; i < numero.length(); i++) {
			sub += numero.charAt(i);
		}
		return sub;
	}
	
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "")
			return false;
		//Transformamos fecha en un entero, cogiendo solo el año de dicha fecha
		int anno = stringToInt(fecha);
		//El algortimo de comparación es harto complicado
		return (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0));
		//DONE
	}
	public static int stringToInt (String fecha){
		int anno = 0;
		int potencia=0;
		int pot [] = {1, 10, 100, 1000};
		//Segun la posición lo miltiplicamos por 1, 10, 100 o 1000 dandonos el orden de magnitud real
		for (int i = fecha.length()-1; i >= fecha.length()-4; i--) {
			anno+=(Integer.parseInt(""+fecha.charAt(i)))*pot[potencia];
			potencia++;
		}
		return anno;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		int dias [] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		
		if (date == "")
			return false;
	//Si la primera cifra ya no es un número ni nos moletamos en seguir
		try{
			Integer.parseInt(""+date.charAt(0));
		}catch(NumberFormatException nfe){
			return false;
		}
		if( date.length() < 10 || date.charAt(2) != '-' || date.charAt(5) != '-' )
			return false;
		int fecha [] = {0, 0, 0};
		//Empleamos un algortmo parecido al del ejercicio anterior, pero lo hemos modificado para que lea el string entero, y no solo el año
		fecha [0] = stringToInt2 (date.substring(6, 10));
		fecha [1] = stringToInt2 (date.substring(3, 5));
		fecha [2] = stringToInt2 (date.substring(0, 2));
		//Damos las excepciones necesarias, así como aprovechar el eño bisiesto
		if(fecha[0] == 0 ||fecha[1] == 0 ||fecha[2] == 0){
			return false;}
		if(fecha[2] == 29 && isLeapYear(date) == false){
			System.out.println("Flag bisiesto");
			return false;}
		
		if( fecha[1] > 12 || fecha[2] > dias[fecha[1]-1]){
			return false;}
		return true;
		}
	public static int stringToInt2 (String fecha){
		int anno = 0;
		int potencia=0;
		int pot [] = {1, 10, 100, 1000};
		//Segun la posición lo miltiplicamos por 1, 10, 100 o 1000 dandonos el orden de magnitud real
		for (int i = fecha.length()-1; i >= 0; i--) {
			anno+=(Integer.parseInt(""+fecha.charAt(i)))*pot[potencia];
			potencia++;
		}
		return anno;
	}
}