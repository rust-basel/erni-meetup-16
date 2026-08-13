package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RangeCheck {

    @JacksonXmlProperty(localName = "SoftHard", isAttribute = true)
    public String softHard;

    @JacksonXmlProperty(localName = "def:ItemOID", isAttribute = true)
    public String itemOid;

    @JacksonXmlProperty(localName = "Comparator", isAttribute = true)
    public String comparator;

    @JacksonXmlProperty(localName = "CheckValue")
    public String checkValue;
}
