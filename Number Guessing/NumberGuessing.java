import javax.swing.*;

public class NumberGuessing {
    public static void main(String[] args) {
        
        try {
            int userAns = 0, count = 1, comNum = (int) (Math.random() * 100 + 1);
            while (userAns != comNum) {
                String response = JOptionPane.showInputDialog(null, "Enter your guess between 1 and 100");
                userAns = Integer.parseInt(response);
                JOptionPane.showMessageDialog(null, " " + determineGuess(userAns, comNum, count));
                count++;
            }
        } 
        catch (Exception e) {
           
        }
    }

    public static String determineGuess(int userAns, int comNum, int count) {
        if (userAns <= 0 || userAns > 100) {
            return "Your guess is invalid";
        } 
        else if (userAns == comNum) 
        {
            return "Correct! \n Total Guesses : " + count;
        } 
        else if (userAns > comNum) 
        {
            return "Your guess is too high, try again, \n Try Number : " + count;
        } 
        else if (userAns < comNum) 
        {
            return "Your guess is too low, try again, \n Try Number :  " + count;
        } 
        else 
        {
            return "Your guess is incorrect \n Try Number : " + count;
        }
    }
}
