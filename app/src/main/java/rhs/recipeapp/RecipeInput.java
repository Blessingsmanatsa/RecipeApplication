package rhs.recipeapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class RecipeInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_input);
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

        // Gets the data repository in write mode
        SQLiteDatabase db = MainActivity.db;

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_RECIPE_NAME , "Cookies");
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_TIMES, "10, 10, 5");
        values.put(DatabaseContract.MyRecipes.COlUMN_NAME_NUM_SERVINGS, "5 peeps");
        values.put(DatabaseContract.MyRecipes.COlUMN_NAME_INGREDIENTS, "sugar and milk");
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_INSTRUCTIONS,"Mix it up!");

        // Insert the new row, returning the primary key value of the new row --> do we have these keys?
        long newRowId = db.insert(DatabaseContract.MyRecipes.TABLE_NAME, null, values);


        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseContract.MyRecipes.COLUMN_NAME_RECIPE_NAME,
                DatabaseContract.MyRecipes.COLUMN_NAME_TIMES,
                DatabaseContract.MyRecipes.COlUMN_NAME_NUM_SERVINGS,
                DatabaseContract.MyRecipes.COlUMN_NAME_INGREDIENTS,
                DatabaseContract.MyRecipes.COLUMN_NAME_INSTRUCTIONS
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DatabaseContract.MyRecipes.COLUMN_NAME_RECIPE_NAME + " = recipeName";
        String[] selectionArgs = { "Cookies" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                DatabaseContract.MyRecipes.COLUMN_NAME_TIMES + " DESC";

        Cursor cursor = db.query(
                DatabaseContract.MyRecipes.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        EditText e = (EditText) findViewById(R.id.printedRecipe);
        e.setText(cursor.toString());

    }




}
