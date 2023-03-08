package PkgFramework;

public class AppException extends Exception {

    public AppException(Throwable cause, Object className, String message) {
        // setDebuggingLog();
        System.out.println(
                "\nError causado por:\t" + cause + "\nEn: \t\t\t" + className + "\nMensaje:\t\t" + message);
    }

    public AppException(Throwable cause, Object className) {
        // setDebuggingLog();
        System.out.println(
                "\nError causado por:\t" + cause + "\nEn: \t\t\t" + className);
    }

    public AppException(String message) {
        System.out.println(
                "\nMensaje:\t\t" + message);
        setDebuggingLog();
    }

    void setDebuggingLog() {
        System.out.println("{AppException}");
        System.out.println(getMessage());
        System.out.println(getCause());
    }
}
