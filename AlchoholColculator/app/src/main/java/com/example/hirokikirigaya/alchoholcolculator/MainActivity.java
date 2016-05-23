package com.example.hirokikirigaya.alchoholcolculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //各種Viewの取得
        Button btncalc = (Button)findViewById(R.id.BtnCalc);
        TextView vtxtweight = (TextView)findViewById(R.id.VtxtWeight);
        TextView vtxtaldegree = (TextView)findViewById(R.id.VtxtAldegree);
        TextView vtxtmili = (TextView)findViewById(R.id.VtxtMili);
        final AutoFontSizeTextView vtxtresult = (AutoFontSizeTextView) findViewById(R.id.VtxtResult);
        final EditText etxtweight = (EditText)findViewById(R.id.EtxtWeight);
        final EditText etxtaldegree = (EditText)findViewById(R.id.EtxtAldegree);
        final EditText etxtmili = (EditText)findViewById(R.id.EtxtMili);

        //クラスの宣言
        final AlcholCalculator alcholCalculator = new AlcholCalculator();

        //btncalcのボタンクリック時処理
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1:体重より、1時間に分解できるアルコール量の計算
                //2:飲んだ量より純アルコール量を計算する
                //1,2の結果より分解にかかる時間を表示する
                alcholCalculator.CalcResult(etxtweight,etxtaldegree,etxtmili,vtxtresult);
            }
        });
    }
}
