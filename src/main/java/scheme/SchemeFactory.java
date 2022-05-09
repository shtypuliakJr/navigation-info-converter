package scheme;

import java.io.IOException;

public class SchemeFactory {

    private static final String GPGGA_SCHEME = "GPGGA";
    private static final String GPRMC_SCHEME = "GPRMC";
    private static final String GPVTG_SCHEME = "GPVTG";

    public Scheme getNewInstance(String schemeName) throws IOException {
        Scheme scheme;
        switch (schemeName) {
            case GPGGA_SCHEME:
                scheme = new Scheme();
                scheme.setSchemeName(GPGGA_SCHEME);
                scheme.readScheme("src/main/resources/SchemeGGA");
                return scheme;
            case GPRMC_SCHEME:
                scheme = new Scheme();
                scheme.setSchemeName(GPRMC_SCHEME);
                scheme.readScheme("src/main/resources/SchemeRMC");
                return scheme;
            case GPVTG_SCHEME:
                scheme = new Scheme();
                scheme.setSchemeName(GPVTG_SCHEME);
                scheme.readScheme("src/main/resources/SchemeVTG");
                return scheme;
            default:
                throw new RuntimeException("No appropriate scheme found");
        }
    }
}