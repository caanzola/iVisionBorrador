package com.example.mac.ivision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.location.places.Place;

public class NuevoCirculoInicio extends AppCompatActivity
{

    TextView edText;
    int PLACE_PICKER_REQUEST = 1;
    Button crearCirculo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_circulo_inicio);

        edText = findViewById(R.id.geoPoint);
        edText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try
                {
                   startActivityForResult(builder.build(NuevoCirculoInicio.this), PLACE_PICKER_REQUEST);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        crearCirculo = findViewById(R.id.button);
        crearCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentInicio = new Intent(NuevoCirculoInicio.this, BottomNavigation.class);
                NuevoCirculoInicio.this.startActivity(intentInicio);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==PLACE_PICKER_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                Place place = PlacePicker.getPlace(NuevoCirculoInicio.this, data);
                edText.setText(place.getAddress());
            }
        }
    }
}
