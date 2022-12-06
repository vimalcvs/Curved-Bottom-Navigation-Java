package alldocumentreader.vimal.office.viewer.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation;

import alldocumentreader.vimal.office.viewer.myapplication.databinding.ActivityMainBinding;
import alldocumentreader.vimal.office.viewer.myapplication.fragment.DashboardFragment;
import alldocumentreader.vimal.office.viewer.myapplication.fragment.HomeFragment;
import alldocumentreader.vimal.office.viewer.myapplication.fragment.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        CurvedBottomNavigation curvedBottomNavigation = findViewById(R.id.bottomNavigation);
        fragmentManager = getSupportFragmentManager();
        curvedBottomNavigation.add(new CurvedBottomNavigation.Model(1, "Dashboard", R.drawable.ic_dashboard_black_24dp));
        curvedBottomNavigation.add(new CurvedBottomNavigation.Model(2, "Home", R.drawable.ic_home_black_24dp));
        curvedBottomNavigation.add(new CurvedBottomNavigation.Model(3, "Notification", R.drawable.ic_notifications_black_24dp));
        curvedBottomNavigation.show(2, true);
        loadFragment(new DashboardFragment());


        curvedBottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    loadFragment(new DashboardFragment());
                    break;
                case 2:
                    loadFragment(new HomeFragment());
                    break;
                case 3:
                    loadFragment(new NotificationsFragment());
                    break;
            }
            return null;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_home_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}