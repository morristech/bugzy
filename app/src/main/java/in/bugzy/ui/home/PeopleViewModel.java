package in.bugzy.ui.home;


import in.bugzy.data.Repository;
import in.bugzy.data.model.Resource;
import in.bugzy.data.model.Person;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

public class PeopleViewModel extends ViewModel {
    private MediatorLiveData<Boolean> mIsLoggedIn = new MediatorLiveData<>();
    private Repository mRepository;
    private MediatorLiveData<Resource<List<Person>>> mPeopleState = new MediatorLiveData<>();

    @Inject
    PeopleViewModel(Repository repository) {
        mRepository = repository;
        mIsLoggedIn.addSource(mRepository.getToken(), token -> {
            if (token == null) {
                mIsLoggedIn.setValue(false);
            } else {
                mIsLoggedIn.setValue(true);
            }
        });

        mPeopleState.addSource(mRepository.getPeople(false), filtersDataResource -> mPeopleState.setValue(filtersDataResource));
    }

    public void reloadPeople() {
        mRepository.getPeople(false);
    }

    public MediatorLiveData<Boolean> getIsLoggedIn() {
        return mIsLoggedIn;
    }

    public MediatorLiveData<Resource<List<Person>>> getPeopleState() {
        return mPeopleState;
    }
}
