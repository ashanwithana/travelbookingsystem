import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './Pages/Login/Login';
import jwt_decode from 'jwt-decode';
import Register from './Pages/Login/Register';
import Footer from './Components/Navigation/Footer';
import NavBar from './Components/Navigation/NavBar';
import AllUsers from './Pages/Users/AllUsers';
import Profile from './Pages/Users/Profile';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
	if (localStorage.getItem('token')) {
		var token = localStorage.getItem('token');
		var decoded = jwt_decode(token);
	}
	return (
		<BrowserRouter>
			<ToastContainer />
			{localStorage.getItem('userType') && <NavBar />}
			<Routes>
				<Route path="/" element={<Login />} />
				<Route path="/profile" element={<Profile decoded={decoded} />} />
				<Route
					path="/all-users"
					element={localStorage.getItem('userType') === 'ADMIN' ? <AllUsers /> : <Login />}
				/>
				<Route path="/register" element={<Register />} />
			</Routes>
			<Footer />
		</BrowserRouter>
	);
}

export default App;
