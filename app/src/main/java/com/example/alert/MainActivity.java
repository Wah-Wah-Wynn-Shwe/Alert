package com.example.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Timer;


public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText t1,t2,t3;
    RadioButton r1,r2;
    private Timer dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        b1=(Button)findViewById(R.id.btn);
        t1=(EditText)findViewById(R.id.txt1);
        t2=(EditText)findViewById(R.id.txt2);
        t3=(EditText)findViewById(R.id.txt3);
        r1=(RadioButton) findViewById(R.id.rb1);
        r2=(RadioButton) findViewById(R.id.rb2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("Do you want to submit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder result=new StringBuilder();
                        result.append("Northern City Register");
                        result.append("\nName:"+t1.getText());
                        if(r1.isChecked()){
                            result.append("\nGenter:"+"Male");
                        }
                        if(r2.isChecked()){
                            result.append("\nGender:"+"Female");
                        }
                        int myans=Integer.parseInt(t2.getText().toString());
                        result.append("\nContact:"+String.valueOf(myans));
                        result.append("\nEmail"+t3.getText()+"@gmail.com");
                        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Northern City Register");
                alert.show();
                setContentView(R.layout.activity_main);

            }
        });
    }
}
