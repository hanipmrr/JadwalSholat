package com.example.jadwalsholatprojek.API;

import com.example.jadwalsholatprojek.model.SholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SholatRepository {
    // Request API dengan method GET dengan 4 parameter (address, method, month, year)
    @GET("v1/calendarByAddress")
    Call<SholatResponse> getJadwalSholat(
            @Query("address") String address,
            @Query("method") String method,
            @Query("month") String month,
            @Query("year") String year
    );
}
