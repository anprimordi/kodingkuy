package um.informatika.kodingkuy.feature.kuis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori

class KategoriActivity : AppCompatActivity(), KategoriContract.View {

    override lateinit var presenter: KategoriContract.Presenter

    private lateinit var rvKategori: RecyclerView
    private lateinit var adapter: KategoriAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)

        presenter = KategoriPresenter(this)
        bindView()
    }

    //mengatur event saat list kuis sukses ditampilkan
    override fun onLoadListKuisSucceed(listKategori: List<Kategori>) {
        setSupportActionBar(toolbar)
        toolbar.title = "Kategori Kuis"

        rvKategori.setHasFixedSize(true)
        //menetapkan list kategori soal pada list data pada adapter
        adapter.setListData(listKategori)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    //mengikat view xml ke variabel kotlin
    private fun bindView() {
        toolbar = findViewById(R.id.toolbar_kategori)
        rvKategori = findViewById(R.id.toolbar_kategori)
        rvKategori.layoutManager = LinearLayoutManager(this)
        adapter = KategoriAdapter(this)
        rvKategori.adapter = adapter
    }
}
