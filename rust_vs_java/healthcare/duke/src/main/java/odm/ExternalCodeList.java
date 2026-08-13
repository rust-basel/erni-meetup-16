package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalCodeList {

    @JacksonXmlProperty(localName = "Dictionary", isAttribute = true)
    public String dictionary;

    @JacksonXmlProperty(localName = "Version", isAttribute = true)
    public String version;
}
