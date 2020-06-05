package com.transportation.lm14.transport.transport_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.transportation.lm14.transport.R;
import com.transportation.lm14.transport.activity.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment{

    public BusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_bus, container, false);


        return  v;
    }

    public void search(String text){

    }

}
