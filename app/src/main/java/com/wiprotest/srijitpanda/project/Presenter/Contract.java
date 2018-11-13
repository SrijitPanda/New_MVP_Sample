package com.wiprotest.srijitpanda.project.Presenter;

import com.wiprotest.srijitpanda.project.Model.RowDataModel;

import java.util.ArrayList;

public interface Contract {

    interface ViewContract{

        /**
         * <h2>updateUI</h2>
         * <p>This method is used to update the view of list that we get from response on api call</p>
         * @param ListDataItems it contains the array's of RowDataModel objects data.
         */
        void updateUI(ArrayList<RowDataModel> ListDataItems);

        /**
         * <h2>errorMessage</h2>
         * <p>If the api call fails it throws error here</p>
         * <p>error is handled</p>
         */
        void errorMessage();

    }

    interface PresenterContract{

        /**
         * <h2>makeServiceCall</h2>
         * <p>This method is used to make api call to get the data from the given link</p>
         */
        void makeServiceCall();

    }
}
