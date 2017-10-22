package dreamycoding.com.profiler.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public class ActivityUtils extends AppCompatActivity {
    /*
    * The {@code fragment} is added to the container view with id {@code frameId}. The Operation
    * performed by the {@code fragmentManager}.
    * */

    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int frameId,
                                             String tag) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commit();
    }
}
