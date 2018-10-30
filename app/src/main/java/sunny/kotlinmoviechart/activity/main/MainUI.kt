package sunny.kotlinmoviechart.activity.main

import android.support.design.widget.TabLayout
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class MainUI : AnkoComponent<MainActivity> {

    lateinit var etUsername: EditText
    lateinit var tabLayout: TabLayout
    lateinit var bId: Button
    lateinit var iv: ImageView
    lateinit var un: TextView
    lateinit var cp: TextView

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER_VERTICAL
            lparams(matchParent, wrapContent)
            padding = dip(16)


              etUsername = editText {
              hint = "input your username"
          }.lparams(matchParent, wrapContent)

          bId = button().lparams(matchParent, wrapContent)

          verticalLayout {
              lparams(matchParent, wrapContent)
              padding = dip(10)

              iv = imageView().lparams(matchParent, wrapContent)
              un = textView().lparams(wrapContent, wrapContent)
              cp = textView().lparams(wrapContent, wrapContent)
          }
        }


    }
}


