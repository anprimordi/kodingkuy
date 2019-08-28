package um.informatika.kodingkuy.feature.materi

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Materi

class MateriActivity : AppCompatActivity(), MateriContract.View {

    override lateinit var presenter: MateriContract.Presenter
    private lateinit var toolbar: Toolbar
    private lateinit var rvMateri: RecyclerView
    private lateinit var msgEmpty: TextView
    private lateinit var adapter: MateriAdapter

    //event saat list materi berhasil ditampilkan, pesan kosong dihilangkan, recyclerview ditampilkan, lalu menetapkan list materi pada adapter
    override fun onLoadListMateriSucceed(listMateri: List<Materi>) {
        msgEmpty.visibility = View.GONE
        rvMateri.visibility = View.VISIBLE
        adapter.setListData(listMateri)
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

        toolbar.title = "Materi"
    }

    //mengikat view xml ke variabel kotlin
    private fun bindView() {
        toolbar = findViewById(R.id.toolbar_materi)
        msgEmpty = findViewById(R.id.text_empty_content)
        rvMateri = findViewById(R.id.rv_materi)

        adapter = MateriAdapter(this)

        rvMateri.adapter = adapter
        rvMateri.layoutManager = LinearLayoutManager(this)
    }
}
