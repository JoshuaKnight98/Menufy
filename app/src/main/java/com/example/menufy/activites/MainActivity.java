package com.example.menufy.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.menufy.R;
import com.example.menufy.fragments.AlertFragment;
import com.example.menufy.fragments.InformationFragment;
import com.example.menufy.fragments.MailFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SwitchCompat aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElements();

        //Evento onClick de mi switch
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()){
                    Toast.makeText(MainActivity.this, "switch is checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "switch is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                boolean createFragment = false;
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.menu_mail:
                        fragment = new MailFragment();
                        createFragment = true;
                        break;

                    case R.id.menu_alert:
                        fragment = new AlertFragment();
                        createFragment = true;
                        break;

                    case R.id.menu_info:
                        fragment = new InformationFragment();
                        createFragment = true;
                        break;

                }

                if(createFragment){
                    changeFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

    }

    private void setElements(){
        toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        //Obtengo mi menu que contiene mi switch
        MenuItem menu = navigationView.getMenu().findItem(R.id.switcher);
        //Obtengo mi switch a traves del menu que lo contiene
        aSwitch = (SwitchCompat) menu.getActionView().findViewById(R.id.switcher);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }
}