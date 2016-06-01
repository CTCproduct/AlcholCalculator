package com.example.hirokikirigaya.alchoholcolculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mds014005 on 2016/06/01.
 */
public class ButtonControl extends AppCompatActivity {

    Bundle bundle = new Bundle();

    public ButtonControl(int btn_id){

        switch (btn_id){
            case R.id.BtnAlcholcalc:
                Intent intent = new Intent(getApplication(),Calculator.class);
                startActivity(intent);
                break;
            case R.id.BtnKnowledge:
                break;
            case R.id.BtnSickness:
                break;
            case R.id.BtnStock1:
                break;
            case R.id.BtnSetting:
                break;
            case R.id.BtnHelp:
                break;
            default:
                break;
        }
    }

}
