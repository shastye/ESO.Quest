package com.clubbpc.esoquest.ui.alliance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.clubbpc.esoquest.databinding.FragmentAllianceBinding;

public class AllianceFragment extends Fragment {

    private FragmentAllianceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AllianceViewModel allianceViewModel =
                new ViewModelProvider(this).get(AllianceViewModel.class);

        binding = FragmentAllianceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAlliance;
        allianceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}