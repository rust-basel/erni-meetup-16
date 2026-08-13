package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeList {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    public String name;

    @JacksonXmlProperty(localName = "DataType", isAttribute = true)
    public String dataType;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CodeListItem")
    public List<CodeListItem> codeListItems;

    @JacksonXmlProperty(localName = "ExternalCodeList")
    public ExternalCodeList externalCodeList;
}
