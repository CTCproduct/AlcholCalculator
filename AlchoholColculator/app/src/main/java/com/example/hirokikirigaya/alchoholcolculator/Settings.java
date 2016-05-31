package com.example.hirokikirigaya.alchoholcolculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Hiroki Kirigaya on 2016/05/24.
 */
public class Settings extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //表示画面
        setContentView(R.layout.activity_settings);

        //ボタンのインスタンス取得
        Button btnMenu = (Button)findViewById(R.id.BtnMenu);

        //ListViewのインスタンス取得
        ListView listSettings = (ListView)findViewById(R.id.ListSetteing);

        //ListViewにセットするアダプターの宣言
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listview_item,R.array.setting);

        listSettings.setAdapter(arrayAdapter);
    }
}
