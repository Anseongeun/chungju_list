package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface; //syeon
import android.widget.Toast; //syeon


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final EditText ResnameText = (EditText) findViewById(R.id.ResnameText);
        final EditText textText = (EditText) findViewById(R.id.textText);


        Button PlusButton = (Button) findViewById(R.id.PlusButton);

        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Resname = ResnameText.getText().toString();
                String text = textText.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(WriteActivity.this);
                                //default code
                                /*
                                builder.setMessage("글 등록에 성공했습니다.")
                                        .setPositiveButton("확인", null)
                                        .create()
                                        .show();
                                Intent intent =  new Intent(WriteActivity.this, WlistActivity.class);
                                WriteActivity.this.startActivity(intent);*/

                                //syeon code
                                builder.setMessage("글이 등록되었습니다.");
                                /*
                                builder.setPositiveButton("취소",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {

                                                Toast.makeText(getApplicationContext(),"우측버튼 클릭됨",Toast.LENGTH_LONG).show();
                                            }
                                        });*/
                                builder.setNegativeButton("확인",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent =  new Intent(WriteActivity.this, GotowlistActivity.class);
                                                WriteActivity.this.startActivity(intent);
                                                Toast.makeText(getApplicationContext(),"acivity 이동",Toast.LENGTH_LONG).show();
                                            }
                                        });
                                builder.show();

                                //default code
                                //Intent intent =  new Intent(WriteActivity.this, WlistActivity.class);
                                //WriteActivity.this.startActivity(intent);

                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(WriteActivity.this);
                                builder.setMessage("글 등록에 실패했습니다.")
                                        .setNegativeButton("다시 시도", null)
                                        .create()
                                        .show();
                                finish();
                            }
                        }
                        catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                WriteRequest writeRequest = new WriteRequest(Resname, text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(WriteActivity.this);
                queue.add(writeRequest);
            }
        });

    }
}
