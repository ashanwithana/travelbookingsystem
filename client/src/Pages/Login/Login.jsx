import * as React from 'react';
import axios from 'axios';
import { useState } from 'react';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';
import VisibilityIcon from '@mui/icons-material/Visibility';
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';

const Login = () => {
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [passwordType, setPasswordType] = useState('password');

	const loginHandler = async () => {
		try {
			if (!email || !password) {
				toast.error('Please fill all the fields!', {
					position: 'top-right',
					autoClose: 1950,
					hideProgressBar: false,
					closeOnClick: true,
					pauseOnHover: true,
					draggable: true,
					progress: undefined,
					theme: 'light',
				});
				return;
			}

			const response = await axios.post(`${process.env.REACT_APP_API_LINK_PREFIX}user/login`, {
				email,
				password,
			});
			console.log(response.data);
			toast.success('Login successfully!', {
				position: 'top-right',
				autoClose: 1950,
				hideProgressBar: false,
				closeOnClick: true,
				pauseOnHover: true,
				draggable: true,
				progress: undefined,
				theme: 'light',
			});
			localStorage.setItem('userType', response.data?.type);
			localStorage.setItem('userEmail', response.data?.email);
			if (response?.data?.type === 'ADMIN') {
				setTimeout(() => {
					window.location.href = '/all-users';
				}, 2000);
			}
			if (response?.data?.type === 'USER') {
				setTimeout(() => {
					window.location.href = '/profile';
				}, 2000);
			}
		} catch (error) {
			console.log(error);
			toast.error(`${error?.response?.data || 'Login failed!'}`, {
				position: 'top-right',
				autoClose: 1950,
				hideProgressBar: false,
				closeOnClick: true,
				pauseOnHover: true,
				draggable: true,
				progress: undefined,
				theme: 'light',
			});
		}
	};

	const togglePassword = () => {
		if (passwordType === 'password') {
			setPasswordType('text');
			return;
		}
		setPasswordType('password');
	};

	return (
		<div
			style={{
				backgroundImage: `url(${process.env.PUBLIC_URL}/assets/svg-wave-generator.gif)`,
			}}
			className="w-[100%] min-h-screen bg-cover bg-center flex flex-col justify-center items-center"
		>
			<div className="flex flex-col items-center bg-white w-full sm:w-[400px] px-5 py-10 gap-10 shadow-xl rounded-md my-10">
				<div className="text-center text-3xl font-extrabold text-gray-900">Login</div>

				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="User Name......"
					type="text"
					value={email}
					onChange={(e) => setEmail(e.target.value)}
				/>
				<div className="w-full flex flex-col items-center gap-2">
					<div className="flex w-full">
						<input
							type={passwordType}
							onChange={(e) => setPassword(e.target.value)}
							value={password}
							name="password"
							className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md rounded-tr-none rounded-br-none"
							placeholder="Password......"
						/>
						{passwordType === 'password' ? (
							<a
								className="p-2 cursor-pointer text-blue-500 hover:text-blue-600 bg-[#ddFFFD]  rounded-tr-md rounded-br-md"
								onClick={togglePassword}
							>
								<VisibilityIcon />
							</a>
						) : (
							<a
								className="p-2 cursor-pointer text-blue-500 hover:text-blue-600 rounded-tr-md rounded-br-md"
								onClick={togglePassword}
							>
								<VisibilityOffIcon />
							</a>
						)}
					</div>
				</div>
				<button
					className="bg-[#000] w-full p-2  hover:bg-[#2c2c2c] text-white font-bold rounded-[60px]"
					onClick={loginHandler}
				>
					Login
				</button>
				<div className="flex justify-center">
					<Link to="/register" className="text-blue-500 hover:text-blue-600">
						Don't have an account?
					</Link>
				</div>
			</div>
		</div>
	);
};

export default Login;
