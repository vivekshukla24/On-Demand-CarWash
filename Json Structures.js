-> For Login
{
  "email":"info@djamware.com",
  "password": "q1w2we3r4"
}

-> For Registering as User(Role will be handled by code for User)
{
  "email": "admin@example.com",
  "password": "q1w2e3r4",
  "fullname": "Example Admin",
  "enabled": true
}

-> For Registering as any other role
{
  "email": "admin@example.com",
  "password": "q1w2e3r4",
  "fullname": "Example Admin",
  "enabled": true,
  "roles":[
     {
        "role":"YOURROLE"
     }
  ]
}

<----------------------------------------------------------->
-> Structure of a [Washer] on DB
{
  "email": "washer@provider.com",
  "password": "password",
  "fullname": "Example washer",
  "enabled": true,
  "roles":[
     {
        "$ref":"roles",
        "$id":{
           "$oid":"61baf84c7b90032c48127fae"
        }
     }
  ]
}


-> Structure of a [Admin] on DB
{
  "email": "admin@provider.com",
  "password": "password",
  "fullname": "Example admin",
  "enabled": true,
  "roles":[
     {
        "$ref":"roles",
        "$id":{
           "$oid":"61ba26a735c79a10aca1ded0"
        }
     }
  ]
}

//Not to be used to create any entity
-> Basic Json Structure of User on DB
{
   "_id":{
      "$oid":"61bb015ad49d7c4d04b43a89"
   },
   "email":"vivek@gmail.com",
   "password":"$2a$10$N2DGugWECmEfHq6JxZ3uP.MuwZIMLbCmY36cwt6ufKIMAGforSNj2",
   "fullname":"Vivek Shukla",
   "enabled":true,
   "roles":[
      {
         "$ref":"roles",
         "$id":{
            "$oid":"61ba26a735c79a10aca1ded0"
         }
      }
   ],
   "_class":"CG.zuulsecurity.models.User"
}
