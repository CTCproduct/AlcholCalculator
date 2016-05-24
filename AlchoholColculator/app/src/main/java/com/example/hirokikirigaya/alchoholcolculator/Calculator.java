package com.example.hirokikirigaya.alchoholcolculator;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //表示画面：AlcholCalculate
        setContentView(R.layout.activity_alcholcalculate);

        //各種Viewの取得
        Button btncalc = (Button)findViewById(R.id.BtnCalc);
        TextView vtxtweight = (TextView)findViewById(R.id.VtxtWeight);
        TextView vtxtaldegree = (TextView)findViewById(R.id.VtxtAldegree);
        TextView vtxtmili = (TextView)findViewById(R.id.VtxtMili);
        final EditText etxtweight = (EditText)findViewById(R.id.EtxtWeight);
        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

        //ListViewの設定
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Calculator.this,R.layout.spinner_main,getResources().getStringArray(R.array.sex));
        adapter.setDropDownViewResource(R.layout.spinner_item);
        Spinner spinner = (Spinner)findViewById(R.id.spSex);
        spinner.setAdapter(adapter);

        //項目が選択された時の動作設定
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //ドロップダウンリストから項目が選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //テスト的にToastを表示してみる
                Spinner spinner = (Spinner) parent;
                Toast.makeText(getApplicationContext(),Integer.toString(spinner.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();
            }

            //何も選択されなかった時の動作
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
    }
}
