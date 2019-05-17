package com.csci412.mealfinder;

import android.content.Context;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);


        final LinearLayout layout = (LinearLayout) findViewById(R.id.add_recipe_layout);
        final LinearLayout inglayout = (LinearLayout) findViewById(R.id.ingredient_holder);

        final Context ctx = this;


        // Create a EditText ui component.




        Button addIngr = (Button) findViewById(R.id.new_ing_button);
        addIngr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

               // Add EditText to LinearLayout
                final LinearLayout ingr = new LinearLayout(ctx);
                //ingr.setLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT);
                ingr.setOrientation(LinearLayout.HORIZONTAL);

                EditText addIngr = new EditText(ctx);
                //add.setId(2);
                addIngr.setHint("Ingredient");
                addIngr.setWidth(1000);
                ingr.addView(addIngr);

                EditText addAmount = new EditText(ctx);
                addAmount.setHint("Amount");
                addAmount.setWidth(100);
                ingr.addView(addAmount);

                inglayout.addView(ingr);

            }

        });

        Button save = (Button) findViewById(R.id.save_recipe_button);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });
    }
}
