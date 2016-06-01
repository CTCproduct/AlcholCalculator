package com.example.hirokikirigaya.alchoholcolculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Hiroki Kirigaya on 2016/05/23.
 */
public class Calculator extends AppCompatActivity {

    ItemDialog itemDialog = new ItemDialog();
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //表示画面：AlcholCalculate
        setContentView(R.layout.activity_alcholcalculate);

        //Buttonのインスタンス取得
        final Button btnSex = (Button)findViewById(R.id.BtnSex);
        final Button btnAlchol = (Button)findViewById(R.id.BtnAlchol);
        final Button btnGlass = (Button)findViewById(R.id.BtnGlass);
        final Button btnAdd = (Button)findViewById(R.id.BtnAdd);
        final Button btnRes = (Button)findViewById(R.id.BtnRes);
        final Button btnMenu = (Button)findViewById(R.id.BtnMenu);

        //TextViewのインスタンス取得
        final TextView vtxtSumTime = (TextView)findViewById(R.id.VtxtSumtime);

        //文字列を格納するArrayListの宣言
        final List<String> arListitem = new ArrayList<String>();

        //ListViewのインスタンスの取得
        final ListView listView = (ListView)findViewById(R.id.List_Item);

        //ArrayaAdapterのインスタンスの取得
        final ArrayAdapter<String> aradListview = new ArrayAdapter<String>(getApplicationContext(),R.layout.listview_item);

        //EditTextのインスタンスの取得
        final EditText etxtWeight = (EditText)findViewById(R.id.EtxtWeight); //体重
        final EditText etxtCount = (EditText)findViewById(R.id.Etxtcount);  //杯数

        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

        //btnMenuタップイベント
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //btnSexタップイベント
        btnSex.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowDialog(R.array.sex,R.id.BtnSex);
            }
        });

        //btnAlcholタップイベント
        btnAlchol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(R.array.alchol,R.id.BtnAlchol);
            }
        });

        //btnGlassタップイベント
        btnGlass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(R.array.glass,R.id.BtnGlass);
            }
        });

        //btnAddのタップイベント
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String  strItem = btnAlchol.getText().toString() + "：" + btnGlass.getText().toString() + "：" + etxtCount.getText().toString() + "杯⇒約" + alcholCalculator.CalcResult(Double.parseDouble(etxtWeight.getText().toString()),btnAlchol.getText().toString(),btnGlass.getText().toString(),Integer.parseInt(etxtCount.getText().toString()));
                    vtxtSumTime.setText(alcholCalculator.GetSumAlcholTime());
                    arListitem.add(strItem);
                    aradListview.clear();
                    aradListview.addAll(arListitem);
                    aradListview.notifyDataSetChanged();
                    listView.setAdapter(aradListview);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"問題発生:"+e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        //btnResのボタンクリック時処理
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //配列の中身と、ListViewの中身を空にする
                arListitem.clear();
                aradListview.clear();
                alcholCalculator.douSumtime = 0.0;
                vtxtSumTime.setText("合計：");
            }
        });
    }

    private void ShowDialog(int array_item,int btn_id){
        bundle.putInt("KEY",array_item);
        bundle.putInt("BTN",btn_id);
        itemDialog.setArguments(bundle);
        itemDialog.show(getSupportFragmentManager(),"dialog");
    }

}
