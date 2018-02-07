package com.bluestacks.bugzy.ui;

import android.support.v4.app.Fragment;

public interface NavigationActivityBehavior {
    public void setContentFragment(Fragment fragment, boolean addToBackStack, String tag);

    public void onContentFragmentsActivityCreated(Fragment fragment, String title, String tag);

    public void setTitle(String title);
}