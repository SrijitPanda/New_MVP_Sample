package com.wiprotest.srijitpanda.project.Presenter;




import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.wiprotest.srijitpanda.project.Model.DataModel;
import com.wiprotest.srijitpanda.project.Model.RowDataModel;
import com.wiprotest.srijitpanda.project.Utility.NetworkClass;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class Presenter implements Contract.PresenterContract {

    @Inject
    NetworkClass networkClass;

    @Inject
    Contract.ViewContract viewContract;

    private DataModel dataModel;
    private static String TAG="Presenter class ";



    @Inject
    Presenter(){
    }

    @Inject
    Gson gson;


    /**
     * <h2>makeServiceCall</h2>
     * <p>This method is used to make api call to get the data from the given link</p>
     */
    @Override
    public void makeServiceCall() {

        Observable<Response<ResponseBody>> request = networkClass.getFeedDataFromApiCall();
        request.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<ResponseBody>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<ResponseBody> value) {

                        String responseToBeParsed = null;
                        try {
                            responseToBeParsed = value.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        dataModel= (DataModel) gson.fromJson(responseToBeParsed,DataModel.class);

                        Log.d(TAG, "Response on Success: "+ responseToBeParsed);

                        ArrayList<RowDataModel> sendList = new ArrayList<>();
                        sendList.addAll(dataModel.getRows());
                        viewContract.updateUI(sendList);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.d(TAG, "Response on Error: "+ e.getMessage());
                        viewContract.errorMessage();
                    }

                    @Override
                    public void onComplete()
                    {
                    }
                });
    }

}

