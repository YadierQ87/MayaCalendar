package yadier.quesada.mayacalendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void lanzarIntentCalendarioLuna(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, CalendarioActivity.class);		
		startActivity(intent);
	}
    
        
    private void lanzarIntentTzolkin(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, TzolkinActivity.class);		
		startActivity(intent);
	}
    
    private void lanzarIntentOndaEncantada(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, OndaEncantadaActivity.class);		
		startActivity(intent);
	}
    
    private void lanzarIntentLos7plasmasRadiales(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		//Intent intent = new Intent(this, Los7plasmas_radialesActivity.class);		
		//startActivity(intent);
    	setContentView(R.layout.activity_los7plasmas_radiales);
	}
    
    private void lanzarIntentLos20sellos(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, Los2sellosActivity.class);		
		startActivity(intent);
	}
    
    private void lanzarIntentEncuentraTuKin(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, EncuentraKinActivity.class);		
		startActivity(intent);
	}
    
    private void lanzarIntentLos13TONOS(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, Los13tonosActivity.class);		
		startActivity(intent);
	}
    
    private void lanzarIntentCalculadoraMaya(){
		//startActivityForResult(new Intent(this, LunaHoy.class), 1);
		Intent intent = new Intent(this, CalculadoraMayaActivity.class);		
		startActivity(intent);
	}
    
    public void verLuna(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentCalendarioLuna();    	
    }    
    
    
    public void verLos13Tonos(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentLos13TONOS();    	
    }
    
    public void verCalculadoraMaya(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentCalculadoraMaya();    	
    }
    
    public void verEncuentraTuKin(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentEncuentraTuKin();    	
    }
    
    public void verLos20sellos(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentLos20sellos();    	
    }
    
    public void verLos7plasmasRadiales(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentLos7plasmasRadiales();    	
    }
    
    public void verOndaEncantada(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentOndaEncantada();    	
    }
    
    public void verTzolkin(View view)
    {
    	//Toast.makeText(this,"probando",Toast.LENGTH_SHORT).show();
    	this.lanzarIntentTzolkin();    	
    }
    
}
