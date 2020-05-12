package com.example.musicpro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicpro.Model.Venue;

import java.util.ArrayList;

public class DisplayVenue extends AppCompatActivity {
    ListView l1;
    DbManager dbManager;
    ArrayList<Venue> arrayList;
    MyAdapter myAdapter;
    TextView et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_venue);
        l1=(ListView)findViewById(R.id.listview);
        dbManager=new DbManager(this);
        arrayList=new ArrayList<>();
        loadDataInListView();
/*
      et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et=(TextView)findViewById(R.id.name);
                Toast.makeText(DisplayVenue.this, et.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });


  */

l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int which_item=position;
                //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();


new AlertDialog.Builder(DisplayVenue.this).setTitle("Confirm").setMessage("Click Yes to view details")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Venue v=arrayList.get(which_item);
                                String n=v.getName();
                                String a=v.getAddress();
                                Intent intent=new Intent(DisplayVenue.this,DetailsPage.class);
                                intent.putExtra("nam",n);
                                intent.putExtra("add",a);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();



                return true;
            }
        });



    }


    private void loadDataInListView() {
        arrayList=dbManager.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
