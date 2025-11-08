package Normal;
public class test {
    public static void main(String[] args) {
        System.out.println("viasak is the bosas");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        
        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        
        System.out.println("after clearing ");
    }
}
