package com.example.hirokikirigaya.alchoholcolculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初期表示画面：メインメニュー
        setContentView(R.layout.activity_main);

        //各種Viewの取得
        Button btnCalc = (Button)findViewById(R.id.BtnAlcholcalc);
        Button btnKnow = (Button)findViewById(R.id.BtnKnowledge);
        Button btnSick = (Button)findViewById(R.id.BtnSickness);
        Button btnStock1 = (Button) findViewById(R.id.BtnStock1);
        Button btnSet = (Button)findViewById(R.id.BtnSetting);
        Button btnHelp = (Button)findViewById(R.id.BtnHelp);

        //計算ボタンクリックイベント
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Calculator.class);
                startActivity(intent);

            }
        });

        //知識ボタンクリックイベント
        btnKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Knowledge.class);
                startActivity(intent);
            }
        });

        //2日酔いクリックイベント
        btnSick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Sickness.class);
                startActivity(intent);
            }
        });

        //予備①クリックイベント
        btnStock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Stock.class);
                startActivity(intent);
            }
        });

        //設定ボタンクリックイベント
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Settings.class);
                startActivity(intent);
            }
        });

        //ヘルプボタンクリックイベント
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Help.class);
                startActivity(intent);
            }
        });
    }
}
