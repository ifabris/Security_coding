package hr.algebra.Security.serialization;

import java.io.*;
import java.util.List;

public class Serializer {

    private static final  List<String> whiteListedClasses = List.of(
            "hr.algebra.Security.request.PlayerRequest"
    );

    public static void serialize(Object obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            if (!checkIfClassISWhiteListed(obj.getClass())) {
                throw new IllegalArgumentException("Class is not whitelisted");
            }

            oos.writeObject(obj);
            System.out.println("Object has been serialized");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String str) {
        try (FileInputStream fis = new FileInputStream(str);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();

            if (!checkIfClassISWhiteListed(obj.getClass())) {
                throw new IllegalArgumentException("Class is not whitelisted");
            }

            System.out.println("Object has been deserialized");
            return obj;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkIfClassISWhiteListed(Class<?> classToCheck){
        String className = classToCheck.getName();
        for (String whiteListedClass : whiteListedClasses) {
            if (className.equals(whiteListedClass)) {
                return true;
            }
        }
        return false;
    }

}
