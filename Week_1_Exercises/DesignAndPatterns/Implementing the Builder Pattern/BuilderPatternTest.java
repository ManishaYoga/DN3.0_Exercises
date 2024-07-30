public class BuilderPatternTest {
    public static void main(String[] args) {
        // Creating a computer with required and optional parameters
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                                .setStorage("1TB SSD")
                                .setGPU("NVIDIA RTX 3080")
                                .setMotherboard("ASUS ROG")
                                .build();

        System.out.println("Gaming Computer Configuration:");
        System.out.println("CPU: " + gamingComputer.getCPU());
        System.out.println("RAM: " + gamingComputer.getRAM());
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("GPU: " + gamingComputer.getGPU());
        System.out.println("Motherboard: " + gamingComputer.getMotherboard());

        // Creating a basic computer with only required parameters
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                                .build();

        System.out.println("\nBasic Computer Configuration:");
        System.out.println("CPU: " + basicComputer.getCPU());
        System.out.println("RAM: " + basicComputer.getRAM());
    }
}
