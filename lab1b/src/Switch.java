public class Switch {
    
    public static void main(String[] args) {
        
        int numberVal = 5;
        
        // using traditional switch statement syntax
        // switch (numberVal) {
        //     case 1:
        //         System.out.println("You have entered one.");
        //         break;
        //     case 2:
        //         System.out.println("You have entered two.");
        //         break;
        //     case 3:
        //         System.out.println("You have entered three.");
        //         break;
        //     case 4:
        //         System.out.println("You have entered four.");
        //         break;
        //     case 5:
        //         System.out.println("You have entered five.");
        //         break;
        //     default:
        //         System.out.println("Number not recognized.");
        // }

        // using new rule switch expression syntax
        switch (numberVal) {
            case 1 -> System.out.println("You have entered one.");
            case 2 -> System.out.println("You have entered two.");
            case 3 -> System.out.println("You have entered three.");
            case 4 -> System.out.println("You have entered four.");
            case 5 -> System.out.println("You have entered five.");
            default -> System.out.println("Number not recognized.");
        }


    }

}
