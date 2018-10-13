package main.com.learning.strings.revert;

class Revert {
    public static String revertSentence(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        String modificatedString = temp.append(str).append(" ").toString();
        temp.delete(0, temp.length());

        for (int i = 0; i < modificatedString.length(); i++) {
            temp.append(modificatedString.charAt(i));
            if (modificatedString.charAt(i) == ' ' || i == modificatedString.length() - 1) {
                result.append(temp.reverse());
                temp.delete(0, temp.length());
                continue;
            }

        }
        return result.toString().trim();
    }
}
