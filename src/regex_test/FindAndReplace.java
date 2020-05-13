package regex_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplace {
    public static void main(String[] args) {
        String dirPath = "/Users/mohammedjhossain/Desktop/Development/Regex/ExerciseInputFiles/";

        String regex25 = "([0-9]+)x([0-9]+)"; // '\1 or \n' in Linux AND 'match.group(n)' in Java represent the group of characters inside the '()'

        String regex26 = "([a-zA-Z]+)\\s([a-zA-Z]+)";

        String regex27 = "([0-9]{1,2}):([0-9]{2})";

        String regex28 = "[0-9]{3}\\.[0-9]{3}\\.([0-9]{4})"; // '\.' represents '.' we use '\\.' for Java

        // Creating a Regex Pattern
        // Pattern objName = Pattern.compile(regexPatternHere);
        Pattern rPattern = Pattern.compile(regex28);


        try{

            File txtFile = new File(dirPath + "regex28.txt");
            FileReader fileReader = new FileReader(txtFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {

                // Creating a regex matcher from our pattern
                Matcher match = rPattern.matcher(line);

                // checking if match.find(), if our match matches any line then print it.
                if(match.find()) {

                    // match.replaceAll() methods helps us to replace the text before printing and match.group(n) takes the group i.e '()s'
                    line = match.replaceAll("xxx.xxx." + match.group(1));
                    System.out.println(line);
                }

            }

            reader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
