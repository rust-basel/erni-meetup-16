package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDef {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    public String name;

    @JacksonXmlProperty(localName = "SASFieldName", isAttribute = true)
    public String sasFieldName;

    @JacksonXmlProperty(localName = "DataType", isAttribute = true)
    public String dataType;

    @JacksonXmlProperty(localName = "Length", isAttribute = true)
    public String length;

    @JacksonXmlProperty(localName = "def:DisplayFormat", isAttribute = true)
    public String displayFormat;

    @JacksonXmlProperty(localName = "def:CommentOID", isAttribute = true)
    public String commentOid;

    @JacksonXmlProperty(localName = "Description")
    public Description description;

    @JacksonXmlProperty(localName = "def:Origin")
    public Origin origin;

    @JacksonXmlProperty(localName = "CodeListRef")
    public CodeListRef codeListRef;

    @JacksonXmlProperty(localName = "def:ValueListRef")
    public ValueListRef valueListRef;
}
