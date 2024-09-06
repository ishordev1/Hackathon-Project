import './App.css';
import { Routes, Route } from 'react-router-dom';
import Home from './Pages/User/Home';
import Navbar from './Component/Navbar';
import { ToastContainer } from 'react-toastify';
import Signup from './Component/Signup';
import Signin from './Component/Signin';
import Footer from './Component/Footer';
import TouristSignup from './Pages/SignupPage/TouristSignup';
import Tourguide from './Pages/SignupPage/TourGuide';
import Roomprovider from './Pages/SignupPage/RoomProvider';
import AdminSignup from './Pages/SignupPage/AdminSignup';
function App() {
  return (
   <>
    <Navbar/>
    <ToastContainer />
  <Routes>
  <Route path='/' element={<Home />}></Route>
  <Route path='/signin' element={<Signin/>}></Route>
  <Route path='/signup' element={<Signup/>}></Route>

  <Route path='/signup/tourist' element={<TouristSignup/>}></Route>
  <Route path='/signup/tourguide' element={<Tourguide/>}></Route>
  <Route path='/signup/homeprovider' element={<Roomprovider/>}></Route>
  <Route path='/signup/admin' element={<AdminSignup/>}></Route>


  </Routes>
  <Footer/>
   </>
  );
}

export default App;
