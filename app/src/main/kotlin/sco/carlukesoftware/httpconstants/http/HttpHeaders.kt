package sco.carlukesoftware.httpconstants.http

import android.content.Context
import androidx.annotation.StringRes
import sco.carlukesoftware.httpconstants.R

/**
 * A utility class that provides constants for common HTTP header names.
 *
 * This class serves as a central repository for HTTP header names,
 * making it easier to work with headers throughout the application.
 * It provides both the header name as a string and an optional
 * Android string resource ID for localization.
 */
class HttpHeaders {

    /**
     * A list of all defined header names.
     */
    val ALL_HEADERS = listOf(
        ACCEPT, ACCEPT_CHARSET, ACCEPT_ENCODING, ACCEPT_LANGUAGE, AUTHORIZATION,
        CACHE_CONTROL, CONNECTION, CONTENT_LENGTH, CONTENT_TYPE, COOKIE, DATE,
        ETAG, EXPECT, EXPIRES, HOST, IF_MATCH, IF_MODIFIED_SINCE, IF_NONE_MATCH,
        IF_UNMODIFIED_SINCE, LAST_MODIFIED, LOCATION, ORIGIN, PRAGMA, REFERER,
        SERVER, SET_COOKIE, TRANSFER_ENCODING, UPGRADE, USER_AGENT, VARY, VIA,
        WARNING, WWW_AUTHENTICATE
    )

    /**
     * Provides utility methods and constants related to HTTP headers.
     *
     * This companion object encapsulates functionalities for retrieving header names,
     * either directly as string resources or as a fallback to a default "UNKNOWN" value.
     * It also provides a set of common HTTP header names as string resource IDs,
     * which can be resolved using the `getString` method.
     */
    companion object {
        /**
         * Gets the header name as a string, optionally resolving it from resources.
         *
         * @param context The Android context for resource resolution.
         * @param stringResId The string resource ID for the header name.
         * @return The header name as a string.
         */
        fun getString(
            context: Context? = null,
            @StringRes stringResId: Int? = null
        ): String {
            return if (context != null && stringResId != null) {
                context.getString(stringResId)
            } else {
                "<UNKNOWN HEADER>"
            }
        }

        // Common HTTP header names
        val ACCEPT = R.string.accept
        val ACCEPT_CHARSET = R.string.accept_charset
        val ACCEPT_ENCODING = R.string.accept_encoding
        val ACCEPT_LANGUAGE = R.string.accept_language
        val AUTHORIZATION = R.string.authorization
        val CACHE_CONTROL = R.string.cache_control
        val CONNECTION = R.string.connection
        val CONTENT_LENGTH = R.string.content_length
        val CONTENT_TYPE = R.string.content_type
        val COOKIE = R.string.cookie
        val DATE = R.string.date
        val ETAG = R.string.etag
        val EXPECT = R.string.expect
        val EXPIRES = R.string.expires
        val HOST = R.string.host
        val IF_MATCH = R.string.if_match
        val IF_MODIFIED_SINCE = R.string.if_modified_since
        val IF_NONE_MATCH = R.string.if_none_match
        val IF_UNMODIFIED_SINCE = R.string.if_unmodified_since
        val LAST_MODIFIED = R.string.last_modified
        val LOCATION = R.string.location
        val ORIGIN = R.string.origin
        val PRAGMA = R.string.pragma
        val REFERER = R.string.referer
        val SERVER = R.string.server
        val SET_COOKIE = R.string.set_cookie
        val TRANSFER_ENCODING = R.string.transfer_encoding
        val UPGRADE = R.string.upgrade
        val USER_AGENT = R.string.user_agent
        val VARY = R.string.vary
        val VIA = R.string.via
        val WARNING = R.string.warning
        val WWW_AUTHENTICATE = R.string.www_authenticate
    }
}
