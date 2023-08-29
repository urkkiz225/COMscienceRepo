import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static Method CurrentMethod;

    public static void main(String[] args) {
        System.out.println(Arrays.stream(args).toList());
        Method[] methods = COMtasks.class.getDeclaredMethods();
        ArrayList<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add("\n{" + method.getName() + ", " + Arrays.stream(methods).toList().indexOf(method) + "}");
        }
        try {
            executeMethodByName(COMtasks.class, userInput("Please type in the name or index of the method that you want to execute from the following list: \n " + methodNames + "\n"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void executeMethodByName(Class<?> targetClass, String methodIdentifier) {
        Method[] methods = targetClass.getDeclaredMethods();
        ArrayList<Object> params = new ArrayList<>();
            try {
                    for (Method method : methods) {
                        try{
                        if (method.getName().equals(methodIdentifier)) {
                            CurrentMethod = method;
                            break;
                        } else if (Arrays.stream(methods).toList().contains(methods[Integer.parseInt(methodIdentifier)])) {
                            CurrentMethod = methods[Integer.parseInt(methodIdentifier)];
                            break;
                        }} catch (NumberFormatException ignored) {
                    }
                }

            } catch (NumberFormatException e) {
                ynInput("Invalid index or no such method exists in the class " + targetClass + ", try again? y/n");
            }
            try {
            for (Parameter ignored : CurrentMethod.getParameters()) {
                try {
                    System.out.println(CurrentMethod.getParameters()[params.size()].isNamePresent());
                    params.add(ConvertUtils.convert(userInput( "Please enter valid argument at parameter index " + (params.size()) + " with a type of " +
                            (CurrentMethod.getParameterTypes()[params.size()].getTypeName()) + " and with a name of:" + (CurrentMethod.getParameters()[params.size()].getName())), CurrentMethod.getParameterTypes()[params.size()]));
                } catch (Exception e) {
                    System.out.println(Arrays.stream(e.getStackTrace()).toList());
                    main(new String[]{});
                }
            }
            CurrentMethod.invoke(targetClass.getDeclaredConstructor().newInstance(), params.toArray());
            Thread.sleep(5000);
            main(new String[]{});
        } catch (NoSuchMethodException e) {
            ynInput("No such method exists in the class " + targetClass + ", try again? y/n");
        } catch (NullPointerException e) {
            ynInput("No such method exists in the class " + targetClass + ", try again? y/n");
            System.out.print(e);
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e);
            main(new String[]{});
        }
    }


    public static boolean ynInput(String message) {
        System.out.println(message);
        String userInputS = userInput("Please type value and press enter");
        if (userInputS.equals("y") || userInputS.equals("yes")) {
            try {
                main(new String[]{});
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (userInputS.equals("n") || userInputS.equals("no")) {
            userInput("\n");

        } else {
            System.out.println("Non-correct syntax, answer y/n|yes/no (case sensitive)");
            ynInput(message);
        }
        return false;
    }

    public static String userInput(String message) {
        System.out.print(message + "\n");
        Scanner scanner = new Scanner(System.in);
        String nextLn = scanner.nextLine();
        switch (nextLn.toUpperCase()) {
            case "/EXIT", "/RAND" -> {
                if (ynInput("Exit?"))
                    System.exit(0);
            }
        }
        return nextLn;
    }
}
