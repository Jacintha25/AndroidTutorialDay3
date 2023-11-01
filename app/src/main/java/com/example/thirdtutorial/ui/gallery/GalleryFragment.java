package com.example.thirdtutorial.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.thirdtutorial.R;
import com.example.thirdtutorial.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    private ProgressBar progressBar; // Add ProgressBar

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        progressBar = root.findViewById(R.id.progressBar); // Find the ProgressBar

        // Observe the ViewModel data
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String text) {
                textView.setText(text);
                progressBar.setVisibility(View.VISIBLE); // Initially show the ProgressBar
            }
        });

        // Show the ProgressBar when the fragment is created
        progressBar.setVisibility(View.VISIBLE);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}