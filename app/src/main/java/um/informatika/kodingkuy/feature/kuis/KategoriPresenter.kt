package um.informatika.kodingkuy.feature.kuis

import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori

class KategoriPresenter internal constructor(private val view: KategoriContract.View) : KategoriContract.Presenter {
    override fun showListKuis() {
        val listKategori = arrayListOf(
                Kategori(
                        1,
                        "Pemrograman berbasis objek",
                        R.array.array_soal_bab_1,
                        R.array.array_jawaban_kunci_bab_1,
                        R.array.array_jawaban_a_bab_1,
                        R.array.array_jawaban_b_bab_1,
                        R.array.array_jawaban_c_bab_1,
                        R.array.array_jawaban_d_bab_1))

        view.showListKuisSucceed(listKategori)
    }

    override fun start() {
        showListKuis()
    }
}