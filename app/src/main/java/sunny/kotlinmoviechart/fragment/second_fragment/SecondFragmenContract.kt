package sunny.kotlinmoviechart.fragment.second_fragment

import android.content.Context
import sunny.kotlinmoviechart.network.api.StackExchangeApi

/**
 * Created by Wayan-MECS on 10/26/2018.
 */
interface SecondFragmenContract {
    interface secondFragPresent{
        fun getlist(api: StackExchangeApi, order: String, sort: String, site: String,ctx: Context)
    }
}