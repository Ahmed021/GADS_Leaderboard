package com.onibiyo.gadsleaderboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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
                SkillIQLeadersFragment skillIQLeadersFragment = new SkillIQLeadersFragment();
                return skillIQLeadersFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
