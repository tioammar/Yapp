package in.lovelacetech.yapp.model;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.Nullable;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import in.lovelacetech.yapp.db.Services;
import in.lovelacetech.yapp.db.Services_Table;

/**
 * Created by Tioammar
 */
public class ServiceModel implements CoreModel<Services> {

    @Override
    public void insert(Services services) {
        if(services.content != null){
            services.save();
        } else throw new IllegalArgumentException();
    }

    @Override
    public void bulkInsert(List<Services> t) {
        if (t.size() > 0) {
            for (Services services : t) {
                services.save();
            }
        }
    }

    @Override
    public void delete(Services services) {
        if (services.id != 0){
            services.delete();
        } throw new IllegalArgumentException();
    }

    @Override
    public void update(Services services) {
        if (services.id != 0 && services.content != null){
            services.update();
        } throw new IllegalArgumentException();
    }

    @Override
    public FlowCursorList<Services> getAll(String condition) {
        String userLocation = "";
        FlowCursorList<Services> services;
        if (condition == null){
            services = new FlowCursorList<>(false, SQLite.select()
                    .from(Services.class).where(Services_Table.location.is(userLocation))
                    .orderBy(Services_Table.created, false));
        } else {
            services = new FlowCursorList<>(false, SQLite.select()
                    .from(Services.class).where(Services_Table.location.is(userLocation))
                    .and(Services_Table.name.like(condition))
                    .orderBy(Services_Table.created, false));
        }
        if (services.getCount() > 0){
            return services;
        }
        return null;
    }

    @Override
    public Services get(long id) {
        Services service = SQLite.select().from(Services.class).where(Services_Table.id.is(id)).querySingle();
        if (service != null && service.id == id) {
            return service;
        } else throw new RuntimeException();
    }

    public static class ServiceLoader extends AsyncTaskLoader<Services> {

        private Services mServices;
        private long mId;

        public ServiceLoader(Context context, long id) {
            super(context);
            mId = id;
        }

        @Override
        protected void onStartLoading() {
            if(mServices == null){
                forceLoad();
            }
            super.onStartLoading();
        }

        @Override
        public Services loadInBackground() {
            mServices = new ServiceModel().get(mId);
            return mServices;
        }
    }

    public static class ServiceListLoader extends AsyncTaskLoader<FlowCursorList<Services>> {

        private FlowCursorList<Services> mServicesCursor;
        private String mCondition;

        public ServiceListLoader(Context context,@Nullable String condition) {
            super(context);
            mCondition = condition;
        }

        @Override
        protected void onStartLoading() {
            if (mServicesCursor == null){
                forceLoad();
            }
            super.onStartLoading();
        }

        @Override
        public FlowCursorList<Services> loadInBackground() {
            mServicesCursor = new ServiceModel().getAll(mCondition);
            return mServicesCursor;
        }
    }
}
