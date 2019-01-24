package co.uk.bbctechnicalinterview.impl;

import co.uk.bbctechnicalinterview.RomanNumeralGenerator;

/**
 * Created by ${Eclair} on 1/23/2019.
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    private StringBuilder string = new StringBuilder();
    @Override
    public String generate(int number) {
        if(number == 0) return string.toString();
        if(number == 1){
            string.append("I");
            generate(number-1);
        }
        if(number < 5){
            string.append("I");
            generate(number - 1);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RomanNumeralGeneratorImpl().generate(1));
    }
}
