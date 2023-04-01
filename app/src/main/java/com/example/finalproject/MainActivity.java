package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
   private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setTitle("الصفحه الرئيسية");
        //drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                        Toast.makeText(getApplicationContext(),"Home Panel is Open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_fav :
                        Toast.makeText(getApplicationContext(),"Favourite Panel is Open",Toast.LENGTH_LONG).show();
                        func();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_setting :
                        Toast.makeText(getApplicationContext(),"Setting Panel is Open",Toast.LENGTH_LONG).show();
                        setting_func();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }

        });

    }

    private void setting_func() {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    private void func() {
        Intent intent = new Intent(this, ListDataFavourite.class);
        startActivity(intent);
    }

   /*
    public void ClickMenu(View view){
        //open drawer layout
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickFavourite(View view){
        Intent intent = new Intent(this, firstPage.class);
        startActivity(intent);
        closeDrawer(drawerLayout);
    }

    public static void redirectActivity(Activity activity,  Class aClass) {
        Intent intent=new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        
    }

    */
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openSettings()
    {
        Intent intent= new Intent(this,settings.class);
        startActivity(intent);
    }
*/
   public void pages(View view){
        Intent intent=null;
        if(view.getId()==R.id.button1){
            intent=new Intent(this,firstPage.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button2){
            intent=new Intent(this,secondPage.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button3){
            intent=new Intent(this,thirdPage.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button4){
            intent=new Intent(this,fourthPage.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button5){
            intent=new Intent(this,fifthPage.class);
            startActivity(intent);
        }
        else {
            intent=new Intent(this,firstPage.class);
            startActivity(intent);
        }

    }


   /* @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }*/
}