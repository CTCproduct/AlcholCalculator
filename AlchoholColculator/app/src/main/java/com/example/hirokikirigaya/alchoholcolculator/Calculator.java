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

    ItemDialog itemDialog = new ItemDialog();
    Bundle bundle = new Bundle();

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
        final Button btncalc = (Button)findViewById(R.id.BtnCalc);
        final Button btnres = (Button)findViewById(R.id.BtnRes);

        final ArrayAdapter<String> adapter;

        //EditTextのインスタンスの取得
        final EditText etxtweight = (EditText)findViewById(R.id.EtxtWeight);

        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

        //btnsexタップイベント
        btnsex.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowDialog(R.array.sex,R.id.BtnSex);
            }
        });

        //btnalcholタップイベント
        btnalchol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(R.array.alchol,R.id.BtnAlchol);
            }
        });

        //btnglassタップイベント
        btnglass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(R.array.glass,R.id.BtnGlass);
            }
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

    private void ShowDialog(int array_item,int btn_id){
        bundle.putInt("KEY",array_item);
        bundle.putInt("BTN",btn_id);
        itemDialog.setArguments(bundle);
        itemDialog.show(getSupportFragmentManager(),"dialog");
    }

}
