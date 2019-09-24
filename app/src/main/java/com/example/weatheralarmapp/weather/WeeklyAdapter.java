package com.example.weatheralarmapp.weather;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatheralarmapp.R;

import java.util.ArrayList;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<WeatherWeeklyItem> weeklyItems;

    WeeklyAdapter(Activity activity, ArrayList<WeatherWeeklyItem> weeklyItems){
        this.activity = activity;
        this.weeklyItems = weeklyItems;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtWeeklyItemDay;
        ImageView imgWeeklyItemIcon;
        TextView txtWeeklyHighTemper;
        TextView txtWeeklyLowTemper;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWeeklyItemDay = (TextView)itemView.findViewById(R.id.txtWeeklyItemDay);
            imgWeeklyItemIcon = (ImageView)itemView.findViewById(R.id.imgWeeklyItemIcon);
            txtWeeklyHighTemper = (TextView)itemView.findViewById(R.id.txtWeeklyHighTemper);
            txtWeeklyLowTemper = (TextView)itemView.findViewById(R.id.txtWeeklyLowTemper);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "click " +
                            weeklyItems.get(getAdapterPosition()).getDay(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_weather_weekly, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyAdapter.ViewHolder holder, int position) {
        WeatherWeeklyItem data = weeklyItems.get(position);

        holder.txtWeeklyItemDay.setText(data.getDay());
//        holder.imgWeeklyItemIcon.setImageResource(data.getWeather());
        holder.txtWeeklyHighTemper.setText(data.getDay());
        holder.txtWeeklyLowTemper.setText(data.getLowTemper());
    }

    @Override
    public int getItemCount() {
        return weeklyItems.size();
    }

    private void removeItemView(int position) {
        weeklyItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, weeklyItems.size()); // 지워진 만큼 다시 채워넣기.
    }
}
