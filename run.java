import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		Password pass=new Password();
		Scanner input=new Scanner(System.in);
    	boolean flag=true;
    	int a=1;
    	while(flag) {
    		pass.menu();
    		a=input.nextInt();
    		switch(a) {   //实现功能选择
    		case 1:
    			System.out.println("请输入需要加密的密码");
    			String password =input.next();
    			Password.encrypt(password);
    			System.out.println("加密后的密码："+Password.encrypt(password));
    			break;
    		case 2:
    			System.out.println("请输入需要解密的密码");
    			String encryptedPassword=input.next();
    			Password.decrypt(encryptedPassword);
    			System.out.println("解密后的密码："+Password.decrypt(encryptedPassword));
    			break;
    		//case 3:
    		//case 4:
    		case 5:
    			flag=false;
    			System.out.println("退出成功");
    			break;
    		}
        }input.close();
	}
}
