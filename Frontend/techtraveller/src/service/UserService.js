import { myAxios } from "./Helper";

export const TouristsignUp=(user)=>{
//signup function call kate bakt return then me data response ka data aaye ga
return myAxios
.post('/auth/touristsignup',user)
.then((response)=>response.data)
}

export const TourGuidesignUp=(user)=>{
//signup function call kate bakt return then me data response ka data aaye ga
return myAxios
.post('/auth/register',user)
.then((response)=>response.data)
}

export const loginUser=(loginDetail)=>{
    return myAxios
    .post('/auth/login',loginDetail)
    .then((response)=>response.data)
}