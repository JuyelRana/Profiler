package dreamycoding.com.profiler.login;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dreamycoding.com.profiler.R;
import dreamycoding.com.profiler.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_FRAGMENT = "LOGIN_FRAGMENT";
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manager = getFragmentManager();

        LoginFragment fragment = (LoginFragment) manager.findFragmentByTag(LOGIN_FRAGMENT);

        if (fragment == null) {
            fragment = LoginFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(getFragmentManager(),
                fragment,
                R.id.cont_login_fragment,
                LOGIN_FRAGMENT);
    }
}
