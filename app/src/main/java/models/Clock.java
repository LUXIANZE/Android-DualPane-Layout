package models;

import androidx.databinding.ObservableField;

import java.util.Calendar;
import java.util.Date;

public class Clock {
    public final ObservableField<String> Now = new ObservableField<>();

    public Clock(Date now){
        setNow(now);
    }

    /**
     * Set Clock.Now by turning Date object into string before setting in Observable Clock.Now
     * @param now The Date to set for variable Now
     */
    private void setNow(Date now){
        Now.set(now.toString());
    }

    public void update(){
        setNow(Calendar.getInstance().getTime());
    }
}
