package com.example.hirokikirigaya.alchoholcolculator;

import android.support.v4.app.NotificationCompat;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Hiroki Kirigaya on 2016/05/23.
 */
public class AlcholCalculator {

    //CalcDisassemblyalchol
    //1:体重×0.1を行い、1時間に分解できるアルコール量を計算する
    public double CalcDisassemnblyalchol(EditText weight){

        //文字列をdouble型にparseして代入
        double tai = Double.parseDouble(weight.getText().toString());

        return tai*0.1;
    }

    //CalcPurealchol
    //2:(度数÷100)×量×0.8を行い、摂取した飲料に含まれる純アルコール量を計算する
    public double CalcPurealchol(EditText alde,EditText mili){

        //EditText内の文字を小数点に変換
        double deg = Double.parseDouble(alde.getText().toString());
        double alc = Double.parseDouble(mili.getText().toString());

        return (deg/100) * alc * 0.8;
    }

    //CalcResult
    //2÷1を行い、分解にかかる時間(小数)を算出し、FormatResultクラスで整えて表示する
    public void CalcResult(EditText wei, EditText al, EditText ml,AutoFontSizeTextView result){

        double result1 = CalcDisassemnblyalchol(wei);
        double result2 = CalcPurealchol(al,ml);

        //アルコール分解時間の計算 切り上げ　
        double min = new BigDecimal(String.valueOf(result2 / result1)).setScale(1, RoundingMode.CEILING).doubleValue();

        //整数部分の取出し
        int hour = (int)min;

        //小数部分の取出し
        min -= hour;

        //結果を表示する
        result.setText("アルコール分解時間：約" + String.valueOf(hour) + "時間" + String.valueOf((int)(min*60)) + "分です。");
        //result.setText(String.valueOf((int)(min*60)));
    }
}
