package com.example.hirokikirigaya.alchoholcolculator;

import android.support.v4.app.DialogFragment;

/**
 * Created by Hiroki Kirigaya on 2016/05/23.
 */
public class AlcholCalculator extends DialogFragment {

    double douSumtime = 0.0;

    //CalcResult
    //2÷1を行い、分解にかかる時間(小数)を算出し、FormatResultクラスで整えて表示する
    public String CalcResult(double wei, String alchol, String glass, int count){

        //一時間に分解できるアルコール量の計算
        double result1 = CalcDisassemnblyalchol(wei);
        //飲んだ量から純アルコールの計算
        double result2 = CalcPurealchol(alchol,glass,count);

        //アルコール分解時間の算出
        double dTotal = result2 / result1;

        //総計
        douSumtime += dTotal;

        //時間の抽出
        int iHour = (int)dTotal;

        //分の抽出
        int iMin = (int)((dTotal - iHour) * 60);

        String strResult = String.valueOf(iHour) + "時間" + String.valueOf(iMin) + "分";

        return  strResult;
    }

    //GetSumAlcholTime
    //合計に表示する合計値を算出するメソッド
    public String GetSumAlcholTime(){
        //時間の抽出
        int iHour = (int)douSumtime;

        //分の抽出
        int iMin = (int)((douSumtime - iHour) * 60);

        return  "合計=約" + String.valueOf(iHour) + "時間" + String.valueOf(iMin) + "分";

    }

    //CalcDisassemblyalchol
    //1:体重×0.1を行い、1時間に分解できるアルコール量を計算する
    public double CalcDisassemnblyalchol(double weight){

        //文字列をdouble型にparseして代入
        return weight*0.1;
    }

    //CalcPurealchol
    //2:(度数÷100)×量×0.8を行い、摂取した飲料に含まれる純アルコール量を計算する
    public double CalcPurealchol(String alde,String gla,int cou){

        //アルコールの種類から、度数を返すメソッドへ
        double degree = SetAlcholDegree(alde);

        //グラスの種類と杯数から、摂取量を返すメソッドへ
        int amount = SetGlassAmount(gla,cou);


        return (degree/100) * amount * 0.8;
    }

    //SetAlcholDegree
    //アルコールの種類からアルコール度数を判定するメソッド
    public double SetAlcholDegree(String alcho){
        switch (alcho){
            case "ビール":
                return 5.0;
            case "ハイボール系":
                return 3.5;
            case "焼酎":
                return 22.5;
            case "日本酒":
                return 15.5;
            case "ワイン":
                return 12.5;
            default:
                return 0.0;
        }
    }

    //SetGlassAmount
    //グラスの種類と杯数から摂取量を返すメソッド
    public int SetGlassAmount(String glass,int amount){

        switch(glass){
            case "大ジョッキ":
                return 500 * amount;
            case "中ジョッキ":
                return 300*amount;
            case "小ジョッキ":
                return 200*amount;
            case "サワーグラス":
                return 350*amount;
            case "ワイングラス":
                return 250*amount;
            case "ロックグラス":
                return 150*amount;
            default:
                return 0;
        }
    }
}
