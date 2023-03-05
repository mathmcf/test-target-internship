package exercise5;

public class RevertedString {

    public static String revertString(String word) {

        String reversedWord = "";

        for (int i = word.length() - 1; i > -1; i--) {

            reversedWord = reversedWord.concat(Character.toString(word.charAt(i)));

        }

        return reversedWord;

    }

}
