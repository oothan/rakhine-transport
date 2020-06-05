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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.activity.DetailActivity;
import com.transportation.lm14.transport.activity.HomeActivity;
import com.transportation.lm14.transport.activity.OneWayActivity;
import com.transportation.lm14.transport.model.Vehicle;

import java.util.List;

/**
 * Created by Maung Oo Thann on 10/17/2017.
 */

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.MyViewHolder> {

    private Context bContext;
    private List<Vehicle> bList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView busName, busFPrice, busSPrice,fromto;
        protected Vehicle vehicle;
        public Button busDetail, busOneWay;
        private ImageView busImg;

        public MyViewHolder(View view) {
            super(view);
            busName = (TextView) view.findViewById(R.id.busName);
            busFPrice = (TextView) view.findViewById(R.id.busFPrice);
            busSPrice = (TextView) view.findViewById(R.id.busSPrice);
            busOneWay = (Button) view.findViewById(R.id.busOneWay);
            busDetail = (Button) view.findViewById(R.id.busDetail);
            busImg=(ImageView)view.findViewById(R.id.busImg);
            fromto=(TextView)view.findViewById(R.id.fromto);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(bContext, DetailActivity.class);
                    intent.putExtra("BUS_ID", bList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",bList.get(getAdapterPosition()).getFavorite());
                    bContext.startActivity(intent);
                }
            });



            busOneWay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(bContext, OneWayActivity.class);
                    intent.putExtra("BUS_ID", bList.get(getAdapterPosition()).getId());

                   /* Log.e("favourite",bList.get(getAdapterPosition()).getFavorite());*/
                    //Toast.makeText(bContext,""+getAdapterPosition(),Toast.LENGTH_SHORT).show();

                    intent.putExtra("fav",bList.get(getAdapterPosition()).getFavorite());
                    bContext.startActivity(intent);
                }
            });

            busDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(bContext, DetailActivity.class);
                    intent.putExtra("BUS_ID", bList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",bList.get(getAdapterPosition()).getFavorite());
                    bContext.startActivity(intent);
                }
            });
        }

        public void bindView(Vehicle vehicle) {

            this.vehicle = vehicle;
            String s=vehicle.getName();
            if (s.equals("Academy")) {
                try {
                    Glide.with(bContext).load(R.drawable.academy).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (s.equals("Aung Pyi Sone")) {
                try {
                    Glide.with(bContext).load(R.drawable.aung_pyi_sone).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (s.equals("Gatesapa")) {
                try {
                    Glide.with(bContext).load(R.drawable.gatesapa).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (s.equals("Rakhine Arr Man")) {
                try {
                    Glide.with(bContext).load(R.drawable.rakhine_arr_man).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (s.equals("Shwe Aung Lan")) {
                try {
                    Glide.with(bContext).load(R.drawable.shwe_aung_lan).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if(s.equals("Kyan Taing Aung"))
            {
                try {
                    Glide.with(bContext).load(R.drawable.kyan_taing_aung).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Man Thitsar"))
            {
                try {
                    Glide.with(bContext).load(R.drawable.man_thit_sar).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(s.equals("Shwe La Min"))
            {
                try {
                    Glide.with(bContext).load(R.drawable.shwe_la_min).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    Glide.with(bContext).load(R.drawable.shwe_mann_yatanar).into(busImg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            busName.setText(vehicle.getName());
            fromto.setText(HomeActivity.startCity+" to "+HomeActivity.endCity);
            busFPrice.setText(String.valueOf(vehicle.getFprice()) + " ks ");
            busSPrice.setText(String.valueOf(vehicle.getSprice()) + " ks ");
        }

    }

    public BusAdapter(Context bContext, List<Vehicle> bList) {
        this.bContext = bContext;
        this.bList = bList;
    }

    public void swapListBus(List<Vehicle> bList) {
        this.bList = bList;
        Log.i("Data Rv", bList.size() + "");
        notifyDataSetChanged();
    }

    @Override
    public BusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bus, parent, false);

        return new BusAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BusAdapter.MyViewHolder holder, int position) {
        Vehicle vehicle = bList.get(position);
        holder.bindView(vehicle);

    }

    @Override
    public int getItemCount() {
        return bList.size();
    }
}
