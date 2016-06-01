package com.example.hirokikirigaya.alchoholcolculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by Hiroki Kirigaya on 2016/05/25.
 */
public class ItemDialog extends DialogFragment {


    //FragmentからActivityへの参照方法
    Button button;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        //Activityから値を受け取る
        int array_id = getArguments().getInt("KEY");
        int btn_id = getArguments().getInt("BTN");

        //フラグメントからActivityへの参照方法
        button = (Button)getActivity().findViewById(btn_id);

        //アラートダイアログに表示するリストの設定
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(array_id));

        //ダイアログを表示するためのビルダーの宣言
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //ダイアログのタイトル
        builder.setTitle("選択してください");

        builder.setSingleChoiceItems(arrayAdapter, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                //ダイアログで選択されてた項目をボタンの文字列にセット
                button.setText(arrayAdapter.getItem(which));

                //ダイアログを消す
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}
