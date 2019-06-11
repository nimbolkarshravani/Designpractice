package com.example.designpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // design design;
    // mark mark;

    Development development_frag;
    Design design_frag;
    Markting markting_frag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        development_frag = new Development();
        design_frag = new Design();
        markting_frag = new Markting();

        BottomNavigationView nav = findViewById(R.id.nav);
        final FrameLayout content = findViewById(R.id.content_layout);

        change_fragment(development_frag);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.development:
                        change_fragment(development_frag);
                        break;
                    case R.id.design:
                        change_fragment(design_frag);
                        break;
                    case R.id.mark:
                        change_fragment(markting_frag);
                        break;
                    default:
                        return false;

                }
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cstm_animation);
                content.startAnimation(animation);
                return true;
            }
        });
    }

    private void change_fragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction3.replace(R.id.content_layout, fragment);
        fragmentTransaction3.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.development:
                Toast.makeText(this, "Development", Toast.LENGTH_SHORT).show();
                break;
            case R.id.design:
                Toast.makeText(this, "Design", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mark:
                Toast.makeText(this, "Marking", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



