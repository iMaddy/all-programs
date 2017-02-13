package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public interface CallAttendant extends Runnable
{
    public boolean assignCall(Call call);
    public boolean isFree();
}
