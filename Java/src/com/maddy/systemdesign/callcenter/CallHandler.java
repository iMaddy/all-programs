package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public interface CallHandler
{
    public void queueCall(Call call);
    public void dispatchCalls();
}
