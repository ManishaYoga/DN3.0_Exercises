public class Computer {
    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String storage;
    private String GPU;
    private String motherboard;

    // Private constructor to enforce the use of Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.motherboard = builder.motherboard;
    }

    // Getters
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getMotherboard() {
        return motherboard;
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private String CPU;
        private String RAM;

        // Optional parameters
        private String storage;
        private String GPU;
        private String motherboard;

        // Constructor with required parameters
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Setter methods for optional parameters
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        // Build method to create a Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
