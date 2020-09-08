package com.onibiyo.gadsleaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerSkillsAdapter extends RecyclerView.Adapter<RecyclerSkillsAdapter.ViewHolder> {

    private String[] skillsIQ = {"300",
            "289", "276", "293",
            "277", "255", "287",
            "289"};

    private String[] learnersName = {"Kekayaan", "Teknologi",
            "Keluarga", "Bisnis",
            "Keluarga", "Hutang",
            "Teknologi", "Pidana"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_skill_iq, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtLearnersName.setText(learnersName[position]);
        holder.txtSkillIQ.setText(skillsIQ[position]);
    }

    @Override
    public int getItemCount() {
        return learnersName.length;
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
