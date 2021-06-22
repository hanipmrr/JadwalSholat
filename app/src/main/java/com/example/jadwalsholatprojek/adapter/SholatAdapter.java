package com.example.jadwalsholatprojek.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholatprojek.R;
import com.example.jadwalsholatprojek.model.SholatDataItem;

import java.util.ArrayList;

public class SholatAdapter extends RecyclerView.Adapter<SholatAdapter.ViewHolder>{
    private ArrayList<SholatDataItem> SholatDataItemArrayList = new ArrayList<>();

    public SholatAdapter() {
    }

    public void setData(ArrayList<SholatDataItem> SholatDataItems) {
        SholatDataItemArrayList.clear();
        SholatDataItemArrayList.addAll(SholatDataItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SholatAdapter.ViewHolder holder, int position) {

        // Get tanggal dan hari
        String tanggal = SholatDataItemArrayList.get(position).getDate().getReadable();
        String hari = SholatDataItemArrayList.get(position).getDate().getGregorian().getWeekday().getEn();

        // Set TextView dengan value dari ArrayList
        holder.tvTanggal.setText(hari + ", " + tanggal);
        holder.tvJamImsak.setText(SholatDataItemArrayList.get(position).getTimings().getImsak());
        holder.tvJamShubuh.setText(SholatDataItemArrayList.get(position).getTimings().getFajr());
        holder.tvJamDzuhur.setText(SholatDataItemArrayList.get(position).getTimings().getDhuhr());
        holder.tvJamAshar.setText(SholatDataItemArrayList.get(position).getTimings().getAsr());
        holder.tvJamMaghrib.setText(SholatDataItemArrayList.get(position).getTimings().getMaghrib());
        holder.tvJamIsya.setText(SholatDataItemArrayList.get(position).getTimings().getIsha());
    }

    @Override
    public int getItemCount() {
        return SholatDataItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTanggal, tvJamImsak, tvJamShubuh, tvJamDzuhur, tvJamAshar, tvJamMaghrib, tvJamIsya;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inisialisasi TextView
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvJamImsak = itemView.findViewById(R.id.tv_imsak);
            tvJamShubuh = itemView.findViewById(R.id.tv_subuh);
            tvJamDzuhur = itemView.findViewById(R.id.tv_dzuhur);
            tvJamAshar = itemView.findViewById(R.id.tv_asar);
            tvJamMaghrib = itemView.findViewById(R.id.tv_maghrib);
            tvJamIsya = itemView.findViewById(R.id.tv_isya);
        }
    }
}
