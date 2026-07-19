package basic.String;

public class StringDemo {

    public static void main(String[] args) {

        // ==========================================================
        // STRING METHODS
        // ==========================================================

        // Creating Strings
        String str = "ahello lavesh here";
        String str2 = "Bhello";

        // Displaying original strings
        System.out.println("String 1: " + str);
        System.out.println("String 2: " + str2);

        // ----------------------------------------------------------
        // charAt()
        // Returns the character at the specified index.
        // ----------------------------------------------------------
        System.out.println("Character at index 1 in str: " + str.charAt(1));
        // Output: h

        // ----------------------------------------------------------
        // codePointAt()
        // Returns the Unicode (ASCII) value of the character.
        // ----------------------------------------------------------
        System.out.println("Unicode value of character at index 0 in str2: " + str2.codePointAt(0));
        // Output: 66 ('B')

        // ----------------------------------------------------------
        // substring()
        // Returns a portion of the string.
        // ----------------------------------------------------------
        System.out.println("Substring excluding last character: "
                + str.substring(0, str.length() - 1));
        // Output: ahello lavesh her

        // ----------------------------------------------------------
        // compareTo()
        // Compares two strings lexicographically.
        //
        // Negative -> first string is smaller
        // Positive -> first string is greater
        // Zero     -> both strings are equal
        // ----------------------------------------------------------
        System.out.println("Comparison of str and str2: " + str.compareTo(str2));

        // ----------------------------------------------------------
        // endsWith()
        // Checks whether the string ends with the given suffix.
        // ----------------------------------------------------------
        System.out.println("Does str end with \"here\"? : " + str.endsWith("here"));
        // Output: true

        // ----------------------------------------------------------
        // contains()
        // Checks whether the string contains a sequence.
        // ----------------------------------------------------------
        System.out.println("Does str contain \"lavesh\"? : " + str.contains("lavesh"));
        // Output: true

        // ----------------------------------------------------------
        // replace()
        // Replaces one sequence with another.
        // ----------------------------------------------------------
        System.out.println("Replacing \"lavesh\" with str2: "
                + str.replace("lavesh", str2));
        // Output: ahello Bhello here

        // ----------------------------------------------------------
        // replaceAll()
        // Replaces using Regular Expressions (Regex).
        // ----------------------------------------------------------
        System.out.println("Replacing entire string with str2: "
                + str.replaceAll(str, str2));
        // Output: Bhello

        // ----------------------------------------------------------
        // toUpperCase()
        // ----------------------------------------------------------
        System.out.println("Uppercase: " + str.toUpperCase());
        // Output: AHELLO LAVESH HERE

        // ----------------------------------------------------------
        // toLowerCase()
        // ----------------------------------------------------------
        System.out.println("Lowercase: " + str2.toLowerCase());
        // Output: bhello

        // ----------------------------------------------------------
        // trim()
        // Removes leading and trailing spaces.
        // ----------------------------------------------------------
        String strWithSpaces = "   Hello World   ";

        System.out.println("Trimmed String: " + strWithSpaces.trim());
        // Output: Hello World

        // ----------------------------------------------------------
        // isEmpty()
        // Returns true if length is 0.
        // ----------------------------------------------------------
        String emptyString = "";

        System.out.println("Is Empty? : " + emptyString.isEmpty());
        // Output: true

        // ----------------------------------------------------------
        // length()
        // Returns number of characters.
        // ----------------------------------------------------------
        System.out.println("Length of str: " + str.length());
        // Output: 18

        // ----------------------------------------------------------
        // split()
        // Splits the string into an array.
        // ----------------------------------------------------------
        String[] words = str.split(" ");

        System.out.println("Words after split():");

        for (String word : words) {
            System.out.println(word);
        }

        // Output:
        // ahello
        // lavesh
        // here

        // ==========================================================
        // STRINGBUILDER
        // ==========================================================

        StringBuilder sb = new StringBuilder();

        // ----------------------------------------------------------
        // append()
        // Adds text at the end.
        // ----------------------------------------------------------
        sb.append("sexy");
        sb.append(" bitch");

        System.out.println("\nAfter append(): " + sb);
        // Output: sexy bitch

        // ----------------------------------------------------------
        // delete()
        // Deletes characters from start index to end index (exclusive).
        // ----------------------------------------------------------
        sb.delete(0, 1);

        System.out.println("After delete(): " + sb);
        // Output: exy bitch

        // ----------------------------------------------------------
        // insert()
        // Inserts text at a specific index.
        // ----------------------------------------------------------
        sb.insert(0, "r");

        System.out.println("After insert(): " + sb);
        // Output: rexy bitch

        // ----------------------------------------------------------
        // charAt()
        // ----------------------------------------------------------
        System.out.println("Character at index 0: " + sb.charAt(0));
        // Output: r

        // ----------------------------------------------------------
        // codePointAt()
        // ----------------------------------------------------------
        System.out.println("Unicode value of index 0: " + sb.codePointAt(0));
        // Output: 114

        // ----------------------------------------------------------
        // length()
        // ----------------------------------------------------------
        System.out.println("Length of StringBuilder: " + sb.length());
        // Output: 10

        // ----------------------------------------------------------
        // reverse()
        // ----------------------------------------------------------
        sb.reverse();

        System.out.println("After reverse(): " + sb);
        // Output: hctib yxer

        // ----------------------------------------------------------
        // setLength(0)
        // Clears the StringBuilder.
        // ----------------------------------------------------------
        sb.setLength(0);

        System.out.println("After clear(): \"" + sb + "\"");
        // Output: ""
    }
}