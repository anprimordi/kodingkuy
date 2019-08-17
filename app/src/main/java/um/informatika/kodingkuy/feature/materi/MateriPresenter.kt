package um.informatika.kodingkuy.feature.materi

import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Materi

class MateriPresenter(val view: MateriContract.View) : MateriContract.Presenter {
    override fun loadListMateri() {
        val listMateri = arrayListOf(
                Materi("Pengenalan Java", "Yuk mengenal pemrograman berbasis objek!", R.drawable.ic_java_colored_128dp, "modul_1.pdf"),
                Materi("Class", "Class merupakan wadah berisi objek yang beratribut", R.drawable.ic_object_colored_48dp, "modul_2.pdf"),
                Materi("Inheritance", "Pewarisan sifat parent class kepada child class", R.drawable.ic_inheritance_colored_128dp, "modul_3.pdf"),
                Materi("Encapsulation", "Membungkus method dan data layaknya kapsul", R.drawable.ic_encapsulation_colored_128dp, "modul_4.pdf"),
                Materi("Polymorphism", "Method sama, tipe objek berbeda", R.drawable.ic_polymorphism_colored_128dp, "modul_5.pdf"),
                Materi("Abstract Class dan Interface", "Keduanya digunakan sebagai basis suatu kelas", R.drawable.ic_abstract_colored_128dp, "modul_6.pdf"),
                Materi("Exception Handling", " Menangani kasus khusus: try ... catch ...", R.drawable.ic_exception_colored_128dp, "modul_7.pdf"))

        view.onLoadListMateriSucceed(listMateri)
    }

    override fun start() {
        loadListMateri()
    }
}