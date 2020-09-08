package com.onibiyo.gadsleaderboard.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.onibiyo.gadsleaderboard.fragment.LearningLeadersFragment;
import com.onibiyo.gadsleaderboard.fragment.SkillsLeadersFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
         this.mNoOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
                return learningLeadersFragment;
            case 1:
                SkillsLeadersFragment skillsLeadersFragment = new SkillsLeadersFragment();
                return skillsLeadersFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
