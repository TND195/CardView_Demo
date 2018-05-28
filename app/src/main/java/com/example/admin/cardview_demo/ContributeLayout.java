package com.example.admin.cardview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ContributeLayout  extends AppCompatActivity {
    Spinner spDemo;
    String[] value= {
            "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "ICS", "Jelly Bean", "KitKat", "Lollipop",
            "Marshmallow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contribute_layout);
        spDemo= (Spinner) findViewById(R.id.sp_category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, value);
        spDemo.setAdapter(adapter);
        spDemo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
