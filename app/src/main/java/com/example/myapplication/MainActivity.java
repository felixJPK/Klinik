package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ambil referensi dari XML
        EditText etDate = findViewById(R.id.et_date);
        ImageButton btnDatePicker = findViewById(R.id.btn_date_picker);

        // Set listener untuk tombol DatePicker
        btnDatePicker.setOnClickListener(view -> {
            // Mendapatkan tanggal saat ini
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Membuka dialog pemilih tanggal
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (DatePicker view1, int selectedYear, int selectedMonth, int selectedDay) -> {
                        // Format tanggal menjadi "DD/MM/YYYY"
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        etDate.setText(selectedDate);
                    },
                    year, month, day);

            datePickerDialog.show();

        });
    }
}