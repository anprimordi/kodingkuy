package um.informatika.kodingkuy.feature.materi

import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Materi

class MateriPresenter(private val view: MateriContract.View) : MateriContract.Presenter {
    //memuat list materi
    override fun loadListMateri() {
        //memasukkan semua materi soal ke dalam array list
        val listMateri = arrayListOf(
                Materi("Pengenalan Java", "Yuk mengenal pemrograman berbasis objek!", R.drawable.ic_materi_java_colored_80dp, "modul_1.pdf"),
                Materi("Class", "Class merupakan wadah berisi objek yang beratribut", R.drawable.ic_materi_class_colored_80dp, "modul_2.pdf"),
                Materi("Inheritance", "Pewarisan sifat parent class kepada child class", R.drawable.ic_materi_inheritance_colored_80dp, "modul_3.pdf"),
                Materi("Encapsulation", "Membungkus method dan data", R.drawable.ic_materi_encapsulation_colored_80dp, "modul_4.pdf"),
                Materi("Polymorphism", "Method sama, tipe objek berbeda", R.drawable.ic_materi_polymorphism_colroed_80dp, "modul_5.pdf"),
                Materi("Abstract Class dan Interface", "Keduanya digunakan sebagai basis suatu kelas", R.drawable.ic_materi_abstract_colored_80dp, "modul_6.pdf"),
                Materi("Exception Handling", " Menangani kasus khusus: try ... catch ...", R.drawable.ic_materi_exception_colored_80dp, "modul_7.pdf"),
                Materi("Dasar-dasar HTML", "Yuk belajar pemrograman web!", R.drawable.ic_materi_html_colored_80dp, "modul_8.pdf"),
                Materi("Komponen HTML Lanjut", "Link, tabel, dan form", R.drawable.ic_materi_link_colored_80dp, "modul_9.pdf"),
                Materi("Validasi HTML5", "Belum punya akun?", R.drawable.ic_materi_validation_colored_80dp, "modul_10.pdf"),
                Materi("Cascading Style Sheet", "CSS 3 untuk penataan estetika layout web", R.drawable.ic_css_colored_80dp, "modul_11.pdf"),
                Materi("Desain Web CSS", "Mendesain web menarik menggunakan CSS", R.drawable.ic_materi_design_colored_80dp, "modul_12.pdf"),
                Materi("Desain Web Responsif", "Untuk ukuran komputer atau mobile? No problem!", R.drawable.ic_materi_responsive_colored_80dp, "modul_13.pdf"),
                Materi("Dasar-dasar PHP", "PHP-in web, jangan yang lain!", R.drawable.ic_materi_php_colored_80dp, "modul_14.pdf"),
                Materi("Pemrosesan Form", "Apa yang terjadi pada formulir anda?", R.drawable.ic_materi_form_colored_80dp, "modul_15.pdf"),
                Materi("Cookie dan Session", "Simpan cookies dan session tanpa perlu login lagi", R.drawable.ic_materi_cookies_colored_80dp, "modul_16.pdf"))

        //menampilkan list materi saat fungsi ini dipanggil
        view.onLoadListMateriSucceed(listMateri)
    }

    override fun start() {
        loadListMateri()
    }
}