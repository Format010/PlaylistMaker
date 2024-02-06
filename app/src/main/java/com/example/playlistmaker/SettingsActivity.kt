package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val back = findViewById<View>(R.id.back)
        val share = findViewById<View>(R.id.buttonShare)
        val support = findViewById<View>(R.id.buttonMailToSupport)
        val userAgreement = findViewById<View>(R.id.buttonUserAgr)

        share.setOnClickListener{
            val textShare = getString(R.string.messageShare)
            val shareApp = Intent()
            shareApp.action = Intent.ACTION_SEND
            shareApp.type = "text/plain"
            shareApp.putExtra(Intent.EXTRA_TEXT, textShare)
            startActivity(Intent.createChooser(shareApp, getString(R.string.shareWith)))
        }

        back.setOnClickListener{
            onBackPressed()
        }
        support.setOnClickListener{
            val subject = getString(R.string.subjectMailto)
            val message = getString(R.string.bodyMailto)
            val email = getString(R.string.emailMailto)
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            supportIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(supportIntent)
        }
        userAgreement.setOnClickListener{
            val agreement = getString(R.string.userAgreement)
            val userAgreementUrl = Intent(Intent.ACTION_VIEW, Uri.parse(agreement))
            startActivity(userAgreementUrl)
        }
    }
}