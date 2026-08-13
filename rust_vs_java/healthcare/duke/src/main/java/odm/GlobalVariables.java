package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalVariables {

    @JacksonXmlProperty(localName = "StudyName")
    public String studyName;

    @JacksonXmlProperty(localName = "StudyDescription")
    public String studyDescription;

    @JacksonXmlProperty(localName = "ProtocolName")
    public String protocolName;
}
