package com.application.angrybirdmood;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean moodBird = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragContentent, new BirdSmile())
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = null;
                if (moodBird){
                    f = new BirdAngry();
                    moodBird = !moodBird;
                    Snackbar.make(view, "Angry Bird", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    f = new BirdSmile();
                    moodBird = !moodBird;
                    Snackbar.make(view, "Smile Bird", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragContentent, f)
                        .commit();
            }
        });
    }

}
