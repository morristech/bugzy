package in.bugzy.ui.common;

import in.bugzy.data.model.Case;

import android.support.v4.app.Fragment;

public interface HomeActivityCallbacks {
    public void setContentFragment(Fragment fragment, boolean addToBackStack, String tag);

    public void onFragmentsActivityCreated(Fragment fragment, String title, String tag);

    public void setTitle(String title);

    public void onCaseSelected(Case cas);
}
