package android.mik.easj.eurotodkk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Double> list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      //AddToList Knap:
        Button AddToList = (Button) findViewById(R.id.AddToList);
        AddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText MyNumber = (EditText) findViewById(R.id.InputNum);



                //lav if hvis der ikke står noget

                if (MyNumber.getText().toString().matches(""))
                {
                    Toast.makeText(MainActivity.this,"Du skal tilføje et nummer",Toast.LENGTH_LONG).show();
                }
                //else tilføj til liste
                else
                {
                    double _doubleMyNumber = Double.parseDouble(MyNumber.getText().toString());

                    list.add(_doubleMyNumber);
                }





            }
        });
    //Beregn Knap:
        Button BeregnBtn = (Button) findViewById(R.id.TotalBtn);
        BeregnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ResultTxt = (TextView) findViewById(R.id.ResultTextView);
                //gennemgå liste og få beregning
                double sum = 0;
                for(double i : list)
                    sum += i;
                double dkr = sum *7.5;

                ResultTxt.setText(dkr + "Kr");
            }
        });

//ryd liste
        Button RydListeBtn = (Button) findViewById(R.id.RydListeBtn);
        RydListeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            list.clear();
                Toast.makeText(MainActivity.this,"Listen er tømt",Toast.LENGTH_LONG).show();



            }
        });

    }
}
