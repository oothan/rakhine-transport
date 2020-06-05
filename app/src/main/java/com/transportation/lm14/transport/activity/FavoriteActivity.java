package com.transportation.lm14.transport.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.transportation.lm14.transport.DB_Handler.BusDBHandler;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.adapter.BusAdapter;
import com.transportation.lm14.transport.adapter.FavoriteAdapter;
import com.transportation.lm14.transport.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private List<Vehicle> favList = new ArrayList<Vehicle>();
    private RecyclerView recycler_view_fav;
    private FavoriteAdapter favAdapter;
    private BusDBHandler mBusDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBusDBHandler=new BusDBHandler(this);

        recycler_view_fav = (RecyclerView) findViewById(R.id.recycler_view_fav);

        favAdapter = new FavoriteAdapter(FavoriteActivity.this,  mBusDBHandler.getAllfavorite("yes"));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view_fav.setLayoutManager(mLayoutManager);
        recycler_view_fav.setItemAnimator(new DefaultItemAnimator());
        recycler_view_fav.setAdapter(favAdapter);

       // bindData();
    }

   /* private void bindData() {
        favList =;
        Log.i("Size : ", mBusDBHandler.getVehicleCount() + "");
        favAdapter.swapListFavorite(favList);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
