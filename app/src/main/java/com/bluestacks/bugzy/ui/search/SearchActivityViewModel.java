package com.bluestacks.bugzy.ui.search;

import com.bluestacks.bugzy.data.CasesRepository;
import com.bluestacks.bugzy.data.SearchSuggestionRepository;
import com.bluestacks.bugzy.data.model.Case;
import com.bluestacks.bugzy.data.model.SearchResultsResource;
import com.bluestacks.bugzy.data.model.SearchSuggestion;
import com.bluestacks.bugzy.utils.SingleLiveEvent;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;


public class SearchActivityViewModel extends ViewModel {
    public static final String TAG = SearchActivityViewModel.class.getName();
    private CasesRepository mCasesRepository;
    private MutableLiveData<String> mSearchLiveData = new MutableLiveData<>();
    private MediatorLiveData<SearchResultsResource<List<Case>>> mSearchResponse;
    private SingleLiveEvent<Void> mClearSearchEvent = new SingleLiveEvent<>();
    private String mCurrentQuery = null;
    private LiveData<List<SearchSuggestion>> mSearchSuggestions;
    private SearchSuggestionRepository mSearchSuggestionRepository;
    private MutableLiveData<String> mSearchTextLive = new MutableLiveData<>();
    private SingleLiveEvent<String> mSearchChangeEvent = new SingleLiveEvent<>();

    @Inject
    public SearchActivityViewModel(CasesRepository repository, SearchSuggestionRepository ssRepository) {
        mCasesRepository = repository;
        mSearchSuggestionRepository = ssRepository;
        LiveData<SearchResultsResource<List<Case>>> tempLiveData = Transformations
                .switchMap(mSearchLiveData, value -> {
                    return mCasesRepository.searchCases(value);
                });
        mSearchResponse = new MediatorLiveData<>();
        mSearchResponse.addSource(tempLiveData, v -> {
            if (v.getQuery().equals(mCurrentQuery)) {
                // If the query is equal to the current query, only then dispatch the event
                mSearchResponse.setValue(v);
            }
        });

        mSearchTextLive = new MutableLiveData<>();
        mSearchSuggestions = Transformations.switchMap(mSearchTextLive, query -> {

            // TODO: Do all of this on a background thread.
            String q = ""; // The query that will be finally submitted to mSearchTextLive
            if (!TextUtils.isEmpty(query) && query.length() > 0) {
                int lastPartStartingIndex = getCrucialIndex(query);
                q = query.substring(lastPartStartingIndex, query.length());
            }

            if (TextUtils.isEmpty(q)) {
                return AbsentLiveData.create();
            }
            return mSearchSuggestionRepository.search(q.trim());
        });
    }


    public void searchTextChanged(String query) {
        mSearchTextLive.setValue(query);
    }

    private int getCrucialIndex(String query) {
        int quotesOccurence = Math.max(query.split("'").length - 1, 0);
        int lastSpaceBeforeQuote = 0;
        if (quotesOccurence % 2 == 0) {
            lastSpaceBeforeQuote = query.lastIndexOf(" ");
        } else {
            int lastQuote = query.lastIndexOf("'");
            lastSpaceBeforeQuote = query.substring(0, lastQuote).lastIndexOf(" ");
        }
        return Math.max(lastSpaceBeforeQuote, 0);
    }

    public void search(String query) {
        mCurrentQuery = query;
        mSearchLiveData.setValue(query);
    }

    public void clearSearch() {
        mCurrentQuery = null;
        mClearSearchEvent.call();
    }

    public void searchSuggestionSelected(SearchSuggestion suggestion) {
        String query = mSearchTextLive.getValue();
        int lastPartStartingIndex = getCrucialIndex(query);
        String p1 = query.substring(0, lastPartStartingIndex);
        if (!TextUtils.isEmpty(p1)) {
            mSearchChangeEvent.setValue(p1 + " " + suggestion.getText() +" ");
        } else {
            mSearchChangeEvent.setValue(suggestion.getText() + " ");
        }
    }

    public LiveData<SearchResultsResource<List<Case>>> getSearchResponse() {
        return mSearchResponse;
    }

    public LiveData<List<SearchSuggestion>> getSearchSuggestions() {
        return mSearchSuggestions;
    }

    public SingleLiveEvent<Void> getClearSearchEvent() {
        return mClearSearchEvent;
    }

    public SingleLiveEvent<String> getSearchChangeEvent() {
        return mSearchChangeEvent;
    }
}
