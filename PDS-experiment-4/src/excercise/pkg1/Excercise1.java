/*
 * A program to convert from IP to symbolic addresses and symbolic to IP addresses.
 */
package excercise.pkg1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author MANDEEP VRATESH
 */
public class Excercise1 {

    /**
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //symbolic to IP
        InetAddress address = InetAddress.getByName(input);
        System.out.print(address.getHostAddress());
        
        System.out.println();
        
        //IP to symbolic
//        address = InetAddress.getByAddress(new byte[]{23,66,124,110});
//        System.out.println(address.getCanonicalHostName());
    }
    
}
