package com.transportation.lm14.transport.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.transportation.lm14.transport.DB_Handler.BusDBHandler;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.adapter.ShipAdapter;
import com.transportation.lm14.transport.model.Vehicle;
import com.transportation.lm14.transport.one_way_fragment.BusFragmentOneWay;
import com.transportation.lm14.transport.one_way_fragment.PlaneFragmentOneWay;
import com.transportation.lm14.transport.one_way_fragment.ShipFragmentOneway;
import com.transportation.lm14.transport.one_way_fragment.TrainFragmentOneWay;
import com.transportation.lm14.transport.transport_fragment.BusFragment;
import com.transportation.lm14.transport.transport_fragment.PlaneFragment;
import com.transportation.lm14.transport.transport_fragment.ShipFragment;
import com.transportation.lm14.transport.transport_fragment.TrainFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //for checking page position
    int checkPage=0;

    Menu menu;
    SearchView searchView;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.bus_icon_selected,
            R.drawable.ship_icon_selected,
            R.drawable.plane_icon_selected,
            R.drawable.train_icon_selected};
    FragmentManager fm;
    FragmentTransaction ft;

    private BusDBHandler mBusDBHandler;

    public static String startCity,endCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Bundle b=getIntent().getExtras();
        this.setTitle(b.getString("start")+" to "+b.getString("end"));

        startCity = b.getString("start");
        endCity = b.getString("end");

        mBusDBHandler = new BusDBHandler(this);


        //((ResultReceiver)getIntent().getExtras()).send(1, new Bundle());

       // setTitlegetSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                checkPage=position;
               // Toast.makeText(getApplicationContext(),"you are in "+position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BusFragmentOneWay(),"");
        adapter.addFragment(new ShipFragmentOneway(),"");
        adapter.addFragment(new PlaneFragmentOneWay(),"");
        adapter.addFragment(new TrainFragmentOneWay(),"");
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    /*private void changeFragment(Fragment homeFragment) {
        ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,homeFragment,null).commit();
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        this.menu=menu;
        searchView=(SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                BusFragment busFragment = new BusFragment();
                busFragment.search(query);


                ShipFragment shipAdapter=new ShipFragment();
                shipAdapter.search(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_aboutAs) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           /* changeFragment(new BusFragment());*/


        }else if (id == R.id.nav_favorite) {
            Intent intent = new Intent( HomeActivity.this,FavoriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_choose) {
            Intent intent = new Intent( HomeActivity.this,ChooseActivity.class);
            startActivity(intent);
        }else if (id== R.id.nav_about)
        {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_question);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    finish();
                    //HomeActivity.this.onSuperBackPressed();
                    //super.onBackPressed();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
    /*
    if (handleCancel()){
        super.onBackPressed();
    }
    */
        }
    }

    public void onSuperBackPressed(){
        super.onBackPressed();
    }
}
