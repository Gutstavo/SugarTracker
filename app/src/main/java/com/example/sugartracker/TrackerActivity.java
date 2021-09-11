package com.example.sugartracker;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class TrackerActivity extends AppCompatActivity {

    private Button back_btn;
    private Button diabsen_btn;
    private Button manually_btn;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        Typeface kanit = Typeface.create(ResourcesCompat.getFont(this, R.font.kanit_extralight), Typeface.NORMAL);
        Typeface montserrat = Typeface.create(ResourcesCompat.getFont(this, R.font.montserrat), Typeface.BOLD);


        back_btn = findViewById(R.id.back);
        diabsen_btn = findViewById(R.id.auto);
        manually_btn = findViewById(R.id.manually);

        Spannable spannable = new SpannableString("With DIABSEN device");
        spannable.setSpan(new TypefaceSpan(montserrat), 0, 4,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(new TypefaceSpan(kanit), 5, 12,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(new TypefaceSpan(montserrat), 13, 19,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        diabsen_btn.setText(spannable);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        diabsen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InsertAuto.class));
            }
        });

        manually_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InsertManually.class));
            }
        });


    }
}