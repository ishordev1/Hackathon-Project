import { privateAxios } from "./Helper";

//create
export const createTourPackage=(tourGuideId,packageDetail)=>{
    return privateAxios
    .post('/tour-packages/'+tourGuideId, packageDetail)
    .then((response)=> response.data);
};

//get TourGuide by email
export const getTourGuideByEmail=(email)=>{
    // console.log("this is email:"+email);
    
    return privateAxios
    .post('/tour-guides/'+email)
    .then((response)=> response.data);
};

//get tour package
export const getAllTourPackage=()=>{
    return privateAxios
    .get('/tour-packages')
    .then((response)=> response.data);
};

//get tour package
export const getAllTourPackageById=(tourGuideId)=>{
    return privateAxios
    .get('/tour-packages/tour-guide/'+tourGuideId)
    .then((response)=> response.data);
};