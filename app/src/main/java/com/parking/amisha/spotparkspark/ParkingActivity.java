package com.parking.amisha.spotparkspark;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ParkingActivity extends AppCompatActivity {

    CheckBox f[], s[], c[], tw[];
    DatabaseReference mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        f=new CheckBox[10];
        s=new CheckBox[18];
        c=new CheckBox[5];
        tw=new CheckBox[20];

        mDB= FirebaseDatabase.getInstance().getReference();

        int a, layoutID;

        for (int i = 0; i < 10; i++) {
            layoutID = getResources().getIdentifier("checkBox"+(i+1), "id", getPackageName());
            f[i] = (CheckBox) findViewById(layoutID);
            f[i].setEnabled(true);
            // whatever operations
        }

        a=21;
        for (int i = 0; i < 18; i++) {
            layoutID = getResources().getIdentifier("checkBox"+(a), "id", getPackageName());
            s[i] = (CheckBox) findViewById(layoutID);
            s[i].setEnabled(true);
            // whatever operations
        }

        a=10;
        for (int i = 0; i < 5; i++) {
            layoutID = getResources().getIdentifier("checkBox"+(++a), "id", getPackageName());
            c[i] = (CheckBox) findViewById(layoutID);
            c[i].setEnabled(true);
            // whatever operations
        }

        a=15;
        for (int i = 0; i < 5; i++) {
            layoutID = getResources().getIdentifier("checkBox"+(++a), "id", getPackageName());
            tw[i] = (CheckBox) findViewById(layoutID);
            tw[i].setEnabled(true);
            // whatever operations
        }
        setOccupied();
    }

    public void setOccupied(){
        mDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String name = (String) dataSnapshot1.child("Availability").getValue();
                    String nam = (String) dataSnapshot1.child("ParkNo").getValue();
                    if (Objects.equals(name, "0")) {
                        for (int i = 0; i < 5; i++) {
                            if (tw[i].getText().equals(nam)) {
                                tw[i].setChecked(true);
                                tw[i].setEnabled(false);
                                break;
                            }
                        }
                        for (int i = 0; i < 18; i++) {
                            if (s[i].getText().equals(nam)) {
                                s[i].setChecked(true);
                                s[i].setEnabled(false);
                                break;
                            }
                        }
                        for (int i = 0; i < 10; i++) {
                            if (f[i].getText().equals(nam)) {
                                f[i].setChecked(true);
                                f[i].setEnabled(false);
                                break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

}
