package year2016.day5.exo;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String puzzleInput = "wtnhxymk";
        //prendre l'input et y ajouter un index croissant

        StringBuilder passwordBuilder = new StringBuilder();

        int index = 0;
        boolean isPasswordFound = false;
        while (!isPasswordFound) {
            String inputToHash = puzzleInput;
            inputToHash += index;

            passwordBuilder.append(findSixthCharIfHashStartsWithFiveZeros(inputToHash));

            isPasswordFound = passwordBuilder.length() >= 8;
            index++;
        }

        System.out.println("answer exo 1 : " + passwordBuilder);

    }

    private static String findSixthCharIfHashStartsWithFiveZeros(String input) {
        String hash = Hashing.md5().hashString(input, Charsets.UTF_8).toString();
        //vérifier si le hash commence par 00000
        Pattern pattern = Pattern.compile("^(00000)");
        Matcher matcher = pattern.matcher(hash);
        //si oui, renvoyer le 6ème char du hash
        return matcher.find() ? Character.toString(hash.charAt(5)) : "";
    }
}
