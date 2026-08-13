package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemGroupItemRef {

    @JacksonXmlProperty(localName = "ItemOID", isAttribute = true)
    public String itemOid;

    @JacksonXmlProperty(localName = "OrderNumber", isAttribute = true)
    public String orderNumber;

    @JacksonXmlProperty(localName = "Mandatory", isAttribute = true)
    public String mandatory;

    @JacksonXmlProperty(localName = "KeySequence", isAttribute = true)
    public String keySequence;

    @JacksonXmlProperty(localName = "Role", isAttribute = true)
    public String role;

    @JacksonXmlProperty(localName = "RoleCodeListOID", isAttribute = true)
    public String roleCodeListOid;

    @JacksonXmlProperty(localName = "MethodOID", isAttribute = true)
    public String methodOid;
}
