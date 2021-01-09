import java.util.*;
import java.io.*;
import java.math.*;

/**
 * adresse du probleme:
 * https://www.codingame.com/training/easy/chuck-norris
 * 
 * Ce programme transforme un message composé de caractères ASCII en un message codé selon le "code Norris"
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine(); //message original
        String messageCode = ""; //message codé final
        String binaryChar = ""; //message original convertis en binaire
        char charPrecedent = ' '; //pendant le codage, se souvient du caractere précédent ("0" ou "1")

        for (int loop1 = 0; loop1 < MESSAGE.length(); loop1++){ //convertis le message original en un code binaire
            int ascii = MESSAGE.charAt(loop1);
            binaryChar = binaryChar.concat(String.format("%7s", Integer.toBinaryString(ascii)).replace(' ', '0')); //convertis les caractères du message en leur valeur binaire
        }

        for (int loop2 = 0; loop2 < binaryChar.length(); loop2++){ //convertis le code binaire obtenus selon le "code de Chuck Norris"
            if (binaryChar.charAt(loop2) == charPrecedent){
                messageCode = messageCode.concat("0");
            }else{
                if(loop2 > 0){
                    messageCode = messageCode.concat(" ");
                }
                if (binaryChar.charAt(loop2) == '1'){
                    messageCode = messageCode.concat("0 0");
                }else{
                    messageCode = messageCode.concat("00 0");
                }
            }
            charPrecedent = binaryChar.charAt(loop2);
        }
        
        //affichage du message codé
        System.out.println(messageCode);
    }
}
