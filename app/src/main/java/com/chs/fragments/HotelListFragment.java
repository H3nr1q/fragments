package com.chs.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class HotelListFragment extends ListFragment {
    List<Hotel> mHotels;
    ArrayAdapter<Hotel> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHotels = carregarHoteis();

        mAdapter = new ArrayAdapter<Hotel>(getActivity(), android.R.layout.simple_list_item_1, mHotels);
        setListAdapter(mAdapter);
    }

    private List<Hotel> carregarHoteis() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Hotel 1", "Av. Hotel 1", 4.0f));
        hotels.add(new Hotel("Hotel 2", "Av. Hotel 2", 5.0f));
        hotels.add(new Hotel("Hotel 3", "Av. Hotel 3", 3.0f));
        return hotels;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if(activity instanceof AoClicarNoHotel){
            Hotel hotel = (Hotel) l.getItemAtPosition(position);

            AoClicarNoHotel listener = (AoClicarNoHotel)activity;
            listener.clicouNoHotel(hotel);
        }

    }

    public interface AoClicarNoHotel{
        void clicouNoHotel(Hotel hotel);
    }
}
