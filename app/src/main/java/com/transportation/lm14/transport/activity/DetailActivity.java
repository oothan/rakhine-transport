package com.transportation.lm14.transport.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

public class DetailActivity extends AppCompatActivity {


    private FloatingActionButton fabButton;

    private TextView vName, fromTo, priceF, priceS, departure, time, address, phoneNo;

    String mBusID = "";

    private Vehicle busVehicle;

    private BusDBHandler mBusDBHandler;

    String vname,catagory;
    public ImageView vTypeImg,vLogo;

    String phone="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vName = (TextView) findViewById(R.id.vName);
        fromTo = (TextView) findViewById(R.id.fromTo);
        priceF = (TextView) findViewById(R.id.priceF);
        priceS = (TextView) findViewById(R.id.priceS);
        departure = (TextView) findViewById(R.id.departure);
        time = (TextView) findViewById(R.id.time);
        address = (TextView) findViewById(R.id.address);
        phoneNo = (TextView) findViewById(R.id.phoneNo);
        fabButton=(FloatingActionButton)findViewById(R.id.fabButton);
        vTypeImg=(ImageView)findViewById(R.id.vTypeImg);
        vLogo=(ImageView)findViewById(R.id.vLogo);

        mBusDBHandler = new BusDBHandler(this);
        busVehicle = new Vehicle();

        mBusID = getIntent().getStringExtra("BUS_ID");
        busVehicle = mBusDBHandler.getBusWithID(mBusID + "");
        Log.i("BUS ID ", mBusID + "");


        if (busVehicle != null) {
            Log.i("Departure : ", busVehicle.getDeparture() + " First Price " + busVehicle.getFprice());

            vName.setText(busVehicle.getName());
            vname=busVehicle.getName();
            fromTo.setText(busVehicle.getStart() + " to " + busVehicle.getEnd());
            priceF.setText(busVehicle.getFprice()+" ks");
            priceS.setText(busVehicle.getSprice()+" ks");
            String str=busVehicle.getDeparture();
            if(str.equals("Every"))
            {
               str=str+"day";
            }
            departure.setText(str);
            time.setText(busVehicle.getTime());
            address.setText(busVehicle.getAddress());
            phone=busVehicle.getPh_no();
            phoneNo.setText(busVehicle.getPh_no());
            catagory=busVehicle.getCategory();

            if(catagory.equals("bus"))
            {
                if(vname.equals("Academy"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.academy).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Aung Pyi Sone"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.aung_pyi_sone).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Gatesapa"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.gatesapa).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Rakhine Arr Man"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.rakhine_arr_man).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe Aung Lan"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_aung_lan).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Kyan Taing Aung"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.kyan_taing_aung).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(vname.equals("Man Thitsar"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.man_thit_sar).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe La Min"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_la_min).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_mann_yatanar).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.car_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (catagory.equals("vessel"))
            {
                if(vname.equals("Shwe Pyi Tan"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_pyi_tan).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Myanmar Ship"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.myanmar_ship).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe Nadi"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.nadi).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if (vname.equals("Ma Li Kha"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.ma_li_kha).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else  if(vname.equals("Shwe Linn Yone"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.shwe_linn_yone).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.null_vessel).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.ship_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if(catagory.equals("flight"))
            {
                if(vname.equals("Myanmar National Airlines"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.mn_air_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.mn_air_logo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Air KBZ"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.air_kbz_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.air_kbz).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Mann Yatanarpon Airlines"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.mann_yandar_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.mann_yandar).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.golden_myanmar_img).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.golden_myanmar).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if (catagory.equals("train"))
            {
                if(vname.equals("Myanmar Railway"))
                {
                    try {
                        Glide.with(getApplicationContext()).load(R.drawable.train).into(vTypeImg);
                        Glide.with(getApplicationContext()).load(R.drawable.railwaylogo).into(vLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }



        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        if(isPermissionGranted())
        {
            callPh(phone);
        }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();

                    ///call
                    callPh(phone);
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void callPh(String ph)
    {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ph));
        //callIntent.setData();
        startActivity(callIntent);

    }
}
