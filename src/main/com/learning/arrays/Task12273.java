package main.com.learning.arrays;

public class Task12273 {

    /**
     * method gets even characters from the array line and connects them in a word
     *
     * @param array 2 dimensional char array that you want work with
     * @return StringBuilder representation of result
     */
    public StringBuilder getEvenWords(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        }

        StringBuilder result = new StringBuilder("Even words is: ");
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 1; j < array[i].length; j = j + 2) {
                result.append(array[i][j]);
            }
            result.append(" ");
        }
        return result;
    }
}
