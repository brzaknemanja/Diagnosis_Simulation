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

    public static List<ActionDefinition> labTestsDefinitions = new List<ActionDefinition>()
    {
        new ActionDefinition("Leukocytes", "Test the number of leukocytes in blood.",
            ActionType.Labarathory, "Leukocytes"),
    };

    public static List<ActionDefinition> therapyDefinitions = new List<ActionDefinition>()
    {
        new ActionDefinition("Mitomicin", "Used as radiation therapy for lung cancer.",
            ActionType.Therapy, "Mitomicin"),
        new ActionDefinition("Drooliticin", "Used to cure dangerous infection Droolitis",
            ActionType.Therapy, "Drooliticin"),
    };

    public static Dictionary<ActionType, List<ActionDefinition>> actionDefinitions = new Dictionary<ActionType, List<ActionDefinition>>()
    {
        { ActionType.Examination, examinationDefinitions },
        { ActionType.Labarathory, labTestsDefinitions },
        { ActionType.Therapy, therapyDefinitions },
    };

   
    public static List<ActionDefinition> GetActionsOfType(ActionType actionType)
    {
        if (actionDefinitions.ContainsKey(actionType))
            return actionDefinitions[actionType];

        return null;
    }
}
