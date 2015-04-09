package yadier.quesada.mayacalendar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CalendarioActivity extends Activity {

	public String[] datos = new String[28];
	//private static  List<ClassLuna> datos_lunas;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		// Show the Up button in the action bar.
		setupActionBar();
		//llenando los datos del GRID;
		AdaptadorMesLunar adaptador =	new AdaptadorMesLunar(this);
		final GridView grdOpciones = (GridView)findViewById(R.id.GridOpciones);
		grdOpciones.setAdapter(adaptador);
		//llenando los otros datos
		
		int mes = Calendar.MONTH;
		int day = Calendar.DAY_OF_MONTH;
		//para los meses menores de 6 month + 6 y para los mayores month - 6;
		if(mes > 6)
		   mes = mes - 6;
		if(mes < 6)
			   mes = mes + 6;
		if(mes == 6 && day > 25)
			mes = 0;
		if(mes == 6 && day < 25)
			mes = 13;
		Llenar_campos(mes);
		//para los meses menores de 6 month + 6 y para los mayores month - 6;
		
		
	}

	public void Llenar_campos(int mes ) {
		 
    final  String[] lunas = {"","1 Luna Magnética","2 Luna Lunar","3 Luna Eléctrica","4 Luna Autoexistente","5 Luna Entonada","6 Luna Rítmica",
    		"7 Luna Resonante","8 Luna Galáctica","9 Luna Solar","10 Luna Planetario","11 Luna Espectral","12 Luna Cristal","13 Luna Cósmica"};
	 final String[] propositos = {"","¿CUÁL ES MI PROPÓSITO?","¿CUÁL ES MI DESAFÍO?","¿CÓMO PUEDO MEJORAR MI SERVICIO?","¿CUÁL ES LA FORMA QUE TOMARÁ MI SERVICIO?",
	"¿CÓMO PUEDO MEJORAR MI PROPIO POTENCIAL?","¿CÓMO PUEDO EXTENDER MI IGUALDAD A LOS DEMÁS?","¿CÓMO PUEDO SINTONIZAR CON LOS DEMÁS?","¿CÓMO VIVO LO QUE CREO?",
	"¿CÓMO PUEDO ALCANZAR MI PROPÓSITO?","¿CÓMO PUEDO PERFECCIONAR LO QUE HAGO?","¿CÓMO PUEDO LIBERARME Y DEJARLO IR?","¿CÓMO PUEDO DEDICAR MI SER A TODO LO QUE VIVE?","¿CÓMO PUEDO EXPANDIR MI ALEGRÍA Y AMOR?"};

     final String[] fechas = {"","26 JULIO A 22 AGOSTO 2014","23 AGOSTO A 19 SEPT. 2014","20 SEPT. A 17 OCTUBRE 2014",
    		"18 OCTUBRE-14 NOVIEMBRE 2014","15 DE NOV. A 12 DICIEMBRE 2014","13 DICIEMBRE A 9 DE ENERO 2015",
    		"10 ENERO A 6 FEBRERO 2015","7 DE FEBRERO A 6 DE MARZO, 2015","7 DE MARZO A 3 DE ABRIL DE 2015",
    		"4 DE ABRIL A 1 DE MAYO, 2015","2 DE MAYO A 29 DE MAYO DE 2015","30 DE MAYO A 26 DE JUNIO DE 2015",
    		"27 DE JUNIO A 24 DE JULIO DE 2014"};
    
     final String[] totems = {"","Murciélago","Escorpión","Venado","Búho","Pavo Real","Lagarto",
    		"Mono","Halcón","Jaguar","Perro","Serpiente","Conejo","Tortuga"};
		
		
		 
		 TextView Luna = (TextView)findViewById(R.id.textView2);
		 Luna.setText("Luna de Hoy: " + lunas[mes]);
		 
		 TextView Totem = (TextView)findViewById(R.id.textView4);
		 Totem.setText("Animal Totem: " + totems[mes]);//totem
		 
		 TextView Proposito = (TextView)findViewById(R.id.textView7);
		 Proposito.setText(propositos[mes]);
		 
		 TextView fechado = (TextView)findViewById(R.id.textView8);
		 fechado.setText("Fecha: " + fechas[mes]);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendario, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}


class AdaptadorMesLunar extends ArrayAdapter{

	private static  List<ClassDiaSemana> datos_dias = ClassCalendario.getDiasMes(calcularmes());//calcularmes()
	Activity context;	
	
	@SuppressWarnings("unchecked")
	AdaptadorMesLunar(Activity context) {
		super(context, R.layout.dia_calendario, datos_dias);
		this.context = context;
		
		}
	
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View item = convertView;
			ViewHolder holder;
			if(item == null)
			{
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.dia_calendario, null);
			holder = new ViewHolder();
			holder.num_dia = (TextView)item.findViewById(R.id.num_dia);
			holder.num_kin = (TextView)item.findViewById(R.id.num_kin);
			holder.tipo_luna = (ImageView)item.findViewById(R.id.tipo_luna);
			holder.dia_gregoriano = (TextView)item.findViewById(R.id.dia_gregoriano);
			holder.tono = (TextView)item.findViewById(R.id.tono);
			holder.imagen_sello = (ImageView)item.findViewById(R.id.imagen_sello);
			holder.table_layout = (FrameLayout)item.findViewById(R.id.frame_dia);
			item.setTag(holder);
			}
			else
			{
			holder = (ViewHolder)item.getTag();
			}	
			holder.num_dia.setText("" + datos_dias.get(position).getDiasemana());
			holder.num_kin.setText("" + datos_dias.get(position).getKin());
			holder.tipo_luna.setImageResource(datos_dias.get(position).getLuna());
			holder.dia_gregoriano.setText(datos_dias.get(position).getFecha_greg());
			holder.tono.setText("" + datos_dias.get(position).getTono());
			holder.imagen_sello.setImageResource(datos_dias.get(position).getIcono());
			holder.table_layout.setBackgroundResource(datos_dias.get(position).getColor());//rojo 
			//holder.table_layout.setBackgroundResource(2131165187);			
		return(item);
		}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int calcularmes() {
		// TODO Auto-generated method stub
		
		int mes = Calendar.MONTH;
		int day = Calendar.DAY_OF_MONTH;
		//para los meses menores de 6 month + 6 y para los mayores month - 6;
		if(mes > 6)
		   mes = mes - 6;
		if(mes < 6)
			   mes = mes + 6;
		if(mes == 6 && day > 25)
			mes = 0;
		if(mes == 6 && day < 25)
			mes = 13;		
		return mes;
	}

}

 class ViewHolder {
 TextView num_dia;
 TextView dia_gregoriano; 
 ImageView tipo_luna;
 TextView num_kin;
 TextView tono;
 ImageView imagen_sello;
 FrameLayout table_layout;
 }
