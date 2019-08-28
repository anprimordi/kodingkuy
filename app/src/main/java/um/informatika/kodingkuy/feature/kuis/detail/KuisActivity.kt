package um.informatika.kodingkuy.feature.kuis.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog
import kotlinx.android.synthetic.main.activity_kuis.*
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Kategori
import um.informatika.kodingkuy.model.Kuis

class KuisActivity : AppCompatActivity() {

//    private lateinit var kategori: Kategori
//    private var index = -1
//    private val kuisList = arrayListOf<Kuis>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_kuis)
//
//        //mendapatkan intent kategori dari kategori activity
//        kategori = intent.getParcelableExtra("kategori")
//
//        supportActionBar?.title = kategori.nama
//
//        with(view_flipper) {
//            isAutoStart = false
//            flipInterval = 500
//        }
//
//        buildKuis()
//
//        //event saat tombol next dan back ditekan
//        button_next.setOnClickListener { showNextKuis() }
//        button_back.setOnClickListener { showPrevKuis() }
//    }
//
//    private fun buildKuis() {
//        //melakukan binding pada komponen kuis
//        val soal = resources.getStringArray(kategori.soal)
//        val kunci = resources.getStringArray(kategori.jawabanKunci)
//        val jwbnA = resources.getStringArray(kategori.jawabanA)
//        val jwbnB = resources.getStringArray(kategori.jawabanB)
//        val jwbnC = resources.getStringArray(kategori.jawabanC)
//        val jwbnD = resources.getStringArray(kategori.jawabanD)
//
//        //iterasi untuk mengisi index dari 1 hingga total jumlah soal
//        for (i in 0 until soal.size) {
//            val kuis = Kuis(
//                    -1,
//                    soal[i],
//                    jwbnA[i],
//                    jwbnB[i],
//                    jwbnC[i],
//                    jwbnD[i],
//                    "",
//                    kunci[i]
//            )
//
//            kuisList.add(kuis)
//        }
//
//        //mengisi jawaban saat grup radiobutton diisi
//        answer_group_1.setOnCheckedChangeListener { _, id ->
//            val kuis = kuisList[index]
//            when (id) {
//                R.id.answer_a_1 -> {
//                    kuis.jawabanA = "A"
//                }
//                R.id.answer_b_1 -> {
//                    kuis.jawabanB = "B"
//                }
//                R.id.answer_c_1 -> {
//                    kuis.jawabanC = "C"
//                }
//                R.id.answer_d_1 -> {
//                    kuis.jawabanD = "D"
//                }
//                else -> kuis.jawaban = ""
//            }
//        }
//
//        answer_group_2.setOnCheckedChangeListener { _, id ->
//            val kuis = kuisList[index]
//            when (id) {
//                R.id.answer_a_2 -> {
//                    kuis.jawabanA = "A"
//                }
//                R.id.answer_b_2 -> {
//                    kuis.jawabanB = "B"
//                }
//                R.id.answer_c_2 -> {
//                    kuis.jawabanC = "C"
//                }
//                R.id.answer_d_2 -> {
//                    kuis.jawabanD = "D"
//                }
//                else -> kuis.jawaban = ""
//            }
//        }
//    }
//
//    //menampilkan pertanyaan dan soal berikutnya
//    private fun showNextKuis() {
//        if (index + 1 >= kuisList.size) countAndShowScore()
//        else {
//            index++
//            //menyesuaikan kuis dengan nomor index saat ini
//            val kuis = kuisList[index]
//            if (index % 2 == 0) {
//                text_number_1.text = String.format("%d", index + 1)
//                text_question_1.text = kuis.textSoal
//                answer_a_1.text = kuis.jawabanA
//                answer_b_1.text = kuis.jawabanB
//                answer_c_1.text = kuis.jawabanC
//                answer_d_1.text = kuis.jawabanD
//
//                answer_group_1.check(
//                        when (kuis.jawaban) {
//                            "A" -> R.id.answer_a_1
//                            "B" -> R.id.answer_b_1
//                            "C" -> R.id.answer_c_1
//                            "D" -> R.id.answer_d_1
//                            else -> -1
//                        }
//                )
//            } else {
//                text_number_2.text = String.format("%d", index + 1)
//                text_question_2.text = kuis.textSoal
//                answer_a_2.text = kuis.jawabanA
//                answer_b_2.text = kuis.jawabanB
//                answer_c_2.text = kuis.jawabanC
//                answer_d_2.text = kuis.jawabanD
//
//                answer_group_2.check(
//                        when (kuis.jawaban) {
//                            "A" -> R.id.answer_a_1
//                            "B" -> R.id.answer_b_1
//                            "C" -> R.id.answer_c_1
//                            "D" -> R.id.answer_d_1
//                            else -> -1
//                        }
//                )
//            }
//
//            //menampilkan animasi saat tombol next ditekan
//            view_flipper.setInAnimation(this, R.anim.in_from_right)
//            view_flipper.setOutAnimation(this, R.anim.out_to_left)
//            view_flipper.showNext()
//        }
//    }
//
//    //menampilkan pertanyaan sebelumnya
//    private fun showPrevKuis() {
//        if (index - 1 < 0) return
//        index--
//        //menyesuaikan pertanyaan dengan nomor index saat ini
//        val kuis = kuisList[index]
//        if (index % 2 == 0) {
//            text_number_1.text = String.format("%d", index + 1)
//            text_question_1.text = kuis.textSoal
//            answer_a_1.text = kuis.jawabanA
//            answer_b_1.text = kuis.jawabanB
//            answer_c_1.text = kuis.jawabanC
//            answer_d_1.text = kuis.jawabanD
//
//            answer_group_1.check(
//                    when (kuis.jawaban) {
//                        "A" -> R.id.answer_a_1
//                        "B" -> R.id.answer_b_1
//                        "C" -> R.id.answer_c_1
//                        "D" -> R.id.answer_d_1
//                        else -> -1
//                    }
//            )
//        } else {
//            text_number_2.text = String.format("%d", index + 1)
//            text_question_2.text = kuis.textSoal
//            answer_a_2.text = kuis.jawabanA
//            answer_b_2.text = kuis.jawabanB
//            answer_c_2.text = kuis.jawabanC
//            answer_d_2.text = kuis.jawabanD
//
//            answer_group_2.check(
//                    when (kuis.jawaban) {
//                        "A" -> R.id.answer_a_1
//                        "B" -> R.id.answer_b_1
//                        "C" -> R.id.answer_c_1
//                        "D" -> R.id.answer_d_1
//                        else -> -1
//                    }
//            )
//        }
//
//        //menampilkan animasi saat tombol back ditekan
//        view_flipper.setInAnimation(this, R.anim.in_from_left)
//        view_flipper.setOutAnimation(this, R.anim.out_to_right)
//        view_flipper.showPrevious()
//    }
//
//    //hitung dan tampilkan skor yang didapat
//    private fun countAndShowScore() {
//        //pertama set semua jawaban menjadi 0
//        var jwbBenar = 0
//        var jwbSalah = 0
//        var jwbKosong = 0
//
//        //iterasi untuk mendapatkan jawaban yang benar, jawaban yang salah, dan pertanyaan yang tidak yang terjawab
//        for (kuis in kuisList) {
//            when {
//                kuis.jawaban == kuis.jawabanKunci -> jwbBenar++
//                kuis.jawaban.isNullOrBlank() -> jwbKosong++
//                else -> jwbSalah++
//            }
//        }
//
//        //rumus skor yang didapat
//        val skor = (jwbBenar * 100) / kuisList.size
//
//        //merupakan model dialog (pop-up) dari library fancy gif dialog
//        //menampilkan dialog yang berisi skor dan jawaban
//        TTFancyGifDialog.Builder(this)
//                .setTitle("Skor kamu $skor")
//                .setMessage("Kamu berhasil menyelesaikan kuis ini dengan " +
//                        "$jwbBenar menjawab benar, " +
//                        "$jwbSalah menjawab salah, dan " +
//                        "$jwbKosong tidak dijawab.")
//                .setGifResource(R.drawable.gif_congrats)
//                .isCancellable(false)
//                .setPositiveBtnText("Selesai")
//                .setPositiveBtnBackground("#0325ff")
//                .setNegativeBtnText("Ulangi")
//                .setNegativeBtnBackground("#ff0266")
//                .OnPositiveClicked { finish() }
//                .OnNegativeClicked { recreate() }
//                .build()
//    }

