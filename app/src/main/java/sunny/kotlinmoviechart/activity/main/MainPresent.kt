package sunny.kotlinmoviechart.activity.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.kotlinmoviechart.network.api.GithubApi

class MainPresent(private var mView: MainContract.mainView?) : MainContract.mainPresent {

    override fun getData(api: GithubApi, username: String, ctx: Context) {
        Log.d("FLOW", "MainPresent.getData")
        Log.d("cek",username)
        api.services.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { user ->
                            Toast.makeText(ctx,"succes",Toast.LENGTH_SHORT).show()
                            mView?.updateUi(user)
                            Log.d("result", "success")
                        }, { error ->
                    Log.d("result", "fail")
                    Log.e("Error", error.message)
                })
    }

}