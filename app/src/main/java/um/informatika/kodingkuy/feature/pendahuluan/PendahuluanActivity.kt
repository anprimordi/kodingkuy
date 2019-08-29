package um.informatika.kodingkuy.feature.pendahuluan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.about.AboutActivity

class PendahuluanActivity : AppCompatActivity() {

    private lateinit var textPengembang: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendahuluan)

        textPengembang = findViewById(R.id.text_pengembang)

        textPengembang.setOnClickListener { startActivity(Intent(this, AboutActivity::class.java)) }
    }
}
