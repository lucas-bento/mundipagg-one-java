package Utility.XmlConverter

import com.thoughtworks.xstream.converters.Converter
import com.thoughtworks.xstream.converters.MarshallingContext
import com.thoughtworks.xstream.converters.UnmarshallingContext
import com.thoughtworks.xstream.io.HierarchicalStreamReader
import com.thoughtworks.xstream.io.HierarchicalStreamWriter

/**
 * Conversor de dados tipo float
 */
class FloatConverter : Converter {

    override fun canConvert(type: Class<Any>): Boolean {
        return type == Float::class.java
    }

    override fun marshal(value: Any?, writer: HierarchicalStreamWriter,
                         context: MarshallingContext) {
        if (value != null && value.toString().trim { it <= ' ' }.length > 0) {
            writer.setValue(value.toString())
        }
    }

    override fun unmarshal(reader: HierarchicalStreamReader,
                           context: UnmarshallingContext): Any? {
        try {
            val value = reader.value
            if (value == null || value.trim { it <= ' ' }.length == 0) {
                return null
            } else {
                return java.lang.Float.valueOf(value)
            }
        } catch (e: Exception) {
            return null
        }

    }
}
