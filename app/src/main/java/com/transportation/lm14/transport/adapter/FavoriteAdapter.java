package com.transportation.lm14.transport.adapter;

import android.app.Activity;
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
import com.transportation.lm14.transport.activity.OneWayActivity;
import com.transportation.lm14.transport.model.Vehicle;

import java.util.List;

/**
 * Created by Maung Oo Thann on 10/26/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {

    private Context favContext;
    private List<Vehicle> favList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView busName, busFPrice, busSPrice,fromto;
        public Button busDetail, busOneWay;
        protected Vehicle vehicle;
        private ImageView busImg,busLogo;
        String vname,catagory;
        public MyViewHolder(View view) {
            super(view);

            busName = (TextView) view.findViewById(R.id.busName);
            busFPrice = (TextView) view.findViewById(R.id.busFPrice);
            busSPrice = (TextView) view.findViewById(R.id.busSPrice);
            busOneWay = (Button) view.findViewById(R.id.busOneWay);
            busDetail = (Button) view.findViewById(R.id.busDetail);
            busImg=(ImageView)view.findViewById(R.id.busImg);
            busLogo=(ImageView)view.findViewById(R.id.busLogo);
            fromto=(TextView)view.findViewById(R.id.fromto);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(favContext, DetailActivity.class);
                    intent.putExtra("BUS_ID", favList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",favList.get(getAdapterPosition()).getFavorite());
                    favContext.startActivity(intent);
                }
            });

            busOneWay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(favContext, OneWayActivity.class);
                    intent.putExtra("BUS_ID", favList.get(getAdapterPosition()).getId());
                    Log.e("fav",favList.get(getAdapterPosition()).getFavorite());
                    intent.putExtra("fav",favList.get(getAdapterPosition()).getFavorite());
                    favContext.startActivity(intent);
                }
            });

            busDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(favContext, DetailActivity.class);
                    intent.putExtra("BUS_ID", favList.get(getAdapterPosition()).getId());
                    intent.putExtra("fav",favList.get(getAdapterPosition()).getFavorite());
                    favContext.startActivity(intent);
                }
            });
        }

        public void bindView(Vehicle vehicle){

            this.vehicle = vehicle;
            vname=vehicle.getName();
            catagory=vehicle.getCategory();
            if(catagory.equals("bus"))
            {
                if(vname.equals("Academy"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.academy).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Aung Pyi Sone"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.aung_pyi_sone).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Gatesapa"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.gatesapa).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Rakhine Arr Man"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.rakhine_arr_man).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe Aung Lan"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.shwe_aung_lan).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Kyan Taing Aung"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.kyan_taing_aung).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(vname.equals("Man Thitsar"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.man_thit_sar).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe La Min"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.shwe_la_min).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(favContext).load(R.drawable.shwe_mann_yatanar).into(busImg);
                        Glide.with(favContext).load(R.drawable.car_logo).into(busLogo);
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
                        Glide.with(favContext).load(R.drawable.shwe_pyi_tan).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Myanmar Ship"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.myanmar_ship).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Shwe Nadi"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.nadi).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if (vname.equals("Ma Li Kha"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.ma_li_kha).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else  if(vname.equals("Shwe Linn Yone"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.shwe_linn_yone).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(favContext).load(R.drawable.null_vessel).into(busImg);
                        Glide.with(favContext).load(R.drawable.ship_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if(catagory.equals("flight"))
            {
                if(vname.equals("Myanmar National Airlines"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.mn_air_img).into(busImg);
                        Glide.with(favContext).load(R.drawable.mn_air_logo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Air KBZ"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.air_kbz_img).into(busImg);
                        Glide.with(favContext).load(R.drawable.air_kbz).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(vname.equals("Mann Yatanarpon Airlines"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.mann_yandar_img).into(busImg);
                        Glide.with(favContext).load(R.drawable.mann_yandar).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    try {
                        Glide.with(favContext).load(R.drawable.golden_myanmar_img).into(busImg);
                        Glide.with(favContext).load(R.drawable.golden_myanmar).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if (catagory.equals("train"))
            {
                if(vname.equals("Myanmar Railway"))
                {
                    try {
                        Glide.with(favContext).load(R.drawable.train).into(busImg);
                        Glide.with(favContext).load(R.drawable.railwaylogo).into(busLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


            busName.setText(vehicle.getName());
            busFPrice.setText(String.valueOf(vehicle.getFprice()) + " ks ");
            busSPrice.setText(String.valueOf(vehicle.getSprice()) + " ks ");


        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }
   /* public void swapListFavorite(List<Vehicle> favList) {
        this.favList = favList;
        Log.i("Data Rv", favList.size() + "");
        notifyDataSetChanged();
    }*/

    public FavoriteAdapter(Context favContext, List<Vehicle> favList) {
        this.favContext = favContext;
        this.favList = favList;
    }

    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favorite, parent, false);

        return new FavoriteAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.MyViewHolder holder, int position) {
        Vehicle vehicle = favList.get(position);
        holder.bindView(vehicle);
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }
}
