-> For Login
{
  "email":"info@djamware.com",
  "password": "q1w2we3r4"
}

-> For Registering as User
{
  "email": "admin@example.com",
  "password": "q1w2e3r4",
  "fullname": "Example Admin",
  "enabled": true
}

-> Structure of a User on DB (Can be used to make Washer and Admin)

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
