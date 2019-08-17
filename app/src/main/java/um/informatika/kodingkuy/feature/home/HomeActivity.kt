package um.informatika.kodingkuy.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.info.InfoActivity
import um.informatika.kodingkuy.feature.pendahuluan.PendahuluanActivity
import um.informatika.kodingkuy.feature.kuis.KuisActivity
import um.informatika.kodingkuy.feature.materi.MateriActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var cardPendahuluan: CardView
    private lateinit var cardInfo: CardView
    private lateinit var cardMateri: CardView
    private lateinit var cardKuis: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        val cardPendahuluan = findViewById<CardView>(R.id.menu_pendahuluan)
//        val cardInfo = findViewById<CardView>(R.id.menu_info)
//        val cardMateri = findViewById<CardView>(R.id.menu_materi)
//        val cardKuis = findViewById<CardView>(R.id.menu_kuis)

        bindView()

        cardPendahuluan.setOnClickListener { startActivity(Intent(this, PendahuluanActivity::class.java)) }
        cardInfo.setOnClickListener { startActivity(Intent(this, InfoActivity::class.java)) }
        cardMateri.setOnClickListener { startActivity(Intent(this, MateriActivity::class.java)) }
        cardKuis.setOnClickListener { startActivity(Intent(this, KuisActivity::class.java)) }
    }

    private fun bindView() {
        cardPendahuluan = findViewById(R.id.menu_pendahuluan)
        cardInfo = findViewById(R.id.menu_info)
        cardMateri = findViewById(R.id.menu_materi)
        cardKuis = findViewById(R.id.menu_kuis)
    }
}
