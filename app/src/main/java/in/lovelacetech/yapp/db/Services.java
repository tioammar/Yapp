package in.lovelacetech.yapp.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by Tioammar
 */

@Table(database = AppData.class, name = Services.TABLE_NAME)
public class Services {

    public static final String TABLE_NAME = "services";

    @Column
    @PrimaryKey
    public long id;

    @Column
    public String name;

    @Column
    public String content;

    @Column
    public String location;

    @Column
    public String category;

    @Column
    public double longitude;

    @Column
    public double latitude;

    @Column
    public String photo;

    @Column
    public boolean validation;

    @Column
    public long contact;

    @Column
    public String update;

    @Column
    public String created;
}
