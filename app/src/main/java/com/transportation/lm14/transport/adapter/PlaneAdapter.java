package com.transportation.lm14.transport.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class PlaneAdapter extends RecyclerView.Adapter<PlaneAdapter.MyViewHolder> {

    private Context pContext;
    private List<Vehicle> pList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView planeName,planeFPrice, planeSPrice,fromto;
        protected Vehicle vehicle;
        public Button planeDetail,planeOneWay;
        public ImageView planeLogo,planeImg;

        public MyViewHolder(View view) {
            super(view);
            planeName = (TextView) view.findViewById(R.id.planeName);
            planeFPrice = (TextView) view.findViewById(R.id.planeFPrice);
            planeSPrice= (TextView) view.findViewById(R.id.planeSPrice);
            planeOneWay=(Button) view.findViewById(R.id.planeOneWay);
            planeDetail=(Button) view.findViewById(R.id.planeDetail);
            planeLogo=(ImageView)view.findViewById(R.id.planeLogo);
            planeImg=(ImageView)view.findViewById(R.id.planeImg);
            fromto=(TextView)view.findViewById(R.id.fromto);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",pList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",pList.get(getAdapterPosition()).getFavorite());
                    pContext.startActivity(intent);
                }
            });

            planeOneWay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pContext, OneWayActivity.class);
                    intent.putExtra("BUS_ID",pList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",pList.get(getAdapterPosition()).getFavorite());
                    pContext.startActivity(intent);
                }
            });

            planeDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",pList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",pList.get(getAdapterPosition()).getFavorite());
                    pContext.startActivity(intent);
                }
            });
        }

        public void bindView(Vehicle vehicle) {

            this.vehicle = vehicle;
            String s=vehicle.getName();
            if(s.equals("Myanmar National Airlines"))
            {
                try {
                    Glide.with(pContext).load(R.drawable.mn_air_logo).into(planeLogo);
                    Glide.with(pContext).load(R.drawable.mn_air_img).into(planeImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Air KBZ"))
            {
                try {
                    Glide.with(pContext).load(R.drawable.air_kbz).into(planeLogo);
                    Glide.with(pContext).load(R.drawable.air_kbz_img).into(planeImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Mann Yatanarpon Airlines"))
            {
                try {
                    Glide.with(pContext).load(R.drawable.mann_yandar).into(planeLogo);
                    Glide.with(pContext).load(R.drawable.mann_yandar_img).into(planeImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else
            {
                try {
                    Glide.with(pContext).load(R.drawable.golden_myanmar).into(planeLogo);
                    Glide.with(pContext).load(R.drawable.golden_myanmar_img).into(planeImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            planeName.setText(vehicle.getName());
            fromto.setText(HomeActivity.startCity+" to "+HomeActivity.endCity);
            planeFPrice.setText(String.valueOf(vehicle.getFprice())+" ks ");
            planeSPrice.setText(String.valueOf(vehicle.getSprice())+" ks ");
        }
    }

    public PlaneAdapter(Context pContext, List<Vehicle> pList) {
        this.pContext = pContext;
        this.pList = pList;
    }

    public void swapListFlight(List<Vehicle> pList){
        this.pList = pList;
        Log.i("Data Rv", pList.size() + "");
        notifyDataSetChanged();
    }

    @Override
    public PlaneAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_plane, parent, false);

        return new PlaneAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaneAdapter.MyViewHolder holder, int position) {
        Vehicle movie = pList.get(position);
        holder.bindView(movie);
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

}
