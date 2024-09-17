import java.util.Comparator;

public class Phone implements Comparable<Phone> {

    private String brand;  // 0
    private String model;  // 1
    private String network_technology;
    private String ThreeG_bands;
    private String FourG_bands;
    private String network_speed; // 5
    private String GPRS;
    private String EDGE;
    private String announced;  // 8
    private String status;
    private String dimentions;  // 10
    private float weight_g; // 11
    private String SIM;
    private String display_type;
    private String display_resolution;
    private String display_size; // 15
    private String OS;
    private String CPU;
    private String Chipset;
    private String GPU;
    private String memory_card; // 20
    private String internal_memory;
    private String RAM;  // 22
    private String primary_camera;
    private String secondary_camera;
    private String loud_speaker;  // 25
    private String audio_jack;
    private String WLAN;
    private String bluetooth;
    private String GPS;
    private String NFC; // 30
    private String radio;
    private String USB;
    private String sensors;
    private String battery;
    private String colors; // 35
    private int approx_price_EUR; // 36
    private String img_url; // 37

    public Phone(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(Phone otherPhone) {
        return Integer.compare(this.approx_price_EUR, otherPhone.approx_price_EUR);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getApprox_price_EUR() {
        return approx_price_EUR;
    }

    public void setApprox_price_EUR(int approx_price_EUR) {
        this.approx_price_EUR = approx_price_EUR;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public void setWeight_g(float weight_g) {
        this.weight_g = weight_g;
    }

    public void setInternal_memory(String internal_memory) {
        this.internal_memory = internal_memory;
    }

    public String toString() {
        return brand + ", " + model + ", " + announced + ", " + weight_g + ", " + internal_memory + ", " + approx_price_EUR + " euros";
    }
}
