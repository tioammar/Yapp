package in.lovelacetech.yapp.model;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.Nullable;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import in.lovelacetech.yapp.db.User;
import in.lovelacetech.yapp.db.User_Table;

/**
 * Created by Tioammar
 */
public class UserModel implements CoreModel<User> {

    @Override
    public void insert(User user) {
        if (user.userName != null){
            user.save();
        } else throw new IllegalArgumentException();
    }

    @Override
    public void bulkInsert(List<User> t) {
        if (t.size() > 0){
            for (User user : t){
                user.save();
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public void delete(User user) {
        if (user.id != 0){
            user.delete();
        } else throw new IllegalArgumentException();
    }

    @Override
    public void update(User user) {
        if (user.id != 0 && user.userName != null){
            user.update();
        } else throw new IllegalArgumentException();
    }

    @Override
    public FlowCursorList<User> getAll(String condition) {
        FlowCursorList<User> users;
        if (condition == null) {
            users = new FlowCursorList<>(false, SQLite.select().from(User.class)
                    .orderBy(User_Table.fullName, true));
        } else {
            users = new FlowCursorList<>(false, SQLite.select().from(User.class)
                    .where(User_Table.fullName.like(condition))
                    .orderBy(User_Table.fullName, true));
        }
        if (users.getCount() > 0) {
            return users;
        } else return null;
    }

    @Override
    public User get(long id) {
        User user = SQLite.select().from(User.class).where(User_Table.id.is(id)).querySingle();
        if (user != null && user.id == id) {
            return user;
        } throw new RuntimeException();
    }

    public static class UserLoader extends AsyncTaskLoader<User> {

        private User mUser;
        private long mId;

        public UserLoader(Context context, long id) {
            super(context);
            mId = id;
        }

        @Override
        protected void onStartLoading() {
            if (mUser == null){
                forceLoad();
            }
            super.onStartLoading();
        }

        @Override
        public User loadInBackground() {
            mUser = new UserModel().get(mId);
            return mUser;
        }
    }

    public static class UserListLoader extends AsyncTaskLoader<FlowCursorList<User>> {

        private String mCondition;
        private FlowCursorList<User> mUsers;

        public UserListLoader(Context context,@Nullable String condition) {
            super(context);
            mCondition = condition;
        }

        @Override
        protected void onStartLoading() {
            if (mUsers == null){
                forceLoad();
            }
            super.onStartLoading();
        }

        @Override
        public FlowCursorList<User> loadInBackground() {
            mUsers = new UserModel().getAll(mCondition);
            return mUsers;
        }
    }
}
