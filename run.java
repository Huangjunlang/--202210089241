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
    			System.out.println("解密功能暂时不可用！！");
    			break;
    		case 3:
    			System.out.println("请输入需要判断强度的密码");
    			password = input.next();
                int strength=Password.checkStrength(password);
                if (strength == 3) {
                    System.out.println("该密码为高强度密码");
                } else if (strength == 2) {
                    System.out.println("该密码为中强度密码");
                } else {
                    System.out.println("该密码为弱强度密码");
                }
    			break;
    		case 4:
    			System.out.print("请输入要生成密码的长度：");
                int length = input.nextInt();
                password = Password.generatePassword(length);
                System.out.println("生成的密码为：" + password);
                break;
    		case 5:
    			flag=false;
    			System.out.println("退出成功");
    			break;
    		}
        }input.close();
	}
}
