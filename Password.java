import java.util.Random;
public class Password {
    private static final int OFFSET = 3;
    
    public static String encrypt(String password) {
        char[] chars = password.toCharArray();         
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + i + OFFSET);// 将每个字符的ASCII码加上它在字符串中的位置和偏移值
        }              
        if (chars.length > 1) {
            char temp = chars[0];
            chars[0] = chars[chars.length - 1];
            chars[chars.length - 1] = temp; // 将字符串的第一位和最后一位调换顺序
        }               
        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString();// 将字符串反转
    }

    public static String decrypt(String encryptedPassword) {
        char[] chars = encryptedPassword.toCharArray(); 
        StringBuilder s = new StringBuilder(new String(chars));
        String reversedPassword = s.reverse().toString();  //将字符串反转
        chars = reversedPassword.toCharArray();
        if (chars.length > 1) {
            char temp = chars[0];
            chars[0] = chars[chars.length - 1];
            chars[chars.length - 1] = temp;    // 将字符串的第一位和最后一位调换顺序
        }     
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - i - OFFSET);// 将每个字符的ASCII码减去它在字符串中的位置和偏移值
        }
        return new String(chars);
        }
    
    public static int checkStrength(String password) {
        int length = password.length();
        boolean Digit = false;
        boolean Lower = false;
        boolean Upper = false;
        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                Digit = true;
            } else if (Character.isLowerCase(c)) {
                Lower = true;
            } else if (Character.isUpperCase(c)) {
                Upper = true;
            }
        }
        int strength = 0;
        if (length >= 8 && Digit && Lower && Upper) {
            strength = 3;
        } else if (length >= 6 && ((Digit && Lower) || (Digit && Upper) || (Lower && Upper))) {
            strength = 2;
        } else {
            strength = 1;
        }
        return strength;
    }
    
    public static String generatePassword(int length) {
        String digits = "0123456789";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(3);
            if (choice == 0) {
                s.append(digits.charAt(random.nextInt(digits.length())));
                hasDigit = true;
            } else if (choice == 1) {
                s.append(lowerLetters.charAt(random.nextInt(lowerLetters.length())));
                hasLower = true;
            } else {
                s.append(upperLetters.charAt(random.nextInt(upperLetters.length())));
                hasUpper = true;
            }
        }
        if (hasDigit && hasLower && hasUpper) {
            return s.toString();
        } else {
            return generatePassword(length);
        }
    }

    public void menu() {
    	System.out.println("==============================");
    	System.out.println("     欢迎使用密码管理系统");
    	System.out.println("==============================");
    	System.out.println("       请选择操作：");
    	System.out.println("     1. 加密");
    	System.out.println("     2. 解密");
    	System.out.println("     3. 判断密码强度");
    	System.out.println("     4. 密码生成");
    	System.out.println("     5. 退出");
    }
}
