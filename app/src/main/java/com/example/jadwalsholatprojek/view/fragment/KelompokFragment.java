package com.example.jadwalsholatprojek.view.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalsholatprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KelompokFragment extends Fragment {

    public KelompokFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_kelompok, container, false);
    }
}
