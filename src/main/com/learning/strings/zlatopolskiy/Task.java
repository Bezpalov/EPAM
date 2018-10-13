package main.com.learning.strings.zlatopolskiy;

class Task {

    public String getThirdSymbol(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("getThirdSymbol - where is the string?");
        }
        if (str.length() < 3) {
            throw new IllegalArgumentException("getThirdSymbol - length of the string must be more than 2");
        }
        return String.valueOf(str.charAt(2));
    }

    public String getLastSymbol(String str) throws NullPointerException, IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("getLastSymbol - where is the string?");
        }
        if (str.length() <= 0) {
            throw new IllegalArgumentException("getLastSymbol - string length must be more than 0");
        }
        int index = str.length() - 1;
        return String.valueOf(str.charAt(index));
    }

    public String getSpecificSymbol(String str, int index) throws NullPointerException, IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("getSpecifiedSymbol - where is the string?");
        }
        if (index < 0) {
            throw new IllegalArgumentException("getSpecifiedSymbol - position of the symbol must be positive");
        }
        if (str.length() < index) {
            throw new IllegalArgumentException("getSpecifiedSymbol - index must be less than string length");
        }

        return String.valueOf(str.charAt(index - 1));
    }

    public int getQuantityOfEqualsLetters(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException("getQuantityOfEqualsLetters - where is the string?");
        }

        int count = 0;
        char current;
        char next;
        boolean isNotFirst = false;

        for (int i = 0; i < str.length() - 1; i++) {
            current = str.charAt(i);
            next = str.charAt(i + 1);
            if (current == next) {
               if(!isNotFirst) {
                   count = count + 2;
                   isNotFirst = true;
                   continue;
               } else {
                   count++;
                   continue;
               }
            }
            isNotFirst = false;
        }
        return count;
    }

    public String changeLettersSpot(String str) throws NullPointerException, IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("changeLettersSpot - where is the string?");
        }
        if (str.length() < 5) {
            throw new IllegalArgumentException("changeLettersSpot - string length must be more than 0");
        }
        char[] arr = str.toCharArray();
        char temp = arr[1];
        arr[1] = arr[4];
        arr[4] = temp;
        return String.valueOf(arr);
    }
}
