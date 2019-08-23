package um.informatika.kodingkuy.feature.materi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.materi.adapter.MateriAdapter
import um.informatika.kodingkuy.feature.materi.adapter.MateriItemClickListener
import um.informatika.kodingkuy.feature.materi.detail.DetailMateriActivity
import um.informatika.kodingkuy.model.Materi

class MateriActivity : AppCompatActivity(), MateriContract.View {

    override lateinit var presenter: MateriContract.Presenter
    private var rvMateri: RecyclerView? = null
    private var msgEmpty: TextView? = null
    private lateinit var adapter: MateriAdapter

    override fun onLoadListMateriSucceed(listMateri: List<Materi>) {
        msgEmpty!!.visibility = View.GONE
        rvMateri!!.visibility = View.VISIBLE
        adapter.setmData(listMateri)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        presenter = MateriPresenter(this)
        bindView()
    }

    private fun bindView() {
        msgEmpty = findViewById(R.id.text_empty_content)
        rvMateri = findViewById(R.id.rv_materi)
        val clickListener = object : MateriItemClickListener {
            override fun onItemClick(materi: Materi) {
                val intent = Intent(this@MateriActivity, DetailMateriActivity::class.java)
                intent.putExtra("materi", materi)
                startActivity(intent)
            }
        }
        adapter = MateriAdapter(clickListener)

        rvMateri!!.adapter = adapter
        rvMateri!!.layoutManager = LinearLayoutManager(this)
    }
}
