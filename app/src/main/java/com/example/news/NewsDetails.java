package com.example.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsDetails extends AppCompatActivity {

    HashMap <String, String> hashMap = new HashMap<>();
    ArrayList < HashMap <String, String> > arrayList = new ArrayList<>();

    ImageView coverImage;

    TextView newsTitle, newsContent;

    FloatingActionButton floatingActionButton;
    public static String TITLE = "";
    public static String NEWS_CONTENT = "";

    public static Bitmap COVER_IMAGE = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        coverImage = findViewById(R.id.coverImage);

        newsTitle = findViewById(R.id.newsTitle);

        newsContent = findViewById(R.id.newsContent);

        floatingActionButton = findViewById(R.id.fab);



        newsTitle.setText(TITLE);
        newsContent.setText(NEWS_CONTENT);

        if (coverImage != null) {
            coverImage.setImageBitmap(COVER_IMAGE);
        }






    }


}