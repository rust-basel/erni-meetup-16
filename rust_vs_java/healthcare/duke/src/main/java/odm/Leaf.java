package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Leaf {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    public String id;

    @JacksonXmlProperty(localName = "xlink:href", isAttribute = true)
    public String href;

    @JacksonXmlProperty(localName = "def:title")
    public String title;
}
