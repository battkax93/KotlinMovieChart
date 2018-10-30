package sunny.kotlinmoviechart.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import sunny.kotlinmoviechart.BuildConfig
import sunny.kotlinmoviechart.network.model.Stck

/**
 * Created by Wayan-MECS on 10/26/2018.
 */
interface Services2 {

    @GET(BuildConfig.BASE_URL2_QUERY)
    fun getAllUser(
            @Query("order") order: String,
            @Query("sort") sort: String,
            @Query("site") site: String): Observable<Stck>
}