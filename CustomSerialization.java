package Serialization;


	import java.io.*;

	class User implements Serializable
	{
	    String name = "Tejas";
	    transient String pwd = "Yadav";
	    transient int pin = 1234;


	    private void writeObject(ObjectOutputStream oos) throws Exception
	    {
	        System.out.println("write obj invoked");
	        String encryptedPwd = pwd+"123";
	        int encPin = pin +1234;
	        oos.writeObject(encryptedPwd);
	        oos.writeInt(encPin);
	        oos.defaultWriteObject();
	    }

	    private void readObject(ObjectInputStream ois) throws Exception
	    {
	        System.out.println("read obj invoked");
	        String decryptedPwd = (String) ois.readObject();
	        pwd = decryptedPwd.substring(0, 3);
	        int decPin = ois.readInt();
	        pin = decPin-1234;
	        ois.defaultReadObject();
	    }

	}

	public class CustomSerialization {

	    public static void main(String[] args) {

	        User ob1 = new User();

	        System.out.println("While serializing : "+ ob1.name + " " + ob1.pwd);

	        //Serialization
	        try {
	            FileOutputStream fos = new FileOutputStream("CustomSerialization.txt");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(ob1);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        //Deserialization

	        try {
	            FileInputStream fis = new FileInputStream("CustomSerialization.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            User ob2 = (User) ois.readObject();
	            System.out.println("User ob2 : "+ob2.name + " " + ob2.pwd);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


