package com.example.jadwalsholatprojek.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APImain {
    private Retrofit retrofit;

    /* Setting awal Retrofit dan set BASE_URL
     * Untuk BASE_URL jika bisa https
     * karena retrofit hanya menerima request dari https
     */
    public SholatRepository getApiJadwalSholat() {
        String BASE_URL = "https://api.aladhan.com/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //mengisi repository untuk request berbagai url yang akan digunakan
        return retrofit.create(SholatRepository.class);
    }
}
