package com.example.hirokikirigaya.alchoholcolculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Hiroki Kirigaya on 2016/05/24.
 */
public class Knowledge extends AppCompatActivity {

    Bundle bunUrl = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //表示画面
        setContentView(R.layout.activity_common);

        //ボタンのインスタンス取得
        Button btnMenu = (Button) findViewById(R.id.BtnMenu);

        //ListViewのインスタンス取得
        ListView listSettings = (ListView) findViewById(R.id.ListSetting);

        //URLの配列を受け取る
        final String[] strUrl = getResources().getStringArray(R.array.knowledge_url);

        //ListViewにセットするアダプターの宣言
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview_item, getResources().getStringArray(R.array.knowledge));

        //ListView内の項目タップ時イベント
        listSettings.setAdapter(arrayAdapter);
        listSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplication(),WebViewContents.class);
                intent.putExtra("URL",strUrl[position]);
                startActivity(intent);
            }
        });

        //btnMenuクリック時イベント
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
