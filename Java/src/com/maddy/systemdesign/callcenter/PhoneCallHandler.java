package com.maddy.systemdesign.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gitanjali on 13/02/17.
 */
public class PhoneCallHandler implements CallHandler
{
    private final int NUM_RESPONDENT = 5;
    private final int NUM_MANAGERS = 3;
    private final int NUM_DIRECTOR = 2;
    private List<List<CallAttendant>> attendants;
    private Queue<Call> callQueue;

    public PhoneCallHandler()
    {
        attendants = new ArrayList<>();
        attendants.add(new ArrayList<>()); // respondent
        attendants.add(new ArrayList<>()); // manager
        attendants.add(new ArrayList<>()); // director

        AbstractFactory respondentFactory = new RespondentFactory();
        AbstractFactory managerFactory = new ManagerFactory();
        AbstractFactory directorFactory = new DirectorFactory();

        for (int i = 0; i < NUM_RESPONDENT; i++)
        {
            attendants.get(Rank.Respondent.getValue()).add(respondentFactory.createEmployee());
        }

        for (int i = 0; i < NUM_MANAGERS; i++)
        {
            attendants.get(Rank.Manager.getValue()).add(managerFactory.createEmployee());
        }

        for (int i = 0; i < NUM_DIRECTOR; i++)
        {
            attendants.get(Rank.Director.getValue()).add(directorFactory.createEmployee());
        }

        callQueue = new LinkedList<>();
    }

    @Override
    public void queueCall(Call call)
    {
        System.out.println("Call queued: callerid " + call.getCallerId());
        callQueue.add(call);
    }

    public void dispatchCalls()
    {
        int totalResources = NUM_RESPONDENT + NUM_MANAGERS + NUM_DIRECTOR;
        ExecutorService executor = Executors.newFixedThreadPool(totalResources);
        int numberOfQueuedCallLastRun = Integer.MAX_VALUE;
        int numberOfQueuedCall;

        while (true)
        {
            numberOfQueuedCall = callQueue.size();
            if (numberOfQueuedCall < numberOfQueuedCallLastRun)
            {
                System.out.println("Number of queued call: " + callQueue.size());
            }
            numberOfQueuedCallLastRun = callQueue.size();
            Call call = callQueue.poll();
            if (call != null)
            {
                CallAttendant callAttendant;
                if ((callAttendant = dispatchToRespondnet(call)) != null)
                {
                    executor.execute(callAttendant);
                } else if ((callAttendant = dispatchToManager(call)) != null)
                {
                    executor.execute(callAttendant);
                } else if ((callAttendant = dispatchToDirector(call)) != null)
                {
                    executor.execute(callAttendant);
                } else
                {
                    //not able to dispatch call - escalate
                    call.increamentRank();
                    callQueue.add(call);
                    numberOfQueuedCallLastRun = callQueue.size();
                }
            }
        }
    }

    private CallAttendant dispatchToRespondnet(Call call)
    {
        if (call.getRank() != Rank.Respondent)
            return null;

        // try to dispatching call to available Respondent
        List<CallAttendant> respondentList = attendants.get(Rank.Respondent.getValue());
        CallAttendant callAttendant = null;

        for (CallAttendant c : respondentList)
        {
            if (c.isFree())
            {
                callAttendant = c;
                break;
            }
        }

        if (callAttendant == null)
            return null;

        if (callAttendant.assignCall(call)) // respondent attended call
            return callAttendant;

        return callAttendant;
    }

    private CallAttendant dispatchToManager(Call call)
    {
        if (call.getRank() != Rank.Manager)
            return null;

        // try to dispatching call to available Respondent
        List<CallAttendant> respondentList = attendants.get(Rank.Manager.getValue());
        CallAttendant callAttendant = null;

        for (CallAttendant c : respondentList)
        {
            if (c.isFree())
            {
                callAttendant = c;
                break;
            }
        }

        if (callAttendant == null)
            return null;

        if (callAttendant.assignCall(call)) // manager attended call
            return callAttendant;

        return null;
    }

    private CallAttendant dispatchToDirector(Call call)
    {
        if (call.getRank() != Rank.Director)
            return null;

        // try to dispatching call to available Respondent
        List<CallAttendant> respondentList = attendants.get(Rank.Director.getValue());
        CallAttendant callAttendant = null;

        for (CallAttendant c : respondentList)
        {
            if (c.isFree())
            {
                callAttendant = c;
                break;
            }
        }

        if (callAttendant == null)
            return null;

        if (callAttendant.assignCall(call)) // director attended call
            return callAttendant;

        return null;
    }
}
