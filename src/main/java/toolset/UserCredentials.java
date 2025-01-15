package toolset;

public class UserCredentials {
    private static String email;
    private static String password;

    class StringUtils { // Compliant

        private StringUtils() {
            throw new IllegalStateException("Utility class");
        }

        public static String concatenate(String s1, String s2) {
            return s1 + s2;
        }

    }
    
    public static void setCredentials(String userEmail, String userPassword) {
        email = userEmail;
        password = userPassword;
    }
    
    public static String getEmail() {
        return email;
    }
    
    public static String getPassword() {
        return password;
    }
    
    public static String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@example.com";
    }
} 