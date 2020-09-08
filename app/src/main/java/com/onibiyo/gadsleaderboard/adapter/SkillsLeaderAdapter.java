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
import com.onibiyo.gadsleaderboard.model.SkillLeader;

import java.util.List;

public class SkillsLeaderAdapter extends RecyclerView.Adapter<SkillsLeaderAdapter.ViewHolder> {

    private Context mContext;
    private List<SkillLeader> items;

    public SkillsLeaderAdapter(Context context, List<SkillLeader> items) {
        mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_skill_iq, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillLeader item = items.get(position);

        holder.txtLearnersName.setText(item.getName());
        holder.txtSkillIQ.setText(mContext.getString(R.string.skill_leader_details, item.getScore(), item.getCountry()));
    }

    @Override
    public int getItemCount() {
        return items == null? 0: items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtLearnersName;
        TextView txtSkillIQ;
        ImageView imgSkills;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLearnersName = (TextView) itemView.findViewById(R.id.txt_name_skills);
            txtSkillIQ = (TextView) itemView.findViewById(R.id.txt_skill_iq);
            imgSkills = (ImageView) itemView.findViewById(R.id.image_skills);
        }
    }
}
