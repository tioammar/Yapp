package in.lovelacetech.yapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import in.lovelacetech.yapp.R;

/**
 * Created by Tioammar
 */
public class Main extends Base {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected boolean setUseToolbar() {
        return true;
    }

    @Override
    protected String setTitle() {
        return "Y App";
    }
}
