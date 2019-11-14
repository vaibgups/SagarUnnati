package com.example.sagarunnati.utility;

import android.util.Log;

public class Logger {

    public static final String appName = "SagarUnnati ";
    public static boolean LOGGING_ENABLED = true;

    private static final int STACK_TRACE_LEVELS_UP = 5;

    public static void v(String tag, String message)
    {
        if (LOGGING_ENABLED)
        {
            Log.v(appName+ tag, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    public static void e(String tag, String message)
    {
        if (LOGGING_ENABLED)
        {
            Log.e(appName + tag, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    public static void i(String tag, String message)
    {
        if (LOGGING_ENABLED)
        {
            Log.i(appName + tag, getClassNameMethodNameAndLineNumber() + message);
        }
    }


    public static void d(String tag, String message)
    {
        if (LOGGING_ENABLED)
        {
            Log.d(appName + tag, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    /**
     * Get the current line number. Note, this will only work as called from
     * this class as it has to go a predetermined number of steps up the stack
     * trace. In this case 5.
     *
     * @author kvarela
     * @return int - Current line number.
     */
    private static int getLineNumber()
    {
        return Thread.currentThread().getStackTrace()[STACK_TRACE_LEVELS_UP].getLineNumber();
    }

    /**
     * Get the current class name. Note, this will only work as called from this
     * class as it has to go a predetermined number of steps up the stack trace.
     * In this case 5.
     *
     * @author kvarela
     * @return String - Current line number.
     */
    private static String getClassName()
    {
        String fileName = Thread.currentThread().getStackTrace()[STACK_TRACE_LEVELS_UP].getFileName();

        // kvarela: Removing ".java" and returning class name
        return fileName.substring(0, fileName.length() - 5);
    }

    /**
     * Get the current method name. Note, this will only work as called from
     * this class as it has to go a predetermined number of steps up the stack
     * trace. In this case 5.
     *
     * @author kvarela
     * @return String - Current line number.
     */
    private static String getMethodName()
    {
        return Thread.currentThread().getStackTrace()[STACK_TRACE_LEVELS_UP].getMethodName();
    }

    /**
     * Returns the class name, method name, and line number from the currently
     * executing log call in the form .()-
     *
     * @author kvarela
     * @return String - String representing class name, method name, and line
     *         number.
     */
    private static String getClassNameMethodNameAndLineNumber()
    {
        return "[" + getClassName() + "." + getMethodName() + "()-" + getLineNumber() + "]: ";
    }
}
