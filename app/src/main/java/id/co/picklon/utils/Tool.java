package id.co.picklon.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Locale;

public class Tool {

    public static String autoCountryCode(String phoneNumber) {
        if (Const.COUNTRY_CODE.equals(phoneNumber.substring(0, 2))) {
            return phoneNumber;
        } else {
            return Const.COUNTRY_CODE + phoneNumber;
        }
    }

    public static void callPhone(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        context.startActivity(intent);
    }
    public static String getFormatedValue(long value) {
        return "RP ".concat(String.format(Locale.ENGLISH, "%,d", value));
    }

}
