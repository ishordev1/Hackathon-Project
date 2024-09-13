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
import 'react-toastify/dist/ReactToastify.css';
import TouristBasePage from './Pages/Tourist/TouristBasePage';
import TouristHomePage from './Pages/Tourist/TouristHomePage';
import TourPackage from './Pages/Tourist/TourPackage';
import BookTourGuideMain from './Pages/Tourist/BookTourGuideMain';
import SelfTravel from './Pages/Tourist/SelfTravel';
import TourGuideBookNowPage from './Pages/Tourist/TourGuideBookNowPage';
import YourAllBooking from './Pages/Tourist/YourAllBooking';
import PackageBookNowPage from './Pages/Tourist/PackageBookNowPage';
import VehicleBook from './Pages/Tourist/VehicleBook';
import VehicleBookNowPage from './Pages/Tourist/VehicleBookNowPage';
import HouseBook from './Pages/Tourist/HouseBook';
import HouseBookNowPage from './Pages/Tourist/HouseBookNowPage';
import TourGuidHome from './Pages/Guide/TourGuidHome';
import GuideBasePage from './Pages/Guide/GuideBasePage';
import AddTourPackage from './Pages/Guide/AddTourPackage';
import ManagePackage from './Pages/Guide/ManagePackage';
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


        {/* tourist Specific Route */}
        <Route path="/tourist" element={<TouristBasePage />}>
        <Route path="home" element={<TouristHomePage />}/>
        <Route path="tourpackage" element={<TourPackage />}/>
        <Route path="selftravel" element={<SelfTravel />}/>
        <Route path="booktourguide" element={<BookTourGuideMain />}/>
        <Route path="tourguidebooknowpage" element={<TourGuideBookNowPage />}/>
        <Route path="bookinghistory" element={<YourAllBooking />}/>
        <Route path="bookpackage" element={<PackageBookNowPage />}/>
        <Route path="bookvehicle" element={<VehicleBook />}/>
        <Route path="bookvehiclenow" element={<VehicleBookNowPage />}/>
        <Route path="bookhouse" element={<HouseBook />}/>
        <Route path="bookhousenow" element={<HouseBookNowPage />}/>
        </Route>


        {/* tour guide Specific Route */}
        <Route path="/guide" element={<GuideBasePage />}>
        <Route path="home" element={<TourGuidHome />}/>
        <Route path="addtourpackage" element={<AddTourPackage />}/>
        <Route path="managePackage" element={<ManagePackage />}/>
        
        </Route>

  </Routes>
  <Footer/>
   </>
  );
}

export default App;
