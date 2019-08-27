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
import um.informatika.kodingkuy.feature.kuis.detail.KuisActivity
import um.informatika.kodingkuy.model.Kategori

class KategoriAdapter(private val context: Context) : RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

    private var mListData: List<Kategori>? = null
    //constructor mListData
    internal fun setListData(mListData: List<Kategori>) {
        this.mListData = mListData
        notifyDataSetChanged()
    }

    //event saat viewholder dibuat, memasukkan view item_list_kategori pada item recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_kategori, parent, false)
        return ViewHolder(view)
    }

    //mendapatkan data sesuai dengan ukuran mListData
    override fun getItemCount(): Int {
        return mListData!!.size
    }

    //mengikat variabel kotlin dengan model
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kategori = mListData!![position]

        holder.titleKategori.text = kategori.nama
        holder.layoutItem.setOnClickListener {
            //kirim intent kategori ke kuis activity untuk mendapatkan title pada toolbar
            val intent = Intent(context, KuisActivity::class.java)
            intent.putExtra("kategori", kategori)
            context.startActivity(intent)
        }
    }

    //mengikat view xml ke variabel kotlin
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item_kategori)
        var titleKategori: TextView = itemView.findViewById(R.id.title_kategori)
    }
}