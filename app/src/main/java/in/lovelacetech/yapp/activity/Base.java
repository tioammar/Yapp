package in.lovelacetech.yapp.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import in.lovelacetech.yapp.R;

/**
 * Created by Tioammar
 */
public abstract class Base extends AppCompatActivity {

    abstract protected boolean setUseToolbar();
    abstract protected String setTitle();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setUpToolbar();

        if (setUseToolbar()){
            ActionBar ab = getSupportActionBar();
            if (ab != null){
                ab.setTitle(setTitle());
            }
        }
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
