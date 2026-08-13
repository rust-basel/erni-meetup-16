package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

    @JacksonXmlProperty(localName = "TranslatedText")
    public TranslatedText translatedText;
}
