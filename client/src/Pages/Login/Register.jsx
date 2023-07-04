import React, { useState } from 'react';
import { POST } from '../../helpers/httpHelper';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';
import VisibilityIcon from '@mui/icons-material/Visibility';
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

function Register() {
	const navigate = useNavigate();
	const [name, setName] = useState('');
	const [email, setEmail] = useState('');
	const [address, setAddress] = useState('');
	const [dob, setDob] = useState('');
	const [type, setType] = useState('USER');
	const [password, setPassword] = useState('');
	const [passwordType, setPasswordType] = useState('password');

	const handleSubmit = async () => {
		try {
			if (!name || !email || !address || !dob || !password) {
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

			const data = { name, email, type, address, dob, password };
			const response = await POST('user/signup', data);

			toast.success('Register successfully!', {
				position: 'top-right',
				autoClose: 1950,
				hideProgressBar: false,
				closeOnClick: true,
				pauseOnHover: true,
				draggable: true,
				progress: undefined,
				theme: 'light',
			});
			navigate('/');
		} catch (error) {
			console.log(error);
			toast.error('Register failed!', {
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
				<div className="text-center text-3xl font-extrabold text-gray-900">Register</div>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="Name"
					type="text"
					value={name}
					onChange={(e) => setName(e.target.value)}
				/>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="Email"
					type="text"
					value={email}
					onChange={(e) => setEmail(e.target.value)}
				/>
				<textarea
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="Address"
					type="text"
					value={address}
					onChange={(e) => setAddress(e.target.value)}
				/>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="Birthday"
					type="date"
					value={dob}
					onChange={(e) => setDob(e.target.value)}
				/>
				{/* <input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-slate-200 rounded-md"
					placeholder="type"
					type="text"
					value={type}
					onChange={(e) => setType(e.target.value)}
				/> */}
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
					onClick={handleSubmit}
				>
					Register
				</button>
				<div className="flex justify-center">
					<Link to="/" className="text-blue-500 hover:text-blue-600">
						Already have an account? Login
					</Link>
				</div>
			</div>
		</div>
	);
}

export default Register;
