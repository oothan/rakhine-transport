package com.transportation.lm14.transport.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.transportation.lm14.transport.DB_Handler.BusDBHandler;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.model.Vehicle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {

    public String startCName, endCname;
    String msg = "";
    private Button btnChoose;
    private Button startCity, endCity;

    BusDBHandler mBusDBHandler;

    private SharedPreferences sh;
    private SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_choose);

        mBusDBHandler = new BusDBHandler(this);
        sh = getSharedPreferences("BUS", 0);
        ed = sh.edit();

        if (sh.getInt("BUS_DATA", 0) == 0) {
            prepareBusData();
        }

        startCity=(Button)findViewById(R.id.startCity);
        endCity=(Button)findViewById(R.id.endCity);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnChoose.setOnClickListener(this);
        startCity.setOnClickListener(this);
        endCity.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.startCity:

                AlertDialog.Builder builderS = new AlertDialog.Builder(ChooseActivity.this);
                builderS.setTitle("Start City")
                        .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                String[] strarr = getResources().getStringArray(R.array.colors_array);
                                startCName = strarr[which];
                                startCity.setText(Html.fromHtml(startCName));
                            }
                        });
                builderS.show();

                break;

            case R.id.endCity:
                AlertDialog.Builder builderE = new AlertDialog.Builder(ChooseActivity.this);
                builderE.setTitle("End City")
                        .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                String[] strarr = getResources().getStringArray(R.array.colors_array);
                                endCname = strarr[which];
                                endCity.setText(Html.fromHtml(endCname));
                            }
                        });
                builderE.show();

                break;

            case R.id.btnChoose:
                Intent intent = new Intent(ChooseActivity.this, HomeActivity.class);
                intent.putExtra("start", startCName);
                intent.putExtra("end", endCname);
                startActivity(intent);
                finish();
                break;

        }
    }

    private void prepareBusData() {

        try {
            JSONArray arrJSON = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < arrJSON.length(); i++) {
                JSONObject objJSON = arrJSON.getJSONObject(i);

                Vehicle vehicle = new Vehicle(objJSON.getString("name"),
                        objJSON.getString("start"),
                        objJSON.getString("end"),
                        objJSON.getString("ph_no"),
                        objJSON.getString("address"),
                        objJSON.getString("departure"),
                        objJSON.getString("time"),
                        objJSON.getString("category"),
                        objJSON.getString("fprice"),
                        objJSON.getString("sprice"),"no",
                        objJSON.getString("id"));
                mBusDBHandler.addVehicle(vehicle);
            }
            ed.putInt("BUS_DATA", 1).commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAsset() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open("transport.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            Log.d("RESPONSE ", stringBuilder.toString());

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
