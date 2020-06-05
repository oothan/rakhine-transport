package com.transportation.lm14.transport.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.activity.DetailActivity;
import com.transportation.lm14.transport.activity.HomeActivity;
import com.transportation.lm14.transport.activity.OneWayActivity;
import com.transportation.lm14.transport.model.Vehicle;

import java.util.List;

/**
 * Created by Maung Oo Thann on 10/24/2017.
 */

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.MyViewHolder>  {

    private Context sContext;
    private List<Vehicle> sList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView shipName,shipFPrice, shipSPrice,fromto;
        protected Vehicle vehicle;
        public Button shipDetail,shipOneWay;
        public ImageView shipImg;

        public MyViewHolder(View view) {
            super(view);
            shipName = (TextView) view.findViewById(R.id.shipName);
            shipFPrice = (TextView) view.findViewById(R.id.shipFPrice);
            shipSPrice= (TextView) view.findViewById(R.id.shipSPrice);
            shipDetail=(Button) view.findViewById(R.id.shipDetail);
            shipOneWay=(Button) view.findViewById(R.id.shipOneWay);
            shipImg=(ImageView) view.findViewById(R.id.shipImg);
            fromto=(TextView)view.findViewById(R.id.fromto);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(sContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",sList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",sList.get(getAdapterPosition()).getFavorite());
                    sContext.startActivity(intent);
                }
            });

            shipOneWay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(sContext, OneWayActivity.class);
                    intent.putExtra("BUS_ID",sList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",sList.get(getAdapterPosition()).getFavorite());
                    sContext.startActivity(intent);
                }
            });

            shipDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(sContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",sList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",sList.get(getAdapterPosition()).getFavorite());
                    sContext.startActivity(intent);
                }
            });
        }

        public void bindView(Vehicle vehicle) {

            this.vehicle = vehicle;
            String s=vehicle.getName();
            if(s.equals("Shwe Pyi Tan"))
            {
                try {
                    Glide.with(sContext).load(R.drawable.shwe_pyi_tan).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Myanmar Ship"))
            {
                try {
                    Glide.with(sContext).load(R.drawable.myanmar_ship).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Shwe Nadi"))
            {
                try {
                    Glide.with(sContext).load(R.drawable.nadi).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (s.equals("Ma Li Kha"))
            {
                try {
                    Glide.with(sContext).load(R.drawable.ma_li_kha).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else  if(s.equals("Ma Li Kha"))
            {
                try {
                    Glide.with(sContext).load(R.drawable.shwe_linn_yone).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else
            {
                try {
                    Glide.with(sContext).load(R.drawable.null_vessel).into(shipImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            shipName.setText(vehicle.getName());
            fromto.setText(HomeActivity.startCity+" to "+HomeActivity.endCity);
            shipFPrice.setText(String.valueOf(vehicle.getFprice())+" ks ");
            shipSPrice.setText(String.valueOf(vehicle.getSprice())+" ks ");
        }
    }

    public ShipAdapter(Context sContext, List<Vehicle> sList) {
        this.sContext = sContext;
        this.sList = sList;
    }

    public void swapListVessel(List<Vehicle> sList){
        this.sList = sList;
        notifyDataSetChanged();
    }

    @Override
    public ShipAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ship, parent, false);

        return new ShipAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShipAdapter.MyViewHolder holder, int position) {
        Vehicle vehicle = sList.get(position);
        holder.bindView(vehicle);

    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

}
