

public class ProgramThree {
    public static void main(String[] args) throws Exception {

        Utils utils = new Utils();

        int pounds = utils.getWeightInPounds();

        utils.convertInputToStonesPounds(pounds);

        Utils.closeScanner();

    }

    
}


    