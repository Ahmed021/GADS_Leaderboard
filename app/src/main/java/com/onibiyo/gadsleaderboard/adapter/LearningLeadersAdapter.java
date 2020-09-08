package com.onibiyo.gadsleaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onibiyo.gadsleaderboard.R;
import com.onibiyo.gadsleaderboard.model.LearningLeader;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private Context mContext;
    private List<LearningLeader> items;

    public LearningLeadersAdapter(Context context, List<LearningLeader> items) {
        mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_learning_hours, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningLeader item = items.get(position);

        holder.txtLearnerName.setText(item.getName());
        holder.txtLearningHours.setText(mContext.getString(R.string.learning_leader_details, item.getHours(), item.getCountry()));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0: items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtLearnerName;
        public TextView txtLearningHours;
        public ImageView imgLearning;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLearnerName = itemView.findViewById(R.id.txt_name_learning);
            txtLearningHours = (TextView) itemView.findViewById(R.id.txt_learning_hours);
            imgLearning = (ImageView) itemView.findViewById(R.id.image_learning);
        }
    }
}
