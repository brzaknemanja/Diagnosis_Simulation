using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PatientManager : MonobehaviourSingleton<PatientManager>
{
    public PatientData patientData;

    public Action onPatientInitialized;
    public Action onPatientDataRefreshed;

    private void Start()
    {
        RestApi.Instance.GetRequest("localhost:8080/initialize?illnessType=Droolitis", OnInitSucces, null);
    }

    private void OnInitSucces(string data)
    {
        Debug.Log(data);
        patientData = JsonUtility.FromJson<PatientData>(data);
        Debug.Log(patientData);

        if (onPatientInitialized != null)
            onPatientInitialized.Invoke();

        if (onPatientDataRefreshed != null)
            onPatientDataRefreshed.Invoke();
    }

    public void OnSimulateClick()
    {
        RestApi.Instance.GetRequest("localhost:8080/simulate", OnRefreshSuccess, null);
    }

    private void OnRefreshSuccess(string data)
    {
        Debug.Log(data);
        patientData = JsonUtility.FromJson<PatientData>(data);
        Debug.Log(patientData);

        if (onPatientDataRefreshed != null)
            onPatientDataRefreshed.Invoke();
    }
}
