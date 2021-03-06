package com.example.widget_sample;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {

	static int n = 0;

	String[] text = {	"正常です",
				"温度が高くなっています",
				"[警告] 熱が暴走しています",
				"どっこいしょ",
				"復帰しました"	};

    @Override
    public void onUpdate(Context c, AppWidgetManager awm, int[] awi) {
    	RemoteViews rv = new RemoteViews(c.getPackageName(), R.layout.main);
		rv.setTextViewText(R.id.textView, text[n]);
		n = (n+1)%5;

		ComponentName cn = new ComponentName(c, MainActivity.class);
		awm.updateAppWidget(cn, rv);
//        Intent in = new Intent(c, WidgetService.class);
//        c.startService(in);
    }

//    public static class WidgetService extends Service {
//        @Override
//        public void onStart(Intent in, int si) {
//            IntentFilter filter = new IntentFilter();
//            filter.addAction(Intent.ACTION_BATTERY_CHANGED);
//            registerReceiver(batteryReceiver, filter);
//        }
//
//        @Override
//        public IBinder onBind(Intent in) {
//            return null;
//        }
//    }
//
//    private static BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
//    	int scale = 100;
//        int level = 0;
//        @Override
//        public void onReceive(Context c, Intent in) {
//        	String ac = in.getAction();
//            if (ac.equals(Intent.ACTION_BATTERY_CHANGED)) {
//                level = in.getIntExtra("level", 0);
//                scale = in.getIntExtra("scale", 0);
//            }
//            AppWidgetManager awm = AppWidgetManager.getInstance(c);
//            ComponentName cn = new ComponentName(c, MainActivity.class);
//            RemoteViews rv = new RemoteViews(c.getPackageName(), R.layout.main);
//            rv.setTextViewText(R.id.textView, ""+(int)(level*100/scale));
//            awm.updateAppWidget(cn, rv);
//        }
//    };
}
