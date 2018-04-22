package com.example.femialfred.agileapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/15/2018.
 */

public class Tab3Discovery extends Fragment {
    GridView gridView;
    //  Activity rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Confirm this fragment has menu items.
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3discovery_layout, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.myGrid);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(getContext()));

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent();

//                final Intent i;

                switch(position)
                {
                    case 0:
                        i  = new Intent(getContext(), AgiPedia1.class);
                        break;

                    case 1:
                        i =  new Intent(getContext(), AgiPedia2.class);
                        break;

                    case 2:
                        i =  new Intent(getContext(), AgiPedia3.class);
                        break;

                    case 3:
                        i = new Intent(getContext(), AgiPedia4.class);
                        break;

                    case 4:
                        i = new Intent(getContext(), AgiPedia5.class);
                        break;

                }
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }

        });

        return view;
    }

}
