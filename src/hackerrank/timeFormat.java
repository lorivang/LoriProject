package hackerrank;

import java.util.Scanner;

public class timeFormat {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        Integer hour = Integer.valueOf(time.substring(0,2));
        String out = "";
        if (time.charAt(8) == 'P') {
            if (hour != 12) {
            hour += 12;
            out = String.valueOf(hour) + time.substring(2,8);
            } else {
                out = time.substring(0,8);
            }
        } else if (hour == 12) {
            out = "00" + time.substring(2,8);
        } else {
            out = time.substring(0,8);
        }
        System.out.println(out);
    }
}
