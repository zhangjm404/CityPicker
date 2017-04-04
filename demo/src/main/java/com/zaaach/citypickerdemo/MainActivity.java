package com.zaaach.citypickerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;
import com.zaaach.citypicker.model.MsgEventBus;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private static final String TAG_MAIN = "maintag";
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        resultTV = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });

        findViewById(R.id.btn_select2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityPickerActivity.class);
                intent.putExtra(CityPickerActivity.KEY_EVENTBUS_TAG, TAG_MAIN);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                resultTV.setText("当前选择：" + city);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscriber(tag = TAG_MAIN, mode = ThreadMode.MAIN)
    private void getCity(MsgEventBus msgEventBus) {
        resultTV.setText("当前选择：" + msgEventBus.getCity());
    }
}
