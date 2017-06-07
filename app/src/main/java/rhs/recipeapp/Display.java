package rhs.recipeapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Display extends RecipeInput {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        String recipeName = values.get("recipeName").toString();
        String times = values.get("times").toString();
        String numServings = values.get("numServings").toString();
        String ingredients = values.get("ingredients").toString();
        String instructions = values.get("instructions").toString();
        // Insert the new row, returning the primary key value of the new row
        db.insert(DatabaseContract.MyRecipes.TABLE_NAME, null, values);



    }

}
