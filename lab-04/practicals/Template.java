import java.util.regex.*;


public class Template {

    public static String fillTemplate(String template, String[] names, String[] values) {

        Pattern pa = Pattern.compile("\\{(\\w+)\\}");
        Matcher match= pa.matcher(template);

        StringBuilder result = new StringBuilder();
        int lastEnd = 0;

        while (match.find()) {

            result.append(template, lastEnd, match.start());

            String placeholder = match.group(1);
            String replacement = "[?]";

        
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }

            result.append(replacement);
            lastEnd = match.end();
        }
        result.append(template.substring(lastEnd));

        return result.toString();
    }
}