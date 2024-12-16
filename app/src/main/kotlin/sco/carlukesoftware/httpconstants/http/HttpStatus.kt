package sco.carlukesoftware.httpconstants.http

/**
 * A comprehensive collection of HTTP status codes, organized for clarity and ease of use.
 *
 * This object provides constants for common HTTP status codes, enhancing code readability
 * and maintainability when dealing with network responses.
 */
object HttpStatus {

    /**
     * 1xx Informational
     *
     * These status codes indicate a provisional response, consisting only of the Status-Line and
     * optional headers, and is terminated by an empty line.
     *
     * Note: These are not commonly used in typical client-server interactions.
     */
    object Informational {
        // Example: 100 Continue, 101 Switching Protocols, etc.
        // Add more if needed
    }

    /**
     * 2xx Success
     *
     * This class of status codes indicates that the client's request was successfully received,
     * understood, and accepted.
     */
    object Success {
        /**
         * The request has succeeded.
         */
        const val OK = 200

        /**
         * The request has been fulfilled, and a new resource has been created as a result.
         */
        const val CREATED = 201

        /**
         * The request has been accepted for processing, but the processing has not been completed.
         */
        const val ACCEPTED = 202

        /**
         * The server has fulfilled the request but does not need to return an entity-body.
         */
        const val NO_CONTENT = 204
    }

    /**
     * 3xx Redirection
     *
     * This class of status code indicates that further action needs to be taken by the user agent
     * in order to fulfill the request.
     */
    object Redirection {
        /**
         * The requested resource has been assigned a new permanent URI.
         */
        const val MOVED_PERMANENTLY = 301

        /**
         * The requested resource resides temporarily under a different URI.
         */
        const val FOUND = 302

        /**
         * The response to the request can be found under a different URI and should be retrieved
         * using a GET method on that resource.
         */
        const val SEE_OTHER = 303

        /**
         * Indicates that the resource has not been modified since the version specified by the
         * request headers If-Modified-Since or If-None-Match.
         */
        const val NOT_MODIFIED = 304

        /**
         * The requested resource resides temporarily under a different URI.
         */
        const val TEMPORARY_REDIRECT = 307

        /**
         * The requested resource has been assigned a new permanent URI.
         */
        const val PERMANENT_REDIRECT = 308
    }

    /**
     * 4xx Client Error
     *
     * The 4xx class of status code is intended for cases in which the client seems to have erred.
     */
    object ClientError {
        /**
         * The server cannot or will not process the request due to something that is perceived to be a client error.
         */
        const val BAD_REQUEST = 400

        /**
         * The request has not been applied because it lacks valid authentication credentials for the target resource.
         */
        const val UNAUTHORIZED = 401

        /**
         * The server understood the request but refuses to authorize it.
         */
        const val FORBIDDEN = 403

        /**
         * The server has not found anything matching the Request-URI.
         */
        const val NOT_FOUND = 404

        /**
         * The method specified in the Request-Line is not allowed for the resource identified by the Request-URI.
         */
        const val METHOD_NOT_ALLOWED = 405

        /**
         * The resource identified by the request is only capable of generating response entities which have content
         * characteristics not acceptable according to the accept headers sent in the request.
         */
        const val NOT_ACCEPTABLE = 406

        /**
         * The client must first authenticate itself with the proxy.
         */
        const val PROXY_AUTHENTICATION_REQUIRED = 407

        /**
         * The client did not produce a request within the time that the server was prepared to wait.
         */
        const val REQUEST_TIMEOUT = 408

        /**
         * The request could not be completed due to a conflict with the current state of the resource.
         */
        const val CONFLICT = 409

        /**
         * The requested resource is no longer available at the server and no forwarding address is known.
         */
        const val GONE = 410

        /**
         * The server refuses to accept the request without a defined Content-Length.
         */
        const val LENGTH_REQUIRED = 411

        /**
         * One or more conditions given in the request header fields evaluated to false when tested on the server.
         */
        const val PRECONDITION_FAILED = 412

        /**
         * The server is refusing to process a request because the request entity is larger than the server is willing or
         * able to process.
         */
        const val PAYLOAD_TOO_LARGE = 413

        /**
         * The server is refusing to service the request because the Request-URI is longer than the server is willing to
         * interpret.
         */
        const val URI_TOO_LONG = 414

        /**
         * The server is refusing to service the request because the entity of the request is in a format not supported
         * by the requested resource for the requested method.
         */
        const val UNSUPPORTED_MEDIA_TYPE = 415

        /**
         * The server cannot serve the requested byte range.
         */
        const val RANGE_NOT_SATISFIABLE = 416

        /**
         * The server could not meet the expectation given in the Expect request header.
         */
        const val EXPECTATION_FAILED = 417

        /**
         * I'm a teapot (April Fools' joke).
         */
        const val IM_A_TEAPOT = 418

        /**
         * The request was directed at a server that is not able to produce a response.
         */
        const val MISDIRECTED_REQUEST = 421

        /**
         * The request was well-formed but was unable to be followed due to semantic errors.
         */
        const val UNPROCESSABLE_ENTITY = 422

        /**
         * The source or destination resource of a method is locked.
         */
        const val LOCKED = 423

        /**
         * The method could not be performed on the resource because the requested action depended on another action and
         * that action failed.
         */
        const val FAILED_DEPENDENCY = 424

        /**
         * The server is unwilling to risk processing a request that might be replayed.
         */
        const val TOO_EARLY = 425

        /**
         * The client should switch to a different protocol.
         */
        const val UPGRADE_REQUIRED = 426

        /**
         * The origin server requires the request to be conditional.
         */
        const val PRECONDITION_REQUIRED = 428

        /**
         * The user has sent too many requests in a given amount of time.
         */
        const val TOO_MANY_REQUESTS = 429

        /**
         * The server is unwilling to process the request because its header fields are too large.
         */
        const val REQUEST_HEADER_FIELDS_TOO_LARGE = 431

        /**
         * The server is denying access to the resource as a consequence of a legal demand.
         */
        const val UNAVAILABLE_FOR_LEGAL_REASONS = 451
    }

    /**
     * 5xx Server Error
     *
     * The server failed to fulfill an apparently valid request.
     */
    object ServerError {
        /**
         * The server encountered an unexpected condition that prevented it from fulfilling the request.
         */
        const val INTERNAL_SERVER_ERROR = 500

        /**
         * The server does not support the functionality required to fulfill the request.
         */
        const val NOT_IMPLEMENTED = 501

        /**
         * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it
         * accessed in attempting to fulfill the request.
         */
        const val BAD_GATEWAY = 502

        /**
         * The server is currently unable to handle the request due to a temporary overloading or maintenance of the
         * server.
         */
        const val SERVICE_UNAVAILABLE = 503

        /**
         * The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server
         * specified by the URI.
         */
        const val GATEWAY_TIMEOUT = 504

        const val HTTP_VERSION_NOT_SUPPORTED = 505 // HTTP Version Not Supported
        const val VARIANT_ALSO_NEGOTIATES = 506 // Variant Also Negotiates
        const val INSUFFICIENT_STORAGE = 507 // Insufficient Storage
        const val LOOP_DETECTED = 508 // Loop Detected
        const val NOT_EXTENDED = 510 // Not Extended
        const val NETWORK_AUTHENTICATION_REQUIRED = 511 // Network Authentication Required
    }
}
