package com.example.intentgamechooseanimal08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {

    int mValueHinhGoc = 0;
    int mCurrentime = 0;
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
    }
    private void countDownTime(int time) {
        mCurrentime = time;
        mHandler.postDelayed(runnable,1000);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentime < 5) {
                mHandler.postDelayed(runnable, 1000);
            } else {
                mHandler.removeCallbacks(runnable);
                Toast.makeText(AnimalActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
