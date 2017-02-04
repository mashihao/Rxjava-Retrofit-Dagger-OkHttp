package id.co.picklon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.co.picklon.model.entities.WashItem;
import id.co.picklon.model.entities.WashService;

public class Picklon {
    public static String TOKEN;
    public static final String MEDIAHOST = "http://ateam.ticp.io:8100/media/";
    private static Map<String, Object> globalMap = new HashMap<>();

    private static List<WashItem>itemList;
    private static List<WashService>serviceList;

    public static Map<String, Object> commonMap() {
        globalMap.clear();
        return globalMap;
    }

    public static String getVersion(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
