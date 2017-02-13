package com.maddy.systemdesign.callcenter;

import com.maddy.systemdesign.callcenter.util.CallerIdGenerator;

/**
 * Created by gitanjali on 13/02/17.
 */
public class CallManger
{
    public static void main(String[] args)
    {
        CallHandler callHandler = new PhoneCallHandler();
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.queueCall(new Call(new Caller(CallerIdGenerator.getNextCallerId())));
        callHandler.dispatchCalls();
    }
}
