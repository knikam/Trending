package com.xscalate.trending.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.xscalate.trending.R;
import com.xscalate.trending.view.fragment.MovieFragment;
import com.xscalate.trending.view.fragment.PeopleFragment;
import com.xscalate.trending.view.fragment.TVShowFragment;

import org.jetbrains.annotations.NotNull;

public class HomeScreen extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuButton;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        loadFragment(new TVShowFragment());

        drawerLayout = findViewById(R.id.home_layout_drawer);
        navigationView = findViewById(R.id.home_nav_view);
        menuButton = findViewById(R.id.home_btn_menu);
        bottomNavigationView = findViewById(R.id.home_nav_bottom_menu);

//        menuButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tv_show:
                        loadFragment(new TVShowFragment());
                        break;
                    case R.id.movies:
                        loadFragment(new MovieFragment());
                        break;
                    case  R.id.people:
                        loadFragment(new PeopleFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment){
         getSupportFragmentManager()
                .beginTransaction()
                 .replace(R.id.home_layout_frame,fragment)
                 .commit();
    }
}