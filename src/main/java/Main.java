import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] test = new String[1];
    public static Method CurrentMethod;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        test=args;
        Method[] methods = COMtasks.class.getDeclaredMethods();
        ArrayList<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add("\n{" + method.getName() + ", " + Arrays.stream(methods).toList().indexOf(method) + "}");
        }
        try {
            executeMethodByName(COMtasks.class, userInput("Please type in the name or index of the method that you want to execute from the following list: \n" + methodNames + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeMethodByName(Class<?> targetClass, String methodIdentifier) {
        System.out.println(Arrays.toString(test));
        Method[] methods = targetClass.getDeclaredMethods();
        ArrayList<Object> params = new ArrayList<>();
            try {
                    for (Method method : methods) {
                        try{
                        if (method.getName().equalsIgnoreCase(methodIdentifier)) {
                            CurrentMethod = method;
                            break;
                        } else if (Arrays.stream(methods).toList().contains(methods[Integer.parseInt(methodIdentifier)])) {
                            CurrentMethod = methods[Integer.parseInt(methodIdentifier)];
                            break;
                        }else if(ynInput("Invalid index or no such method exists in the class " + targetClass + ", try again? y/n")) main(test);
                        else System.exit(0);
                        } catch (NumberFormatException ignored) {
                    }
                }

            } catch (NumberFormatException e) {
                if(ynInput("Invalid index or no such method exists in the class " + targetClass + ", try again? y/n")) main(test);
                else System.exit(0);
            }
            try {
            for (Parameter ignored : CurrentMethod.getParameters()) {
                try {
                    params.add(ConvertUtils.convert(userInput( "Please enter valid argument at parameter index " + (params.size()) + " with a type of " +
                            (CurrentMethod.getParameterTypes()[params.size()].getTypeName()) + " and with a name of:" + (CurrentMethod.getParameters()[params.size()].getName())), CurrentMethod.getParameterTypes()[params.size()]));
                } catch (Exception e) {
                    e.printStackTrace();
                    main(test);
                }
            }
            try {
                long startTime=System.currentTimeMillis();
                CurrentMethod.invoke(targetClass.getDeclaredConstructor().newInstance(), params.toArray());
                System.out.print("\nSuccessfully invoked method (Runtime: "+(System.currentTimeMillis()-startTime)+"ms, total memory usage: "+(Math.round((float)(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/100000)*0.1f)+"mb from heap sized "+(Math.round((float)(Runtime.getRuntime().totalMemory()))/100000)*0.1f+"mb\n");
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
                for (int i = 0; i < 8; i++) {
                    System.out.print("\rContinuing in "+(8-i)+"...");
                    Thread.sleep(1000);
                }System.out.print("\r");
            main(test);
        } catch (NullPointerException e) {
            ynInput("No such method exists in the class " + targetClass + ", try again? y/n");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e);
            main(test);
        }
    }


    public static boolean ynInput(String message) {
        System.out.println(Arrays.toString(test));
        System.out.println(message);
        String userInputS = userInput("Please type value and press enter");
        if (userInputS.equals("y") || userInputS.equals("yes")) {
            return true;
        } else if (userInputS.equals("n") || userInputS.equals("no")) {
            main(test);
        } else {
            System.out.println("Non-correct syntax, answer y/n|yes/no (case sensitive)");
            ynInput(message);
        }
        return false;
    }

    public static String userInput(String message) {
        System.out.println(Arrays.toString(test));
        System.out.print(message + "\n");
        Scanner scanner = new Scanner(System.in);
        String nextLn = scanner.nextLine();
        switch (nextLn.toUpperCase()) {
            case "/EXIT", "/EX" -> {
                if (ynInput("Exit?")){
                    System.exit(0);
                    return "";
                }
            }
        }
        return nextLn;
    }
}
