package net.paulacr.webviewpdfreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    private val pdfUrl = "https://www.adobe.com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById<WebView>(R.id.webViewContainer).also {
            setupWebview()
        }

        readPdfButton.setOnClickListener {
            webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUrl")
       }
    }

    private fun setupWebview() {
        webViewContainer.settings.javaScriptEnabled = true
        webViewContainer.webViewClient = WebViewClient()
        webViewContainer.webChromeClient = WebChromeClient()
    }
}
