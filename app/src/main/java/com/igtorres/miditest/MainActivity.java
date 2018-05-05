package com.igtorres.miditest;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bluetooth, note1, note2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetooth = findViewById(R.id.bluetooth);
        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);

        bluetooth.setOnClickListener(view->{
            activateBluetooth();
        });

    }

    private void activateBluetooth(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            toast("Device does not support Bluetooth");
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                toast("Bluetooth is not enable :(");
            }
            else {
                toast("Bluetooth is enabled! :D");
            }
        }
    }

    //utility
    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
