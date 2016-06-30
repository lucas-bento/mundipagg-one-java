package ResourceClients

import DataContracts.PostNotification.StatusNotification
import EnumTypes.HttpContentTypeEnum
import Utility.SerializeUtility

/**
 * Recurso para post de notificação
 */
class PostNotificationResource {

    /**
     * Converte XML de Post de Notificação em Objeto
     * @param xml
     * *
     * @return
     */
    fun parseFromXML(xml: String): StatusNotification? {
        // Inicia objeto de serialização e deserialização para efetuar parse
        val serializerResponse = SerializeUtility<StatusNotification>()
        val statusNotification = serializerResponse.Deserializer(StatusNotification::class.java, xml, HttpContentTypeEnum.Xml)
        return statusNotification
    }
}
