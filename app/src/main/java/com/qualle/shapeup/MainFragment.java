package com.qualle.shapeup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        NavController navController = NavHostFragment.findNavController(this);

        view.findViewById(R.id.main_button_settings).setOnClickListener(v ->
                navController.navigate(R.id.settings_fragment));
        view.findViewById(R.id.main_button_profile).setOnClickListener(v ->
                navController.navigate(R.id.profileFragment));

//        view.findViewById(R.id.main_button_save_workout).setOnClickListener(v ->
//                navController.navigate(R.id.saveWorkoutResultFragment));
        view.findViewById(R.id.main_button_save_workout).setOnClickListener(v ->
                navController.navigate(R.id.saveWorkoutResultFragment));

        getChildFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.main_chart_list_container, ChartListFragment.class, null)
                .commit();

        return view;
    }
}