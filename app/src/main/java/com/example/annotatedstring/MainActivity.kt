package com.example.annotatedstring

import android.R.attr.onClick
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.annotatedstring.ui.theme.AnnotatedStringTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextWithLink(context = this)
        }
    }
}

@Composable
fun TextWithLink(context: Context){


    val linkStyle = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)
    val mContext = LocalContext.current


    val annotatedString = buildAnnotatedString {
        withLink(LinkAnnotation.Clickable(tag = "",
            linkInteractionListener = { mContext.startActivity(Intent(mContext, SecondActivity::class.java))},
            styles = TextLinkStyles(style = linkStyle) )) {
            append("Urban")
        }
        append(" University")
    }
    Text(annotatedString, fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 100.dp, start = 20.dp))
}

