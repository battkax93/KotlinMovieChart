package sunny.kotlinmoviechart.activity.main

import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.kotlinmoviechart.network.api.GithubApi

class MainPresent(private var mView: MainContract.mainView?) : MainContract.mainPresent {

    override fun getData(api: GithubApi, username: String) {
        Log.d("FLOW", "MainPresent.getData")
        Log.d("cek",username)
        api.services.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { user ->
                            mView?.init(user)
                            Log.d("result", "success")
                        }, { error ->
                    Log.d("result", "fail")
                    Log.e("Error", error.message)
                })
    }

}