package br.senai.sc.es4dof.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar cal1 = Calendar.getInstance();
		
		Date dataAtual = new Date();
		cal1.setTime(dataAtual);
		
		Calendar cal2 = Calendar.getInstance(); 
		cal2.add(Calendar.YEAR, 1);
		
	 for (Calendar cal = cal1; cal.compareTo(cal2)<= 0; cal.add(Calendar.DATE, 1)) {  
         System.out.println (df.format (cal.getTime()));  
     }  
		
	}

}
