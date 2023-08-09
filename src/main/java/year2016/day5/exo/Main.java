package year2016.day5.exo;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String puzzleInput = "wtnhxymk";
        //prendre l'input et y ajouter un index croissant

        StringBuilder passwordBuilder = new StringBuilder();

        int index = 0;
        while (passwordBuilder.length() < 8) {
            String inputToHash = puzzleInput;
            inputToHash += index;

            passwordBuilder.append(findSixthCharIfHashStartsWithFiveZeros(inputToHash));

            index++;
        }

        System.out.println("answer exo 1 : " + passwordBuilder);

        String passwordForExo2 = findPasswordForExo2(puzzleInput);
        System.out.println("answer exo 2 : " + passwordForExo2);

    }

    /**
     * exo 1
     *
     * @param input
     * @return
     */
    private static String findSixthCharIfHashStartsWithFiveZeros(String input) {
        String hash = Hashing.md5().hashString(input, Charsets.UTF_8).toString();
        //vérifier si le hash commence par 00000
        Pattern pattern = Pattern.compile("^00000");
        Matcher matcher = pattern.matcher(hash);
        //si oui, renvoyer le 6ème char du hash
        return matcher.find() ? Character.toString(hash.charAt(5)) : "";
    }


    /**
     * exo 2
     *
     * @param input
     * @return
     */
    private static String findPasswordForExo2(String input) {
        int index = 0;
        boolean isPasswordFound = false;
        StringBuilder passwordBuilder = new StringBuilder("        ");
        Map<Integer, Boolean> positionsWritten = initializeMap();

        while (!isPasswordFound) {

            //si le hash commence par 00000
            String inputToHash = input;
            inputToHash += index;
            String hash = findHashFromInput(inputToHash);
            if (isHashStartsWithFiveZeros(hash) && (hash.charAt(5) <= '7')) {
                int indexToChangeInPassword = Integer.parseInt(String.valueOf(hash.charAt(5)));

                //pour empêcher qu'une valeur soit écrasée
                if (Boolean.FALSE.equals(positionsWritten.get(indexToChangeInPassword))) {
                    passwordBuilder.setCharAt(indexToChangeInPassword, hash.charAt(6));
                    positionsWritten.put(indexToChangeInPassword, true);
                }

            }
            isPasswordFound = areAllPositionFound(positionsWritten);

            index++;
        }

        return passwordBuilder.toString();
    }

    private static boolean isHashStartsWithFiveZeros(String hash) {
        Pattern pattern = Pattern.compile("^00000");
        Matcher matcher = pattern.matcher(hash);
        return matcher.find();
    }

    /**
     * exo 2
     *
     * @param input
     * @return
     */
    private static String findHashFromInput(String input) {
        return Hashing.md5().hashString(input, Charsets.UTF_8).toString();
    }

    /**
     * exo 2
     *
     * @param positionsWritten
     * @return
     */
    private static boolean areAllPositionFound(Map<Integer, Boolean> positionsWritten) {
        for (Boolean value : positionsWritten.values()) {
            if (Boolean.FALSE.equals(value)) return false;
        }
        return true;
    }

    /**
     * exo 2
     *
     * @return
     */
    private static Map<Integer, Boolean> initializeMap() {
        HashMap<Integer, Boolean> resMap = new HashMap<>();
        resMap.put(0, false);
        resMap.put(1, false);
        resMap.put(2, false);
        resMap.put(3, false);
        resMap.put(4, false);
        resMap.put(5, false);
        resMap.put(6, false);
        resMap.put(7, false);
        return resMap;
    }
}
