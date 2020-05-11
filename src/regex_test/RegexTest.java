package regex_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.*;

public class RegexTest {
    public static void main(String[] args) {
        String dirPath = "/Users/mohammedjhossain/Desktop/Development/Regex/ExerciseInputFiles/";

        // Patterns for regex
        String regex1 = "fooa*bar"; // '*' finds if a word has 0 or more occurrences of the letter is it followed by. In this case 'a'.

        String regex2 = "foo.bar"; // '.' finds if there is any character (single)  in its position. In this case it will see if there is any letter between foo & bar.

        String regex3 = "foo.*bar"; // '.*' finds if there is 0 or more occurrences of characters in the position of '.'

        String regex4 = "foo\\s*bar"; // '\s' finds a single whitespace. '\s*' finds 0 or more occurrences of whitespace. *we are using '\\s' to escape the '\' in string. (Java Thing)

        String regex5 = "[fcl]oo"; // '[fcl]' finds if the letter f,c or l is in a single assigned position.

        String regex6 = "[fcdplb]oo"; // '[fcdplb]' finds if the letter f,c or l is in a single assigned position.

        String regex7 = "[^mh]oo"; // '[^mh]oo' find the words that doesn't have the letters m & h in the given position.

        String regex8 = "[j-m]oo"; // '[j-m]oo' finds a range from j to l (j, k, l & m) in the single given position.

        String regex9 = "[j-mz]oo"; // '[j-m]oo' finds a range from j to l (j, k, l, m & z) in the single given position.

        String regex10 = "[j-mJ-Mz]oo"; // '[j-mJ-Mz]' finds (j,k,l,m,J,K,L,M & z) in the single given position.

        /*
        regex11 matches any word that as 0 or more occurrences of 'x' followed by a '.' (period) followed by 0 or more occurrences of 'y'. '\.' represents '.'
        because . is a regex character as well we have to escape is i.e use a '\' before representing a '.' because it is not inside a [].
        In Java we escape the '\' with another '\' as '\' in Java has a meaning of its own as well.
         */
        String regex11 = "x*\\.y*";

        /*
        regex12 matches any string that is 'x#y', 'x:y' & 'x.y' as we use 'x[#:.]y'
         */
        String regex12 = "x[#:.]y";

        /*
        regex13 matches any string that is 'x#y', 'x:y' & 'x^y' as we use 'x[#:\\^]y'. We have to escape '^' with a '\' because it has a special meaning inside '[]'.
        In Java we escape the '\' with another '\' as '\' in Java has a meaning of its own as well.
         */
        String regex13 = "x[#:\\^]y";

        /*
        regex14 matches any string that is 'x#y', 'x:y' & 'x^y' as we use 'x[#\\\\\\^]y'. We have to escape '^' & '\' with a '\' because it has a special meaning inside '[]'.
        In Java we escape the '\' with another '\' as '\' in Java has a meaning of its own as well.
         */
        String regex14 = "x[#\\\\\\^]y";

        /*
        '^' INSIDE [] acts as an exclusion symbol, but OUTSIDE [] acts as a STARTS with symbol.
        '^foo.*' finds any line starting with 'foo' and has anything after it.
         */
        String regex15 = "^foo.*";

        /*
        '$' ENDS with symbol. '$' followed by any word will be tested if that line ends with that word.
        '.*bar$' finds any line that ends with the word 'bar'.
         */
        String regex16 = ".*bar$";

        String regex17 = "^foo$"; // finds a line with the only word 'foo'.

        String regex18 = "^[0-9]{3}$"; // finds any 3-digit number '{n}' is used to repeat 'n' number of times.

        String regex19 = "^[a-z]{4,6}$"; // find any work that is 4 to 6 letters long. '{least, most}'

        String regex20 = "^(ha){4,}$"; // matches the repetition of 'ha' at least 4 times or greater. '()' represents a charset.

        String regex21 = "^(ha){2}$"; // matches the repetition of 'ha' maximum 2 times. i.e 'ha' or 'haha'

        String regex22 = "^(foo)a+(bar)$"; // '+' symbol matches 1 or more occurrences of the char or charset following it. In this case 'a'

        String regex23 = "^(http)s?(://website)$"; // '?' symbol matches 0 or 1 occurrence of the char or charset following it. In this case 's'

        String regex24 = "^(log|ply)wood$"; // '|' is an or operator. In this case matches 'log' or 'ply'.


        // Creating a Regex Pattern
        // Pattern objName = Pattern.compile(regexPatternHere);
        Pattern rPattern = Pattern.compile(regex24);


        try{

            File txtFile = new File(dirPath + "regex24.txt");
            FileReader fileReader = new FileReader(txtFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {

                // Creating a regex matcher from our pattern
                Matcher match = rPattern.matcher(line);

                // checking if match.find(), if our match matches any line then print it.
                if(match.find()) {
                    System.out.println(line);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
