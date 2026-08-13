package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueListItemRef {

    @JacksonXmlProperty(localName = "ItemOID", isAttribute = true)
    public String itemOid;

    @JacksonXmlProperty(localName = "OrderNumber", isAttribute = true)
    public String orderNumber;

    @JacksonXmlProperty(localName = "Mandatory", isAttribute = true)
    public String mandatory;

    @JacksonXmlProperty(localName = "MethodOID", isAttribute = true)
    public String methodOid;

    @JacksonXmlProperty(localName = "def:WhereClauseRef")
    public WhereClauseRef whereClauseRef;
}
