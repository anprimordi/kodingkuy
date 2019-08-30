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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //mengatur event saat menu diklik
        card_pendahuluan.setOnClickListener { startActivity(Intent(this, PendahuluanActivity::class.java)) }
        card_about.setOnClickListener { startActivity(Intent(this, AboutActivity::class.java)) }
        card_materi.setOnClickListener { startActivity(Intent(this, MateriActivity::class.java)) }
        card_kuis.setOnClickListener { startActivity(Intent(this, KategoriActivity::class.java)) }

        text_copyright.text = String.format(Locale.getDefault(), "%d by Ahmad Nuftah Primordi", Calendar.getInstance().get(Calendar.YEAR))
    }
}
