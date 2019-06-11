package com.dharma.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //Get Class Object
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks
            // because ConcreteClass is not available at compile time
            concreteClass = Class.forName("com.dharma.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName());

        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName());

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName());

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName());


        //Get Super Class
        Class<?> superClass = Class.forName("com.dharma.reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass);
        System.out.println(Object.class.getSuperclass());
        System.out.println(String[][].class.getSuperclass());

        //Get Public Member Classes
        Class<?>[] classes = concreteClass.getClasses();
        System.out.println(Arrays.toString(classes));

        //Get Declared Classes
        Class<?>[] explicitClasses = Class.forName("com.dharma.reflection.ConcreteClass").getDeclaredClasses();
        System.out.println(Arrays.toString(explicitClasses));

        //Get Declaring Class
        Class<?> innerClass = Class.forName("com.dharma.reflection.ConcreteClass$ConcreteClassDefaultClass");
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());

        //Getting Package Name
        System.out.println(Class.forName("com.dharma.reflection.BaseInterface").getPackage().getName());

        //Getting Class Modifiers
        System.out.println(Modifier.toString(concreteClass.getModifiers()));
        System.out.println(Modifier.toString(Class.forName("com.dharma.reflection.BaseInterface").getModifiers()));

        //Get Type parameters (generics)
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for(TypeVariable<?> t : typeParameters) {
            System.out.print(t.getName()+",");
        }

        //Get Implemented Interfaces
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
        System.out.println(Arrays.toString(interfaces));
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));

        //Get All Public Methods
        Method[] publicMethods = Class.forName("com.dharma.reflection.ConcreteClass").getMethods();
        System.out.println(Arrays.toString(publicMethods));

        //Get All Public Constructors
        Constructor<?>[] publicConstructors = Class.forName("com.dharma.reflection.ConcreteClass").getConstructors();
        System.out.println(Arrays.toString(publicConstructors));

        //Get All Public Fields
        Field[] publicFields = Class.forName("com.dharma.reflection.ConcreteClass").getFields();
        System.out.println(Arrays.toString(publicFields));

        //Get All Annotations
        java.lang.annotation.Annotation[] annotations = Class.forName("com.dharma.reflection.ConcreteClass").getAnnotations();
        System.out.println(Arrays.toString(annotations));

        //Get Public Field
        try {
            Field field = Class.forName("com.dharma.reflection.ConcreteClass").getField("interfaceInt");
            System.out.println(field.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //Field Declaring Class
        try {
            Field field = Class.forName("com.dharma.reflection.ConcreteClass").getField("interfaceInt");
            Class<?> fieldClass = field.getDeclaringClass();
            System.out.println(fieldClass.getCanonicalName());
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        //Get Field Type
        Field field = null;
        try {
            field = Class.forName("com.dharma.reflection.ConcreteClass").getField("publicInt");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Class<?> fieldType = field.getType();
        System.out.println(fieldType.getCanonicalName());

        //Get/Set Public Field Value
        field = null;
        try {
            field = Class.forName("com.dharma.reflection.ConcreteClass").getField("publicInt");
            ConcreteClass obj = new ConcreteClass(5);
            System.out.println(field.get(obj));
            field.setInt(obj, 10);
            System.out.println(field.get(obj));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Get/Set Private Field Value
        Field privateField = null;
        try {
            privateField = Class.forName("com.dharma.reflection.ConcreteClass").getDeclaredField("privateString");
            privateField.setAccessible(true);
            ConcreteClass objTest = new ConcreteClass(1);
            System.out.println(privateField.get(objTest));
            privateField.set(objTest, "private string updated");
            System.out.println(privateField.get(objTest));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        //Get Public Method
        Method method = null;
        try {
            method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(method.getReturnType());
            System.out.println(Modifier.toString(method.getModifiers())); //prints "public"
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //Invoking Public Method
        try {
            method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            Map<String, String> hm = new HashMap<>();
            method.invoke(hm, "key", "value");
            System.out.println(hm); // prints {key=value}
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //Invoking Private Methods
        try {
            method = Class.forName("com.dharma.reflection.BaseClass").getDeclaredMethod("method3", null);
            method.setAccessible(true);
            method.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //Get Public Constructor
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.dharma.reflection.ConcreteClass").getConstructor(int.class);
            System.out.println(Arrays.toString(constructor.getParameterTypes()));

            Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
            System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //Instantiate Object using Constructor
        try {
            constructor = Class.forName("com.dharma.reflection.ConcreteClass").getConstructor(int.class);
            System.out.println(Arrays.toString(constructor.getParameterTypes()));

            Object myObj = constructor.newInstance(10);
            Method myObjMethod = myObj.getClass().getMethod("method1", null);
            myObjMethod.invoke(myObj, null);

            Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
            System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes()));
            HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
            myMap.put("test", "test");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
