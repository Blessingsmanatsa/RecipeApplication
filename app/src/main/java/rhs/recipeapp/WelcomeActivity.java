package rhs.recipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button browse = (Button) findViewById(R.id.browse); //creates the button to continue to the next activity
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBrowseActivity();
            }
        });

        /* Button categories = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSearchActivity();
            }
        }); */

        Button favs = (Button) findViewById(R.id.favs);
        favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFavsActivity();
            }
        });
    }

    private void goToBrowseActivity() {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    /*private void goToSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }*/

    private void goToFavsActivity() {
        Intent intent = new Intent(this, FavsActivity.class);
        startActivity(intent);
    }
}
