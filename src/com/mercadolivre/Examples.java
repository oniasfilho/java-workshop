package com.mercadolivre;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;

public class Examples {

    public static void testIndent(){
        String text = "Hello World! \n This is testing a Java 12 feature.";
        System.out.println(text);

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);
    }

    public static void testTransform(){
        String text = "Onias";
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString());

        System.out.println(transformed);
    }

    public static void testFileMismatchForIdenticalFiles(){
        try {
            Path filePath1 = Files.createTempFile("file1", "txt");
            Path filePath2 = Files.createTempFile("file2", "txt");
            Files.writeString(filePath1, "Teste Java 12");
            Files.writeString(filePath2, "Teste Java 12");

            long mismatch = Files.mismatch(filePath1, filePath2);

            System.out.println(mismatch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFileMismatchForDifferentFiles(){
        try {
            Path filePath1 = Files.createTempFile("file1", "txt");
            Path filePath2 = Files.createTempFile("file2", "txt");
            Files.writeString(filePath1, "Teste Java 12");
            Files.writeString(filePath2, "Teste Java 17+");

            long mismatch = Files.mismatch(filePath1, filePath2);

            System.out.println(mismatch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testMultipleCaseLabelsForSwitchExpressions(int number){
        String result = "";
        switch (number) {
            case 1, 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4, 5, 6:
                result = "four or five or six";
                break;
            default:
                    result = "unknown";
        };

        System.out.println(result);
    }

    public static void testReturnWithoutBreak(int number){
        String result = switch (number) {
            case 1,2 -> "one or two";
            default -> "one and two were the only options :)";
        };

        System.out.println(result);
    }

    public static void testCompactNumberFormatting(long number) {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(number));

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong.format(number));
    }

    public static String testSwitchUsingYield(int input){
        return switch(input){
            case 1, 2 -> {
                yield "one or two";
            }
            default -> "one and two were the only options :)";
        };
    }

    public static void testTextBlocks(){
        String JSON_STRING
                = "{\r\n" + "\"name\" : \"Onias\",\r\n" + "\"website\" : \"https://www.whatever.com/\"\r\n" + "}";
        System.out.println(JSON_STRING);

        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Onias",
                    "website" : "https://www.whatever.com/"
                }""";
        System.out.println(TEXT_BLOCK_JSON);
    }


}
