package com.example.thirdtutorial.ui.slideshow;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thirdtutorial.R;
import com.example.thirdtutorial.databinding.FragmentSlideshowBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
//import com.example.yourpackage.databinding.FragmentSlideshowBinding;
//import com.example.yourpackage.ui.slideshow.SlideshowViewModel;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Reference the DatePicker and TimePicker
        DatePicker datePicker = root.findViewById(R.id.datePicker);
        TimePicker timePicker = root.findViewById(R.id.timePicker);

        // Reference the "Confirm" button
        Button confirmButton = root.findViewById(R.id.confirmButton);

        // Set a listener for date selection
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Handle the selected date (year, monthOfYear, dayOfMonth)
            }
        });

        // Set a listener for time selection
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Handle the selected time (hourOfDay, minute)
            }
        });

        // Set a click listener for the "Confirm" button
        confirmButton.setOnClickListener(view -> {
            // Capture the selected date and time
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            // Format the date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String selectedDate = dateFormat.format(Calendar.getInstance().getTime());
            String selectedTime = timeFormat.format(Calendar.getInstance().getTime());

            // Create a custom Toast view
            View layout = inflater.inflate(R.layout.custom_toast_layout, root.findViewById(R.id.customToastText));
            TextView toastText = layout.findViewById(R.id.customToastText);

            // Set the text for the custom Toast
            String message = "Your birthday is on \nDate: " + selectedDate + "\nTime: " + selectedTime;
            toastText.setText(message);

            // Create the custom Toast
            Toast customToast = new Toast(requireContext());
            customToast.setDuration(Toast.LENGTH_SHORT);
            customToast.setView(layout);

            // Show the custom Toast
            customToast.show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}