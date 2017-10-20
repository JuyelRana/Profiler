package dreamycoding.com.profiler;

import android.support.annotation.StringRes;

/**
 * Created by Juyel on 10/19/2017.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void makeToast(@StringRes int stringId);

    void makeToast(String message);
}
