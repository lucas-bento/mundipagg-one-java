package Utility

import org.apache.http.HttpRequest
import org.apache.http.HttpResponse
import org.apache.http.ProtocolException
import org.apache.http.impl.client.DefaultRedirectStrategy
import org.apache.http.protocol.HttpContext

/**
 * Permitir redirecionamento
 */
class RedirectRoles : DefaultRedirectStrategy() {

    @Throws(ProtocolException::class)
    override fun isRedirected(hr: HttpRequest, hr1: HttpResponse, hc: HttpContext?): Boolean {
        return hr1.statusLine.statusCode >= 300 && hr1.statusLine.statusCode <= 300
    }
}
