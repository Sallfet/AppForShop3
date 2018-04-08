package com.viktorkrasnovid.appforshop3.db;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class DBUtils {
    public static void execute(Runnable r) {
        Executors.newSingleThreadScheduledExecutor().execute(r);
    }

    public static <V> V executeAndGet(Callable<V> callable) {
        try {
            return Executors.newSingleThreadScheduledExecutor().submit(callable).get();
        } catch (InterruptedException e) {
            e.printStackTrace();//todo
        } catch (ExecutionException e) {
            e.printStackTrace();//todo
        }

        return null;
    }
}
