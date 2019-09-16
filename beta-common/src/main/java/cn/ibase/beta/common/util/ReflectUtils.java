package cn.ibase.beta.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射处理辅助类
 */
public class ReflectUtils {

    private static final Logger log = LoggerFactory.getLogger(ReflectUtils.class);

    /**
     * 获取类属性（包含私有以及受保护的，父类也会检索）
     *
     * @param sourceClass 类
     * @param fieldName   属性名称
     * @return 属性
     */
    public static Field getField(Class<?> sourceClass, String fieldName) {
        Field field = null;
        try {
            field = sourceClass.getField(fieldName);
        } catch (NoSuchFieldException ignored) {

        }

        if (field == null) {
            try {
                field = sourceClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ignored) {

            }
        }

        if (field == null) {
            Class<?> superClass = sourceClass.getSuperclass();
            if (superClass != null) {
                field = getField(superClass, fieldName);
            }
        }
        return field;
    }

    /**
     * 获取属性的值
     *
     * @param object    对象
     * @param fieldName 属性名
     * @return 属性值
     */
    public static Object getFieldValue(Object object, String fieldName) {
        Object value = null;
        if (object != null) {
            Field field = getField(object.getClass(), fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    value = field.get(object);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage(), e);
                }
            } else {
                log.error(object.getClass().getName() + "Field \""+ fieldName +"\" is not exist");
            }
        }
        return value;
    }

    /**
     * 获取静态属性值
     *
     * @param sourceClass 类
     * @param fieldName   属性名
     * @return 属性值
     */
    public static Object getStaticFieldValue(Class<?> sourceClass, String fieldName) {
        Field field = getField(sourceClass, fieldName);
        Object value = null;
        if (field != null) {
            field.setAccessible(true);
            if (isStatic(field)) {
                try {
                    value = field.get(null);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage(), e);
                }
            } else {
                log.error("Field is not static");
            }
        } else {
            log.error(sourceClass.getClass().getName() + "Field \""+ fieldName +"\" is not exist");
        }
        return value;
    }

    /**
     * 设置属性值
     *
     * @param object    对象
     * @param fieldName 属性名
     * @param newValue  新值
     */
    public static void setFieldValue(Object object, String fieldName, Object newValue) {
        if (object != null) {
            Field field = getField(object.getClass(), fieldName);
            if (field != null) {
                field.setAccessible(true);
                if (!isFinal(field)) {
                    try {
                        field.set(object, newValue);
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(), e);
                    }
                } else {
                    log.error("Field is final");
                }
            } else {
                log.error(object.getClass().getName() + "Field \""+ fieldName +"\" is not exist");
            }
        }
    }

    /**
     * 设置静态属性值
     *
     * @param sourceClass 类
     * @param fieldName   属性名
     * @param newValue    新值
     */
    public static void setStaticFieldValue(Class<?> sourceClass, String fieldName, Object newValue) {
        Field field = getField(sourceClass, fieldName);
        if (field != null) {
            field.setAccessible(true);
            if (isStatic(field)) {
                if (!isFinal(field)) {
                    try {
                        field.set(null, newValue);
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(), e);
                    }
                } else {
                    log.error("Field is final");
                }
            } else {
                log.error("Field is not static");
            }
        } else {
            log.error(sourceClass.getClass().getName() + "Field \""+ fieldName +"\" is not exist");
        }
    }

    /**
     * 是否静态（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isStatic(Object field) {
        return java.lang.reflect.Modifier.isStatic((Integer) invokeMethod(field, "getModifiers",  new  Object[]{}));
    }

    /**
     * 是否不可变/覆写（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isFinal(Object field) {
        return java.lang.reflect.Modifier.isFinal((Integer) invokeMethod(field, "getModifiers",  new  Object[]{}));
    }

    /**
     * 是否公共（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isPublic(Object field) {
        return java.lang.reflect.Modifier.isPublic((Integer) invokeMethod(field, "getModifiers",  new  Object[]{}));
    }

    /**
     * 是否私有（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isPrivate(Object field) {
        return java.lang.reflect.Modifier.isPrivate((Integer) invokeMethod(field, "getModifiers",  new  Object[]{}));
    }

    /**
     * 是否受保护（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isProtected(Object field) {
        return java.lang.reflect.Modifier.isProtected((Integer) invokeMethod(field, "getModifiers",  new  Object[]{}));
    }


    /**
     * 获取类方法（包含私有以及受保护的，父类也会检索）
     *
     * @param sourceClass 类
     * @param methodName  方法名
     * @param var2        方法的参数类型
     * @return 方法对象
     */
    public static Method getMethod(Class<?> sourceClass, String methodName, Class... var2) {
        Method method = null;
        try {
            method = sourceClass.getMethod(methodName, var2);
        } catch (NoSuchMethodException ignored) {

        }

        if (method == null) {
            try {
                method = sourceClass.getDeclaredMethod(methodName, var2);
            } catch (NoSuchMethodException ignored) {

            }
        }

        if (method == null) {
            Class<?> superClass = sourceClass.getSuperclass();
            if (superClass != null) {
                method = getMethod(superClass, methodName, var2);
            }
        }
        return method;
    }

    /**
     * 执行静态方法
     *
     * @param sourceClass 类
     * @param methodName  方法名
     * @param var2        参数
     * @return 执行结果
     */
    public static Object invokeStaticMethod(Class<?> sourceClass, String methodName, Object... var2) {
        Class<?>[] args = null;
        if (var2 != null) {
            args = new Class[var2.length];
            for (int i = 0; i < var2.length; i++) {
                args[i] = var2[i].getClass();
            }
        }
        Method method = getMethod(sourceClass, methodName, args);
        Object result = null;
        try {
            if (method != null) {
                if (isStatic(method)) {
                    method.setAccessible(true);
                    result = method.invoke(null, var2);
                } else {
                    log.error("method is not static");
                }
            } else {
                log.error("Method is not exist");
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 执行类方法
     *
     * @param sourceObject 类对象
     * @param methodName   方法名
     * @param var2         参数
     * @return 执行结果
     */
    public static Object invokeMethod(Object sourceObject, String methodName, Object... var2) {
        Class<?>[] args = null;
        if (var2 != null) {
            args = new Class[var2.length];
            for (int i = 0; i < var2.length; i++) {
                args[i] = var2[i].getClass();
            }
        }
        Method method = getMethod(sourceObject.getClass(), methodName, args);
        Object result = null;
        try {
            if (method != null) {
                method.setAccessible(true);
                result = method.invoke(sourceObject, var2);
            } else {
                log.error("Method is not exist");
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }


    /**
     * 获取类属性名
     *
     * @param pclass
     * @return String[]
     */
    public static String[] getClassDeclaredFieldNames(Class<?> pclass) {
        Field[] propertyField;
        String[] returnArray;
        int count = 0;

        if (pclass == null) {
            return null;
        }
        propertyField = pclass.getDeclaredFields();
        if (propertyField != null && propertyField.length > 0) {
            count = propertyField.length;
        }

        returnArray = new String[count];
        for (int i = 0; i < count; i++) {
            returnArray[i] = propertyField[i].getName();
        }
        return returnArray;
    }
    /**
     * 拷贝对象方法（适合同一类型的对象复制，但结果需强制转换）
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object copy(Object objSource) throws InstantiationException, IllegalAccessException{
        //如果源对象为空，则直接返回null
        if(null == objSource) return null;

        // 获取源对象类型
        Class<?> clazz = objSource.getClass();
        Object objDes = clazz.newInstance();
        // 获得源对象所有属性
        Field[] fields = clazz.getDeclaredFields();
        // 循环遍历字段，获取字段对应的属性值
        for ( Field field : fields )
        {
            // 如果不为空，设置可见性，然后返回
            field.setAccessible( true );
            try
            {
                // 设置字段可见，即可用get方法获取属性值。
                field.set(objDes, field.get(objSource));
            }
            catch ( Exception e )
            {
                log.error("执行{}类的{}属性的set方法时出错。{}",clazz.getSimpleName(),field.getName(),e);
            }
        }
        return objDes;
    }


    /**
     * 拷贝对象方法（适合不同类型的转换）<br/>
     *前提属性名称和类型要相同
     * @param objSource 源对象
     * @param clazzDes 目标class
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T, K> T copy(K objSource,Class<T> clazzDes) throws InstantiationException, IllegalAccessException{
        //如果源对象为空，则直接返回null
        if(null == objSource||clazzDes==null){
            return null;
        }
        T objDes = clazzDes.newInstance();
        // 获得源对象所有属性
        Field[] fields = objSource.getClass().getDeclaredFields();

        // 循环遍历字段，获取字段对应的属性值
        for ( Field field : fields )
        {
            // 如果不为空，设置可见性，然后返回
            field.setAccessible( true );
            try
            {
                String fieldName = field.getName();// 属性名
                String firstLetter = fieldName.substring(0, 1).toUpperCase();// 获取属性首字母
                // 拼接set方法名
                String setMethodName = "set" + firstLetter + fieldName.substring(1);
                // 获取set方法对象
                Method setMethod = clazzDes.getMethod(setMethodName,new Class[]{field.getType()});
                if(setMethod!=null){
                    // 对目标对象调用set方法装入属性值
                    setMethod.invoke(objDes, field.get(objSource));
                }

            }
            catch ( Exception e )
            {
                log.error("执行{}类的{}属性的set方法时出错。{}",clazzDes.getSimpleName(),field.getName(),e);
            }
        }
        return objDes;
    }


}
