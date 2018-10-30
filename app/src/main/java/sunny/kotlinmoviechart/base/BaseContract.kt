package sunny.kotlinmoviechart.base

import android.view.View

/**
 * Created by Wayan-MECS on 10/26/2018.
 */
interface BaseContract {

    interface baseFragmentView{
        fun initVar()
        fun init(v: View)
        fun action()
        fun run()
    }
}