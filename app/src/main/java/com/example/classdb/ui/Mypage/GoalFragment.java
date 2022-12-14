package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.classdb.R;
import com.example.classdb.databinding.FragmentGoalBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class GoalFragment extends Fragment {

    private FragmentGoalBinding fragmentGoalBinding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private boolean isGoal;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GoalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GoalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoalFragment newInstance(String param1, String param2) {
        GoalFragment fragment = new GoalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentGoalBinding = FragmentGoalBinding.inflate(inflater);

        isGoal=true;
        setLayout(isGoal);

        //?????? ?????? ????????? db?????? ?????? ??????
        fragmentGoalBinding.cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db ?????? ??????
                //????????????
                isGoal = false;
                setLayout(isGoal);
            }
        });
        fragmentGoalBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoalDialog dialog = new GoalDialog(view.getContext());
                dialog.callFunction();

                dialog.register_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //DB??? ?????? ?????? ?????????
                        //???????????? Toast??? ??????
                        dialog.dismiss();
                        //????????? ?????? ????????? ?????????(?????? ?????????????????? ?????? ??????)
                        setLayout(true);
                    }
                });
                dialog.cancle_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        //setLayout(false);
                    }
                });

            }
        });

        //return inflater.inflate(R.layout.fragment_goal, container, false);
        return fragmentGoalBinding.getRoot();

    }

    private void setLayout(boolean isGoal){
        //isGoal=true;
        if(!isGoal){ //?????? ?????? ??? ???????????? ??????
            AddButtonLayout btn_layout = new AddButtonLayout(getContext());//?????? ???????????? ??????
            FrameLayout layout = (FrameLayout)fragmentGoalBinding.addButtonLayoutContainer; //?????? ??????????????? ?????? ????????????
            layout.addView(btn_layout);
            fragmentGoalBinding.addButton.setVisibility(fragmentGoalBinding.addButton.VISIBLE);
            fragmentGoalBinding.cancleButton.setVisibility(fragmentGoalBinding.cancleButton.GONE); //?????? ?????? ?????????

        }else{      //?????? ?????? ?????? ?????? ??????
            GoalBoxLayout goal_box = new GoalBoxLayout(getContext());
            FrameLayout layout = (FrameLayout)fragmentGoalBinding.addButtonLayoutContainer; //?????? ??????????????? ?????? ????????????
            layout.addView(goal_box);
            fragmentGoalBinding.addButton.setVisibility(fragmentGoalBinding.addButton.GONE);
            fragmentGoalBinding.cancleButton.setVisibility(fragmentGoalBinding.cancleButton.VISIBLE); //?????? ?????? ?????????

        }
    }
    private boolean getIsGoal(){

        return true;
    }

}