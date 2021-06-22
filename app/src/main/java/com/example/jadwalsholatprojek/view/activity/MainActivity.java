package com.example.jadwalsholatprojek.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.jadwalsholatprojek.R;
import com.example.jadwalsholatprojek.view.fragment.JadwalSholatFragment;
import com.example.jadwalsholatprojek.view.fragment.KelompokFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new JadwalSholatFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activitymain_bottomnavbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Menampilkan Fragment yang ingin ditampilkan pada saat aplikasi dibuka pertama kali
        loadFragment(selectedFragment);
    }


    // return nilai boolean ketika fragment terpilih
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bottomnavbar_jadwal:
                selectedFragment = new JadwalSholatFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnavbar_kelompok:
                selectedFragment = new KelompokFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    // method untuk load fragment yang terpilih
    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
