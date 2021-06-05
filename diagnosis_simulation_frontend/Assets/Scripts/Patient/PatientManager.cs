using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PatientManager : MonobehaviourSingleton<PatientManager>
{
    public PatientData patientData;

    private void Start()
    {
        RestApi.Instance.GetRequest("localhost:8080/initialize?illnessType=Droolitis", OnInitSucces, OnInitFail);
    }

    private void OnInitSucces(string data)
    {
        Debug.Log(data);
        patientData = JsonUtility.FromJson<PatientData>(data);
        Debug.Log(patientData);
    }

    private void OnInitFail(string data)
    {
        Debug.Log(data);
    }
}
