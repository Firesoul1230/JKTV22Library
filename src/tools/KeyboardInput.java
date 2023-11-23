/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class KeyboardInput {
    public static int inputNumber(Integer min, Integer max){
        int number = 0;
        
        Scanner scanner = new Scanner(System.in);
        boolean isNumber = true;
        boolean repeat = true;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                isNumber = false;
                number = 0;
            }
            if(min == null && max == null){
                if(isNumber){
                    repeat = false;
                }
            }else if(min == null && max != null){
                if(isNumber && (number <= max)){
                    repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }
            }else if(min != null && max == null){
               if((number >= min) && isNumber){
                    repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }                     
            }else if((number >= min && number <= max) && isNumber){
                repeat = false;
            }else{
                System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                isNumber = true;
                repeat = true;
            }
        }while(repeat);
        return number;
    }
}
