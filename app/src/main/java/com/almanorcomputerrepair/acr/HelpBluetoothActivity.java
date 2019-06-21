package com.almanorcomputerrepair.acr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class HelpBluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_bluetooth);

        setTitle("Bluetooth Troubleshooting");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void openImage(View view) {
        // getResources().getResourceName(view.getId());
        Intent intent = new Intent(HelpBluetoothActivity.this, ImageViewActivity.class);
        intent.putExtra("img", getResources().getResourceName(view.getId()));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
