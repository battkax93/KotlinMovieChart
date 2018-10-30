package sunny.kotlinmoviechart.network.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sunny.kotlinmoviechart.BuildConfig

class StackExchangeApi {
    private val gson = GsonBuilder().create()!!
    private val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL2)
            .build()

    val services: Services2 = retrofit.create(Services2::class.java)
}