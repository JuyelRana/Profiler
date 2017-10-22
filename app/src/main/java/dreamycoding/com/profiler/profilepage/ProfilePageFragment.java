package dreamycoding.com.profiler.profilepage;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import dreamycoding.com.profiler.R;
import dreamycoding.com.profiler.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePageFragment extends Fragment implements ProfilePageContract.View {
    private ProfilePageContract.Presenter presenter;

    private TextView userBio, userInterests, userName, userEmail;
    private ImageView thumbnail;
    private FloatingActionButton editDetails;
    private ImageButton settings, logout;

    public ProfilePageFragment() {
        // Required empty public constructor
    }

    public static ProfilePageFragment newInstance(){
        ProfilePageFragment fragment = new ProfilePageFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This is important. It helps our View/Presenter/Service service orientation
        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_page, container, false);
        //Where we assign our views
        userBio = (TextView) view.findViewById(R.id.lbl_page_user_bio);
        userInterests = (TextView) view.findViewById(R.id.lbl_page_user_interests);
        userName = (TextView) view.findViewById(R.id.lbl_page_user_name);
        userEmail = (TextView) view.findViewById(R.id.lbl_page_user_email);

        thumbnail = (ImageView) view.findViewById(R.id.imb_page_thumbnail);
        thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Called the onThumbnailClick method
                presenter.onThumbnailClick();
            }
        });

        settings = (ImageButton) view.findViewById(R.id.imb_page_user_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAccountSettingsClick();
            }
        });

        logout = (ImageButton) view.findViewById(R.id.imb_page_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogoutClick();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Where we create presenter if need
        if (presenter == null) {
            presenter = (ProfilePageContract.Presenter) new ProfilePagePresenter();
        }

        presenter.subscribe();
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void makeToast(@StringRes int stringId) {
        Toast.makeText(getActivity(), getString(stringId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(ProfilePageContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        userName.setText(name);
    }

    @Override
    public void setEmail(String email) {
        userEmail.setText(email);
    }

    @Override
    public void setBio(String bio) {
        userBio.setText(bio);
    }

    @Override
    public void setInterests(String interests) {
        userInterests.setText(interests);
    }

    @Override
    public void setProfilePhotoUrl(String profilePhotoUrl) {
        //TODO handle this properly
        Picasso.with(getActivity())
                .load(profilePhotoUrl)
                .noFade()
                .into(thumbnail, new Callback() {
                    @Override
                    public void onSuccess() {
                        presenter.onThumbnailLoaded();
                    }

                    @Override
                    public void onError() {
                        //set a default profile photo
                        setDefaultProfilePhoto();
                    }
                });
    }

    @Override
    public void setDefaultProfilePhoto() {
        Picasso.with(getActivity())
                .load(R.drawable.default_profile_pic)
                .noFade()
                .into(thumbnail, new Callback() {
                    @Override
                    public void onSuccess() {
                        presenter.onThumbnailLoaded();
                    }

                    @Override
                    public void onError() {
                        //TODO handle this better later on
                        makeToast("Unable to load Image.");
                    }
                });
    }

    @Override
    public void showLogoutSnackbar() {
        Snackbar.make(getView(),
                getString(R.string.action_logout),
                Snackbar.LENGTH_SHORT)
                .setAction(R.string.action_logout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onLogoutConfirmed();
                    }
                }).show();
    }

    @Override
    public void startLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setThumbnailLoadingIndicator(boolean show) {
        //TODO handle this
    }

    @Override
    public void setDetailLoadingIndicators(boolean show) {
        // TODO handle this
    }
}
