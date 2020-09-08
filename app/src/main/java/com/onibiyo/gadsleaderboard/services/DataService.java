package com.onibiyo.gadsleaderboard.services;

import com.onibiyo.gadsleaderboard.model.LearnersDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("api/hours")
    Call<List<LearnersDetails>> getLearningHours();

//    @GET("api/skilliq")
//    Call<JSONRes> getSkillIQs(@Query("count")int count);
}
