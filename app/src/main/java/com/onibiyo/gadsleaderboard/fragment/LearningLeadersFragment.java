package com.onibiyo.gadsleaderboard.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onibiyo.gadsleaderboard.adapter.LearningLeadersAdapter;
import com.onibiyo.gadsleaderboard.R;
import com.onibiyo.gadsleaderboard.model.LearningLeader;
import com.onibiyo.gadsleaderboard.services.DataService;
import com.onibiyo.gadsleaderboard.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LearningLeadersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LearningLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeadersFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private List<LearningLeader> mLearningLeaders;
    private LearningLeadersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private View mView;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningLeadersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningLeadersFragment newInstance(String param1, String param2) {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        initView(mLearningLeaders);
        getLearnersList();

        return mView;
    }

    private void getLearnersList() {
        DataService dataService = ServiceBuilder.buildService(DataService.class);
        Call<List<LearningLeader>> listCall = dataService.getLearningLeaders();

        listCall.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                mLearningLeaders = response.body();
                initView(mLearningLeaders);
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
                Log.d("Error", t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(List<LearningLeader> learningLeaders) {
        mRecyclerView = mView.findViewById(R.id.rv_learning_hours);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new LearningLeadersAdapter(getActivity(), learningLeaders);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
