package com.dualDev.cvMaker;

import android.app.Application;

import com.batch.android.Batch;
import com.batch.android.BatchActivityLifecycleHelper;
import com.batch.android.Config;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Batch.setConfig(new Config("5DA4BCFF506031E87AE8D36BF7057A")); // live
    Batch.setConfig(new Config("5DA4BCFF506031E87AE8D36BF7057A")); // development
    registerActivityLifecycleCallbacks(new BatchActivityLifecycleHelper());
    // You should configure your notification's customization options here.
    // Not setting up a small icon could cause a crash in applications created with Android Studio 3.0 or higher.
    // More info in our "Customizing Notifications" documentation
    Batch.Push.setSmallIconResourceId(R.mipmap.ic_launcher);

  }
}
