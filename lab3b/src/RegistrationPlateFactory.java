public class RegistrationPlateFactory {
    
    private static String[] registrationPlates = {
        "LA05 XYZ", // London 
        "NG58 JKL", // Nottingham 
        "MA13 HYP", // Manchester 
        "BX06 TUV", // Birmingham 
        "CF67 QRS", // Cardiff 
        "YS09 PQR", // Yorkshire 
        "WD21 NML", // Exeter area (Western region)
        "KR16 FGH", // Northampton
        "SJ04 UVW", // Glasgow 
        "LV22 ABC", // Liverpool
        "WX19 XYZ"  // Bristol 
    };

    private static int nextIndex = 0;

    static RegistrationPlate getNextRegistrationPlate(){

        if (nextIndex >= registrationPlates.length) {
            nextIndex = 0;
        }

        String plateString = registrationPlates[nextIndex];

        RegistrationPlate plate = new RegistrationPlate();
        plate.setNumber(plateString);

        nextIndex++;

        return plate;

    }

    

}
