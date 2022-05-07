package ru.palyanaff.samsung_project_english_learning.screens.levels.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import ru.palyanaff.samsung_project_english_learning.R;
import ru.palyanaff.samsung_project_english_learning.screens.levels.data.Level;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Level> arrayList;

    public ItemAdapter(ArrayList<Level> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.button.setText(arrayList.get(position).getLevelId());
        holder.textView.setText(arrayList.get(position).getHeader());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: switch to next fragment with level content
                /*FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new RunnerFragment());
                fragmentTransaction.commit();*/
                Toast.makeText(v.getContext(), arrayList.get(position).getHeader().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        Button button;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_level_item);
            textView = itemView.findViewById(R.id.textView_level_item);
        }
    }
}
