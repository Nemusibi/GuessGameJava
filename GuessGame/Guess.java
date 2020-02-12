import java.util.Random;
import javax.swing.JOptionPane;

public class Guess {
    public static void main(String[] args) {
        Random randd = new Random();

        // declaring variables
        int count = 0, randNum, guessNum1 = 0, max1 = 0;
        String guessNum = "", max, reply = "n", input = "";

        // enabling user to enter the maximum number in random generator with a
        // try/catch block
        do {
            max = JOptionPane.showInputDialog("Enter your maximum number in random generator:");

            try {
                max1 = Integer.parseInt(max);
            }

            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You entered: " + e.getMessage() + " instead of a digit try again.",
                        "error", JOptionPane.ERROR_MESSAGE);

    
                noOption(max);
            }

            catch (NullPointerException errorMess) {
                JOptionPane.showMessageDialog(null,
                        "You entered: " + errorMess.getMessage() + " empty string  instead of a digit try again.",
                        "Null error", JOptionPane.ERROR_MESSAGE);
                
                noOption(max);
    
            }
            // generating the random number
            randNum = randd.nextInt(max1) + 1;

            while (guessNum1 != randNum) {
                // user enters their guess in try/catch block
                guessNum = JOptionPane.showInputDialog("Enter your guess number:");

                // do {
                try {
                    guessNum1 = Integer.parseInt(guessNum);
                }

                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "You entered: " + e.getMessage() + " instead of a digit try again.", "error",
                            JOptionPane.ERROR_MESSAGE);

                    
                    noOption(guessNum);
                    continue;
                }

                catch (NullPointerException errorMess) {
                    JOptionPane.showMessageDialog(null,
                            "You entered: " + errorMess.getMessage() + " instead of a digit try again.", "Null error",
                            JOptionPane.ERROR_MESSAGE);

                    noOption(guessNum);
                    continue;
                }

                if (guessNum1 > max1 || guessNum1 < 1) {
                    JOptionPane.showMessageDialog(null, "The number entered is out of range", "Try Again",
                            JOptionPane.ERROR_MESSAGE);

                    noOption(guessNum);
                    continue;
                }

                // evaluating match between guessed number and random number
                if (guessNum1 > randNum) {
                    JOptionPane.showMessageDialog(null, "Eish hade! you're too high, guess again", "error",
                            JOptionPane.ERROR_MESSAGE);
                    count++;

                    noOption(guessNum);
                    continue;
                }

                else if (guessNum1 < randNum) {
                    JOptionPane.showMessageDialog(null, "Eish hade! you're too low, guess again", "error",
                            JOptionPane.ERROR_MESSAGE);
                    
                    count++;  

                    noOption(guessNum);
                    continue;
                }

                else {
                    count++;
                    JOptionPane.showMessageDialog(null, "Yay!! you're correct, well done.", "Congratulations",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                noOption(guessNum);
                
            } // end of while

            JOptionPane.showMessageDialog(null, "You took " + count + " attempts to solve this", "Congratulations",
                    JOptionPane.INFORMATION_MESSAGE);
            reply = JOptionPane.showInputDialog("Would you like to play again? Y/N");

            count = 0;
            noOption(guessNum);
            
        } while (reply.equalsIgnoreCase("y"));
    }

    static void noOption(String input) throws NullPointerException{
        if(input == null){
            try{
                throw new NullPointerException("Bye!");
            }

            catch(NullPointerException nExcep)
            {
                JOptionPane.showMessageDialog(null, "You cancelled. " + nExcep.getMessage(),
            "End of game", JOptionPane.INFORMATION_MESSAGE);
            }
            System.exit(1);
        }
    }
    
}