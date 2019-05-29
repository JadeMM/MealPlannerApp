package com.csci412.mealfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    private ListView obj;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllRecipes();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;
                String name = (String) arg0.getItemAtPosition(arg2);

                Bundle dataBundle = new Bundle();
                dataBundle.putString("name", name);
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayCreatedRecipes.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

        Button next = (Button) findViewById(R.id.find_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FindRecipe.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button add = (Button) findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AddRecipe.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}