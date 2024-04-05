package com.example.gunungberapiaktif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGunungBerapi;
    private ArrayList<GunungBerapi> list = new ArrayList<>();
    private ListGngAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGunungBerapi = findViewById(R.id.rv_gng);
        rvGunungBerapi.setHasFixedSize(true);

        list.addAll(GunungBerapiData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvGunungBerapi.setLayoutManager(new LinearLayoutManager(this));

        ListGngAdapter listGunungAdapter = new ListGngAdapter(list);
        rvGunungBerapi.setAdapter(listGunungAdapter);

        listGunungAdapter.setOnItemClickCallback(new ListGngAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(GunungBerapi data) {
                showSelectedGunungBerapi(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            showAbout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAbout() {
        Intent aboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(aboutIntent);
    }

    private void showSelectedGunungBerapi(GunungBerapi gng) {
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_GUNUNG, gng.getName());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, gng.getPhoto());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TINGGI, gng.getTinggi());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_LOKASI, gng.getLokasi());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_SEJARAH, gng.getSejarah());
        startActivity(moveWithDataIntent);
    }
}