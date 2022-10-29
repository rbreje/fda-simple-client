# FDA Simple Client

## Overview

The purpose of this application is to provide an easier way for an user to have access to OpenFDA storage data. You have a facile way of getting drug records using some predefine and straight forward fields. The app is allowing you to store data and to retrieve it anytime through a few RESTful API endpoints.

I was looking for enhance and expand my technical knowledge by build something that provides value at the same time.

## How to Run the Application

The default root URL is: ```http://localhost:8080```. You can switch the persistence of the application from ```application.properties```. 

## API Endpoints

```GET /api/openfda/records```

You can find below the fields' description.

| No  |    Field Name    |                                      Description                                      |                       Other                       |
|:---:|:----------------:|:-------------------------------------------------------------------------------------:|:-------------------------------------------------:|
|  1  | manufacturerName | This value represents the name of the manufacturer to be use in the search condition. |                   **mandatory**                   |
|  2  |    brandName     |    This value represents the name of the brand to be use in the search condition.     |                   **optional**                    |
|  3  | submissionStatus | This value represents the status of the submission to be use in the search condition. | **mandatory**. Valid values are: **TA** or **AP** |


Example of a valid request body for this endpoint.
```json
{
  "manufacturerName":"Sandoz",
  "brandName":"",
  "submissionStatus":"TA"
}
```

```GET /api/local/records```
No need to provide a body for this request.

Example of the response.
```json
{
  "drugRecords": [
    {
      "applicationNumber": "ANS16262",
      "manufacturerName": "Sandoz",
      "substanceName": "Oxitocin",
      "products": [
        {
          "productNumber": "263"
        },
        {
          "productNumber": "334"
        }
      ]
    }
  ]
}
```

```GET /api/local/records/{id}```

You have to provide this request with a valid application number as id. The endpoint will return an element if does exist. The response is the similar to the one above.

```POST /api/local/records```

You can use this endpoint in order to store a record. The application number have to be unique. You cannot save two records with the same id.

```json
{
  "applicationNumber":"ADSS25152",
  "manufacturerName":"Terapia",
  "substanceName":"Paracetamol",
  "products": [
    {
      "productNumber":"4525"
    },
    {
      "productNumber":"3512"
    }
  ]
}
```


## Others

### TODOs:
 - Enhance the code with logging capabilities
 - Enhance the tests
 - Enhance the deployment solution