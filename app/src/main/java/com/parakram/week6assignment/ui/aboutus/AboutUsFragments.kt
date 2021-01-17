package com.parakram.week6assignment.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.parakram.week6assignment.R
import com.parakram.week6assignment.ui.aboutus.AboutUsViewModel as AboutUsViewModel1

class AboutUsFragments : Fragment() {

    private lateinit var notificationsViewModel: AboutUsViewModel1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(AboutUsViewModel1::class.java)
        val root = inflater.inflate(R.layout.fragments_about_us, container, false)

        val webView: WebView = root.findViewById(R.id.webView)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {

            val url = "https://softwarica.edu.np/"
            webView.loadUrl(url)
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }
            }
        })
        return root
    }
}


