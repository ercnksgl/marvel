package com.path.marvelmobile.remote.interactions;

import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public abstract class UseCase<T, Params> {
    private CompositeDisposable disposable;

    public UseCase(){disposable = new CompositeDisposable();}

    public void execute(Params params, DisposableObserver<T> observer){
        Observable<T> observable = this.buildUseCaseObservable(params)
                .doOnError(it->{
                    if(it instanceof ConnectException || it instanceof UnknownHostException){
                        this.dispose();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        disposable.add(observable.subscribeWith(observer));
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void dispose(){
        if(!disposable.isDisposed())
            disposable.dispose();
    }
}
