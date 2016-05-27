package com.example.hirokikirigaya.alchoholcolculator;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

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
        final Button btnCalc = (Button)findViewById(R.id.BtnCalc);
        final Button btnRes = (Button)findViewById(R.id.BtnRes);

        //文字列を格納するArrayListの宣言
        final ArrayList<String> arListitem = new ArrayList<>();

        //ListViewのインスタンスの取得
        final ListView listView = (ListView)findViewById(R.id.List_Item);

        //ArrayaAdapterのインスタンスの取得
        final ArrayAdapter<String> aradListview = new ArrayAdapter<String>(getApplicationContext(),R.layout.listview_item);

        //EditTextのインスタンスの取得
        final EditText etxtWeight = (EditText)findViewById(R.id.EtxtWeight); //体重
        final EditText etxtCount = (EditText)findViewById(R.id.Etxtcount);  //杯数

        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

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
                arListitem.add(btnAlchol.getText().toString() + "：" + btnGlass.getText().toString() + "：" + etxtCount.getText().toString() + "杯");
                aradListview.clear();
                aradListview.addAll(arListitem);
                aradListview.notifyDataSetChanged();
                listView.setAdapter(aradListview);
            }
        });

        //btnCalcのボタンクリック時処理
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1:体重より、1時間に分解できるアルコール量の計算
                //2:飲んだ量より純アルコール量を計算する
                //1,2の結果より分解にかかる時間を表示する
                String strAlchol = alcholCalculator.CalcResult(Double.parseDouble(etxtWeight.getText().toString()),btnAlchol.getText().toString(),btnGlass.getText().toString(),Integer.parseInt(etxtCount.getText().toString()));
                AlertDialog.Builder builder = new AlertDialog.Builder(Calculator.this);
                builder.setMessage(strAlchol);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //btnResのボタンクリック時処理
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //配列の中身と、ListViewの中身を空にする
                arListitem.clear();
                aradListview.clear();
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
