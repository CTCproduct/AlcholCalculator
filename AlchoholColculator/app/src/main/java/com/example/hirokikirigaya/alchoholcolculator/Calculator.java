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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Hiroki Kirigaya on 2016/05/23.
 */
public class Calculator extends AppCompatActivity {

    //ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //表示画面：AlcholCalculate
        setContentView(R.layout.activity_alcholcalculate);

        //Buttonのインスタンス取得
        final Button btnsex = (Button)findViewById(R.id.BtnSex);
        final Button btnalchol = (Button)findViewById(R.id.BtnAlchol);
        final Button btnglass = (Button)findViewById(R.id.BtnGlass);
        final Button btnadd = (Button)findViewById(R.id.BtnAdd);
        Button btncalc = (Button)findViewById(R.id.BtnCalc);
        final Button btnres = (Button)findViewById(R.id.BtnRes);

        final ArrayAdapter<String> adapter;

        //EditTextのインスタンスの取得
        final EditText etxtweight = (EditText)findViewById(R.id.EtxtWeight);

        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

        //表示するリスト項目の設定
        adapter = new ArrayAdapter<String>(Calculator.this,R.layout.spinner_item,getResources().getStringArray(R.array.sex));

        //btnsexのボタンクリック時処理
        btnsex.setOnClickListener(new View.OnClickListener() {

            int selectedIndex = 0;

            //ダイアログを表示する
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Calculator.this);
                builder.setTitle("選択してください");
                builder.setSingleChoiceItems(adapter,selectedIndex,onClickListener);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            //ダイアログ内で項目が選択された時の処理
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedIndex = which;
                    btnsex.setText(adapter.getItem(which));
                    dialog.dismiss();
                }
            };
        });

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Calculator.this,R.layout.spinner_item,getResources().getStringArray(R.array.alchol));

        btnalchol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDialog itemDialog = new ItemDialog();
                itemDialog.show(getSupportFragmentManager(),"dialog");
            }
        });

        //btnalcholのボタンクリック時処理
        /*
        btnalchol.setOnClickListener(new View.OnClickListener() {

            int selectedIndex = 0;

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Calculator.this);
                builder.setTitle("選択してください");
                builder.setSingleChoiceItems(adapter1,selectedIndex,onClickListener);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedIndex  = which;
                    btnalchol.setText(adapter1.getItem(which));
                    dialog.dismiss();
                }
            };
        });
        */

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Calculator.this,R.layout.spinner_item,getResources().getStringArray(R.array.glass));

        //btnglassタップイベント
        btnglass.setOnClickListener(new View.OnClickListener() {
            int selectedIndex = 0;

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Calculator.this);
                builder.setTitle("選択してください");
                builder.setSingleChoiceItems(adapter2,selectedIndex,onClickListener);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedIndex = which;
                    btnglass.setText(adapter2.getItem(which));
                    dialog.dismiss();
                }
            };
        });

        //btncalcのボタンクリック時処理
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1:体重より、1時間に分解できるアルコール量の計算
                //2:飲んだ量より純アルコール量を計算する
                //1,2の結果より分解にかかる時間を表示する
                //alcholCalculator.CalcResult(etxtweight,etxtaldegree,etxtmili,vtxtresult);
            }
        });

        //btnresのボタンクリック時処理
    }

}
