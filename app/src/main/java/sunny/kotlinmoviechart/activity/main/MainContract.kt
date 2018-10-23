package sunny.kotlinmoviechart.activity.main

import android.view.View
import sunny.kotlinmoviechart.network.api.GithubApi
import sunny.kotlinmoviechart.network.model.Github


interface MainContract {

    interface mainView{
        fun run(un: String)
        fun init(user: Github)
    }

    interface mainPresent{
        fun getData(api: GithubApi, username: String)
    }

}