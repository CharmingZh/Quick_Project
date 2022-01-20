import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Non-assessed unit tests.
 * These tests check whether some of the expected functions have the correct name and signature.
 */
public class DeclarationTest
{
    @Rule
    public Timeout globalTimeout = new Timeout(30000);
    
    private Class<?> doubleArray;
    private Class<?> doubleArray2;
    private Class<?> agentArray;

    /**
     * Constructor for this test class.
     */
    public DeclarationTest()
    {
        doubleArray = (new double[0]).getClass();
        doubleArray2 = (new double[0][0]).getClass();
    }
    
    /**
     * helper method to assert that a class is located in the default package
     */
    private void assertDefaultPackage(Class<?> targetClass)
    {
        String msg = targetClass.getName()+" must be in default package";
        if (targetClass.getPackage() != null)
        {
            assertEquals(msg, "", targetClass.getPackage().getName());
        }
    }
    /**
     * helper method to verify the type parameter of a return value
     */
    private void assertReturnTypeParameter(Class<?> targetClass, String methodName, Class typePar, Class... paramType)
    {        
        String fullname = targetClass.getName()+"."+methodName; 
        String tpname = typePar.getName();
        String msg = "return type of "+fullname+" must have type parameter <"+ tpname +">; ";

        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);
            Type returnType = method.getGenericReturnType();

            if(returnType instanceof ParameterizedType){
                ParameterizedType ptype = (ParameterizedType) returnType;
                Type[] typeArguments = ptype.getActualTypeArguments();
                assertEquals(msg, 1, typeArguments.length);
                assertEquals(msg, typePar, typeArguments[0]);
            }
            else 
            {
                fail(msg);
            }
        }
        catch (NoSuchMethodException e)
        {
            fail("Method "+fullname+" does not exist or has incorrect signature");
        }

    }

    /**
     * helper method for testing whether a (static) function is declared
     */
    private void assertFunctionDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+methodName; 
        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);

            assertEquals("Return type of "+fullname, returnType, method.getReturnType());

            assertTrue(fullname+" not declared static", Modifier.isStatic(method.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(method.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail("Function "+fullname+" does not exist or has incorrect signature");
        }                

    }

    /**
     * helper method for testing whether a method is declared
     */
    private void assertMethodDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+methodName; 
        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);

            assertEquals("Return type of "+fullname, returnType, method.getReturnType());

            assertFalse(fullname+" must not be declared static", Modifier.isStatic(method.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(method.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail("Method "+fullname+" does not exist or has incorrect signature");
        }                

    }

    /**
     * helper method for testing whether a constructor is declared
     */
    private void assertConstructorDeclared(Class<?> targetClass, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = "Constructor in "+targetClass.getName(); 
        try
        {
            Constructor constructor = targetClass.getConstructor(paramType);

            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(constructor.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail(fullname+" does not exist or has incorrect signature");
        }    
    }

    /**
     * helper method for testing whether *no* constructor is declared 
     * (for composite data types)
     */
    private void assertNoConstructorDeclared(Class<?> targetClass)
    {
        assertDefaultPackage(targetClass);

        try
        {
            Constructor constructor = targetClass.getDeclaredConstructor(new Class[]{});
            
            String msg = "Default constructor in "+targetClass.getName()+" must not be overridden";
            assertFalse(msg, Modifier.isPrivate(constructor.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            // default constructor has been overridden by custom constructor with different signature
            fail(targetClass.getName()+" must not have non-default constructors");
        }    
        
        boolean hasExtraConstructors = targetClass.getConstructors().length > 1;

        String msg = targetClass.getName() + " must not have non-default constructors";
        assertFalse(msg, hasExtraConstructors);
    }

    /**
     * helper method for testing whether a field is declared
     */
    private void assertFieldDeclared(Class<?> targetClass, String fieldName, Class type)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+fieldName; 
        try
        {
            Field field = targetClass.getDeclaredField(fieldName);

            assertEquals("Type of field "+fullname, type, field.getType());

            assertFalse(fullname+" must not be declared static", Modifier.isStatic(field.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(field.getModifiers()) );
        }
        catch (NoSuchFieldException e)
        {
            fail("Field "+fullname+" does not exist");
        }      
    }

    /**
     * helper method for testing whether a class is a subclass of another one
     */
    private void assertSubclassOf(Class<?> targetClass, Class<?> superClass)
    {
        assertDefaultPackage(targetClass);

        String msg = "Checking whether "+targetClass.getName()+ " is a subclass of "+superClass.getName();
        assertTrue(msg, superClass.isAssignableFrom(targetClass));
    }

    /**
     * Tests whether the function Vectors.norm() is declared.
     */
    @Test
    public void vectorsNormDeclaredTest()
    {    
        assertFunctionDeclared(Vectors.class, "norm", double.class, doubleArray);
        
    }


    /**
     * Tests whether the function Vectors.vectorProduct() is declared.
     */
    @Test
    public void vectorsVectorProductDeclaredTest()
    {    
        assertFunctionDeclared(Vectors.class, "vectorProduct", doubleArray, doubleArray, doubleArray);
        
    }

    /**
     * Tests whether the function Vectors.dihedralAngle() is declared.
     */
    @Test
    public void vectorsDihedralAngleTest()
    {    
        assertFunctionDeclared(Vectors.class, "dihedralAngle", double.class, doubleArray, doubleArray);
        
    }

    /**
     * Tests whether the function Vectors.solidAngle() is declared.
     */
    @Test
    public void vectorsSolidAngleTest()
    {    
        assertFunctionDeclared(Vectors.class, "solidAngle", double.class, doubleArray, doubleArray, doubleArray);
        
    }

    /**
     * Tests whether the function Vectors.angleBetweenPlanes() is declared.
     */
    @Test
    public void vectorsAngleBetweenPlanesTest()
    {    
        assertFunctionDeclared(Vectors.class, "angleBetweenPlanes", double.class, doubleArray, doubleArray, doubleArray, doubleArray);
        
    }

    /**
     * Tests whether the function ProposedIdentity.formulaVerification() is declared.
     */
    @Test
    public void formulaVerificationTest()
    {    
        assertFunctionDeclared(ProposedIdentity.class, "formulaVerification", double.class, doubleArray, doubleArray, doubleArray);
        
    }

    /**
     * Tests whether the function ProposedIdentity.correctnessRatio() is declared.
     */
    @Test
    public void correctnessRatioTest()
    {    
        assertFunctionDeclared(ProposedIdentity.class, "correctnessRatio", double.class, int.class);
        
    }

    /**
     * Tests whether the function MinFinder.minimumSolidAngle() is declared.
     */
    @Test
    public void minimumSolidAngleTest()
    {    
        assertFunctionDeclared(MinFinder.class, "minimumSolidAngle", SolidAngleResult.class, doubleArray2);        
    }

    /**
     * Tests whether the class SolidAngleResult has the correct fields
     */
    @Test
    public void solidAngleResultTest()
    {    
        assertNoConstructorDeclared(SolidAngleResult.class);
        assertFieldDeclared(SolidAngleResult.class, "angle", double.class);        
        assertFieldDeclared(SolidAngleResult.class, "x", doubleArray);        
        assertFieldDeclared(SolidAngleResult.class, "y", doubleArray);        
        assertFieldDeclared(SolidAngleResult.class, "z", doubleArray);        
    }
    
}
