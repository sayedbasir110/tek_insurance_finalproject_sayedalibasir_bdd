package tek_insurance.bdd.utility;

public class HelperMethods {
    public static String getFieldXpath(String field){
        return "//label[text()='"+field+"']//following-sibling::input";
    }
    public static String getDropDownXpath(String dropDown){
        return "//label[text()='"+dropDown+"']//following-sibling::div//select";
    }
    public static String getAccountProfileDetailXpath(String detail){
        return "//p[text()='"+detail+"']//following-sibling::p";
    }
}
