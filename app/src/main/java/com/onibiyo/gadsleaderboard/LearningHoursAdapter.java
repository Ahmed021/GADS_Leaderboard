package com.onibiyo.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.onibiyo.gadsleaderboard.model.LearnersDetails;

import java.util.List;

public class LearningHoursAdapter extends RecyclerView.Adapter<LearningHoursAdapter.ViewHolder> {

    private Context mContext;
    private List<LearnersDetails> mLearnersDetails;

    public LearningHoursAdapter(Context context, List<LearnersDetails> learnersDetails) {
        mContext = context;
        mLearnersDetails = learnersDetails;
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
       holder.txtLearnerName.setText(mLearnersDetails.get(position).getName());
       int score = mLearnersDetails.get(position).getScore();
       String country = mLearnersDetails.get(position).getCountry();
       String image = mLearnersDetails.get(position).getBadgeUrl();
       holder.txtLearningHours.setText(
               new StringBuilder().append(score).append(" learning hours, ").append(country).toString()
       );
       if (image.isEmpty()) {
           Glide.with(mContext).load(image).into(holder.imgLearning);
       }
    }

    @Override
    public int getItemCount() {
        return mLearnersDetails.size();
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
