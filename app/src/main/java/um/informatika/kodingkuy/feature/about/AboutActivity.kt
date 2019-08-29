package um.informatika.kodingkuy.feature.about

import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element
import um.informatika.kodingkuy.R
import java.util.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val aboutPage = AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.image_app_owner)
                .setDescription("Ahmad Nuftah Primordi\nS1 Teknik Informatika\nUniversitas Negeri Malang")
                .addItem(Element().setTitle("Version 1.0"))
                .addGroup("Connect with me!")
                .addEmail("ahmadnuftahprimordi@gmail.com")
                .addInstagram("a_primordi")
                .addGitHub("anprimordi")
                .addItem(createCopyright())
                .create()

        //activity ini tidak menggunakan layout xml namun menggunakan library medyo about page
        setContentView(aboutPage)
    }

    //membuat copyright dengan tahun terkini
    private fun createCopyright(): Element {
        val copyright = Element()
        val copyrightString = String.format(Locale.getDefault(), "Copyright © %d by Ahmad Nuftah Primordi", Calendar.getInstance().get(Calendar.YEAR))
        copyright.title = copyrightString
        copyright.icon = R.drawable.ic_launcher_foreground
        copyright.gravity = Gravity.CENTER
        copyright.onClickListener = View.OnClickListener { Toast.makeText(this@AboutActivity, copyrightString, Toast.LENGTH_SHORT).show() }

        return copyright
    }
}
