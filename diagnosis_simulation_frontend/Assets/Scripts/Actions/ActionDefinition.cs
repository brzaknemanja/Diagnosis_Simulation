using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public enum ActionType
{
    Examination,
    Therapy,
    Labarathory
}

public class ActionDefinition
{
    public string actionName;
    public string actionDescription;
    public ActionType actionType;
    public string actionServerParam;

    public ActionDefinition(string actionName, string actionDescription, ActionType actionType, string actionServerParam)
    {
        this.actionName = actionName;
        this.actionDescription = actionDescription;
        this.actionType = actionType;
        this.actionServerParam = actionServerParam;
    }

    public string GetActionButtonText()
    {
        switch (this.actionType)
        {
            case ActionType.Examination:
                return "Send";
            case ActionType.Therapy:
                return "Apply";
            case ActionType.Labarathory:
                return "Test";
            default:
                return "Apply";
        }
    }

    public static List<ActionDefinition> examinationDefinitions = new List<ActionDefinition>()
    {
        new ActionDefinition("Spirometry", "Spirometry is a common office test used to assess how well your lungs work by measuring how much air you inhale, how much you exhale and how quickly you exhale. Spirometry is used to diagnose asthma, chronic obstructive pulmonary disease (COPD) and other conditions that affect breathing.Aug",
            ActionType.Examination, "Spirometry"),
        new ActionDefinition("MRI", "Magnet magnet and lots of magnets",
            ActionType.Examination, "MRI"),
    };

    public static Dictionary<ActionType, List<ActionDefinition>> actionDefinitions = new Dictionary<ActionType, List<ActionDefinition>>()
    {
        { ActionType.Examination, examinationDefinitions }
    };

   
    public static List<ActionDefinition> GetActionsOfType(ActionType actionType)
    {
        if (actionDefinitions.ContainsKey(actionType))
            return actionDefinitions[actionType];

        return null;
    }
}
