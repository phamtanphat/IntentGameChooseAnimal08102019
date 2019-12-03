package com.example.intentgamechooseanimal08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImgHinhGoc, mImgHinhChon;
    ImageButton mImgPlay;
    FrameLayout mFrameLayout;
    TextView mTxtTime;
    String[] mArrayNameImage;
    int mValueHinhGoc = 0;
    int mCurrentime = 0;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();
    }

    private void event() {
        mImgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFrameLayout.setVisibility(View.GONE);
                randomImage();
                countDownTime(0);
            }
        });
    }

    private void countDownTime(int time) {
        mCurrentime = time;
        mHandler.postDelayed(runnable,1000);
    }

    private void randomImage() {
        mArrayNameImage = getResources().getStringArray(R.array.arrayAnimal);
        Collections.shuffle(Arrays.asList(mArrayNameImage));
        mValueHinhGoc = getResources().getIdentifier(mArrayNameImage[0], "drawable", getPackageName());
        mImgHinhGoc.setImageResource(mValueHinhGoc);
    }

    private void init() {
        mImgHinhChon = findViewById(R.id.imageviewHinhChon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhGoc);
        mImgPlay = findViewById(R.id.imagebuttonPlay);
        mFrameLayout = findViewById(R.id.framelayout);
        mTxtTime = findViewById(R.id.textviewThoiGian);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentime < 5) {
                mTxtTime.setText("Time : " + (5 - mCurrentime++));
                mHandler.postDelayed(runnable, 1000);
            } else {
                Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
