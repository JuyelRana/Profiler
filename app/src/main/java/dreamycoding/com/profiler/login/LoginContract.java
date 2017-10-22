package dreamycoding.com.profiler.login;

import android.support.annotation.StringRes;

import dreamycoding.com.profiler.BasePresenter;
import dreamycoding.com.profiler.BaseView;

/**
 * Created by Juyel on 10/13/2017.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void makeToast(@StringRes int stringId);

        void makeToast(String message);

        String getEmail();

        String getPassword();

        void startProfileActivity();

        void startCreateAccountActivity();

        void setPresenter(LoginContract.Presenter presenter);

        void showProgressIndicator(boolean show);
    }

    interface Presenter extends BasePresenter {
        void onLogInClick();

        void onCreateClick();

    }
}
