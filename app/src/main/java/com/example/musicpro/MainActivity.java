package com.example.musicpro;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.newvenue);
    }

    public void detailspage(View view)
    {
        startActivity(new Intent(this,DetailsPage.class));
    }

    public void showvenue(View view)
    {
        startActivity(new Intent(this,DisplayVenue.class));
    }

    public void showmap(View view)
    {
        startActivity(new Intent(this,DisplayMap.class));
    }
}
