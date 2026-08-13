package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeListItem {

    @JacksonXmlProperty(localName = "CodedValue", isAttribute = true)
    public String codedValue;

    @JacksonXmlProperty(localName = "Rank", isAttribute = true)
    public String rank;

    @JacksonXmlProperty(localName = "Decode")
    public Decode decode;
}
