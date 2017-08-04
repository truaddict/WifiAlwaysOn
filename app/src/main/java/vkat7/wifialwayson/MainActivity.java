package vkat7.wifialwayson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i0 = new Intent();
        i0.setAction("vkat7.wifialwayson.ScreenOnService");
        startService(i0);
    }
}
