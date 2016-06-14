package in.lovelacetech.yapp.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Tioammar
 */

@Table(database = AppData.class, name = User.TABLE_NAME)
public class User extends BaseModel {

    public static final String TABLE_NAME = "user";

    @Column
    @PrimaryKey
    public long id;

    @Column
    public String fullName;

    @Column
    public String userName;

    @Column
    public String photo;
}