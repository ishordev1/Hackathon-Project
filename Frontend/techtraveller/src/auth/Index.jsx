
// CheckIsLogin
export const isLoggedIn = () => {
    if(localStorage.length===0){
        return false
    }
    let data = localStorage.getItem("data")
    if (data === null) {
        return false
    }
    else {
        return true
    }
};

// doLogin=> data=> set to localStorage
export const doLogin = (data, next) => {
    // in local storage only string set so we convert into string and set
    localStorage.setItem("data", JSON.stringify(data))
    next()
};

// doLogout
export const doLogout = (next) => {
    localStorage.removeItem("data")
    next()
};


//get current user
export const getCurrentUserDetails = () => {
    if (isLoggedIn()) {
        //return karna hai user ka name jo jwt ke saath hai
        return JSON.parse(localStorage.getItem("data")).user;
    }
    else return undefined;
};

//check admin
export const isAdminUser = () => {
    if (isLoggedIn()) {

        const tokenData = JSON.parse(localStorage.getItem('data'))
        const role = tokenData.user.role;
        if (role === "ADMIN") {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}

//check normal
export const isNormalUser = () => {
    if (isLoggedIn()) {
        const tokenData = JSON.parse(localStorage.getItem('data'))
        const role = tokenData.user.role;
        if (role === "NORMAL") {
            return true;
        }
        else {
        
            return false;
        }
    }
    else {
        return false;
    }
}

export const getToken=()=>{
    if(isLoggedIn()){
        return JSON.parse(localStorage.getItem('data')).jwtToken
    }
    else{
        return null
    }
}