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

public class FacultyActivity extends AppCompatActivity {

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

        int a;

        for (int i = 0; i < 10; i++) {
            int layoutID = getResources().getIdentifier("checkBox"+(i+1), "id", getPackageName());
            f[i] = (CheckBox) findViewById(layoutID);
            f[i].setEnabled(true);
            // whatever operations
        }
        setOccupied();
        a=20;

        for (int i = 0; i < 18; i++) {
            int layoutID = getResources().getIdentifier("checkBox"+(++a), "id", getPackageName());
            s[i] = (CheckBox) findViewById(layoutID);
            s[i].setEnabled(false);
            // whatever operations
        }
        a=10;

        for (int i = 0; i < 5; i++) {
            int layoutID = getResources().getIdentifier("checkBox"+(++a), "id", getPackageName());
            c[i] = (CheckBox) findViewById(layoutID);
            c[i].setEnabled(false);
            // whatever operations
        }
        a=15;

        for (int i = 0; i < 5; i++) {
            int layoutID = getResources().getIdentifier("checkBox"+(++a), "id", getPackageName());
            tw[i] = (CheckBox) findViewById(layoutID);
            tw[i].setEnabled(false);
            // whatever operations
        }

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
