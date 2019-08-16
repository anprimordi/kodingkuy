package um.informatika.kodingkuy.feature.materi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Materi

class MateriAdapter(private val clickListener: MateriItemClickListener?) : RecyclerView.Adapter<MateriAdapter.ViewHolder>() {

    private var mData: List<Materi>? = null

    init {
        mData = ArrayList()
        notifyDataSetChanged()
    }

    fun setmData(mData: List<Materi>) {
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_materi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val materi = mData!![position]

        holder.textTitle.text = materi.title
        holder.textSubtitle.text = materi.subtitle
        holder.imageSource.setImageResource(materi.imageSource)
        holder.layoutItem.setOnClickListener { clickListener?.onItemClick(materi) }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle: TextView = itemView.findViewById(R.id.text_title)
        var textSubtitle: TextView = itemView.findViewById(R.id.text_subtitle)
        var imageSource: ImageView = itemView.findViewById(R.id.image_materi)
        var layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item_materi)
    }
}