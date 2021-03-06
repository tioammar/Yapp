package in.lovelacetech.yapp.model;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created Tiommar.
 */
public interface CoreModel<T extends BaseModel> {

    void insert(T t);
    void bulkInsert(List<T> t);
    void delete(T t);
    void update(T t);
    FlowCursorList<T> getAll(String condition);
    T get(long id);
}
