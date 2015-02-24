package com.myanmarunicodearea.zawni.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*	Zawgyi<>Unicode converter java class
 *  Based on rules from Parabaik Myanmar Text Converter
 *  https://github.com/ngwestar/parabaik/blob/master/scripts/zg12uni51.js
 *	Copyright (C) 2014 Ngwe Tun (Solveware Solution)
 *	Copyright (C) 2014 Ye Mon Kyaw
 *
 *	Based on Paytan java module class by Thura Hlaing
 *  https://gist.github.com/trhura/b60ff85937d79812ddff
 * 
 */
public class Zawgyi2Unicode {
    public Zawgyi2Unicode() {

    }

    /**
     * This method is created by Thura Hlaing. And it is a part of Paytan
     * project.
     *
     * @param input_text - String (it must be Zawgyi encoded text string)
     * @return - String (Unicode encoded text string will be return)
     */

    public static String zg12uni51(String input_text) {
        String output_text = input_text;
        output_text = output_text.replaceAll("\\u106a", "\u1009");
        output_text = output_text.replaceAll("\\u1025(?=[\\u1039\\u102c])",
                "\u1009");
        output_text = output_text.replaceAll("\\u1025\\u102e", "\u1026");
        output_text = output_text.replaceAll("\\u106b", "\u100a");
        output_text = output_text.replaceAll("\\u1090", "\u101b");
        output_text = output_text.replaceAll("\\u1040", "\u1040");
        output_text = output_text.replaceAll("\\u108f", "\u1014");
        output_text = output_text.replaceAll("\\u1012", "\u1012");
        output_text = output_text.replaceAll("\\u1013", "\u1013");
        output_text = output_text.replaceAll("[\\u103d\\u1087]", "\u103e");//medial ha converted
        output_text = output_text.replaceAll("\\u103c", "\u103d");//medial wa converted
        output_text = output_text.replaceAll(
                "[\\u103b\\u107e\\u107f\\u1080\\u1081\\u1082\\u1083\\u1084]",
                "\u103c"); // medial ra converted
        output_text = output_text.replaceAll("[\\u103a\\u107d]", "\u103b");//medial ya converted
        output_text = output_text.replaceAll("\\u103d\\u103b", "\u103b\u103d"); //reorder medial (wa + ya) to (ya + wa)
        output_text = output_text.replaceAll("\\u108a", "\u103d\u103e"); //zawgyi medial (wa + ha) to Uni medial(wa + ha)
        output_text = output_text.replaceAll("\\u103e\\u103d", "\u103d\u103e"); // reorder medial (ha + wa) to (wa + ha)
        //kinzi
        output_text = output_text.replaceAll(
                "((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u1064",
                "\u1064$1$2$3");
        output_text = output_text.replaceAll(
                "((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108b",
                "\u1064$1$2$3\u102d");
        output_text = output_text.replaceAll(
                "((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108c",
                "\u1064$1$2$3\u102e");
        output_text = output_text.replaceAll(
                "((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108d",
                "\u1064$1$2$3\u1036");
        //end kizi but now its zawgyi kinzi !!
        output_text = output_text.replaceAll("\\u105a", "\u102b\u103a");
        output_text = output_text.replaceAll("\\u108e", "\u102d\u1036");
        output_text = output_text.replaceAll("\\u1033", "\u102f");
        output_text = output_text.replaceAll("\\u1034", "\u1030");
        output_text = output_text.replaceAll("\\u1088", "\u103e\u102f"); // medial ha + vowel u converted
        output_text = output_text.replaceAll("\\u1089", "\u103e\u1030");
        output_text = output_text.replaceAll("\\u1039", "\u103a");
        output_text = output_text.replaceAll("[\\u1094\\u1095]", "\u1037");
        output_text = output_text
                .replaceAll(
                        "([\\u1000-\\u1021])([\\u102c\\u102d\\u102e\\u1032\\u1036]){1,2}([\\u1060\\u1061\\u1062\\u1063\\u1065\\u1066\\u1067\\u1068\\u1069\\u1070\\u1071\\u1072\\u1073\\u1074\\u1075\\u1076\\u1077\\u1078\\u1079\\u107a\\u107b\\u107c\\u1085])",
                        "$1$3$2");
        output_text = output_text.replaceAll("\\u1064", "\u1004\u103a\u1039");
        output_text = output_text.replaceAll("\\u104e",
                "\u104e\u1004\u103a\u1038");
        output_text = output_text.replaceAll("\\u1086", "\u103f");
        output_text = output_text.replaceAll("\\u1060", "\u1039\u1000");
        output_text = output_text.replaceAll("\\u1061", "\u1039\u1001");
        output_text = output_text.replaceAll("\\u1062", "\u1039\u1002");
        output_text = output_text.replaceAll("\\u1063", "\u1039\u1003");
        output_text = output_text.replaceAll("\\u1065", "\u1039\u1005");
        output_text = output_text
                .replaceAll("[\\u1066\\u1067]", "\u1039\u1006");
        output_text = output_text.replaceAll("\\u1068", "\u1039\u1007");
        output_text = output_text.replaceAll("\\u1069", "\u1039\u1008");
        output_text = output_text.replaceAll("\\u106c", "\u1039\u100b");
        output_text = output_text.replaceAll("\\u1070", "\u1039\u100f");
        output_text = output_text
                .replaceAll("[\\u1071\\u1072]", "\u1039\u1010");
        output_text = output_text
                .replaceAll("[\\u1073\\u1074]", "\u1039\u1011");
        output_text = output_text.replaceAll("\\u1075", "\u1039\u1012");
        output_text = output_text.replaceAll("\\u1076", "\u1039\u1013");
        output_text = output_text.replaceAll("\\u1077", "\u1039\u1014");
        output_text = output_text.replaceAll("\\u1078", "\u1039\u1015");
        output_text = output_text.replaceAll("\\u1079", "\u1039\u1016");
        output_text = output_text.replaceAll("\\u107a", "\u1039\u1017");
        output_text = output_text.replaceAll("\\u107b", "\u1039\u1018");
        output_text = output_text.replaceAll("\\u107c", "\u1039\u1019");
        output_text = output_text.replaceAll("\\u1085", "\u1039\u101c");
        output_text = output_text.replaceAll("\\u106d", "\u1039\u100c");
        output_text = output_text.replaceAll("\\u1091", "\u100f\u1039\u100d");
        output_text = output_text.replaceAll("\\u1092", "\u100b\u1039\u100c");
        output_text = output_text.replaceAll("\\u1097", "\u100b\u1039\u100b");
        output_text = output_text.replaceAll("\\u106f", "\u100d\u1039\u100e");
        output_text = output_text.replaceAll("\\u106e", "\u100d\u1039\u100d");
        output_text = output_text.replaceAll(
                "(\\u103c)([\\u1000-\\u1021])((?:\\u1039[\\u1000-\\u1021])?)",
                "$2$3$1");
        output_text = output_text.replaceAll(
                "(\\u103e)(\\u103d)([\\u103b\\u103c])", "$3$2$1"); // medial (ha + wa + (ya or ra) to (ya or ra)+ wa + ha
        output_text = output_text.replaceAll("(\\u103e)([\\u103b\\u103c])", // medial (ha + (ya or ra)) to (ya or ra) + ha
                "$2$1");
        output_text = output_text.replaceAll("(\\u103d)([\\u103b\\u103c])", // medial (wa + ( ya or ra)) to (ya or ra) + wa
                "$2$1");
        // hour: minute sign ":" autorrect added
        output_text = output_text.replaceAll(
                "([\\u1040-\\u1049])\\u1038([\\u1040-\\u1049])", "$1\u003a$2");
        output_text = output_text
                .replaceAll(
                        "(?<=[\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103e\\u104c-\\u109f])(\\u1040)((?=\\s))?",
                        "\u101d");
        //Add zero conditional autocorrect to consonants wa
        output_text = output_text
                .replaceAll(
                        "(?<![\\u1040-\\u1049])(\\u1040)(?=[\\u1000-\\u101c\\u101e-\u102c\\u102e-\\u103e\\u104c-\\u109f])",
                        "\u101d");
        output_text = output_text.replaceAll("(?<=(\\u101d))(\\u1040)((?=\\s))?", "\u101d");
        output_text = output_text
                .replaceAll(
                        "(?<=([\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103e\\u104c-\\u109f\\s]))(\\u1047)",
                        "\u101b");
        output_text = output_text
                .replaceAll(
                        "(\\u1047)(?=[\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103e\\u104c-\\u109f\\s])",
                        "\u101b");
        output_text = output_text
                .replaceAll(
                        "((?:\\u1031)?)([\\u1000-\\u1021])((?:\\u1039[\\u1000-\\u1021])?)((?:[\\u102d\\u102e\\u1032])?)([\\u1036\\u1037\\u1038]{0,2})([\\u103b-\\u103e]{0,3})((?:[\\u102f\\u1030])?)([\\u1036\\u1037\\u1038]{0,2})((?:[\\u102d\\u102e\\u1032])?)",
                        "$2$3$6$1$4$9$7$5$8");// reorder to cons+medial+vowel+final
        output_text = output_text.replaceAll("\\u1036\\u102f", "\u102f\u1036");
        output_text = output_text.replaceAll("(\\u103a)(\\u1037)", "$2$1");
        //add more Spelling AutoCorrect
        output_text = output_text.replaceAll("(\\u102f)(\\u102d)", "$2$1");
        output_text = output_text.replaceAll("([\\u102d\\u102e])(\\u103e)", "$2$1");
        output_text = output_text.replaceAll("([\\u102d\\u102e])([\\u102d\\u102e])", "$2");
        output_text = output_text.replaceAll("\\u103a\\u103a", "\u103a");

        return output_text;
    }

