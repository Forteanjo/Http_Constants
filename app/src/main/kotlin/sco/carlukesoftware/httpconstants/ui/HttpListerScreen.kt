package sco.carlukesoftware.httpconstants.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import sco.carlukesoftware.httpconstants.http.HttpHeaders
import sco.carlukesoftware.httpconstants.http.HttpStatus
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * Composable function that displays a list of HTTP headers and HTTP status codes.
 *
 * This screen is divided into two main sections:
 * 1. **HTTP Headers:** This section lists common HTTP headers and their descriptions.
 *    The data for this section is extracted from the application's resources using [extractHttpHeaders].
 * 2. **HTTP Status Codes:** This section lists common HTTP status codes and their meanings.
 *    The data for this section is obtained using [extractHttpStatusCodes].
 *
 * The screen uses a [LazyColumn] to efficiently render the list, improving performance
 * when dealing with potentially long lists. Each header and status code is displayed
 * as a [ListItem] within its respective section, separated by a [SectionHeader].
 *
 * @param modifier Modifier for styling the root composable.
 *
 * @see extractHttpHeaders
 * @see extractHttpStatusCodes
 * @see SectionHeader
 * @see ListItem
 */
@Composable
fun HttpListerScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // 1. Extract Header Data
    val httpHeaders = extractHttpHeaders(context)

    // 2. Extract Status Code Data
    val httpStatusCodes = extractHttpStatusCodes()

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
                it.first
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

/**
 * Extracts HTTP headers from a class (assumed to be `HttpHeaders.Companion`) based on resource IDs.
 *
 * This function retrieves all properties of type `Int` within the `HttpHeaders.Companion` class.
 * It treats these properties as resource IDs pointing to string resources. For each such property,
 * it retrieves the string resource using the provided `Context` and constructs a key-value pair
 * representing an HTTP header, where the key is the property's name and the value is the string
 * obtained from the resource.
 *
 * **Error Handling:**
 *  - If a property's value is not a valid resource ID, `context.getString(resourceId)` might throw a `Resources.NotFoundException`. This exception is not handled within the function, and the caller should handle it if necessary.
 *
 * **Reflection:**
 * This function uses reflection to access the properties of `HttpHeaders.Companion`.
 *
 * **Visibility:**
 * It sets each property to be accessible via `property.isAccessible = true`.
 *
 * @param context The Android `Context` used to retrieve string resources.
 * @return A list of `Pair<String, String>`, where each pair represents an HTTP header. The first element
 *         of the pair is the header name (the property name), and the second is the header value
 *         (the string from the resource).
 * @throws Resources.NotFoundException if any of resource Ids isn't found in resources.
 */
private fun extractHttpHeaders(context: Context): List<Pair<String, String>> =
    HttpHeaders.Companion::class.declaredMemberProperties
        .filter { property ->
            property.returnType.classifier == Int::class
        } // Only process Int properties (resource IDs)
        .map { property ->
            property.isAccessible = true
            val resourceId = property.getter.call(HttpHeaders.Companion) as Int
            property.name to context.getString(resourceId)
        }

/**
 * Extracts HTTP status codes and their corresponding names from the `HttpStatus` class.
 *
 * This function reflects on the `HttpStatus` class, finds its static integer fields (which represent
 * HTTP status codes), and then creates a list of pairs where each pair consists of:
 *
 * 1. The name of the HTTP status code field (e.g., "OK", "NOT_FOUND").
 * 2. The string representation of the integer value of the HTTP status code (e.g., "200", "404").
 *
 * **Note:** This function relies on reflection to access the fields of the `HttpStatus` class.
 * It modifies the accessibility of the fields to make them accessible, which could be
 * considered a less conventional approach in typical Java/Kotlin development.
 *
 * **Example:**
 * If `HttpStatus.OK` is defined as `public static final int OK = 200;`
 * and `HttpStatus.NOT_FOUND` is defined as `public static final int NOT_FOUND = 404;`
 * This function would return a list similar to:
 * `[Pair("OK", "200"), Pair("NOT_FOUND", "404"), ...]` (other status codes)
 *
 * @return A list of pairs, where each pair contains the name of an HTTP status code and its string representation.
 */
private fun extractHttpStatusCodes(): List<Pair<String, String>> =
    HttpStatus::class.java.fields
        .filter { it.type == Int::class.java } // Only process Int fields
        .map { field ->
            field.isAccessible = true
            field.name to field.get(null).toString()
        }


/**
 * Composable function to display a section header.
 *
 * This function renders a styled Text composable to serve as a header for a section within a layout.
 * It utilizes the MaterialTheme's `titleMedium` typography with bold font weight and adds padding for visual separation.
 *
 * @param title The text content of the section header.
 * @param modifier Modifier to be applied to the Text composable for layout customization.
 *                 Defaults to an empty Modifier.
 */
@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme
            .typography
            .titleMedium
            .copy(
                fontWeight = FontWeight.Bold
            ),
        modifier = modifier
            .padding(
                vertical = 16.dp,
                horizontal = 16.dp
            )
    )
}

/**
 * A composable function that displays a single item in a list, showing a name and a corresponding value.
 *
 * This function arranges the name and value in a row with space between them,
 * utilizing MaterialTheme's typography for styling.
 *
 * @param name The name or label to display on the left side of the row.
 * @param value The corresponding value to display on the right side of the row.
 */
@Composable
fun ListItem(
    name: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement
            .SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme
                .typography
                .bodyLarge
        )

        Text(
            text = value,
            style = MaterialTheme
                .typography
                .bodyMedium,
            textAlign = TextAlign
                .End
        )
    }
}
