public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from remote server and then displayed
        image1.display();
        
        // Image will not be loaded from remote server again, just displayed
        image1.display();

        // Image will be loaded from remote server and then displayed
        image2.display();
    }
}
