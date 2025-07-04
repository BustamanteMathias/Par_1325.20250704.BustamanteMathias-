package pkg2pp_bustamantemathias.Utilidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ManejadorDeDatos {
    private static final Scanner s = new Scanner(System.in);

    public static int getInt(String msj, String msgError) {
        while (true) {
            System.out.print(msj);
            if (s.hasNextInt()) {
                return s.nextInt();
            } else {
                System.out.println(msgError);
                s.nextLine();
            }
        }
    }

    public static int getIntRange(String msj, String msgError, int min, int max) {
        while (true) {
            System.out.print(msj);
            if (s.hasNextInt()) {
                int buffer = s.nextInt();
                if (buffer >= min && buffer <= max) {
                    return buffer;
                } else {
                    System.out.println("[ERROR] Fuera de rango. [MIN=" + min + "]" + " [MAX=" + max + "].");
                }
            } else {
                System.out.println(msgError);
                s.nextLine();
            }
        }
    }

    public static double getDouble(String msj, String msgError) {
        while (true) {
            System.out.print(msj);
            if (s.hasNextDouble()) {
                return s.nextDouble();
            } else {
                System.out.println(msgError);
                s.nextLine();
            }
        }
    }

    public static double getDoubleRange(String msj, String msgError, double min, double max) {
        while (true) {
            System.out.print(msj);
            if (s.hasNextDouble()) {
                double buffer = s.nextDouble();
                if (buffer >= min && buffer <= max) {
                    return buffer;
                } else {
                    System.out.println("[ERROR] Fuera de rango. [MIN=" + String.format("%.2f", min) + "]" + " [MAX=" + String.format("%.2f", max) + "].");
                }
            } else {
                System.out.println(msgError);
                s.nextLine();
            }
        }
    }

    public static String getString(String msj, String msgError) {
        String buffer;
        do {
            s.nextLine();
            System.out.print(msj);
            buffer = s.nextLine().trim();
            if (buffer.isEmpty()) {
                System.out.println(msgError);
            }
        } while (buffer.isEmpty());
        return buffer;
    }

    public static LocalDate getDate(int min_yyyy, int max_yyyy) {
        return LocalDate.of(
                getIntRange("[DD-mm-aaaa] Ingrese dia: ", "[ERROR] Dato no valido.", 1, 31),
                getIntRange("[dd-MM-aaaa] Ingrese mes: ", "[ERROR] Dato no valido.", 1, 12),
                getIntRange("[dd-mm-AAAA] Ingrese año: ", "[ERROR] Dato no valido.", min_yyyy, max_yyyy)
        );
    }

    public static String printDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static int compareDate(LocalDate d1, LocalDate d2) {
        return d1.compareTo(d2);
    }
}