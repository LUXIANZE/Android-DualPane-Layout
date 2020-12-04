package utils;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper {
    private ToastHelper singleton;
    private Context context;

    private ToastHelper(){

    }

    public void Toast(String message){
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this.context, message, duration);
        toast.show();
    }

    public ToastHelper getInstance(){
        if (singleton == null){
            return new ToastHelper();
        }else {
            return singleton;
        }
    }

    public void setContext(Context context){
        this.context = context;
    }
}
