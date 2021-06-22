package com.example.jadwalsholatprojek.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jadwalsholatprojek.model.SholatDataItem;
import com.example.jadwalsholatprojek.model.SholatResponse;
import com.example.jadwalsholatprojek.API.APImain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSholatViewModel extends ViewModel {
    private APImain apiMain;
    private MutableLiveData<ArrayList<SholatDataItem>> listJadwalSholatMutableLiveData = new MutableLiveData<>();

    //setting datanya
    public void setJadwalSholat() {
        if (this.apiMain == null) {
            apiMain = new APImain();
        }

        /* Set parameter utk query API
         * parameter terdiri dari :
         * 1. address = isi dengan alamat yang diinginkan
         * 2. method = metode perhitungan, default value = 2
         * 3. month = bulan yang ingin dicari
         * 4. year = tahun yang ingin dicari
         */
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
        String address = "Sleman";
        String method = "2";
        String current_month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String current_year = String.valueOf(calendar.get(Calendar.YEAR));

        apiMain.getApiJadwalSholat().getJadwalSholat(address, method, current_month, current_year)
                .enqueue(new Callback<SholatResponse>() {

                    // onResponse berjalan apabila request berhasil
                    @Override
                    public void onResponse(Call<SholatResponse> call, Response<SholatResponse> response) {
                        SholatResponse jadwalSholatResponse = response.body();
                        if (jadwalSholatResponse != null && jadwalSholatResponse.getData() != null) {
                            ArrayList<SholatDataItem> jadwalSholatDataItems = jadwalSholatResponse.getData();
                            listJadwalSholatMutableLiveData.postValue(jadwalSholatDataItems);
                        }
                    }

                    // onFailure berjalan apabila request gagal atau terjadi kesalahan
                    @Override
                    public void onFailure(Call<SholatResponse> call, Throwable t) {

                    }
                });
    }

    public LiveData<ArrayList<SholatDataItem>> getJadwalSholat(){
        return listJadwalSholatMutableLiveData;
    }
}
