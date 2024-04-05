package com.example.gunungberapiaktif;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://media-xsp1-1.cdn.whatsapp.net/v/t61.24694-24/427284416_7644361565628452_1218894186092502710_n.jpg?ccb=11-4&oh=01_ASAGmhyUf3hmv_YCkfMXA0KiDxeClgSGGfrEBkL7Dupsyw&oe=661D3C9F&_nc_sid=e6ed6c&_nc_cat=106";

        Glide.with(About.this)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);
    }
}