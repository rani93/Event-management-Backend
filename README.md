### Creating the data
POST http://localhost:8081/event/save
Content-Type: application/json

{
  "name": "",
  "description": ""
}



### Access by id
GET http://localhost:8081/event/{{id}}




### Access all
GET http://localhost:8081/event/all
