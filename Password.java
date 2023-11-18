
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
        StringBuilder sb = new StringBuilder(new String(chars));
        String reversedPassword = sb.reverse().toString();  //将字符串反转
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
