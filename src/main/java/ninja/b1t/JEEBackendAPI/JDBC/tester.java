package ninja.b1t.JEEBackendAPI.JDBC;

import java.util.Scanner;

public class tester {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte ID des Entries angeben!\n");
        int id = sc.nextInt();

        System.out.println("Bitte Content für den Entry eingeben!\n");
        String content = sc.next();

        System.out.println("Bitte Erstelldatum für den Entry eingeben! WICHTIG: Format muss YYYY-MM-DD sein!\n");
        String created = sc.next();

        System.out.println("Bitte Mood für den Entry eingeben! (VERY_GOOD, GOOD, MEDIUM, UNKNOWN, LOW)\n");
        String mood = sc.next();

        System.out.println("UPDATE journalentry SET\n" + "`content` = " + "\"" + content + "\",\n" + "`created` = " + "\"" + created + "\",\n" + "`mood` = " + "\"" + mood + "\"\n" + "WHERE `id` = " + id + ";");
    }
}
