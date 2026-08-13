package bench;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import odm.Odm;
import odm.OdmMapper;

import java.nio.charset.StandardCharsets;

public class OdmSmokeTest {

    public static void main(String[] args) throws Exception {
        XmlMapper mapper = OdmMapper.create();
        String xmlData;
        try (var stream = OdmSmokeTest.class.getClassLoader().getResourceAsStream("test.xml")) {
            if (stream == null) {
                throw new IllegalStateException("test.xml not found on classpath");
            }
            xmlData = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }

        Odm odm = mapper.readValue(xmlData, Odm.class);
        System.out.println("ODMVersion: " + odm.odmVersion);
        System.out.println("FileOID: " + odm.fileOid);
        System.out.println("Studies: " + (odm.studies != null ? odm.studies.size() : 0));
        if (odm.studies != null && !odm.studies.isEmpty()) {
            var study = odm.studies.get(0);
            System.out.println("Study OID: " + study.oid);
            System.out.println("MetaDataVersions: " + (study.metaDataVersions != null ? study.metaDataVersions.size() : 0));
            if (study.metaDataVersions != null && !study.metaDataVersions.isEmpty()) {
                var mdv = study.metaDataVersions.get(0);
                System.out.println("MetaDataVersion OID: " + mdv.oid);
                System.out.println("ItemGroupDefs: " + (mdv.itemGroupDefs != null ? mdv.itemGroupDefs.size() : 0));
                System.out.println("ItemDefs: " + (mdv.itemDefs != null ? mdv.itemDefs.size() : 0));
                System.out.println("CodeLists: " + (mdv.codeLists != null ? mdv.codeLists.size() : 0));
                System.out.println("MethodDefs: " + (mdv.methodDefs != null ? mdv.methodDefs.size() : 0));
                System.out.println("CommentDefs: " + (mdv.commentDefs != null ? mdv.commentDefs.size() : 0));
                System.out.println("Leaves: " + (mdv.leaves != null ? mdv.leaves.size() : 0));
            }
        }

        String serialized = mapper.writeValueAsString(odm);
        System.out.println("Serialized length: " + serialized.length());
        System.out.println("Serialization OK");
    }
}
