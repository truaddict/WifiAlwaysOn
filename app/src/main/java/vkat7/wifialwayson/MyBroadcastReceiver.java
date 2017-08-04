package vkat7.wifialwayson;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "WifiAlwaysOn";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.d(TAG, "BOOT_COMPLETED event catched!");
            Intent i0 = new Intent();
            i0.setAction("vkat7.wifialwayson.ScreenOnService");
            context.startService(i0);
        }
    }
}
