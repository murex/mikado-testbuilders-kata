package com.murex.tbw;

import com.murex.tbw.storage.JsonRepository;
import com.murex.tbw.storage.Repository;

public final class MainRepository {

    private static MainRepository runningRepository = null;
    private final Repository repository;

    private MainRepository() {
        repository = new JsonRepository();
    }

    public static Repository configuredRepository() {
        if (runningRepository == null) {
            runningRepository = new MainRepository();
        }
        return runningRepository.repository;
    }
}
