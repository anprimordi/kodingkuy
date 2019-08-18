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
                .setDescription(R.string.app_description.toString())
                .addItem(Element().setTitle("Version " + R.string.app_version))
                .addGroup(R.string.text_connect_with_me.toString())
                .addEmail(R.string.text_email.toString())
                .addFacebook(R.string.app_owner.toString())
                .addInstagram(R.string.text_instagram.toString())
                .addGitHub(R.string.text_github.toString())
                .addItem(createCopyright())
                .create()

        setContentView(aboutPage)
    }

    private fun createCopyright(): Element {
        val copyright = Element()
        val copyrightString = String.format(Locale.getDefault(), R.string.msg_copyright.toString(), Calendar.getInstance().get(Calendar.YEAR))
        copyright.title = copyrightString
        copyright.icon = R.mipmap.ic_launcher_round
        copyright.gravity = Gravity.CENTER
        copyright.onClickListener = View.OnClickListener { Toast.makeText(this@AboutActivity, copyrightString, Toast.LENGTH_SHORT).show() }

        return copyright
    }
}
