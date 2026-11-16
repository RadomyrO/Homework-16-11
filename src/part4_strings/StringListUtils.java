package part4_strings;

import java.util.ArrayList;

// Part 4. StringUtilities
public class StringListUtils {

    private ArrayList<String> sentences = new ArrayList<>();

    public void addSentence(String s) {
        sentences.add(s);
    }

    private String clean(String w) {
        return w.replaceAll("[^a-zA-Z0-9]", "");
    }

    // Part 4.1 countWords
    public int countWords() {
        int count = 0;
        for (String s : sentences) {
            if (s.trim().isEmpty()) continue; // пустые не считаем
            count += s.trim().split("\\s+").length;
        }
        return count;
    }

    // Part 4.2 findLongestWord
    public String findLongestWord() {
        String longest = "";
        for (String s : sentences) {
            for (String w : s.trim().split("\\s+")) {
                String c = clean(w);
                if (c.length() > longest.length()) longest = c;
            }
        }
        return longest;
    }

    // Part 4.3 removeShortWords
    public void removeShortWords(int minLength) {
        for (int i = 0; i < sentences.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (String w : sentences.get(i).trim().split("\\s+")) {
                if (clean(w).length() >= minLength) {
                    sb.append(w).append(" ");
                }
            }
            sentences.set(i, sb.toString().trim()); // перезаписали
        }
    }

    public void printAll() {
        for (int i = 0; i < sentences.size(); i++) {
            System.out.println("  " + i + ": \"" + sentences.get(i) + "\"");
        }
    }

    // Part 4.4 Demo
    public static void main(String[] args) {
        StringListUtils u = new StringListUtils();
        u.addSentence("Java is a cool language.");
        u.addSentence("I like to write programs at night!");
        u.addSentence("ArrayList is very useful for homework.");

        System.out.println("Sentences:");
        u.printAll();

        System.out.println("Total words: " + u.countWords());
        System.out.println("Longest word: " + u.findLongestWord());

        u.removeShortWords(4);
        System.out.println("After removeShortWords(4):");
        u.printAll();
        System.out.println("Total words now: " + u.countWords());
    }
}
