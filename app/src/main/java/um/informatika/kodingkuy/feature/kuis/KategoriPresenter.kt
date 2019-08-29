package um.informatika.kodingkuy.feature.kuis

import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori

class KategoriPresenter internal constructor(private val view: KategoriContract.View) : KategoriContract.Presenter {
    override fun loadListKuis() {
        //memasukkan semua kategori soal ke dalam array list
        val listKategori = arrayListOf(
                Kategori(
                        1,
                        "Pemrograman Berbasis Objek",
                        R.drawable.ic_materi_java_colored_80dp,
                        R.array.array_soal_bab_1,
                        R.array.array_jawaban_kunci_bab_1,
                        R.array.array_jawaban_a_bab_1,
                        R.array.array_jawaban_b_bab_1,
                        R.array.array_jawaban_c_bab_1,
                        R.array.array_jawaban_d_bab_1),
                Kategori(
                        2,
                        "Pemrograman Web",
                        R.drawable.ic_materi_html_colored_80dp,
                        R.array.array_soal_bab_2,
                        R.array.array_jawaban_kunci_bab_2,
                        R.array.array_jawaban_a_bab_2,
                        R.array.array_jawaban_b_bab_2,
                        R.array.array_jawaban_c_bab_2,
                        R.array.array_jawaban_d_bab_2))

        //menampilkan list kategori soal saat fungsi ini dipanggil
        view.onLoadListKuisSucceed(listKategori)
    }

    override fun start() {
        loadListKuis()
    }
}