    private lateinit var kategori: Kategori
    private var index = -1
    private val kuisList = arrayListOf<Kuis>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)

        kategori = intent.getParcelableExtra("kategori")

        supportActionBar?.title = kategori.nama

        with(view_flipper) {
            isAutoStart = false
            flipInterval = 500
        }

        prepareKuis()

        button_next.setOnClickListener { showNextKuis() }
        button_back.setOnClickListener { showPrevKuis() }

        showNextKuis()
    }

    private fun prepareKuis() {
        val soal = resources.getStringArray(kategori.soal)
        val kunci = resources.getStringArray(kategori.jawabanKunci)
        val jwbnA = resources.getStringArray(kategori.jawabanA)
        val jwbnB = resources.getStringArray(kategori.jawabanB)
        val jwbnC = resources.getStringArray(kategori.jawabanC)
        val jwbnD = resources.getStringArray(kategori.jawabanD)

        for (i in 0 until soal.size) {
            val kuis = Kuis(
                    -1, soal[i],
                    jwbnA[i], jwbnB[i], jwbnC[i],
                    jwbnD[i], "", kunci[i]
            )
            kuisList.add(kuis)
        }

        answer_group_1.setOnCheckedChangeListener { _, id ->
            val kuis = kuisList[index]
            when (id) {
                R.id.answer_a_1 -> {
                    kuis.jawaban = "A"
//                    showNextKuis()
                }
                R.id.answer_b_1 -> {
                    kuis.jawaban = "B"
//                    showNextKuis()
                }
                R.id.answer_c_1 -> {
                    kuis.jawaban = "C"
//                    showNextKuis()
                }
                R.id.answer_d_1 -> {
                    kuis.jawaban = "D"
//                    showNextKuis()
                }
                else -> kuis.jawaban = ""
            }
        }
        answer_group_2.setOnCheckedChangeListener { _, id ->
            val kuis = kuisList[index]
            when (id) {
                R.id.answer_a_2 -> {
                    kuis.jawaban = "A"
//                    showNextKuis()
                }
                R.id.answer_b_2 -> {
                    kuis.jawaban = "B"
//                    showNextKuis()
                }
                R.id.answer_c_2 -> {
                    kuis.jawaban = "C"
//                    showNextKuis()
                }
                R.id.answer_d_2 -> {
                    kuis.jawaban = "D"
//                    showNextKuis()
                }
                else -> kuis.jawaban = ""
            }
        }
    }

    private fun showNextKuis() {
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

            view_flipper.setInAnimation(this, R.anim.in_from_right)
            view_flipper.setOutAnimation(this, R.anim.out_to_left)
            view_flipper.showNext()
        }
    }

    private fun showPrevKuis() {
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

        view_flipper.setInAnimation(this, R.anim.in_from_left)
        view_flipper.setOutAnimation(this, R.anim.out_to_right)
        view_flipper.showPrevious()
    }

    private fun countAndShowScore() {
        var jwbBenar = 0
        var jwbSalah = 0
        var jwbKosong = 0

        for (kuis in kuisList) {
            when {
                kuis.jawaban == kuis.jawabanKunci -> jwbBenar++
                kuis.jawaban.isNullOrBlank() -> jwbKosong++
                else -> jwbSalah++
            }
        }
        val skor = (jwbBenar * 100) / kuisList.size

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
}
