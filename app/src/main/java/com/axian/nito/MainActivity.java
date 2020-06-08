package com.axian.nito;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    String []urls;
    String []titles;

    private AdView mAdView;

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView )findViewById ( R.id.RecyclerView );

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        urls=new String[]{
                "https://drive.google.com/file/d/1GmvPbS8E77Bi1Fdcb1ILKzsihY6IO2x0/view?usp=sharing",
                "https://drive.google.com/file/d/0B5prfHWWrBKhd2hTbUkyWHN1WDQ/view?usp=sharing",
                "https://drive.google.com/file/d/0B_N4IlJVs3EGdVQyTFN4SHVsb1E/view?usp=sharing",
        };

        titles=new String[]{
                "June 2018",
                "Agha Khan Board",
                "Outer Space Arms Race"
        };

        customAdapter=new CustomAdapter ( this,titles,urls );
        recyclerView.setLayoutManager ( new LinearLayoutManager( this ) );
        recyclerView.setAdapter ( customAdapter );

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();
                if(id==R.id.home)
                {
                    Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_LONG).show();
                }

                else if (id==R.id.more)
                {
                    Toast.makeText(MainActivity.this,"More",Toast.LENGTH_LONG).show();
                }
                else if (id==R.id.about)
                {
                    Intent intent=new Intent ( MainActivity.this, About.class );
                    startActivity ( intent);
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item)||  super.onOptionsItemSelected(item) ;
    }
}