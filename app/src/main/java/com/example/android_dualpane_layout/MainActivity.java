package com.example.android_dualpane_layout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.android_dualpane_layout.databinding.ActivityMainBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Calendar;

import models.Clock;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Clock clock;
    Runnable updater;
    Handler timerHandler;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clock = new Clock(Calendar.getInstance().getTime());
        timerHandler = new Handler();
        updater = () -> {

            clock.update();

            /*
             * - Only add a callback to the message queue when there is no more callbacks
             * - Without this checking, whenever timeHandler.post(updater) is executed,
             *   updater is enqueued to the message queue infinitely unless we remove it
             * - Not sure whether is it a correct way or not, since it seems like a waste of resource
             */
            if (!timerHandler.hasCallbacks(updater)){
                timerHandler.postDelayed(updater,1000);
            }
        };

        binding.setClock(clock);
    }

    public void onAutoUpdateToggled(View view) {
        if (view.getClass() == SwitchMaterial.class){
            if (binding.AutoUpdateSwitch.isChecked()) {
                timerHandler.post(updater);
            } else {
                timerHandler.removeCallbacks(updater);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerHandler.removeCallbacks(updater);
    }

    public void onNextPageBtnClicked(View view) {
    }
}