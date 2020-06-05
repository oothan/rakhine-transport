package com.transportation.lm14.transport.one_way_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.transportation.lm14.transport.DB_Handler.BusDBHandler;
import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.activity.HomeActivity;
import com.transportation.lm14.transport.adapter.BusAdapter;
import com.transportation.lm14.transport.adapter.TrainAdapter;
import com.transportation.lm14.transport.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainFragmentOneWay extends Fragment {

    private List<Vehicle> tList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TrainAdapter trainAdapter;

    private BusDBHandler mBusDBHandler;
    private LinearLayout emptyView;

    public TrainFragmentOneWay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_train_fragment_one_way, container, false);

        mBusDBHandler = new BusDBHandler(getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_one_way_train);
        emptyView = (LinearLayout) view.findViewById(R.id.emptyView);

        trainAdapter = new TrainAdapter(getActivity(), tList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(trainAdapter);

        bindData();

        return view;
    }

    private void bindData() {
        tList = mBusDBHandler.getAllTrain("train", HomeActivity.startCity, HomeActivity.endCity);
        if (tList.size() == 0) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }
        Log.i("Size : ", mBusDBHandler.getVehicleCount() + "");
        trainAdapter.swapListTrain(tList);
    }

}
