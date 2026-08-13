package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MethodDef {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    public String name;

    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    public String methodType;

    @JacksonXmlProperty(localName = "Description")
    public Description description;
}
