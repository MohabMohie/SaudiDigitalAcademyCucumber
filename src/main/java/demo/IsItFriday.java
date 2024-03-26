package demo;

public class IsItFriday {
    public static String isItFriday(String today) {
//            if (today.equals("Friday")){
//                return "TGIF";
//            } else {
//                return "Nope";
//            }
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
