package com.parking.amisha.spotparkspark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton car, bike;
    Button park;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        park = (Button) findViewById(R.id.parking);
        car = (ImageButton) findViewById(R.id.car);
        bike= (ImageButton) findViewById(R.id.bike);

        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ParkingActivity.class);
                startActivity(in);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SelectClass.class);
                startActivity(in);
            }
        });

        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, BikeActivity.class);
                startActivity(in);
            }
        });
    }
}
