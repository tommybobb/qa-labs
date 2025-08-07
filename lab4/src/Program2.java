public class Program2{


    public static void main(String[] args) {

        // String name = "Thomas";

        // System.out.println("Char in index 2: " + name.charAt(2));
        // System.out.println("toLower: " + name.toLowerCase());
        
        
        // for(char c : name.toCharArray()){
        //     System.out.println(c);
        // }

        // if(name.startsWith("T")){
        //     System.out.println("Starts with T");
        // } else {
        //     System.out.println("Does not start with T");
        // }

        // if(name.endsWith("T")){
        //     System.out.println("Ends with T");
        // } else {
        //     System.out.println("Does not end with T");
        // }

        // System.out.println("Index of m: " + name.indexOf("m"));
        
        // System.out.println("Full name: " + name.concat(" Clarke"));

        StringBuilder sb = new StringBuilder("Bruce Springsteen");

        sb = sb.append( " is the artist ever");

        sb = sb.insert(sb.indexOf("artist"), "best ");

        int start = sb.indexOf("artist");
        sb = sb.replace(start, start + "artist".length(), "rock singer");

        String line = sb.toString();



        System.out.println(line);

    }   

}
