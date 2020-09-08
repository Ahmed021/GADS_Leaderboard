package com.onibiyo.gadsleaderboard.services;

import com.onibiyo.gadsleaderboard.model.LearningLeader;
import com.onibiyo.gadsleaderboard.model.SkillLeader;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("api/hours")
    Call<List<LearningLeader>> getLearningLeaders();

    @GET("api/skilliq")
    Call<List<SkillLeader>> getSkillsLeaders();
}
