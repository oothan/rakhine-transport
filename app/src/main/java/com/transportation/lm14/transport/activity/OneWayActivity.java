package com.transportation.lm14.transport.activity;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.transportation.lm14.transport.DB_Handler.BusDBHandler;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.model.Vehicle;

public class OneWayActivity extends AppCompatActivity {

    private Button OWdetail;
    private Vehicle busVehicle;
    String mBusID = "";
    String str, catagory,favorite;
    MenuItem mItem;
    int check = 0;
    private BusDBHandler mBusDBHandler;
    private ImageView vTypeImg, vLogo;
    private TextView vName, fromTo, departure, time, priceF, priceS;
    String fav;

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_way);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vName = (TextView) findViewById(R.id.vName);
        fromTo = (TextView) findViewById(R.id.fromTo);
        departure = (TextView) findViewById(R.id.departure);
        time = (TextView) findViewById(R.id.time);
        priceF = (TextView) findViewById(R.id.priceF);
        priceS = (TextView) findViewById(R.id.priceS);
        vTypeImg = (ImageView) findViewById(R.id.vTypeImg);
        vLogo = (ImageView) findViewById(R.id.vLogo);
        OWdetail = (Button) findViewById(R.id.OWdetail);


       // Toast.makeText(getApplicationContext(),"fav is "+getIntent().getExtras().getString("fav"),Toast.LENGTH_SHORT).show();

        mBusDBHandler = new BusDBHandler(this);
        busVehicle = new Vehicle();

        mBusID = getIntent().getStringExtra("BUS_ID");
        busVehicle = mBusDBHandler.getBusWithID(mBusID + "");
        Log.i("BUS ID ", mBusID + "");
        fav=getIntent().getExtras().getString("fav");



        if (busVehicle != null) {
            str = busVehicle.getName();
            vName.setText(busVehicle.getName());
            fromTo.setText(busVehicle.getStart() + " to " + busVehicle.getEnd());
            String s=busVehicle.getDeparture();
            if(s.equals("Every"))
            {
                s=s+"day";
            }
            departure.setText(s);
            time.setText(busVehicle.getTime());
            priceF.setText(busVehicle.getFprice() + " ks");
            priceS.setText(busVehicle.getSprice() + " ks");
            favorite=busVehicle.getFavorite();
            catagory = busVehicle.getCategory();


            if (catagory.equals("bus")) {
                if (str.equals("Academy")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.academy).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Aung Pyi Sone")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.aung_pyi_sone).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Gatesapa")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.gatesapa).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Rakhine Arr Man")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.rakhine_arr_man).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Shwe Aung Lan")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_aung_lan).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Kyan Taing Aung")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.kyan_taing_aung).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Man Thitsar")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.man_thit_sar).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Shwe La Min")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_la_min).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_mann_yatanar).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (catagory.equals("vessel")) {
                if (str.equals("Shwe Pyi Tan")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_pyi_tan).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Myanmar Ship")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.myanmar_ship).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Shwe Nadi")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.nadi).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Ma Li Kha")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.ma_li_kha).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Shwe Linn Yone")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_linn_yone).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.null_vessel).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (catagory.equals("flight")) {
                if (str.equals("Myanmar National Airlines")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.mn_air_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.mn_air_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Air KBZ")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.air_kbz_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.air_kbz).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("Mann Yatanarpon Airlines")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.mann_yandar_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.mann_yandar).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.golden_myanmar_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.golden_myanmar).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (catagory.equals("train")) {
                if (str.equals("Myanmar Railway")) {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.train).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.railwaylogo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        OWdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("BUS_ID", mBusID);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.one_way, menu);

        if (fav=="yes")
        {
            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_favorite_fill);
        }
        else
        {

            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_favorite_blank);
        }

        if(favorite.equals("yes"))
        {
            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_favorite_fill);
        }
        else{
            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_favorite_blank);
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        if (item.getItemId() == R.id.action_favorite) {
            if (check == 0) {
                Toast.makeText(this, "Add to Favorite.", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_favorite_fill);
                check = 1;

                mBusDBHandler.updateFav(mBusID, "yes");
            } else {
                Toast.makeText(this, "Remove from Favorite.", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_favorite_blank);
                check = 0;
                mBusDBHandler.updateFav(mBusID, "no");
            }

        }
        return true;
    }

}
