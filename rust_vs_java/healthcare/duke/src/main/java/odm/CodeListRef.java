package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeListRef {

    @JacksonXmlProperty(localName = "CodeListOID", isAttribute = true)
    public String codeListOid;
}
