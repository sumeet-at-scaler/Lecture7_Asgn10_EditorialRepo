import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.fail;

public class PracticeWithAtomicDataTypesTest {

    @Test
    public void testExistenceOfClassNamedPracticeWithAtomicDataTypes() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
        } catch (Exception e) {
            fail("PracticeWithAtomicDataTypes class not found");
        }
    }

    @Test
    public void testFieldsOfPracticeWithAtomicDataTypesClass() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Field field = PracticeWithAtomicDataTypesClass.getDeclaredField("count");
            if(!Modifier.isPrivate(field.getModifiers())){
                fail("count field is not private");
            }
            if(!field.getType().getSimpleName().equals("AtomicInteger")){
                fail("count field is not of type AtomicInteger");
            }
        } catch (Exception e) {
            fail("count field does not exist");
        }
    }

    @Test
    public void testConstructor() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Constructor constructor = PracticeWithAtomicDataTypesClass.getDeclaredConstructor();
            if(!Modifier.isPublic(constructor.getModifiers())){
                fail("constructor is not public");
            }
        } catch (Exception e) {
            fail("Appropriate constructor not found");
        }
    }

    @Test
    public void testConstructorWorks() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Constructor constructor = PracticeWithAtomicDataTypesClass.getDeclaredConstructor();

            Object counterObj = constructor.newInstance();

            Field countField = PracticeWithAtomicDataTypesClass.getDeclaredField("count");
            countField.setAccessible(true);
            int countValue = ((AtomicInteger)countField.get(counterObj)).intValue();

            if(0 != countValue){
                fail("Constructor is not setting value of count variable to 0.");
            }
        } catch (Exception e) {
            fail("Appropriate constructor not found");
        }
    }

    @Test
    public void testIncAndGetMethodSignatureAndModifiers() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Method incAndGetMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("incAndGet");

            if (!incAndGetMethod.getReturnType().equals(int.class)) {
                fail("incAndGet method should've have int return type");
            }

            Class[] parameterTypes = incAndGetMethod.getParameterTypes();
            if (parameterTypes.length != 0) {
                fail("incAndGet method should have 0 parameters only");
            }

            if (!Modifier.isPublic(incAndGetMethod.getModifiers())) {
                fail("incAndGet method should be public");
            }
        } catch (Exception e) {
            fail("incAndGet method not found");
        }
    }

    @Test
    public void testGetAndIncMethodSignatureAndModifiers() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Method getAndIncMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("getAndInc");

            if (!getAndIncMethod.getReturnType().equals(int.class)) {
                fail("getAndInc method should've have int return type");
            }

            Class[] parameterTypes = getAndIncMethod.getParameterTypes();
            if (parameterTypes.length != 0) {
                fail("getAndInc method should have 0 parameters only");
            }

            if (!Modifier.isPublic(getAndIncMethod.getModifiers())) {
                fail("getAndInc method should be public");
            }
        } catch (Exception e) {
            fail("getAndInc method not found");
        }
    }

    @Test
    public void testGetMethodSignatureAndModifiers() {
        try {
            Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
            Method getMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("get");

            if (!getMethod.getReturnType().equals(int.class)) {
                fail("get method should've have int return type");
            }

            Class[] parameterTypes = getMethod.getParameterTypes();
            if (parameterTypes.length != 0) {
                fail("get method should have 0 parameters only");
            }

            if (!Modifier.isPublic(getMethod.getModifiers())) {
                fail("get method should be public");
            }
        } catch (Exception e) {
            fail("get method not found");
        }
    }

    @Test
    public void testFunctionality() throws Exception {
        Class PracticeWithAtomicDataTypesClass = Class.forName("PracticeWithAtomicDataTypes");
        Constructor constructor = PracticeWithAtomicDataTypesClass.getDeclaredConstructor();
        Object counterObj = constructor.newInstance();

        Method getMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("get");
        int countValue = (int) getMethod.invoke(counterObj);
        if(0 != countValue){
            fail("get not returning the correct value of count");
        }

        Method incAndGetMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("incAndGet");
        countValue = (int) incAndGetMethod.invoke(counterObj);
        if(1 != countValue){
            fail("incAndGet not working properly");
        }

        Method getAndIncMethod = PracticeWithAtomicDataTypesClass.getDeclaredMethod("getAndInc");
        countValue = (int) getAndIncMethod.invoke(counterObj);
        if(1 != countValue){
            fail("getAndInc not working properly");
        }

        countValue = (int) getMethod.invoke(counterObj);
        if(2 != countValue){
            fail("getAndInc not working properly");
        }
    }
}
