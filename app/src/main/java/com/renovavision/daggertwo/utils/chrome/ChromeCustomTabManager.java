package com.renovavision.daggertwo.utils.chrome;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;

import com.renovavision.daggertwo.R;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class ChromeCustomTabManager {

    public ChromeCustomTabManager() {

    }

    public void openLink(Context context, String url) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(activity.getResources().getColor(R.color.colorPrimary));

            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(activity, Uri.parse(url));
        }
    }
}
