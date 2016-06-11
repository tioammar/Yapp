package in.lovelacetech.yapp.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Tioammar
 */

@Database(name = AppData.DB_NAME, version = AppData.DB_VERSION)
public class AppData {

    public static final String DB_NAME = "yapp";
    public static final int DB_VERSION = 1;
}
