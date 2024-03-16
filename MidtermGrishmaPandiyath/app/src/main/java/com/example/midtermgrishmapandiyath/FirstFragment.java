package com.example.midtermgrishmapandiyath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.midtermgrishmapandiyath.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String meter = binding.meters.getText().toString();

                if (!meter.isEmpty()) {
                    try {
                        double millimeters = Double.parseDouble(meter) * 1000;
                        binding.textviewSecond.setText(String.valueOf(millimeters));
                    } catch (NumberFormatException e) {

                        binding.textviewSecond.setText("Please give a valid input");
                    }
                } else {
                    binding.textviewSecond.setText("Please give some input");
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}