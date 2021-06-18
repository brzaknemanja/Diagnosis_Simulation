using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public enum ActionType
{
    Examination,
    Therapy,
    Labarathory,
    Procedure
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
        new ActionDefinition("Cholesterol", "A cholesterol test is a blood test that measures the amount of each type of cholesterol and certain fats in your blood. Too much LDL cholesterol in your blood may put you at risk for heart disease and other serious conditions.",
            ActionType.Labarathory, "Cholesterol"),
    };

    public static List<ActionDefinition> therapyDefinitions = new List<ActionDefinition>()
    {
        new ActionDefinition("Mitomicin", "Used as radiation therapy for lung cancer.",
            ActionType.Therapy, "Mitomicin"),
        new ActionDefinition("Drooliticin", "Used to cure dangerous infection Droolitis",
            ActionType.Therapy, "Drooliticin"),
    };

    public static List<ActionDefinition> procedureDefinitions = new List<ActionDefinition>()
    {
        new ActionDefinition("Suction", "A suction machine, also known as an aspirator, is a type of medical device that is primarily used for removing obstructions — like mucus, saliva, blood, or secretions — from a person’s airway..",
            ActionType.Procedure, "Suction"),
        new ActionDefinition("Defibrillation", "Defibrillation is an emergency treatment for ventricular fibrillation and other life-threatening arrhythmias (abnormal heartbeats)",
            ActionType.Procedure, "Defibrillation"),
        new ActionDefinition("Intubation", "Intubation is a procedure that's used when you can't breathe on your own. Your doctor puts a tube down your throat and into your windpipe to make it easier to get air into and out of your lungs.",
            ActionType.Procedure, "Intubation"),
        new ActionDefinition("Liver Transplant", "A liver transplant is a surgical procedure that removes a liver that no longer functions properly (liver failure) and replaces it with a healthy liver from a deceased donor or a portion of a healthy liver from a living donor.",
            ActionType.Procedure, "LiverTransplant"),
        new ActionDefinition("Lungs Transplant", "A lung transplant is a surgical procedure to replace a diseased or failing lung with a healthy lung, usually from a deceased donor.",
            ActionType.Procedure, "LungsTransplant"),
    };

    public static Dictionary<ActionType, List<ActionDefinition>> actionDefinitions = new Dictionary<ActionType, List<ActionDefinition>>()
    {
        { ActionType.Examination, examinationDefinitions },
        { ActionType.Labarathory, labTestsDefinitions },
        { ActionType.Therapy, therapyDefinitions },
        { ActionType.Procedure, procedureDefinitions }
    };

   
    public static List<ActionDefinition> GetActionsOfType(ActionType actionType)
    {
        if (actionDefinitions.ContainsKey(actionType))
            return actionDefinitions[actionType];

        return null;
    }
}
