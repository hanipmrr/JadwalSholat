package com.example.jadwalsholatprojek.view.fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalsholatprojek.R;
import com.example.jadwalsholatprojek.adapter.SholatAdapter;
import com.example.jadwalsholatprojek.model.SholatDataItem;
import com.example.jadwalsholatprojek.view.viewmodel.JadwalSholatViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalSholatFragment extends Fragment {


    private SholatAdapter jadwalSholatAdapter;
    private RecyclerView recyclerViewJadwalSholat;
    private JadwalSholatViewModel jadwalSholatViewModel;

    public JadwalSholatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_jadwal_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting Adapter untuk RecyclerView dengan membawa data Jadwal Sholat
        jadwalSholatAdapter = new SholatAdapter();
        jadwalSholatAdapter.notifyDataSetChanged();

        //setting rv
        recyclerViewJadwalSholat = view.findViewById(R.id.jadwal_sholat_rv);
        recyclerViewJadwalSholat.setHasFixedSize(true);
        recyclerViewJadwalSholat.setLayoutManager(new LinearLayoutManager(getActivity()));

        //inisialisasi viewmodel
        jadwalSholatViewModel = new ViewModelProvider(this).get(JadwalSholatViewModel.class);
        jadwalSholatViewModel.setJadwalSholat();
        jadwalSholatViewModel.getJadwalSholat().observe(getViewLifecycleOwner(), getJadwalSholat);

        recyclerViewJadwalSholat.setAdapter(jadwalSholatAdapter);
    }

    private Observer<ArrayList<SholatDataItem>> getJadwalSholat = new Observer<ArrayList<SholatDataItem>>() {
        @Override
        public void onChanged(ArrayList<SholatDataItem> jadwalSholatDataItems) {
            if (jadwalSholatDataItems != null) {
                jadwalSholatAdapter.setData(jadwalSholatDataItems);
            }
        }
    };
}