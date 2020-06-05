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

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.MyViewHolder>   {

    private Context tContext;
    private List<Vehicle> tList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView trainName,trainFPrice, trainSPrice,fromto;
        protected Vehicle vehicle;
        public Button trainDetail,trainOneWay;
        private ImageView trainImg;

        public MyViewHolder(View view) {
            super(view);
            trainName = (TextView) view.findViewById(R.id.trainName);
            trainFPrice = (TextView) view.findViewById(R.id.trainFPrice);
            trainSPrice= (TextView) view.findViewById(R.id.trainSPrice);
            trainDetail=(Button) view.findViewById(R.id.trainDetail);
            trainOneWay=(Button) view.findViewById(R.id.trainOneWay);
            trainImg=(ImageView)view.findViewById(R.id.trainImg);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",tList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",tList.get(getAdapterPosition()).getFavorite());
                    tContext.startActivity(intent);
                }
            });

            trainOneWay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tContext, OneWayActivity.class);
                    intent.putExtra("BUS_ID",tList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",tList.get(getAdapterPosition()).getFavorite());
                    tContext.startActivity(intent);
                }
            });

           trainDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tContext, DetailActivity.class);
                    intent.putExtra("BUS_ID",tList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",tList.get(getAdapterPosition()).getFavorite());
                    tContext.startActivity(intent);
                }
            });
        }

        public void bindView(Vehicle vehicle) {

            this.vehicle = vehicle;
            String s=vehicle.getName();
            if (s.equals("Myanmar Railway")) {
                try {
                    Glide.with(tContext).load(R.drawable.train).into(trainImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            trainName.setText(vehicle.getName());
            fromto.setText(HomeActivity.startCity+" to "+HomeActivity.endCity);
            trainFPrice.setText(String.valueOf(vehicle.getFprice())+" ks ");
            trainSPrice.setText(String.valueOf(vehicle.getSprice())+" ks ");
        }
    }

    public TrainAdapter(Context tContext, List<Vehicle> tList) {
        this.tContext = tContext;
        this.tList = tList;
    }

    public void swapListTrain(List<Vehicle> tList){
        this.tList = tList;
        notifyDataSetChanged();
    }

    @Override
    public TrainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_train, parent, false);

        return new TrainAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrainAdapter.MyViewHolder holder, int position) {
        Vehicle vehicle = tList.get(position);
        holder.bindView(vehicle);

    }

    @Override
    public int getItemCount() {
        return tList.size();
    }
}
