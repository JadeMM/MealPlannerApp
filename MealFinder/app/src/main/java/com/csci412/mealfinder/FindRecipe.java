package com.csci412.mealfinder;

import android.net.Uri;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;

public class FindRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_recipe);

        setContentView(R.layout.find_recipe);
        final EditText ing4 = (EditText) findViewById(R.id.forth_ingredient);
        ing4.setVisibility(View.INVISIBLE);
        final EditText ing5 = (EditText) findViewById(R.id.fifth_ingredient);
        ing5.setVisibility(View.INVISIBLE);
        final Button addButton = (Button) findViewById(R.id.add_ingredient_button);

        Button add = (Button) findViewById(R.id.add_ingredient_button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(ing4.getVisibility() == View.INVISIBLE) {
                    ing4.setVisibility(View.VISIBLE);
                } else {
                    ing5.setVisibility(View.VISIBLE);
                    addButton.setVisibility(View.INVISIBLE);
                }
            }

        });
    }
    
    
    public void internet1(View view){
        Intent newBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.allrecipes.com"));
        startActivity(newBrowser);
    }
}
