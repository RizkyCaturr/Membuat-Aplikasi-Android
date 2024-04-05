package com.example.gunungberapiaktif;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_GUNUNG = "extra_gunung";
    public static final String EXTRA_TINGGI = "TINGGI";
    public static final String EXTRA_PHOTO = "photo";
    public static final String EXTRA_LOKASI = "extra_lokasi";
    public static final String EXTRA_SEJARAH = "extra_SEJARAH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_item_photo);
        String url = getIntent().getStringExtra(EXTRA_PHOTO);
        Glide.with(this)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);

        TextView txtTinggi = findViewById(R.id.tv_item_tinggi);
        String tinggi = getIntent().getStringExtra(EXTRA_TINGGI);
        txtTinggi.setText(getString(R.string.Tinggi) + tinggi);

        TextView txtNama = findViewById(R.id.tv_item_nama);
        String nama = getIntent().getStringExtra(EXTRA_GUNUNG);
        txtNama.setText(nama);

        TextView txtLokasi = findViewById(R.id.lokasi);
        String lokasi = getIntent().getStringExtra(EXTRA_LOKASI);
        txtLokasi.setText(getString(R.string.Lokasi) + lokasi);

        TextView txtSEJARAH = findViewById(R.id.sejarah);
        String SEJARAH = getIntent().getStringExtra(EXTRA_SEJARAH);
        txtSEJARAH.setText(getString(R.string.Sejarah) + SEJARAH);
    }
}