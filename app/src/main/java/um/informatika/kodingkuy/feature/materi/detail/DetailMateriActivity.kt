package um.informatika.kodingkuy.feature.materi.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import um.informatika.kodingkuy.R
import um.informatika.kodingkuy.model.Materi

class DetailMateriActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var textDetailSubtitle: TextView
    private lateinit var imageDetailMateri: ImageView
    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)

        bindView()

        val materi = intent.getParcelableExtra<Materi>("materi")

        setSupportActionBar(toolbar)

        toolbar.title = materi.title
        textDetailSubtitle.setText(materi.subtitle)
        imageDetailMateri.setImageResource(materi.imageSource)

        pdfView.fromAsset(materi.fileSource)
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeHorizontal(false)
                .pageFitPolicy(FitPolicy.BOTH)
                .spacing(0)
                .load()
    }

    private fun bindView() {
        toolbar = findViewById(R.id.toolbar_detail_materi)
        textDetailSubtitle = findViewById(R.id.text_detail_subtitle)
        imageDetailMateri = findViewById(R.id.image_detail_materi)
        pdfView = findViewById(R.id.pdf_view)
    }
}
