// TestBuilderPattern.java
public class TestBuilderPattern {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 3080")
            .build();

        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
