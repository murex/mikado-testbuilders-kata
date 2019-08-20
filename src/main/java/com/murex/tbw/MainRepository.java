package com.murex.tbw;

import com.murex.tbw.storage.JsonRepository;
import com.murex.tbw.storage.Repository;

public final class MainRepository {

    private static MainRepository runningRepository = null;
    private Repository repository;

    private MainRepository() {
        repository = new JsonRepository();
    }

    public static Repository configuredRepository() {
        if (runningRepository == null) {
            runningRepository = new MainRepository();
        }
        return runningRepository.repository;
    }

    /* Working effectively with Legacy Code
     * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
     */
    @Deprecated
    public void override(Repository newRepository) {
        repository = newRepository;
    }
    @Deprecated
    public void reset() {
        repository = new JsonRepository();
    }
}
