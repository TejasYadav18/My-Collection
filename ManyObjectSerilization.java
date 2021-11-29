package Serialization;


import java.io.*;

class AA implements Serializable
{
    int i = 10;
}

class BB implements Serializable
{
    int j = 20;
}

class CC implements Serializable
{
    int k = 30;
}

public class ManyObjectSerilization {

    public static void main(String[] args) {

        AA a = new AA();
        BB b = new BB();
        CC c = new CC();

        try {
            FileOutputStream fos = new FileOutputStream("ManyObjectsSerialized.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.writeObject(b);
            oos.writeObject(c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Deserialization

        try {
            FileInputStream fis = new FileInputStream("ManyObjectsSerialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);


            while (ois.available() == 0)
            {
                Object obj = ois.readObject();
                if (obj instanceof AA)
                {
                    AA a1 = (AA) obj;
                    System.out.println(a1.getClass().getName());
                }
                if (obj instanceof BB)
                {
                    BB b1 = (BB) obj;
                    System.out.println(b1.getClass().getName());
                }
                if (obj instanceof CC)
                {
                    CC c1 = (CC) obj;
                    System.out.println(c1.getClass().getName());
                }

            }


        }catch (EOFException e)
        {
            System.out.println("File ended!!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}