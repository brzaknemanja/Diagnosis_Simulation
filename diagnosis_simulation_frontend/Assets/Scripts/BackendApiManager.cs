using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BackendApiManager
{
    public static string backendRestApi = "localhost:8080/";

    public static string GetActionRestPoint(ActionDefinition actionDefinition)
    {
        string restApiPoint = backendRestApi;

        switch (actionDefinition.actionType)
        {
            case ActionType.Examination:
                restApiPoint += "examine?examinationType=" + actionDefinition.actionServerParam;
                break;
            case ActionType.Labarathory:
                restApiPoint += "examine?examinationType=" + actionDefinition.actionServerParam;
                break;
        }

        return restApiPoint;
    }
    
}
