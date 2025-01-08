public class TASK06 {

    public static void main(String[] args) {
        double a = 10 ;
        double b = 12;
        double c = 16 ;

        double s = (a+b+c)/2 ;

        double area = Math.sqrt( s * (s-a) * (s-b) * (s-c));

        System.out.println("The area of a triangle is: " + area);

    }
}
