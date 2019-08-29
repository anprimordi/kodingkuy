package um.informatika.kodingkuy.feature.home

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_home.*
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.about.AboutActivity
import um.informatika.kodingkuy.feature.kuis.KategoriActivity
import um.informatika.kodingkuy.feature.materi.MateriActivity
import um.informatika.kodingkuy.feature.pendahuluan.PendahuluanActivity
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var cardPendahuluan: CardView
    private lateinit var cardAbout: CardView
    private lateinit var cardMateri: CardView
    private lateinit var cardKuis: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bindView()

        //mengatur event saat menu diklik
        cardPendahuluan.setOnClickListener { startActivity(Intent(this, PendahuluanActivity::class.java)) }
        cardAbout.setOnClickListener { startActivity(Intent(this, AboutActivity::class.java)) }
        cardMateri.setOnClickListener { startActivity(Intent(this, MateriActivity::class.java)) }
        cardKuis.setOnClickListener { startActivity(Intent(this, KategoriActivity::class.java)) }

        text_copyright.text = String.format(Locale.getDefault(), "Copyright © %d by Ahmad Nuftah Primordi", Calendar.getInstance().get(Calendar.YEAR))
    }

    //mengikat view xml ke variabel kotlin
    private fun bindView() {
        cardPendahuluan = findViewById(R.id.card_pendahuluan)
        cardAbout = findViewById(R.id.card_about)
        cardMateri = findViewById(R.id.card_materi)
        cardKuis = findViewById(R.id.card_kuis)
    }
}
