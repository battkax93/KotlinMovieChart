package sunny.kotlinmoviechart.activity.main

import android.content.Context
import android.view.View
import sunny.kotlinmoviechart.network.api.GithubApi
import sunny.kotlinmoviechart.network.model.Github


interface MainContract {

    interface mainView{
        fun run(un: String, ctx: Context)
        fun updateUi(user: Github)
    }

    interface mainPresent{
        fun getData(api: GithubApi, username: String, ctx: Context)
    }

}