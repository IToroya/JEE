package ninja.b1t.JEEBackendAPI.JDBC;

import java.sql.*;
import java.util.Scanner;

public class JeeJDBC {

    public static void main(String[] args) {


        SqlStatements statement = new SqlStatements();
        int eingabe = 0;

        System.out.println("Was soll gemacht werden?\n" + "1: Alle Entries ausgeben\n" + "2: Entry an bestimmter Id ausgeben\n"
                            + "3: Einen neuen Entry hinzufügen\n" + "4: Einen bestehenden Entry ändern\n" + "5: Einen Entry an bestimmter Id löschen\n");
        Scanner sc = new Scanner(System.in);

        eingabe = sc.nextInt();
        while(eingabe < 1 || eingabe > 5) {
            System.out.println("Es muss eine Zahl von 1 bis 5 eingegeben werden!");
            eingabe = sc.nextInt();
        }

        switch(eingabe) {
            case 1: {
                statement.selectAllEntries();
                statement.nochWasTun();
                break;
            }
            case 2: {
                System.out.println("\nWelcher Entry soll ausgegeben werden? Bitte ID des Entries eingeben! ");
                int id = sc.nextInt();
                while(id < 1) {
                    System.out.println("Es muss eine gültige ID über 0 sein!");
                    id = sc.nextInt();
                }
                statement.selectEntryById(id);
                statement.nochWasTun();

                break;
            }
            case 3: {
                System.out.println("Bitte Content für den Entry eingeben!\n");
                String content = stringContent();

                System.out.println("Bitte Erstelldatum für den Entry eingeben! WICHTIG: Format muss YYYY-MM-DD sein!\n");
                String created = sc.next();

                System.out.println("Bitte Mood für den Entry eingeben! (VERY_GOOD, GOOD, MEDIUM, UNKNOWN, LOW)\n");
                String mood = sc.next();

                statement.addEntry(content, created, mood);
                statement.nochWasTun();
                break;
            }
            case 4: {
                System.out.println("Bitte ID des zu ändernden Entries angeben!\n");
                int id = sc.nextInt();

                System.out.println("Bitte geänderten Content für den Entry eingeben!\n");
                String content = stringContent();

                System.out.println("Bitte Editierdatum für den Entry eingeben! WICHTIG: Format muss YYYY-MM-DD sein!\n");
                String created = sc.next();

                System.out.println("Bitte aktuellen Mood für den Entry eingeben! (VERY_GOOD, GOOD, MEDIUM, UNKNOWN, LOW)\n");
                String mood = sc.next();

                statement.updateEntry(id, content, created, mood);
                statement.nochWasTun();
                break;
            }
            case 5: {
                System.out.println("Bitte ID des zu löschenden Entries eingeben!\n");
                int id = sc.nextInt();

                System.out.println("Sicher dass der Entry mit der ID " + id + " gelöscht werden soll?\nZum bestätigen " + "\"" + "ja" + "\"" + " eingeben!\n");
                String sicher = sc.next();
                if(sicher.equals("ja"))
                    statement.deleteEntry(id);
                else
                    System.out.println("Dann eben nicht!\n");
                statement.nochWasTun();
                break;
            }
        }
    }

    private static String stringContent(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
