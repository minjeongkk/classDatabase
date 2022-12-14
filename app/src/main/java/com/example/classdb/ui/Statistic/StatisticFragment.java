package com.example.classdb.ui.Statistic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.classdb.databinding.FragmentStatisticBinding;

public class StatisticFragment extends Fragment {

    private FragmentStatisticBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StatisticViewModel dashboardViewModel =
                new ViewModelProvider(this).get(StatisticViewModel.class);

        binding = FragmentStatisticBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}