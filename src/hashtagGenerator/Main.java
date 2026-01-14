package hashtagGenerator;

public class Main {

    public static Object generateHashtag(String text) {

        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        StringBuilder hashtag = new StringBuilder("#");

        String[] words = text.trim().split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizeFirstLetter = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                hashtag.append(capitalizeFirstLetter);
            }
        }

        if (hashtag.length() == 1 || hashtag.length() > 140) {
            return false;
        }

        return hashtag.toString();
    }

    static void main() {
        String text1 = " Hello there thanks for trying my Kata";
        String text2 = " Hello World ";
        String text3 = "";

        System.out.println(generateHashtag(text1));
        System.out.println(generateHashtag(text2));
        System.out.println(generateHashtag(text3));
    }
}
