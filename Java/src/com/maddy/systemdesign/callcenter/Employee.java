package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public abstract class Employee implements CallAttendant
{
    protected Rank rank;
    private Call currentCall = null;
    private int empId;

    public Employee(int id)
    {
        empId = id;
    }

    /*
     returns true if Employee is able to take call
     */
    @Override
    public boolean assignCall(Call call)
    {
        if(isFree())
        {
            System.out.println("Assinged call to: " + rank.toString() + " empId: " + empId
            + " call id: " + call.getCallerId());
            currentCall = call;
            call.setCallAttendant(this);
            return true;
        }

        return false;
    }

    @Override
    public boolean isFree()
    {
        return currentCall == null;
    }

    public void escalateCall()
    {
        if(currentCall != null)
        {
            currentCall.increamentRank();
        }
    }

    public void disconnectCall()
    {
        System.out.println("Disconnecting call: " + rank.toString() + " empId: " + empId
                + " call id: " + currentCall.getCallerId());
        currentCall.setCallAttendant(null);
        currentCall = null;
    }

    @Override
    public void run()
    {
        System.out.println("Attending call: " + rank.toString() + " empId: " + empId
                + " call id: " + currentCall.getCallerId());
        try
        {
            Thread.sleep(10*1000);

        } catch (InterruptedException e)
        {
            System.out.println("Call dropped: "+ rank.toString() + " empId: " + empId
                    + " call id: " + currentCall.getCallerId());
        }
        finally
        {
            disconnectCall();
        }
    }
}
