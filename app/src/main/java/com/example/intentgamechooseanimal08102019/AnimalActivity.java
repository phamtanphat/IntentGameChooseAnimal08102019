package com.example.intentgamechooseanimal08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {

    int mCurrentime = 0;
    Handler mHandler = new Handler();
    TableLayout tableLayout;
    String[] mArrayNameImage;
    int index = 0;
    int valuehinh = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        tableLayout = findViewById(R.id.tableLayout);

        mArrayNameImage = getResources().getStringArray(R.array.arrayAnimal);

        Intent intent = getIntent();
        int time = intent.getIntExtra("currentTime",-1);
        countDownTime(time);

        // 18 hinh
        // so cot : 3 Image
        // so dong : 6 Tabrow

        for (int i = 0 ; i < 6 ; i++){
            TableRow tableRow = new TableRow(this);
            for (int j = 0 ; j < 3 ; j++){
                final ImageView imageView  = new ImageView(this);
                valuehinh = getResources().getIdentifier(mArrayNameImage[index++], "drawable", getPackageName());
                imageView.setTag(valuehinh);
                imageView.setImageResource(valuehinh);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("valueHinh",Integer.parseInt(imageView.getTag().toString()));
                        setResult(RESULT_OK,intent);
                        mHandler.removeCallbacks(runnable);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }

    }
    private void countDownTime(int time) {
        mCurrentime = time;
        mHandler.postDelayed(runnable,1000);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentime < 5) {
                mCurrentime++;
                mHandler.postDelayed(runnable, 1000);
            } else {
                mHandler.removeCallbacks(runnable);
                Intent intent = new Intent();
                intent.putExtra("currentTime",1);
                setResult(RESULT_CANCELED,intent);
                finish();
                Toast.makeText(AnimalActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
