package yadier.quesada.mayacalendar;

//import java.sql.Date;
import java.io.Console;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.R.integer;
import android.R.string;
import android.net.Uri;
import android.util.Log;
import android.webkit.ConsoleMessage;

//import android.text.format.DateFormat;



public class ClassCalendario {

	/**
	 * @param args
	 */
	public final static String[] meses = {"","7","8","9","10","11","12","1","2","3","4","5","5","6"};
	public final static int[] cantd_dias = {0,31,31,30,31,30,31,31,28,31,30,31,31,31};
	public final static int[] dia_inicio = {0,26,23,20,18,15,13,10,7,7,4,2,30,27};
		
	
	//los id de los iconos de la luna nueva,creciente,llena,menguante
	public final static int[] ic_lunas = {2130837548,2130837545,2130837546,2130837547};
	/* las fases de las lunas */
	public final static int[] luna_nueva =     {0,1 ,3 ,5 ,6 ,8 ,10,11,12,14,15,17,18,20};
	public final static int[] luna_creciente = {0,10,11,12,14,15,16,18,19,21,22,24,26,28};
	public final static int[] luna_llena =     {0,16,18,19,20,22,24,25,27,0 ,1 ,3 ,4 ,6 };	
	public final static int[] luna_menguante = {0,23,25,26,28,0 ,2 ,4 ,6 ,7 ,9,10,11,12};	
	
       	
	/*public final static int[] ic_tonos = {0,2130837518,2130837537,2130837528,2130837532,2130837533,2130837519,2130837527,2130837518,
			2130837521,2130837529,2130837516,2130837523,2130837517,2130837526,2130837515,2130837522,
			2130837535,2130837520 , 2130837536,2130837534};//los id de los tonos;*/
	
	public final static int[] ic_sellos = {0,2130837518,2130837537,2130837528,2130837532,2130837533,2130837519,2130837527,2130837518,
       			2130837521,2130837529,2130837516,2130837523,2130837517,2130837526,2130837515,2130837522,
       			2130837535,2130837520 , 2130837536,2130837534};//los id de los sellos;
       	
	public final static int[] num_sello   = {0,9,17,5,13,1,9,17,5,13,1,9,17,5};//+20
	public final static int[] kin_inicio  = {0,9,37,65,93,121,149,177,205,233,1,29,57,85};//+27
	public final static int[] tono_inicio = {0,9,11,13,2,4,6,8,10,12,1,3,5,7};//+13
    
	
	public  ClassCalendario() {
		// TODO Auto-generated method stub		
	}
	
	public static List<ClassDiaSemana> getDiasMes(int mes) {
		
		List<ClassDiaSemana>	listadiasMes = new ArrayList<ClassDiaSemana>();	
		
		//if mes - 6 pos en meses
	
       //	ClassCambioLuna[] dias_lunas = new ClassCambioLuna[]{new ClassCambioLuna(1, "menguante")};
       	int luna = 0;		String portal = "";		String asterisco = "";	
		String mymes="",fecha_greg=""; 	 int mydia=0;
       	int mysello;
       	int contador_sello = num_sello[mes];//posicion del sello inicial
       	int num_dias       = cantd_dias[mes];//cant de dias del mes inicial
       	int kin_inicial    = kin_inicio[mes];//kin inicial       	
       	int tono_inicial   = tono_inicio[mes];//tono inicial
       	//los 4 dias de cambio de luna 
       	int llena = luna_llena[mes];
       	int creciente = luna_creciente[mes];
       	int menguante = luna_menguante[mes];
       	int nueva = luna_nueva[mes];
       	
       	
       	mydia = dia_inicio[mes];
       	mymes = meses[mes]; int color = 0;
       	
		for (int j = 1; j < 29; j++) {
			
			if(contador_sello >= 21)
				contador_sello = 1;
			if(mydia > num_dias)
			{
				mymes = meses[mes+1];
				mydia = 1;
			}				
			if(tono_inicial >= 14)
				tono_inicial = 1;	
			if(j > 0 && j < 8)
			       color = 2131165190;//rosado
			if(j > 7 && j < 14)
			       color =  2131165191 ;//blanco
			if(j > 14 && j < 22)
					color = 2131165187;//azul
			if(j > 21 && j < 29)
					color = 2131165186;//amarillo
			fecha_greg = mydia + "/" + mymes;
			mysello =  ic_sellos[contador_sello];
			//para insertar la luna
			luna =  2130837549 ;//no luna
			if(j == llena)
			   luna = ic_lunas[2];
			if(j == creciente)
				   luna = ic_lunas[1];
			if(j == nueva)
				   luna = ic_lunas[0];
			if(j == menguante)
				   luna = ic_lunas[3];
			
			ClassDiaSemana Dia = new ClassDiaSemana(j,fecha_greg,mysello,luna,kin_inicial, portal,asterisco,tono_inicial,color);
			
			listadiasMes.add(Dia);
			/*int intmes = Calendar.MONTH;	
			int dia = Calendar.DAY_OF_MONTH;
			String mont = dia + "-" + intmes;*/
			//Log.v("tono","-" + tono_inicial);
			kin_inicial++;  tono_inicial++;  contador_sello++; mydia++;
		}
		
		return listadiasMes;
	}

}


 
 
 class ClassDiaSemana {
	 
	public ClassDiaSemana(int diasemana, String fecha_greg, int icono,
			int luna, int kin, String portal, String asterisco,int tono,int color) {
		super();
		this.diasemana = diasemana;
		this.fecha_greg = fecha_greg;
		this.icono = icono;
		this.luna = luna;
		this.kin = kin;
		this.portal = portal;
		this.asterisco = asterisco;
		this.tono = tono;
		this.color = color;
	}
	 
	String fecha_greg;	 int icono;	int color;
	int luna;	 int kin;	 int tono;	 String portal;
	String asterisco;   	int diasemana;
	 
	 public int getDiasemana() {
		return diasemana;
	}
	
	public String getFecha_greg() {
		return fecha_greg;
	}	
	public int getLuna() {
		return luna;
	}	
	public int getKin() {
		return kin;
	}	
	public String getPortal() {
		return portal;
	}	
	public String getAsterisco() {
		return asterisco;
	}	
	 public int getIcono() {
		return icono;
	}	     
	public int getColor() {
		return color;
	}	 
	 public int getTono() {
		return tono;
	}	 
 }  
 