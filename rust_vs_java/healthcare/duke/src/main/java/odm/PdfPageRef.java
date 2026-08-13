package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PdfPageRef {

    @JacksonXmlProperty(localName = "PageRefs", isAttribute = true)
    public String pageRefs;

    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    public String pageRefType;
}
