//this class works as the backend and will generate the password

import java.util.Random;

public class PasswordGenerator {
    //character pools
    //strings wil hold the characters/numbers/symbols that we are going to randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYSMBOLS = "!@#$%^&*()_+[]{};:,.<>/?";

    //the random class allows us to generate a random number and randomly choose 
    private final Random random;

    //constructor
    public PasswordGenerator(){random = new Random();};

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        StringBuilder passwordBuilder = new StringBuilder();



        //store valid charecers (toggle states)
        String validCharacters = "";

        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYSMBOLS;

        //bulid password
        for(int i = 0; i < length; i++){
            //generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get the chra based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            //store char into the password builder
            passwordBuilder.append(randomChar);

            //do this until we have reached the length that the user has provided to us





        }
        return passwordBuilder.toString();

    }




























}
