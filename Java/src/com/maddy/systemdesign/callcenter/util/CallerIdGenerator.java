package com.maddy.systemdesign.callcenter.util;

/**
 * Created by gitanjali on 13/02/17.
 */
public class CallerIdGenerator
{
    private static int callId = 1;

    synchronized public static int getNextCallerId()
    {
        return callId++;
    }
}
