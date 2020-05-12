package com.example.musicpro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

public class DetailsPage extends AppCompatActivity {
    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        et1=(EditText)findViewById(R.id.venuname);
        et2=(EditText)findViewById(R.id.address);
        et3=(EditText)findViewById(R.id.time);

        String nam=getIntent().getStringExtra("nam");
        String add=getIntent().getStringExtra("add");
        et1.setText(nam);
        et2.setText(add);

    }


    public void addRecord(View view)            //stores in database
    {
       if(et1.getText().toString().length()==0 || et2.getText().toString().length()==0 || et3.getText().toString().length()==0){
            checkDetails();
        }

        else {
        DbManager db = new DbManager(this);
        String res = db.addRecord(et1.getText().toString(), et2.getText().toString(), et3.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }
    }

    public void delVenue(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Delete Venue?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                String d=et1.getText().toString();
String snam=et1.getText().toString();
dat(snam);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind not to delete record", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void checkDetails()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning");
        builder.setMessage("Venue details are incomplete");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        builder.show();
    }

    public void dat(String a)
    {
        DbManager db = new DbManager(this);
        boolean res = db.deleteTitle(a);
        if(res==true)
        {
            startActivity(new Intent(DetailsPage.this, DisplayVenue.class));

        }
    }



}
