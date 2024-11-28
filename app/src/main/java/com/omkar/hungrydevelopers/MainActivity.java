package com.omkar.hungrydevelopers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CardView starterCard;
    CardView mainsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        starterCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);
        TextView emailTextView = findViewById(R.id.text_view_email_address);

        starterCard.setOnClickListener((view) -> {
            Intent starterActivtyIntent = new Intent(MainActivity.this,StarterActivity.class);
            startActivity(starterActivtyIntent);
        });

        mainsCard.setOnClickListener((view) -> {
            Intent mainCourseActivityIntent = new Intent(MainActivity.this,MainCourseActivity.class);
            startActivity(mainCourseActivityIntent);
        });

        emailTextView.setOnClickListener((view) -> {
            Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
            launchEmailAppIntent.setData(Uri.parse("mailto:thehungrydevelopers@dev.com"));
            startActivity(launchEmailAppIntent);
        });
    }
}