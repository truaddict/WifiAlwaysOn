package vkat7.wifialwayson;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.widget.Toast;
import android.app.Notification;

public class ScreenOnService extends Service {

    private static final String TAG = "WifiAlwaysOn";
    BroadcastReceiver mReceiver=null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ScreenOnService has been created");
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Intent i = new Intent(context, ScreenOnService.class);
                context.startService(i);
            }
        };
        registerReceiver(mReceiver, filter);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_wifi_lock);
        Notification notification = builder.build();
        startForeground(777, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onDestroy() {

        Log.i("WifiAlwaysOn", "Service  destroy");
        if(mReceiver!=null)
            unregisterReceiver(mReceiver);

    }
}
