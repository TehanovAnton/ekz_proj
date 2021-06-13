package classes.functiontag;

public class FunctionTag {
    public static boolean checkCustomTagAttrNotEmpty(Object textAttr){
        return !((String)textAttr).equals("");
    }
}
