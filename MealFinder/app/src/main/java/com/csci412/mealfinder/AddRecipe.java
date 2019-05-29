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
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class AddRecipe extends AppCompatActivity {


    DBHelper mydb;

    EditText name;
    EditText amount1;
    EditText amount2;
    EditText amount3;
    EditText amount4;
    EditText amount5;
    EditText ing1;
    EditText ing2;
    EditText ing3;
    EditText ing4;
    EditText ing5;
    EditText step1;
    EditText step2;
    EditText step3;
    EditText step4;
    EditText step5;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);
        name = (EditText) findViewById(R.id.enter_name);
        amount1 = (EditText) findViewById(R.id.enter_amount1);
        amount2 = (EditText) findViewById(R.id.enter_amount2);
        amount3 = (EditText) findViewById(R.id.enter_amount3);
        amount4 = (EditText) findViewById(R.id.enter_amount4);
        amount5 = (EditText) findViewById(R.id.enter_amount5);
        ing1 = (EditText) findViewById(R.id.enter_ing1);
        ing2 = (EditText) findViewById(R.id.enter_ing2);
        ing3 = (EditText) findViewById(R.id.enter_ing3);
        ing4 = (EditText) findViewById(R.id.enter_ing4);
        ing5 = (EditText) findViewById(R.id.enter_ing5);
        step1 = (EditText) findViewById(R.id.enter_step_1);
        step2 = (EditText) findViewById(R.id.enter_step_2);
        step3 = (EditText) findViewById(R.id.enter_step_3);
        step4 = (EditText) findViewById(R.id.enter_step_4);
        step5 = (EditText) findViewById(R.id.enter_step_5);

        mydb = new DBHelper(this);


        final LinearLayout layout = (LinearLayout) findViewById(R.id.add_recipe_layout);

        final LinearLayout ingr1 = (LinearLayout) findViewById(R.id.ingredient_1_layout);
        final LinearLayout ingr2 = (LinearLayout) findViewById(R.id.ingredient_2_layout);
        ingr2.setVisibility(View.GONE);
        final LinearLayout ingr3 = (LinearLayout) findViewById(R.id.ingredient_3_layout);
        ingr3.setVisibility(View.GONE);
        final LinearLayout ingr4 = (LinearLayout) findViewById(R.id.ingredient_4_layout);
        ingr4.setVisibility(View.GONE);
        final LinearLayout ingr5 = (LinearLayout) findViewById(R.id.ingredient_5_layout);
        ingr5.setVisibility(View.GONE);

        final Button addIngr = (Button) findViewById(R.id.new_ing_button);
        addIngr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(ingr2.getVisibility() == View.GONE) {
                    ingr2.setVisibility(View.VISIBLE);
                } else if (ingr3.getVisibility() == View.GONE){
                    ingr3.setVisibility(View.VISIBLE);
                } else if (ingr4.getVisibility() == View.GONE){
                    ingr4.setVisibility(View.VISIBLE);
                } else {
                    ingr5.setVisibility(View.VISIBLE);
                    addIngr.setVisibility(View.GONE);
                }
            }

        });




        final LinearLayout step1 = (LinearLayout) findViewById(R.id.step_1_layout);
        final LinearLayout step2 = (LinearLayout) findViewById(R.id.step_2_layout);
        step2.setVisibility(View.GONE);
        final LinearLayout step3 = (LinearLayout) findViewById(R.id.step_3_layout);
        step3.setVisibility(View.GONE);
        final LinearLayout step4 = (LinearLayout) findViewById(R.id.step_4_layout);
        step4.setVisibility(View.GONE);
        final LinearLayout step5 = (LinearLayout) findViewById(R.id.step_5_layout);
        step5.setVisibility(View.GONE);

        final Button addStep = (Button) findViewById(R.id.new_instr_button);
        addStep.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(step2.getVisibility() == View.GONE) {
                        step2.setVisibility(View.VISIBLE);
                    } else if (step3.getVisibility() == View.GONE) {
                        step3.setVisibility(View.VISIBLE);
                    } else if (step4.getVisibility() == View.GONE) {
                        step4.setVisibility(View.VISIBLE);
                    } else {
                        step5.setVisibility(View.VISIBLE);
                        addStep.setVisibility(View.GONE);
                    }
                }
        });



        Button save = (Button) findViewById(R.id.save_recipe_button);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(insert()) {
                    Intent intent = new Intent(getApplicationContext(),MainPage.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean insert() {
        boolean done = false;
        String s1 = step1.getText().toString();
        if(s1.length() > 0) {
            s1 = "1. " + s1;
        }

        String s2 = step2.getText().toString();
        if(s2.length() > 0)
            s2 = "2. " + s2;

        String s3 = step3.getText().toString();
        if(s3.length() > 0)
            s3 = "3. " + s3;

        String s4 = step4.getText().toString();
        if(s4.length() > 0)
            s4 = "4. " + s4;

        String s5 = step5.getText().toString();
        if(s5.length() > 0) {
            s5 = "5. " + s5;
        }

        if(mydb.insertRecipe(name.getText().toString(), ing1.getText().toString(), ing2.getText().toString(), ing3.getText().toString(),
                ing4.getText().toString(), ing5.getText().toString(),amount1.getText().toString(),amount2.getText().toString(),
                amount3.getText().toString(), amount4.getText().toString(), amount5.getText().toString(), s1, s2, s3, s4, s5)){
            Toast.makeText(getApplicationContext(), "Saved Recipe", Toast.LENGTH_SHORT).show();
            done = true;
        } else{
            Toast.makeText(getApplicationContext(), "Failed. Try again", Toast.LENGTH_SHORT).show();
        }
        return done;
    }
}
