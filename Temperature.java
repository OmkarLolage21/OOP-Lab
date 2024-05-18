package FinalOOPLab;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) throws InvalidTemperatureException {
        Scanner sc = new Scanner(System.in);
        double celsius = sc.nextDouble();
        if(celsius < -273.15 || celsius > 1000){
            throw new InvalidTemperatureException();
        }
        else{
            System.out.println((9.0 / 5.0) * celsius + 32);
        }
    }
}
class InvalidTemperatureException extends Exception{
    InvalidTemperatureException(){
        super("Temperature should be between -273.15°C to 1000°C");
    }
}
