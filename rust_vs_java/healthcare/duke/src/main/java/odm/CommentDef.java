package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDef {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Description")
    public Description description;
}
