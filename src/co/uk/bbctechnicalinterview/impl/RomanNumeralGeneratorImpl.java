package co.uk.bbctechnicalinterview.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.uk.bbctechnicalinterview.RomanNumeralGenerator;

/**
 * Created by ${Eclair} on 1/23/2019.
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    private StringBuilder string = new StringBuilder();
    @Override
    public String generate(final int number) {
        if(number > 3999 || number < 0) return "Number above 3999 and negative numbers are unsupported";
        //base case
        if(number == 0) return string.toString();
        //starting from the highest units 1000 case
        if(number >=1000) {
            appendSymbol(number, 1000, "M");
            return generate(number%1000);
        }
        //less than 1000 and or equal to 500 case
        if(number >=500){
            //less than 1000 greater or equal to 900 case
            if(number >= 900){
               string.append("CM");
                return generate(number % 900);
            }
            //less than 900 greater or equal to 500 case
            appendSymbol(number, 500, "D");
            return generate(number % 500);
        }
        //less than 500 greater or equal to 100 case
        if(number >= 100){
            //less than 500 greater or equal to 400 case
            if(number >= 400){
                string.append("CD");
                return generate(number % 400);
            }
            //less than 400 greater or equal to 100
            appendSymbol(number, 100, "C");
            return generate(number%100);
        }
        //less than 100 greater or equal to 50 case
        if(number >= 50){
            //less than 100 greater or equal to 90 case
            if(number >= 90){
                string.append("XC");
                return generate(number % 90);
            }
            //less than 90 greater or equal to 50
            appendSymbol(number, 50, "L");
            return generate(number%50);
        }
        //less than 50 greater or equal to 10 case
        if(number >= 10){
            //less than 50 greater or equal to 40 case
            if(number >= 40){
                string.append("XL");
                return generate(number % 40);
            }
            //less than 90 greater or equal to 50
            appendSymbol(number, 10, "X");
            return generate(number%10);
        }
        //less than 10 greater or equal to 5 case
        if(number >= 5){
            //less than 10 greater or equal to 9 case
            if(number == 9){
                string.append("IX");
                return generate(0);
            }
            //less than 90 greater or equal to 50
            appendSymbol(number, 5, "V");
            return generate(number%5);
        }
        /* less than 5 and greater to 1 */
        if(number > 0 && number < 5){
            //less than 5 greater or equal to 9 case
            if(number == 4){
                string.append("IV");
                return generate(number % 4);
            }
            //less than 90 greater or equal to 50
            appendSymbolWithMod(number, 5, "I");
            return generate(0);
        }

        return string.toString();
    }

    private void appendSymbolWithMod(final int number, final int unit, final String symbol)
    {
        for (int i = 0; i < number % unit; i++)
        {
            string.append(symbol);
        }
    }

    private void appendSymbol(final int number, final int unit, final String symbol)
    {
        for (int i = 0; i < number / unit; i++)
        {
            string.append(symbol);
        }
    }

    @Test
    public void given_a_numericValue_WhenCalling_generate_should_convertToRomanNumerals()
    {
        final String romanNumerals = this.generate(3999);
        assertEquals(romanNumerals, "MMMCMXCIX");
    }

    @Test
    public void given_a_invalid_numericValue_WhenCalling_generate_should_ReturnAmessage()
    {
        final String romanNumerals = this.generate(4000);
        assertEquals(romanNumerals, "Number above 3999 and negative numbers are unsupported");
    }

    @Test
    public void given_a_zero_numericValue_WhenCalling_generate_should_ReturnAnEmptyString()
    {
        final String romanNumerals = this.generate(0);
        assertEquals(romanNumerals, "");
    }
}
