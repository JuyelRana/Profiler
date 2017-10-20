package dreamycoding.com.profiler.profilepage;

import dreamycoding.com.profiler.BasePresenter;
import dreamycoding.com.profiler.BaseView;

/**
 * Created by Juyel on 10/13/2017.
 */

public interface ProfilePageContract {

    interface View extends BaseView<Presenter> {
        void setPresenter(ProfilePageContract.Presenter presenter);

        void setName(String name);

        void setEmail(String email);

        void setBio(String bio);

        void setInterests(String interests);

        void setProfilePhotoUrl(String profilePhotoUrl);

        void setDefaultProfilePhoto();

//        void startPhotoActivity();
//
//        void startDetailActivity();
//
//        void setProfileSettingsActivity(String name);

        void showLogoutSnackbar();

        void startLoginActivity();

        void setThumbnailLoadingIndicator(boolean show);

        void setDetailLoadingIndicators(boolean show);
    }

    interface Presenter extends BasePresenter {
        void onThumbnailClick();

        void onEditProfileClick();

        void onLogoutClick();

        void onLogoutConfirmed();

        void onAccountSettingsClick();

        void onThumbnailLoaded();
    }
}
