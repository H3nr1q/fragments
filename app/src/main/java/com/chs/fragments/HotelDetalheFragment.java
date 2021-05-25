package com.chs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class HotelDetalheFragment extends Fragment {
    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String EXTRA_HOTEL = "hotel";

    TextView mTextNome, mTextEndereco;
    RatingBar mRatingEstrelas;
    Hotel mHotel;

    public static HotelDetalheFragment novaInstancia(Hotel hotel){
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_HOTEL, hotel);
        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(parametros);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalhe_hotel, container, false);
        mTextNome = layout.findViewById(R.id.txtNome);
        mTextEndereco = layout.findViewById(R.id.txtEndereco);
        mRatingEstrelas = layout.findViewById(R.id.rtbEstrelas);

        if(mHotel != null){
            mTextNome.setText(mHotel.nome);
            mTextEndereco.setText(mHotel.endereco);
            mRatingEstrelas.setRating(mHotel.estrelas);
        }

        return layout;
    }
}
