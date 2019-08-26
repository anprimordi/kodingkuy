package um.informatika.kodingkuy.feature.kuis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori

class KategoriAdapter(private val context: Context) : RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

    private var mListData: List<Kategori>? = null
    internal fun setListData(mListData: List<Kategori>) {
        this.mListData = mListData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_kategori, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kategori = mListData!![position]

        holder.titleKategori.text = kategori.nama
        holder.layoutItem.setOnClickListener {
            val intent = Intent(context, KuisActivity::class.java)
            intent.putExtra("kategori", kategori)
            // send kategori intent to kuis activity to get title for toolbar
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item_kategori)
        var titleKategori: TextView = itemView.findViewById(R.id.title_kategori)
    }
}