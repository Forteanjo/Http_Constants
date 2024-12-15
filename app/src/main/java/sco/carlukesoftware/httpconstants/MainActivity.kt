package sco.carlukesoftware.httpconstants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import sco.carlukesoftware.httpconstants.ui.theme.HttpConstantsTheme
import sco.carlukesoftware.ktor.http.HttpHeaders
import sco.carlukesoftware.ktor.http.HttpStatusCodes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HttpConstantsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HttpTesterApp(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HttpTesterApp(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val companionObject = HttpHeaders.Companion
    val httpHeaders = companionObject::class.declaredMemberProperties
        .map { property ->
            property.isAccessible = true
            property.name to context.getString(property.getter.call(companionObject) as Int) //to (property.get()?.toString() ?: "null")
        }

    val httpStatusCodes = HttpStatusCodes::class.java.fields
        .map { field ->
            field.name to (field.get(null)?.toString() ?: "null")
        }

    LazyColumn(
        modifier = modifier
    ) {
        // HTTP Headers Section
        item {
            SectionHeader(
                title = "HTTP Headers"
            )
        }

        items(
            items = httpHeaders,
            key = {
                it
            }
        ) { (name, value) ->
            ListItem(
                name = name,
                value = value.toString()
            )
        }

        // HTTP Status Codes Section
        item {
            SectionHeader(
                title = "HTTP Status Codes"
            )
        }

        items(
            items = httpStatusCodes,
            key = {
                it.first
            }
        ) { (name, value) ->
            ListItem(
                name = name,
                value = value
            )
        }

    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(
                vertical = 8.dp
            )
    )
}

@Composable
fun ListItem(name: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = value,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HttpConstantsTheme {
        Greeting("Android")
    }
}
