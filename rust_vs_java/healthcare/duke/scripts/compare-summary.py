import json
import sys


def load(path):
    with open(path) as f:
        return json.load(f)


def java_summary(d):
    mdv = d['studies'][0]['metaDataVersions'][0]
    return {
        'odmVersion': d['odmVersion'],
        'fileOid': d['fileOid'],
        'fileType': d['fileType'],
        'creationDateTime': d['creationDateTime'],
        'studyOid': d['studies'][0]['oid'],
        'metaDataVersionOid': mdv['oid'],
        'metaDataVersionName': mdv['name'],
        'itemGroupDefs': len(mdv['itemGroupDefs']),
        'itemDefs': len(mdv['itemDefs']),
        'codeLists': len(mdv['codeLists']),
        'methodDefs': len(mdv['methodDefs']),
        'commentDefs': len(mdv['commentDefs']),
        'leaves': len(mdv['leaves']),
        'firstItemGroupName': mdv['itemGroupDefs'][0]['name'],
        'firstItemGroupDescription': mdv['itemGroupDefs'][0]['description']['translatedText']['text'],
        'firstCodeListName': mdv['codeLists'][0]['name'],
        'firstMethodName': mdv['methodDefs'][0]['name'],
        'firstLeafId': mdv['leaves'][0]['id'],
    }


def rust_summary(d):
    mdv = d['Study'][0]['MetaDataVersion'][0]
    return {
        'odmVersion': d['@ODMVersion'],
        'fileOid': d['@FileOID'],
        'fileType': d['@FileType'],
        'creationDateTime': d['@CreationDateTime'],
        'studyOid': d['Study'][0]['@OID'],
        'metaDataVersionOid': mdv['@OID'],
        'metaDataVersionName': mdv['@Name'],
        'itemGroupDefs': len(mdv['ItemGroupDef']),
        'itemDefs': len(mdv['ItemDef']),
        'codeLists': len(mdv['CodeList']),
        'methodDefs': len(mdv['MethodDef']),
        'commentDefs': len(mdv['def:CommentDef']),
        'leaves': len(mdv['def:leaf']),
        'firstItemGroupName': mdv['ItemGroupDef'][0]['@Name'],
        'firstItemGroupDescription': mdv['ItemGroupDef'][0]['Description']['TranslatedText']['$text'],
        'firstCodeListName': mdv['CodeList'][0]['@Name'],
        'firstMethodName': mdv['MethodDef'][0]['@Name'],
        'firstLeafId': mdv['def:leaf'][0]['@ID'],
    }


if __name__ == '__main__':
    java = load(sys.argv[1])
    rust = load(sys.argv[2])
    js = java_summary(java)
    rs = rust_summary(rust)
    ok = True
    for k in js:
        if js[k] != rs[k]:
            print(f"MISMATCH {k}: java={js[k]} rust={rs[k]}")
            ok = False
    if ok:
        print("OK: Java and Rust produced equivalent parsed summaries")
    for k, v in js.items():
        print(f"  {k}: {v}")
