package odm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLInputFactory2;

import javax.xml.stream.XMLInputFactory;

public final class OdmMapper {

    private OdmMapper() {
    }

    public static XmlMapper create() {
        XMLInputFactory factory = XMLInputFactory2.newFactory();
        // Disable namespace awareness so element prefixes stay attached to the local name.
        // This mirrors serde-xml-rs' behaviour of matching names like "def:CommentDef".
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);

        XmlMapper mapper = new XmlMapper(factory);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, false);
        return mapper;
    }
}
