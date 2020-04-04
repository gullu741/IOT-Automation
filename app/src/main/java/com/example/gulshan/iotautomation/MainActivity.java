package com.example.gulshan.iotautomation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import static com.example.gulshan.iotautomation.R.id.*;



public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    Switch fan, bulb, light, pump;

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedinstancestate) {
        super.onCreate(savedinstancestate);
        setContentView(R.layout.activity_main);

        sb = (SeekBar) findViewById(SEEKBAR);
        fan = (Switch) findViewById(FAN);
        bulb = (Switch) findViewById(BULB);
        light = (Switch) findViewById(LIGHT);
        pump = (Switch) findViewById(PUMP);


        fan.setChecked(false);
        bulb.setChecked(false);
        light.setChecked(false);
        pump.setChecked(false);
        sb.setEnabled(false);
        sb.setMax(10);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                async a = new async();
                a.execute("F"+String.valueOf(sb.getProgress())+"\n");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void toggleBulb(View view) {
        if (bulb.isChecked() == true) {
            async a = new async();
            a.execute("B1\n");
        } else {
            async a = new async();
            a.execute("B0\n");
        }
    }

    public void toggleLight(View view) {
        if (light.isChecked() == true) {
            async a = new async();
            a.execute("L1\n");
        } else {
            async a = new async();
            a.execute("L0\n");
        }
    }

    public void togglePump(View view){
        if(pump.isChecked() == true){
            async a = new async();
            a.execute("P1\n");
        }else{
            async a = new async();
            a.execute("P0\n");
        }
    }

    public void toggleFan(View view){
        if(fan.isChecked() == true){
            sb.setEnabled(true);
            async a = new async();
            a.execute("F"+String.valueOf(sb.getProgress())+"\n");


        }else{
            async a = new async();
            a.execute("F0\n");
            sb.setEnabled(false);
        }
    }

}
