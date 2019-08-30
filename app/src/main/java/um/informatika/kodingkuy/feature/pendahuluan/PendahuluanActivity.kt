package um.informatika.kodingkuy.feature.pendahuluan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_pendahuluan.*
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.feature.about.AboutActivity

class PendahuluanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendahuluan)

        text_pengembang.setOnClickListener { startActivity(Intent(this, AboutActivity::class.java)) }
    }
}
