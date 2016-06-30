package Utility.XmlConverter

import DataContracts.ServiceConstants
import com.thoughtworks.xstream.converters.Converter
import com.thoughtworks.xstream.converters.MarshallingContext
import com.thoughtworks.xstream.converters.UnmarshallingContext
import com.thoughtworks.xstream.io.HierarchicalStreamReader
import com.thoughtworks.xstream.io.HierarchicalStreamWriter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.GregorianCalendar

/**
 * Conversor de data
 */
class DateConverter : Converter {

    private val formatter = SimpleDateFormat(ServiceConstants.DATE_TIME_FORMAT)

    override fun canConvert(clazz: Class<Any>): Boolean {
        return Date::class.java.isAssignableFrom(clazz)
    }

    override fun marshal(value: Any, writer: HierarchicalStreamWriter,
                         context: MarshallingContext) {
        val date = value as Date
        writer.setValue(formatter.format(date))
    }

    override fun unmarshal(reader: HierarchicalStreamReader,
                           context: UnmarshallingContext): Any? {
        val calendar = GregorianCalendar()
        try {
            calendar.time = formatter.parse(reader.value)
        } catch (e: ParseException) {
            return null
        }

        return calendar.time
    }
}