    static public boolean isUnicodeCheck(String input_text) {
        Pattern uniPattern = Pattern
                .compile("[ဃငဆဇဈဉညဋဌဍဎဏဒဓနဘရဝဟဠအ]်|ျ[က-အ]ါ|ျ[ါ-း]|[^\u1031]စ်|\u103e|\u103f|\u1031[^\u1000-\u1021\u103b\u1040\u106a\u106b\u107e-\u1084\u108f\u1090]|\u1031$|\u1031[က-အ]\u1032|\u1025\u102f|\u103c\u103d[\u1000-\u1001]|ည်း|ျင်း|င်|န်း|ျာ|[ာ်ါ]တ်|ြို");
        Matcher uniMatcher = uniPattern.matcher(input_text);
        return uniMatcher.find();
    }

    static public boolean isZawgyiCheck(String input_text) {

        Pattern zgPattern = Pattern
                .compile("\u0020[\u103b\u107e-\u1084][က-အ]|\u0020\u1031[က-အ\u1040]|\u1031\u1005\u103A|"
                        + " ေ[က-အ]်|[က-အ]း|\u1031\u1047");

        Matcher zgMatcher = zgPattern.matcher(input_text);

        return zgMatcher.find();
    }

    static public String autoConverted(String input_text) {
        if (!isUnicodeCheck(input_text))
            return zg12uni51(input_text);
        return input_text;
    }

}
