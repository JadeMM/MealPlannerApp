package com.csci412.mealfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DBRecipes extends AppCompatActivity {

    private ListView obj;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_recipes);


        mydb = new DBHelper(this);
        Bundle extras = getIntent().getExtras();
            String first = extras.getString("first");
            String second = extras.getString("second");
            String third = extras.getString("third");
            String fourth = extras.getString("fourth");
            String fifth = extras.getString("fifth");

        TextView search = (TextView) findViewById(R.id.input);
        ArrayList array_list;

        if(fifth.length() > 0) {
            search.setText("Searching for recipes with " + first + ", " + second + ", " + third + ", " + fourth + ", and" + fifth);
            array_list = mydb.getIngredientRecipes(first, second, third, fourth, fifth);
        } else if (fourth.length() > 0) {
            search.setText("Searching for recipes with " + first + ", " + second + ", " + third + ", and" + fourth);
            array_list = mydb.getIngredientRecipes(first, second, third, fourth);
        } else if (third.length() > 0) {
            search.setText("Searching for recipes with " + first + ", " + second + ", and" + third);
            array_list = mydb.getIngredientRecipes(first, second, third);
        } else if (second.length() > 0) {
            search.setText("Searching for recipes with " + first + " and " + second);
            array_list = mydb.getIngredientRecipes(first, second);
        } else if (first.length() > 0) {
            search.setText("Searching for recipes with " + first);
            array_list = mydb.getIngredientRecipes(first);
        } else {
            search.setText("Searching for all recipes");
            array_list = mydb.getAllRecipes();
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        obj = (ListView)findViewById(R.id.listView2);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
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
    }
}