package sunny.kotlinmoviechart.fragment.second_fragment

import android.content.Context
import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.kotlinmoviechart.network.api.StackExchangeApi
import sunny.kotlinmoviechart.network.model.Stck

class SecondFragmentPresent : SecondFragmenContract.secondFragPresent {

    lateinit var adapter: xAdapter
    lateinit var stckList: ArrayList<Stck.Item>

    override fun getlist(api: StackExchangeApi, order: String, sort: String, site: String, ctx: Context) {
        stckList = arrayListOf()
        adapter = xAdapter(ctx,stckList)
        api.services.getAllUser(order, sort, site)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user ->
                    Log.d("Res", "Succes ")
                    Log.d("cek", user.items[0].owner.displayName)
                    adapter.updateAnswers(user.items)
                }, { error ->
                    Log.d("Res", "Fail")
                    Log.d("ERROR", error.message)
                })
    }
}