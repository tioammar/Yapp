package in.lovelacetech.yapp.model;

import com.raizlabs.android.dbflow.list.FlowCursorList;

import java.util.List;

import in.lovelacetech.yapp.db.User;

/**
 * Created by Tioammar
 */
public class UserModel implements CoreModel<User> {

    @Override
    public void insert(User user) {

    }

    @Override
    public void bulkInsert(List<User> t) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public FlowCursorList<User> getAll() {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }
}
