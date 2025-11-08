package Normal;
class ProgressBar {
    void progress() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            System.out.print("\rProgress: " + i + "%");
            Thread.sleep(50);
        } 
        System.out.println("\nDone!");
    }
}

class ClearScreen {

    void clear() throws InterruptedException {
        System.out.println("Hello, World!");
        Thread.sleep(1000); // Wait 1 second

        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("This is the next print after clearing!");
    }
}

//for all os

private static void clearTerminal() {
    try {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
            // macOS / Linux: try native clear
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } else if (os.contains("windows")) {
            // Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            // Fallback: ANSI escape code
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (Exception e) {
        // IDE fallback: print a bunch of blank lines
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}


public class Tool1_ClearTermihnal {
    public static void main(String[] args) {

    }

}
