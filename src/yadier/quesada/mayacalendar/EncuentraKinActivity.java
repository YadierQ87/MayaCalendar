package yadier.quesada.mayacalendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class EncuentraKinActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encuentra_kin);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
    
	public int CalcularTuKin(int dia,int mes, int anno) {

		KinAnual kin = new KinAnual();
		int pos_anno = kin.getPosAnno(anno);
		int val1,val2,val3,kinfinal;
		val1 = kin.getMeses()[mes];//valor del mes
		val2 = kin.getValores()[pos_anno];
		val3 = val1 + val2 + dia;
		if(val3 > 260)
		   kinfinal = val3 - 260;
		else 
			kinfinal = val3;
		return kinfinal;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encuentra_kin, menu);
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


class KinAnual
{
	int[] valores = {0,62,167,12,117,222};
	int[] annos =   {1858};
	int[] meses = {	0,0,31,59,90,120,151,181,212,243,13,44,74};//los 12 meses
	public int[] getMeses() {
		return meses;
	}

	public void setMeses(int[] meses) {
		this.meses = meses;
	}

	public KinAnual() {
		super();
		
		//int control = 1;
		for (int i = 6; i < 53; i++) {
			if (valores[i-5] + 5 > 260)
				valores[i] = (valores[i-5] + 5) - 260;
			else
			    valores[i] = valores[i-5] + 5;
		}
		
		for (int j = 1; j < 5; j++) {
			for (int i = 1; i < 53; i++) {
			    annos[i*j] =  annos[0] + i*j;				
			}
		}
		
	}

	public int[] getValores() {
		return valores;
	}

	public void setValores(int[] valores) {
		this.valores = valores;
	}

	public int[] getAnnos() {
		return annos;
	}

	public void setAnnos(int[] annos) {
		this.annos = annos;
	}
	
	public int getPosAnno(int anno) {
		for (int i = 0; i < 260; i++) {
			if (annos[i] == anno)
				return i;
		}
		return 0;
	}    
	
}