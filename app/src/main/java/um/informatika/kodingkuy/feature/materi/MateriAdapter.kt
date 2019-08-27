package um.informatika.kodingkuy.feature.materi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.materi.detail.DetailMateriActivity
import um.informatika.kodingkuy.model.Materi

class MateriAdapter(private val context: Context) : RecyclerView.Adapter<MateriAdapter.ViewHolder>() {

    private var mListData: List<Materi>? = null

    init {
        mListData = ArrayList()
        notifyDataSetChanged()
    }

    //constructor mListData
    fun setListData(mListData: List<Materi>) {
        this.mListData = mListData
        notifyDataSetChanged()
    }

    //event saat viewholder dibuat, memasukkan view item_list_kategori pada item recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_materi, parent, false)
        return ViewHolder(view)
    }

    //mendapatkan data sesuai dengan ukuran mListData
    override fun getItemCount(): Int {
        return mListData!!.size
    }

    //mengikat variabel kotlin dengan model
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val materi = mListData!![position]

        holder.textTitle.text = materi.title
        holder.textSubtitle.text = materi.subtitle
        holder.imageSource.setImageResource(materi.imageSource)
        holder.layoutItem.setOnClickListener {
            val intent = Intent(context, DetailMateriActivity::class.java)
            intent.putExtra("materi", materi)
            context.startActivity(intent) }
    }

    //mengikat view xml ke variabel kotlin
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle: TextView = itemView.findViewById(R.id.text_title)
        var textSubtitle: TextView = itemView.findViewById(R.id.text_subtitle)
        var imageSource: ImageView = itemView.findViewById(R.id.image_materi)
        var layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item_materi)
    }
}