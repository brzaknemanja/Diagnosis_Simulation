using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestServerAPI : MonoBehaviour
{
    private void Start()
    {
        RestApi.Instance.GetRequest("localhost:8080/initialize?illnessType=Droolitis", OnSucces, OnFail);
    }

    private void OnSucces(string data)
    {
        Debug.Log(data);
    }

    private void OnFail(string data)
    {
        Debug.Log(data);
    }
}
