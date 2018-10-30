package sunny.kotlinmoviechart.fragment.second_fragment

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import sunny.kotlinmoviechart.R
import sunny.kotlinmoviechart.network.model.Stck
import java.util.ArrayList

class xAdapter(private val mContext: Context, posts: ArrayList<Stck.Item>) : RecyclerView.Adapter<xAdapter.ViewHolder>() {

    private var mItems: List<Stck.Item>? = null

    init {
        mItems = posts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val postView = inflater.inflate(R.layout.simple_list2, parent, false)
        return ViewHolder(postView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var ivAva: ImageView
        internal var titleTv1: TextView
        internal var titleTv2: TextView
        internal var titleTv3: TextView

        init {
            titleTv1 = itemView.findViewById(R.id.textTest1) as TextView
            titleTv2 = itemView.findViewById(R.id.textTest2) as TextView
            titleTv3 = itemView.findViewById(R.id.textTest3) as TextView
            ivAva = itemView.findViewById(R.id.ivAva) as ImageView
            //            ivAva.setOnClickListener(this);

            //            itemView.setOnClickListener(this);
        }

        override fun onClick(v: View) {
            val item = getItem(adapterPosition)
            if (v.id == ivAva.id) {

            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: xAdapter.ViewHolder, position: Int) {

        val item = mItems!![position]
        val textView1 = holder.titleTv1
        val textView2 = holder.titleTv2
        val textView3 = holder.titleTv3
        val iv1 = holder.ivAva

        textView1.setText(item.owner.displayName)
        textView2.setText(item.owner.userType)
        textView3.setText(item.owner.userId.toString())
        Picasso.get().load(item.owner.profileImage)
                .into(iv1)

        iv1.setOnClickListener { Toast.makeText(mContext, "clicked IV", Toast.LENGTH_SHORT).show() }

    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }

    fun updateAnswers(items: List<Stck.Item>) {
        mItems = items
        notifyDataSetChanged()
    }

    private fun getItem(adapterPosition: Int): Stck.Item {
        return mItems!![adapterPosition]
    }

}


/*
class StackAdapter : RecyclerView.Adapter<StackAdapter.ViewHolder>() {
    private var mItems: List<Stck.Item>? = null
    lateinit var mContext: Context

    fun StackAdapter (context: Context, posts: ArrayList<Stck.Item>) {
        mItems = posts
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.simple_list2, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var stack = mItems!![position]
        Picasso.get().load(stack.owner.profileImage).into(holder?.iv1)
        holder?.tv1?.text = stack.owner.displayName
        holder?.tv2?.text = stack.owner.userType
        holder?.tv3?.text = stack.owner.reputation.toString()

    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }


    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var iv1: ImageView? = null
        var tv1: TextView? = null
        var tv2: TextView? = null
        var tv3: TextView? = null
        var b1: Button? = null

        init {
            this.iv1 = row?.findViewById(R.id.ivAva)
            this.tv1 = row?.findViewById(R.id.textTest1)
            this.tv2 = row?.findViewById(R.id.textTest2)
            this.tv3 = row?.findViewById(R.id.textTest3)
            this.b1 = row?.findViewById(R.id.btn_1)
        }
    }

    fun updateAnswer(it: List<Stck.Item>){
        mItems = it
        Log.d("flow","stackadapter.updateanswer")
        notifyDataSetChanged()
    }
}*/
