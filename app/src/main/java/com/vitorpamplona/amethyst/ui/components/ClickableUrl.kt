package com.vitorpamplona.amethyst.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString

@Composable
fun ClickableUrl(urlText: String, url: String) {
    val uri = LocalUriHandler.current

    val doubleCheckedUrl = if (url.contains("://")) url else "https://$url"

    ClickableText(
        text = AnnotatedString(urlText),
        onClick = { runCatching { uri.openUri(doubleCheckedUrl) } },
        style = LocalTextStyle.current.copy(color = MaterialTheme.colors.primary)
    )
}
