package um.informatika.kodingkuy.feature.kuis.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.ImageView
//import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog
import kotlinx.android.synthetic.main.activity_kuis.*
import kotlinx.android.synthetic.main.toolbar_kuis.*
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori
import um.informatika.kodingkuy.model.Kuis

class KuisActivity : AppCompatActivity() {

    private lateinit var kategori: Kategori
    private var index = -1
    private val kuisList = arrayListOf<Kuis>()
    private lateinit var toolbar: Toolbar
//    private lateinit var titleKuis: TextView
//    private lateinit var imageKuis: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)

        //mendapatkan intent kategori dari kategori activity
        kategori = intent.getParcelableExtra("kategori")

        bindView()
        //menyesuaikan title pada toolbar dengan judul materi
        setSupportActionBar(toolbar)

//        toolbar.title = kategori.title
        text_kuis_title.text = kategori.title
        image_kuis.setImageResource(kategori.image)

        with(view_flipper) {
            isAutoStart = false
            flipInterval = 500
        }

        buildKuis()

        //event saat tombol next dan back ditekan
        button_next.setOnClickListener { showNextKuis() }
        button_prev.setOnClickListener { showPrevKuis() }

        showNextKuis()
    }

    //method untuk membangun kuis
    private fun buildKuis() {
        //data binding pada komponen kuis
        val soal = resources.getStringArray(kategori.soal)
        val kunci = resources.getStringArray(kategori.jawabanKunci)
        val jwbnA = resources.getStringArray(kategori.jawabanA)
        val jwbnB = resources.getStringArray(kategori.jawabanB)
        val jwbnC = resources.getStringArray(kategori.jawabanC)
        val jwbnD = resources.getStringArray(kategori.jawabanD)

        //iterasi untuk mengisi index dari 0 hingga total jumlah soal
        for (i in 0 until soal.size) {
            val kuis = Kuis(
                    -1,
                    soal[i],
                    jwbnA[i],
                    jwbnB[i],
                    jwbnC[i],
                    jwbnD[i],
                    "",
                    kunci[i]
            )
            kuisList.add(kuis)
        }

        answer_group_1.setOnCheckedChangeListener { _, id ->
            val kuis = kuisList[index]

            //mengisi jawaban saat grup radiobutton diisi
            when (id) {
                R.id.answer_a_1 -> kuis.jawaban = "A"
                R.id.answer_b_1 -> kuis.jawaban = "B"
                R.id.answer_c_1 -> kuis.jawaban = "C"
                R.id.answer_d_1 -> kuis.jawaban = "D"
                else -> kuis.jawaban = ""
            }
        }

        answer_group_2.setOnCheckedChangeListener { _, id ->
            val kuis = kuisList[index]

            //mengisi jawaban saat grup radiobutton diisi
            when (id) {
                R.id.answer_a_2 -> kuis.jawaban = "A"
                R.id.answer_b_2 -> kuis.jawaban = "B"
                R.id.answer_c_2 -> kuis.jawaban = "C"
                R.id.answer_d_2 -> kuis.jawaban = "D"
                else -> kuis.jawaban = ""
            }
        }
    }

    //menampilkan soal berikutnya
    private fun showNextKuis() {
        //bila tombol next ditekan dan sudah melampaui boundary-nya maka akan memanggil method untuk menghitung dan menampilkan skor
        if (index + 1 >= kuisList.size) countAndShowScore()
        else {
            index++
            val kuis = kuisList[index]
            if (index % 2 == 0) {
                // soal ganjil
                text_number_1.text = String.format("%d.", index + 1)
                text_question_1.text = kuis.textSoal
                answer_a_1.text = kuis.jawabanA
                answer_b_1.text = kuis.jawabanB
                answer_c_1.text = kuis.jawabanC
                answer_d_1.text = kuis.jawabanD

                answer_group_1.check(
                        when (kuis.jawaban) {
                            "A" -> R.id.answer_a_1
                            "B" -> R.id.answer_b_1
                            "C" -> R.id.answer_c_1
                            "D" -> R.id.answer_d_1
                            else -> -1
                        }
                )
            } else {
                // soal genap
                text_number_2.text = String.format("%d.", index + 1)
                text_question_2.text = kuis.textSoal
                answer_a_2.text = kuis.jawabanA
                answer_b_2.text = kuis.jawabanB
                answer_c_2.text = kuis.jawabanC
                answer_d_2.text = kuis.jawabanD

                answer_group_2.check(
                        when (kuis.jawaban) {
                            "A" -> R.id.answer_a_2
                            "B" -> R.id.answer_b_2
                            "C" -> R.id.answer_c_2
                            "D" -> R.id.answer_d_2
                            else -> -1
                        }
                )
            }

            //menampilkan animasi saat tombol next ditekan
            view_flipper.setInAnimation(this, R.anim.in_from_right)
            view_flipper.setOutAnimation(this, R.anim.out_to_left)
            view_flipper.showNext()
        }
    }

    //menampilkan pertanyaan sebelumnya
    private fun showPrevKuis() {
        //bila tombol prev ditekan dan index kurang dari 0, maka tidak ada event yang terjadi
        if (index - 1 < 0) return
        index--
        val kuis = kuisList[index]
        if (index % 2 == 0) {
            // soal ganjil
            text_number_1.text = String.format("%d.", index + 1)
            text_question_1.text = kuis.textSoal
            answer_a_1.text = kuis.jawabanA
            answer_b_1.text = kuis.jawabanB
            answer_c_1.text = kuis.jawabanC
            answer_d_1.text = kuis.jawabanD

            answer_group_1.check(
                    when (kuis.jawaban) {
                        "A" -> R.id.answer_a_1
                        "B" -> R.id.answer_b_1
                        "C" -> R.id.answer_c_1
                        "D" -> R.id.answer_d_1
                        else -> -1
                    }
            )
        } else {
            // soal genap
            text_number_2.text = String.format("%d.", index + 1)
            text_question_2.text = kuis.textSoal
            answer_a_2.text = kuis.jawabanA
            answer_b_2.text = kuis.jawabanB
            answer_c_2.text = kuis.jawabanC
            answer_d_2.text = kuis.jawabanD

            answer_group_2.check(
                    when (kuis.jawaban) {
                        "A" -> R.id.answer_a_2
                        "B" -> R.id.answer_b_2
                        "C" -> R.id.answer_c_2
                        "D" -> R.id.answer_d_2
                        else -> -1
                    }
            )
        }

        //menampilkan animasi viewflipper saat tombol previous ditekan
        view_flipper.setInAnimation(this, R.anim.in_from_left)
        view_flipper.setOutAnimation(this, R.anim.out_to_right)
        view_flipper.showPrevious()
    }

    //menghitung dan menampilkan skor
    private fun countAndShowScore() {
        //inisialisasi variabel jawaban
        var jwbBenar = 0
        var jwbSalah = 0
        var jwbKosong = 0

        /*
        jika jawaban pengguna sesuai dengan kunci jawaban maka jwbBenar akan bertambah
        jika jawaban tidak diisi maka jwbKosong bertambah
        selain kedua kondisi di atas maka jwbSalah bertambah
        */
        for (kuis in kuisList) {
            when {
                kuis.jawaban == kuis.jawabanKunci -> jwbBenar++
                kuis.jawaban.isNullOrBlank() -> jwbKosong++
                else -> jwbSalah++
            }
        }

        //total skor adalah jawaban benar dikali 100 dibagi jumlah soal
        val skor = (jwbBenar * 100) / kuisList.size

        //merupakan suatu plug-in dialog dari Fancy Gif Dialog
        //dialog/pop-up akan akan menampilkan skor yang didapat serta rincian dari jawaban
        TTFancyGifDialog.Builder(this)
                .setTitle("Skor Kamu $skor")
                .setMessage("Kamu berhasil menyelesaikan kuis ini dengan " +
                        "$jwbBenar menjawab benar, " +
                        "$jwbSalah menjawab salah, dan" +
                        "$jwbKosong tidak menjawab.")
                .setGifResource(R.drawable.gif_congrats)
                .isCancellable(false)
                .setPositiveBtnText("Selesai")
                .setPositiveBtnBackground("#03A9F4")
                .setNegativeBtnText("Ulangi")
                .setNegativeBtnBackground("#8BC34A")
                .OnPositiveClicked { finish() }
                .OnNegativeClicked { recreate() }
                .build()
    }


    private fun bindView() {
        toolbar = findViewById(R.id.toolbar_kuis)
//        titleKuis = findViewById(R.id.text_kuis_title)
//        imageKuis = findViewById(R.id.image_kuis)
    }
}
