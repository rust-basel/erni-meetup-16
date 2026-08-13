package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "ODM")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Odm {

    @JacksonXmlProperty(localName = "ODMVersion", isAttribute = true)
    public String odmVersion;

    @JacksonXmlProperty(localName = "FileOID", isAttribute = true)
    public String fileOid;

    @JacksonXmlProperty(localName = "FileType", isAttribute = true)
    public String fileType;

    @JacksonXmlProperty(localName = "CreationDateTime", isAttribute = true)
    public String creationDateTime;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Study")
    public List<Study> studies;
}
