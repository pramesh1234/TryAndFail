package com.app.tryandfail.presentation.screen.detailScreen.components

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrailerPostView(videoUrl:String?=null,postUrl:String?=null) {
    Box(modifier = Modifier) {
        Log.d("TAG", "TrailerPostView: $videoUrl")
        if (false) {
            Column {
                WebViewCompose(videoUrl!!)
            }

        }else{
            GlideImage(model = postUrl , contentDescription = "Poster",  modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth().height(300.dp), contentScale = ContentScale.Crop)
        }
    }
}


@Composable
fun WebViewCompose(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}
