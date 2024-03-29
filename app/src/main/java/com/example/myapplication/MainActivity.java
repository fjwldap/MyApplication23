package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {
    TextView text1;
    Integer id,year, major,db;
    String pw;
    EditText editTextid, editTextpw;

    private void setdb(int db)
    {
        this.db = db;
    }

    private Integer getId()
    {
        return id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    private String getPw()
    {
        return pw;
    }

    private void setPw(String pw) { this.pw = pw; }

    private Integer getyear()
    {
        return year;
    }

    private void setyear(int year)
    {
        this.year = year;
    }

    private Integer getmajor()
    {
        return major;
    }

    private void setmajor(int major)
    {
        this.major = major;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextid = (EditText)findViewById(R.id.editTextId);
        editTextpw = (EditText)findViewById(R.id.editTextPw);

        text1 = (TextView) findViewById(R.id.text1);

        Button button1 = (Button) findViewById(R.id.button1);

        Spinner spinner = (Spinner)findViewById(R.id.spinnerMajor);
        Spinner spinner2 = (Spinner)findViewById(R.id.spinnerYear);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//데이터베이스 열기
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               setdb(position);
               setmajor(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setyear(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

             }
        });

        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n = getmajor();
                //queryData(n);
                gethakbun();
                getPassword();
                Intent intent = new Intent(getApplicationContext(),TimeTableActivity.class);
                intent.putExtra("database",db);
                intent.putExtra("studentId",id);
                intent.putExtra("studentPw",pw);
                intent.putExtra("studentYear",year);
                intent.putExtra("studentMajor",major);
                startActivity(intent);
            }
        });
    }

    private void getPassword() {
        String password = "";
        password = editTextpw.getText().toString();
        setPw(password);//int로 바꿔서 전달
    }

    private void gethakbun() {
          String hakbun = "";
          hakbun = editTextid.getText().toString();
          setId(Integer.parseInt(hakbun));//int로 바꿔서 전달

    }

}
